package com.example.piknik_v3;

import android.Manifest;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.telephony.SmsManager;
import android.telephony.TelephonyManager;
import android.widget.EditText;

public class Functions extends Activity {
    private static final String TODO = null;
    EditText editNum = (EditText) findViewById(R.id.deviceNumber);
    String deviceNumber = editNum.getText().toString();

    @TargetApi(Build.VERSION_CODES.M)
    String getUserNumber() {
        TelephonyManager tMgr = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        if (checkSelfPermission(Manifest.permission.READ_SMS) != PackageManager.PERMISSION_GRANTED && checkSelfPermission(Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    Activity#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for Activity#requestPermissions for more details.
            return TODO;
        }
        String mPhoneNumber = tMgr.getLine1Number();
        return mPhoneNumber;
    }

    void userRegister(){
        String userNumber = getUserNumber();
        sendMessage(3, getDeviceNumber());
    }

    String getDeviceNumber(){
        return deviceNumber;
    }

    void sendMessage(int power, String device_number){

        String messageText = null;

        switch (power){
            case 1:
                messageText = "CMON";
                break;
            case 2:
                messageText = "CMOF";
                break;
            case 3:
                messageText = "*123456*#" + getUserNumber() + "#";
                break;
            default:
                break;
        }

        SmsManager sms = SmsManager.getDefault();
        sms.sendTextMessage(device_number, null, messageText, null, null);
    }
}
