package com.la.playground3.view.apps.demo.citypicker;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.la.playground3.R;
import com.la.playground3.common.CustomActivity;
import com.lljjcoder.style.citylist.CityListSelectActivity;
import com.lljjcoder.style.citylist.bean.CityInfoBean;
import com.lljjcoder.style.citylist.utils.CityListLoader;

public class CityPickerSingleListActivity extends CustomActivity {

    private MaterialToolbar toolBar;
    private TextInputEditText etCity;
    private MaterialButton btnCityPicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_picker_single_list);
        initView();
        initToolBar();
        initEditTextCityPicker();
        initButtonCityPicker();
    }

    private void initToolBar() {
        toolBar.setNavigationOnClickListener(view -> finish());
    }

    private void initEditTextCityPicker() {
        etCity.setOnClickListener(view -> {
            CityListLoader.getInstance().loadCityData(this);
            Intent intent = new Intent(customGetActivity(), CityListSelectActivity.class);
            startActivityForResult(intent, CityListSelectActivity.CITY_SELECT_RESULT_FRAG);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CityListSelectActivity.CITY_SELECT_RESULT_FRAG) {
            if (resultCode == RESULT_OK) {
                if (data == null) {
                    return;
                }
                Bundle bundle = data.getExtras();

                CityInfoBean cityInfoBean = bundle.getParcelable("cityinfo");

                if (null == cityInfoBean) {
                    return;
                }

                customToast("城市： " + cityInfoBean.getName());
                etCity.setText(cityInfoBean.getName());
            }
        }
    }

    private void initButtonCityPicker() {
        // 居中的AlertDialog
        btnCityPicker.setOnClickListener(view -> {
        });
    }

    private void initView() {
        toolBar = findViewById(R.id.tool_bar);
        etCity = findViewById(R.id.et_city);
        btnCityPicker = findViewById(R.id.btn_city_picker);
    }
}