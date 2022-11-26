package com.la.playground3.view.apps.demo.sensor;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.widget.LinearLayoutCompat;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textview.MaterialTextView;
import com.la.playground3.R;
import com.la.playground3.common.CustomActivity;

public class SensoRedPacketDemoActivity extends CustomActivity implements SensorEventListener {


    private static final float NS2S = 1.0f / 1000000000.0f; // 将纳秒转化为秒
    private final float[] mAngle = new float[3]; // 记录xyz三个方向上的旋转角度
    private final float[] mTempAngle = new float[3]; // 记录xyz三个方向上的旋转角度
    private MaterialToolbar sensorMainMtb;
    private TextView sensorMainTv;
    private float mTimestamp; // 记录上次的时间戳
    private SensorManager mSensorMgr;// 声明一个传感管理器对象 private float mTimestamp; // 记录上次的时间戳
    private boolean mIsEnableListener = false;
    private MaterialButton sensorMainBtnSaveStatus;
    private FloatingActionButton sensorMainFtbRun;
    private int shakeCount = 0;
    private int shakeMoney = 0;

    /**
     * 手机振动器
     */
    private Vibrator vibrator;
    private TextView sensorMainTvCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_senso_red_packet_demo);

        initView();
        initToolBar();
        initSensor();
        mSensorMgr = (SensorManager) getSystemService(SENSOR_SERVICE);
        // 震动效果的系统服务
        vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
    }

    private void initSensor() {
        sensorMainTv.setText("test");

    }

    private void initToolBar() {
        sensorMainMtb.setNavigationOnClickListener(view -> finish());
    }

    private void initView() {
        sensorMainMtb = (MaterialToolbar) findViewById(R.id.sensor_main_mtb);
        sensorMainTv = (TextView) findViewById(R.id.sensor_main_tv);
        sensorMainBtnSaveStatus = (MaterialButton) findViewById(R.id.sensor_main_btn_save_status);
        sensorMainFtbRun = (FloatingActionButton) findViewById(R.id.sensor_main_ftb_run);

        sensorMainBtnSaveStatus.setOnClickListener(view -> saveStatus());
        sensorMainFtbRun.setOnClickListener(view -> run());
        sensorMainTvCount = (TextView) findViewById(R.id.sensor_main_tv_count);
    }

    private void run() {
        if (mIsEnableListener) {
            mIsEnableListener = false;
            customToast("关闭");
        } else {
            saveStatus();
            mIsEnableListener = true;
            customToast("开启");
        }

    }

    private void saveStatus() {
        mTempAngle[0] = mAngle[0];
        mTempAngle[1] = mAngle[1];
        mTempAngle[2] = mAngle[2];
//        customDialog("记录成功", mTempAngle[0] + "\n" + mTempAngle[1] + "\n" + mTempAngle[2]);
    }


//    @Override
//    protected int getContentLayoutId() {
//        return R.layout.activity_main;
//    }
//
//    @Override
//    protected void initWidget() {
//// 从系统服务中获取传感管理器对象
//        mSensorMgr = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
//    }

    @Override
    protected void onPause() {
        super.onPause();
// 注销当前活动的传感监听器
        mSensorMgr.unregisterListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
//注册感光器
        mSensorMgr.registerListener(this, mSensorMgr.getDefaultSensor(Sensor.TYPE_GYROSCOPE), SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_GYROSCOPE) { // 陀螺仪⾓度变更事件
            if (mTimestamp != 0) {
                final float dT = (event.timestamp - mTimestamp) * NS2S;
                mAngle[0] += event.values[0] * dT;
                mAngle[1] += event.values[1] * dT;
                mAngle[2] += event.values[2] * dT;
// x轴的旋转⾓度，⼿机平放桌上，然后绕侧边转动
                float angleX = (float) Math.toDegrees(mAngle[0]);
// y轴的旋转⾓度，⼿机平放桌上，然后绕底边转动
                float angleY = (float) Math.toDegrees(mAngle[1]);
// z轴的旋转⾓度，⼿机平放桌上，然后⽔平旋转
                float angleZ = (float) Math.toDegrees(mAngle[2]);
//                String desc = String.format("陀螺仪检测到当前\nx轴⽅向的转动⾓度为%f\ny轴⽅向的转动⾓度为%f\nz轴⽅向的转动⾓度为%f\n\n\n缓存存储x转动⾓度为%f\n缓存存储y转动⾓度为%f\n缓存存储z转动⾓度为%f", angleX, angleY, angleZ, mTempAngle[0], mTempAngle[1], mTempAngle[2]);

//                System.out.println("失败" + ((mAngle[0] - mTempAngle[0]) + " " + (mAngle[1] - mTempAngle[1]) + " " + (mAngle[2] - mTempAngle[2])));
//                System.out.println("失败" + ((mAngle[0] - mTempAngle[0] >= 1.0) + " " + (mAngle[1] - mTempAngle[1]>= -1.0) + " " + (mAngle[2] - mTempAngle[2]>= -1.0)));
                if (mIsEnableListener) {
                    if (mAngle[0] - mTempAngle[0] >= 1.0 || mAngle[0] - mTempAngle[0] <= -1.0 || mAngle[1] - mTempAngle[1] >= 1.0 || mAngle[1] - mTempAngle[1] <= -1.0 || mAngle[2] - mTempAngle[2] >= 1.0 || mAngle[2] - mTempAngle[2] <= -1.0) {
                        run();
//                        customDialog("触发成功！", "开始震动！\n点击 OK 以关闭检测");
                        requestVibration();
                        shakeCount += 1;
                        shakeMoney = (int) (1 + Math.random() * (30 - 1 + 1)) + shakeMoney;
                        sensorMainTv.setText("第" + shakeCount + "次" + shakeMoney + "元");
                        LinearLayoutCompat linearLayoutCompat = new LinearLayoutCompat(customGetActivity());
                        linearLayoutCompat.setBackgroundColor(this.getResources().getColor(R.color.red_light));
                        linearLayoutCompat.setOrientation(LinearLayoutCompat.VERTICAL);
                        linearLayoutCompat.setGravity(Gravity.CENTER_HORIZONTAL);
                        linearLayoutCompat.setMinimumHeight(1000);
                        linearLayoutCompat.setMinimumWidth(100);
                        MaterialTextView materialTextView = new MaterialTextView(customGetActivity());
                        materialTextView.setText("恭喜你🎉");
                        materialTextView.setPadding(50, 50, 50, 50);
                        materialTextView.setTextSize(25);
                        materialTextView.setGravity(View.TEXT_ALIGNMENT_CENTER);
                        materialTextView.setTextColor(this.getResources().getColor(R.color.white));
                        MaterialTextView materialTextView1 = new MaterialTextView(customGetActivity());
                        materialTextView1.setText("你摇中了" + shakeMoney + "元！");
                        materialTextView1.setPadding(50, 50, 50, 50);
                        materialTextView1.setGravity(View.TEXT_ALIGNMENT_CENTER);
                        materialTextView1.setTextColor(this.getResources().getColor(R.color.white));
                        linearLayoutCompat.addView(materialTextView);
                        linearLayoutCompat.addView(materialTextView1);
                        MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(customGetActivity());
                        builder.setView(linearLayoutCompat);
//                        builder.setPositiveButton("领取", null);
                        builder.show();
                    }
                }

            }
            mTimestamp = event.timestamp;
        }
    }

    private void requestVibration() {
        long[] pattern = {2000};
        vibrator.vibrate(pattern, -1);
    }

    //当传感器精度改变时回调该⽅法，⼀般⽆需处理
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }

}