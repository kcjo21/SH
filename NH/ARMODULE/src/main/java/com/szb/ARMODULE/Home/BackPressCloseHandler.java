package com.szb.ARMODULE.Home;

import android.app.Activity;
import android.content.Intent;
import android.widget.Toast;

import com.szb.ARMODULE.start_pack.MainActivity;

public class BackPressCloseHandler {           //백키 핸들러
    private long backKeyPressedTime = 0;
    private Toast toast;

    private Activity activity;

    public BackPressCloseHandler(Activity context) {
        this.activity = context;
    }



    public void onBackPressed() {
        if (System.currentTimeMillis() > backKeyPressedTime + 2000) {
            backKeyPressedTime = System.currentTimeMillis();
            showGuide();
            return;
        }
        if (System.currentTimeMillis() <= backKeyPressedTime + 2000) {
            toast.cancel();
            activity.moveTaskToBack(true);
            activity.finish();

            android.os.Process.killProcess(android.os.Process.myPid());
        }
    }

    public void showGuide() {
        toast = Toast.makeText(activity, "한번 더 누르시면 종료됩니다.", Toast.LENGTH_SHORT); //백키 토스트 출력
        toast.show();
    }

}