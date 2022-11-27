package com.la.playground3.view.apps.demo.citypicker;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.la.playground3.R;
import com.la.playground3.common.CustomActivity;
import com.lljjcoder.bean.CityBean;
import com.lljjcoder.style.citylist.utils.CityListLoader;
import com.lljjcoder.style.citythreelist.ProvinceActivity;

public class CityPickerThreeListActivity extends CustomActivity {

    private MaterialToolbar toolBar;
    private TextInputEditText etCity;
    private MaterialButton btnCityPicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_picker_three_list);
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
            //跳转到省份列表
            Intent intent = new Intent(this, ProvinceActivity.class);
            startActivityForResult(intent, ProvinceActivity.RESULT_DATA);
            customToast("该功能暂时无法使用。");
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ProvinceActivity.RESULT_DATA) {
            if (resultCode == RESULT_OK) {
                if (data == null) {
                    return;
                }
                //省份结果
                CityBean province = data.getParcelableExtra("province");
                //城市结果
                CityBean city = data.getParcelableExtra("city");
                //区域结果
                CityBean area = data.getParcelableExtra("area");
                customToast("省份：" + province.getName() + " 城市：" + city.getName() + " 区域：" + area.getName());
                etCity.setText(province.getName() + " " + city.getName() + " " + area.getName());
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