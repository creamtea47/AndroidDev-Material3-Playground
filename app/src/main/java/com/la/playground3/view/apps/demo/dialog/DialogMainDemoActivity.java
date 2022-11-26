package com.la.playground3.view.apps.demo.dialog;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.la.playground3.R;
import com.la.playground3.common.CustomActivity;
import com.la.playground3.databinding.ActivityDialogMainDemoBinding;

public class DialogMainDemoActivity extends CustomActivity {
    private final int mIcon = R.drawable.baseline_self_improvement_24;
    private final String mTitle = "Title";
    private final String mLongTitle = "This is a long title. It is so long that it spans multiple lines on normal screens and may trigger ellipses.";
    private final String mMessage = "Message";
    private final String mPositive = "Accept";
    private final String mLongPositive = "This is a long Accept message";
    private final String mOverLengthPositive = "This is a long Accept message,It's really too long!";
    private final String mNegative = "Decline";
    private final String mLongNegative = "This is a long Decline message";
    private final String mOverLengthNegative = "This is a long Decline message,It's really too long!";
    private final String mNeutral = "Cancel";
    private final String mLongNeutral = "This is a long Cancel message";
    private final String mOverLengthNeutral = "This is a long Cancel message,It's really too long!";
    private ActivityDialogMainDemoBinding mbinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mbinding = ActivityDialogMainDemoBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(mbinding.getRoot());

