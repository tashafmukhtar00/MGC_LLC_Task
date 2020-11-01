package com.tashi.mgc_llc_task;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ImageView mCounterImageView;
    private TextView mCounterTextView;


    int mDeviceUnlocked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        registerReceiver(new PhoneUnlockedReceiver(), new IntentFilter("android.intent.action.USER_PRESENT"));
        registerReceiver(broadcastReceiver, new IntentFilter("broadCastName"));


    }

    private void initViews() {

        mCounterImageView = findViewById(R.id.imageViewCounter);
        mCounterTextView = findViewById(R.id.textViewCounter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        //  mCounterTextView.setText("Device Unlocted "+ mDeviceUnlocked + " times");
    }


    BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @SuppressLint("SetTextI18n")
        @Override
        public void onReceive(Context context, Intent intent) {

            Bundle b = intent.getExtras();

            mDeviceUnlocked = b.getInt("message");
            mCounterTextView.setText("Device Unlocked " + mDeviceUnlocked + " times");

            switch (mDeviceUnlocked) {
                case 0: {
                    mCounterImageView.setBackgroundResource(R.drawable.zero);

                }
                break;
                case 1: {
                    mCounterImageView.setBackgroundResource(R.drawable.one);

                }
                break;
                case 2: {
                    mCounterImageView.setBackgroundResource(R.drawable.two);

                }
                break;
                case 3: {
                    mCounterImageView.setBackgroundResource(R.drawable.three);
                }
                break;

                case 4: {
                    mCounterImageView.setBackgroundResource(R.drawable.four);
                }
                break;
                case 5: {
                    mCounterImageView.setBackgroundResource(R.drawable.five);

                }
                break;

                case 6: {
                    mCounterImageView.setBackgroundResource(R.drawable.six);
                }
                break;

                case 7: {
                    mCounterImageView.setBackgroundResource(R.drawable.seven);
                }
                break;

                case 8: {
                    mCounterImageView.setBackgroundResource(R.drawable.eight);
                }
                break;

                case 9: {
                    mCounterImageView.setBackgroundResource(R.drawable.nine);
                }
                break;

                case 10: {
                    mCounterImageView.setBackgroundResource(R.drawable.ten);
                }
                break;

                default: {
                    mCounterImageView.setBackgroundResource(R.drawable.tenplus);
                }
                break;


            }


        }
    };

    @Override
    protected void onStop() {
        super.onStop();
    }
}