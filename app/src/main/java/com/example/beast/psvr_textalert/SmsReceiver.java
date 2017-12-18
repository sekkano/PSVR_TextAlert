package com.example.beast.psvr_textalert;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;

/**
 * Created by Beast on 12/18/17.
 */

public class SmsReceiver extends BroadcastReceiver {

    private static SmsListener mListener;

    @Override
    public void onReceive(Context context, Intent intent) {

        Bundle data = intent.getExtras();

        Object[] pdus = (Object[]) data.get("pdus");
        String format = data.getString("format");
        for (int i = 0; i < pdus.length; i++) {

            SmsMessage smsMessage = SmsMessage.createFromPdu((byte[]) pdus[i], format);

            String sender = smsMessage.getDisplayOriginatingAddress();

            String messageBody = smsMessage.getMessageBody();

            mListener.messageReceived(messageBody);
        }

    }

    public static void bindListener(SmsListener listener) {
        mListener = listener;
    }
}
