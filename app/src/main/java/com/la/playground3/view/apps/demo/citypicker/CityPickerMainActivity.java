package com.la.playground3.view.apps.demo.citypicker;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.textfield.TextInputEditText;
import com.la.playground3.R;
import com.la.playground3.common.CustomActivity;
import com.lljjcoder.Interface.OnCityItemClickListener;
import com.lljjcoder.bean.CityBean;
import com.lljjcoder.bean.DistrictBean;
import com.lljjcoder.bean.ProvinceBean;
import com.lljjcoder.citywheel.CityConfig;
import com.lljjcoder.style.citylist.Toast.ToastUtils;
import com.lljjcoder.style.citypickerview.CityPickerView;

public class CityPickerMainActivity extends CustomActivity {

    private MaterialToolbar toolBar;
    private TextInputEditText etCity;
    private MaterialButton btnCityPicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_picker_main);
        initView();
        initToolBar();
        initEditTextCityPicker();
        initButtonCityPicker();
    }

    private void initToolBar() {
        toolBar.setNavigationOnClickListener(view -> finish());
    }

    private void initEditTextCityPicker() {
        etCity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CityPickerView cityPickerView = new CityPickerView();
                cityPickerView.init(CityPickerMainActivity.this.customGetActivity());
                CityConfig cityConfig = new CityConfig.Builder().build();
                cityPickerView.setConfig(cityConfig);
                cityPickerView.setOnCityItemClickListener(new OnCityItemClickListener() {
                    @Override
                    public void onSelected(ProvinceBean province, CityBean city, DistrictBean district) {
                        super.onSelected(province, city, district);
                        ToastUtils.showShortToast(customGetActivity(), province.getName() + city.getName() + district.getName());
                        etCity.setText(province.getName() + city.getName() + district.getName());
                    }

                    @Override
                    public void onCancel() {
                        super.onCancel();
                        customToast("取消选择");
                    }
                });
                cityPickerView.showCityPicker();
            }

        });
    }

    private void initButtonCityPicker() {
        // 居中的AlertDialog
        btnCityPicker.setOnClickListener(view -> {
            MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(customGetActivity());
            builder.setTitle("提示");
            builder.setMessage("选择成功");
            builder.setPositiveButton("确定", (dialogInterface, i) -> {
                dialogInterface.dismiss();
            });
            builder.show();
        });
    }

    private void initView() {
        toolBar = findViewById(R.id.tool_bar);
        etCity = findViewById(R.id.et_city);
        btnCityPicker = findViewById(R.id.btn_city_picker);
    }
}