        initToolBar();
        initListView();
    }


    /**
     * <p>初始化 ToolBar</p>
     */
    private void initToolBar() {
        mbinding.dialogMainMtb.setNavigationOnClickListener(view -> finish());
    }

    /**
     * <p>初始化 ListView</p>
     */
    private void initListView() {
        String[] dialogsType = new String[]{
                "AppCompat AlertDialog",
                "Message, 2 Actions",
                "Long Message, 2 Actions",
                "Title, 2 Actions",
                "Title, Message, 3 Long Actions",
                "Long Title, Message, Over-length Buttons",
                "Icon, Title, Message, 2 Actions",
                "Icon, Title, Message, 2 Actions (Centered)",
                "Edit Text",
                "Items list",
                "Multi-select list",
                "Single select list",
                "Custom View",
                "Scrolling Content, Title, Actions",
                "Short Buttons",
                "Icon, Title, Message, 2 Full Width Actions",
                "Icon, Title, Message, 2 Full Width Actions (Centered)"
        };
        ArrayAdapter adapter = new ArrayAdapter(customGetActivity(), android.R.layout.simple_list_item_1, dialogsType);
        mbinding.dialogMainLv.setAdapter(adapter);

        mbinding.dialogMainLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (dialogsType[i]) {
                    case "AppCompat AlertDialog":
                        alertDialogBuilder();
                        break;
                    case "Message, 2 Actions":
                        MaterialAlertDialogBuilderWithMessageAnd2Actions();
                        break;
                    case "Long Message, 2 Actions":
                        MaterialAlertDialogBuilderWithLongMessageAnd2Actions();
                        break;
                    case "Title, 2 Actions":
                        MaterialAlertDialogBuilderWithTitleWith2Actions();
                        break;
                    case "Title, Message, 3 Long Actions":
                        MaterialAlertDialogBuilderWithTitleMessageAnd3LongAction();
                        break;
                    case "Long Title, Message, Over-length Buttons":
                        MaterialAlertDialogBuilderWithLongTitleMessageAnd3OverLengthAction();
                        break;
                    case "Icon, Title, Message, 2 Actions":
                        MaterialAlertDialogBuilderWithIconTitleMessageAnd2Action();
                        break;
                    case "Icon, Title, Message, 2 Actions (Centered)":
                        MaterialAlertDialogBuilderWithIconTitleMessageAnd2CenteredAction();
                        break;
                    case "Edit Text":
                        MaterialAlertDialogBuilderWithEditText();
                        break;
                    case "Items list":
                        MaterialAlertDialogBuilderWithItemsList();
                        break;
                    case "Multi-select list":
                        MaterialAlertDialogBuilderWithMultiSelectList();
                        break;
                    case "Single select list":
                        MaterialAlertDialogBuilderWithSingleSelectList();
                        break;
                    case "Custom View":
                        MaterialAlertDialogBuilderWithCustomView();
                        break;
                    case "Scrolling Content, Title, Actions":
                        MaterialAlertDialogBuilderWithScrollingContentTitleAndActions();
                        break;
                    case "Short Buttons":
                        MaterialAlertDialogBuilderWithShortButtons();
                        break;
                    case "Icon, Title, Message, 2 Full Width Actions":
                        MaterialAlertDialogBuilderWithIconTitleMessageAnd2FullWidthAction();
                        break;
                    case "Icon, Title, Message, 2 Full Width Actions (Centered)":
                        MaterialAlertDialogBuilderWithIconTitleMessageAnd2CenteredFullWidthAction();
                        break;
                }
            }
        });
    }

    /**
     * 封装 AlertDialogBuilder 方法
     * <p>带有图标、标题、内容、三个按钮</p>
     */
    private void alertDialogBuilder() {
        AlertDialog.Builder builder = new AlertDialog.Builder(customGetActivity());
        builder.setIcon(mIcon)
                .setTitle(mTitle)
                .setMessage(mMessage)
                .setPositiveButton(mPositive, null)
                .setNegativeButton(mNegative, null)
                .setNeutralButton(mNeutral, null)
                .show();
    }


    /**
     * 封装 MaterialAlertDialogBuilder 方法
     * <p>带有内容、两个按钮</p>
     */
    private void MaterialAlertDialogBuilderWithMessageAnd2Actions() {
        MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(customGetActivity());
        builder.setMessage(mMessage)
                .setPositiveButton(mPositive, null)
                .setNegativeButton(mNegative, null)
                .show();
    }

    /**
     * 封装 MaterialAlertDialogBuilder 方法
     * <p>带有长文本内容、两个按钮</p>
     */
    private void MaterialAlertDialogBuilderWithLongMessageAnd2Actions() {
        MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(customGetActivity());
        builder.setMessage(R.string.large_text)
                .setPositiveButton(mPositive, null)
                .setNegativeButton(mNegative, null)
                .show();
    }

    /**
     * 封装 MaterialAlertDialogBuilder 方法
     * <p>带有标题、两个按钮</p>
     */
    private void MaterialAlertDialogBuilderWithTitleWith2Actions() {
        MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(customGetActivity());
        builder.setTitle(mTitle)
                .setPositiveButton(mPositive, null)
                .setNegativeButton(mNegative, null)
                .show();
    }

    /**
     * 封装 MaterialAlertDialogBuilder 方法
     * <p>带有标题、内容、三个长文本按钮</p>
     */
    private void MaterialAlertDialogBuilderWithTitleMessageAnd3LongAction() {
        MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(customGetActivity());
        builder.setTitle(mTitle)
                .setPositiveButton(mLongPositive, null)
                .setNegativeButton(mLongNegative, null)
                .setNeutralButton(mLongNeutral, null)
                .show();
    }

    /**
     * 封装 MaterialAlertDialogBuilder 方法
     * <p>带有超长标题、内容、三个超长文本按钮</p>
     */
    private void MaterialAlertDialogBuilderWithLongTitleMessageAnd3OverLengthAction() {
        MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(customGetActivity());
        builder.setTitle(mLongTitle)
                .setView(R.layout.demo_dialog_edit_text)
                .setPositiveButton(mOverLengthPositive, null)
                .setNegativeButton(mOverLengthNegative, null)
                .setNeutralButton(mOverLengthNeutral, null)
                .show();
    }

    /**
     * 封装 MaterialAlertDialogBuilder 方法
     * <p>带有图标、标题、内容、两个按钮</p>
     */
    private void MaterialAlertDialogBuilderWithIconTitleMessageAnd2Action() {
        MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(customGetActivity());
        builder.setIcon(mIcon)
                .setTitle(mTitle)
                .setMessage(mMessage)
                .setPositiveButton(mPositive, null)
                .setNegativeButton(mNegative, null)
                .show();
    }

    /**
     * 封装 MaterialAlertDialogBuilder 方法
     * <p>带有居中图标、居中标题、内容、两个按钮</p>
     */
    private void MaterialAlertDialogBuilderWithIconTitleMessageAnd2CenteredAction() {
        MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(customGetActivity(), R.style.ThemeOverlay_Material3_MaterialAlertDialog_Centered);
        builder.setIcon(mIcon)
                .setTitle(mTitle)
                .setMessage(mMessage)
                .setPositiveButton(mPositive, null)
                .setNegativeButton(mNegative, null)
                .show();
    }

    /**
     * 封装 MaterialAlertDialogBuilder 方法
     * <p>带有输入框</p>
     */
    private void MaterialAlertDialogBuilderWithEditText() {
        MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(customGetActivity());
        builder.setTitle(mTitle)
                .setView(R.layout.demo_dialog_edit_text)
                .setPositiveButton(mPositive, null)
                .setNegativeButton(mNegative, null)
                .show();
    }

    /**
     * 封装 MaterialAlertDialogBuilder 方法
     * <p>带有列表项</p>
     */
    private void MaterialAlertDialogBuilderWithItemsList() {
        MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(customGetActivity());
        CharSequence[] items = {"Item 1", "Item 2", "Item 3"};
        builder.setTitle(mTitle)
                .setPositiveButton(mPositive, null)
                .setItems(items, null)
                .show();
    }

    /**
     * 封装 MaterialAlertDialogBuilder 方法
     * <p>带有多选项的列表</p>
     */
    private void MaterialAlertDialogBuilderWithMultiSelectList() {
        MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(customGetActivity());
        CharSequence[] items = {"Item 1", "Item 2", "Item 3"};
        builder.setTitle(mTitle)
                .setPositiveButton(mPositive, null)
                .setMultiChoiceItems(items, new boolean[]{false, true, false}, null)
                .setNegativeButton(mNegative, null)
                .show();
    }

    /**
     * 封装 MaterialAlertDialogBuilder 方法
     * <p>带有单选项的列表</p>
     */
    private void MaterialAlertDialogBuilderWithSingleSelectList() {
        MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(customGetActivity());
        CharSequence[] items = {"Item 1", "Item 2", "Item 3"};
        builder.setTitle(mTitle)
                .setPositiveButton(mPositive, null)
                .setSingleChoiceItems(items, 2, null)
                .setNegativeButton(mNegative, null)
                .show();
    }

    /**
     * 封装 MaterialAlertDialogBuilder 方法
     * <p>带有自定义视图</p>
     */
    private void MaterialAlertDialogBuilderWithCustomView() {
        MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(customGetActivity());
        builder.setTitle(mTitle)
                .setView(R.layout.demo_dialog_seekbar)
                .setPositiveButton(mPositive, null)
                .setNegativeButton(mNegative, null)
                .show();
    }

    /**
     * 封装 MaterialAlertDialogBuilder 方法
     * <p>带有滚动内容、标题、按钮</p>
     */
    private void MaterialAlertDialogBuilderWithScrollingContentTitleAndActions() {
        MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(customGetActivity());
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 100; i++) {
            stringBuilder.append("line").append(i).append("\n");
        }
        builder.setTitle(mTitle)
                .setMessage(stringBuilder.toString())
                .setPositiveButton(mPositive, null)
                .setNegativeButton(mNegative, null)
                .show();
    }


    /**
     * 封装 MaterialAlertDialogBuilder 方法
     * <p>带有短文本按钮</p>
     */
    private void MaterialAlertDialogBuilderWithShortButtons() {
        MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(customGetActivity());
        builder.setTitle(mTitle)
                .setPositiveButton("2", null)
                .setNegativeButton("1", null)
                .show();
    }


    /**
     * 封装 MaterialAlertDialogBuilder 方法
     * <p>图标、标题、内容、2个全宽按钮</p>
     */
    private void MaterialAlertDialogBuilderWithIconTitleMessageAnd2FullWidthAction() {
        MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(customGetActivity(), R.style.ThemeOverlay_Catalog_MaterialAlertDialog_FullWidthButtons);
        builder.setIcon(mIcon)
                .setTitle(mTitle)
                .setMessage(mMessage)
                .setPositiveButton(mPositive, null)
                .setNegativeButton(mNegative, null)
                .show();
    }


    /**
     * 封装 MaterialAlertDialogBuilder 方法
     * <p>图标、标题、内容、2个全宽居中按钮</p>
     */
    private void MaterialAlertDialogBuilderWithIconTitleMessageAnd2CenteredFullWidthAction() {
        MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(customGetActivity(), R.style.ThemeOverlay_Catalog_MaterialAlertDialog_Centered_FullWidthButtons);
        builder.setIcon(mIcon)
                .setTitle(mTitle)
                .setMessage(mMessage)
                .setPositiveButton(mPositive, null)
                .setNegativeButton(mNegative, null)
                .show();
    }

}