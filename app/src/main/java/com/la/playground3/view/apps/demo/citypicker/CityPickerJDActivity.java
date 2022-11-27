package com.la.playground3.view.apps.demo.citypicker;

import android.os.Bundle;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.la.playground3.R;
import com.la.playground3.common.CustomActivity;
import com.lljjcoder.Interface.OnCityItemClickListener;
import com.lljjcoder.bean.CityBean;
import com.lljjcoder.bean.DistrictBean;
import com.lljjcoder.bean.ProvinceBean;
import com.lljjcoder.style.cityjd.JDCityConfig;
import com.lljjcoder.style.cityjd.JDCityPicker;

public class CityPickerJDActivity extends CustomActivity {

    private MaterialToolbar toolBar;
    private TextInputEditText etCity;
    private MaterialButton btnCityPicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_picker_jd);
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
            JDCityPicker jdCityPicker = new JDCityPicker();
            JDCityConfig jdCityConfig = new JDCityConfig.Builder().build();

            jdCityConfig.setShowType(JDCityConfig.ShowType.PRO_CITY);
            jdCityPicker.init(this);
            jdCityPicker.setConfig(jdCityConfig);
            jdCityPicker.setOnCityItemClickListener(new OnCityItemClickListener() {
                @Override
                public void onSelected(ProvinceBean province, CityBean city, DistrictBean district) {
                    etCity.setText(province.getName() + " " + city.getName() + " " + district.getName());
                    customToast("省份：" + province.getName() + " 城市：" + city.getName() + " 区域：" + district.getName());
                }

                @Override
                public void onCancel() {
                    super.onCancel();
                    customToast("取消选择");
                }
            });
            jdCityPicker.showCityPicker();
        });
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