package com.tashi.mgc_llc_task;

import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class PhoneUnlockedReceiver extends BroadcastReceiver {

    private int deveiceLocked  = 0;

    @Override
    public void onReceive(Context context, Intent intent) {

        KeyguardManager keyguardManager = (KeyguardManager)context.getSystemService(Context.KEYGUARD_SERVICE);
        if (keyguardManager.isKeyguardSecure()) {

            deveiceLocked ++;


            Bundle extras = intent.getExtras();
            Intent i = new Intent("broadCastName");
            // Data you need to pass to activity
            i.putExtra("message", deveiceLocked);

            context.sendBroadcast(i);
            //phone was unlocked, do stuff here




        }
    }
}
