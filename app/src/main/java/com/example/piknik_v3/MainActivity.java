package com.example.piknik_v3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    Functions registrator = new Functions();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connect);
    }

    public void onClick(View view)
    {
        registrator.userRegister();
        Intent intent = new Intent(MainActivity.this, DeviceManage.class);
        startActivity(intent);
    }
}
