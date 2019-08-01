package com.example.piknik_v3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class DeviceManage extends AppCompatActivity {

    Functions manager = new Functions();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device_manage);
    }

    public void on(View view) {
        manager.sendMessage(1, manager.getDeviceNumber());
    }

    public void off(View view) {
        manager.sendMessage(2, manager.getDeviceNumber());
    }
}
