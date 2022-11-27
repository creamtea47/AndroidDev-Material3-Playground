package com.la.playground3.view.apps.demo.citypicker;

import android.os.Bundle;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.textfield.TextInputEditText;
import com.la.playground3.R;
import com.la.playground3.common.CustomActivity;
import com.la.playground3.entity.CustomCityData;

import java.util.ArrayList;
import java.util.List;

public class CityPickerCustomDataActivity extends CustomActivity {

    /**
     * 自定义数据源-省份数据
     */
    private final List<CustomCityData> mProvinceListData = new ArrayList<>();
    private MaterialToolbar toolBar;
    private TextInputEditText etCity;
    private MaterialButton btnCityPicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_picker_custom_data);
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
            errorDialog();
            etCity.setText("该功能暂时无法使用。");
        });
    }

    private void errorDialog() {
        MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(customGetActivity());
        builder.setTitle("提示");
        builder.setMessage("该功能暂无法使用\n因为自定义数据源无法使用。\n该功能已移除。");
        builder.setPositiveButton("确定", (dialogInterface, i) -> dialogInterface.dismiss());
        builder.show();
    }

    private void initButtonCityPicker() {
        // 居中的AlertDialog
        btnCityPicker.setOnClickListener(view -> {
            errorDialog();
        });
    }

    private void initView() {
        toolBar = findViewById(R.id.tool_bar);
        etCity = findViewById(R.id.et_city);
        btnCityPicker = findViewById(R.id.btn_city_picker);
    }
}