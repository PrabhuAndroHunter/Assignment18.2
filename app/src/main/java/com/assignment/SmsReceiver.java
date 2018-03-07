package com.assignment;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;

/**
 * Created by prabhu on 6/3/18.
 */

public class SmsReceiver extends BroadcastReceiver {
    final String TAG = SmsReceiver.class.toString();

    // this method gets called when new message came
    public void onReceive(Context context, Intent intent) {

        // get data from the intent.
        final Bundle smsBundle = intent.getExtras();

        try {

            if (smsBundle != null) {
                final Object[] smsObj = (Object[]) smsBundle.get("pdus");
                for (int i = 0; i < smsObj.length; i++) {
                    SmsMessage message = SmsMessage.createFromPdu((byte[]) smsObj[i]);
                    String phoneNumber = message.getDisplayOriginatingAddress(); // get Phone Number
                    String msg = message.getDisplayMessageBody(); // get actual message
                    Log.d(TAG, "onReceive: msg"+msg);
                    Log.d(TAG, "onReceive: phone number "+phoneNumber);
                   new MainActivity().showSms(msg);
                }
            }
        } catch (Exception e) {
            Log.e(TAG, "onReceive: " + e.getMessage());
        }
    }
}