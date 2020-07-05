package com.sedi.viktor.paymentsmanager.brodcasts

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.provider.Telephony
import android.util.Log
import com.sedi.viktor.paymentsmanager.common.showToast

class NotificationMonitor : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        Log.i("NotificationMonitor", "onReceive()")
        if (context != null && intent != null) {
            var message = intent.getStringExtra(Telephony.Sms.Intents.SMS_RECEIVED_ACTION)
            if (message != null && message.isNotEmpty())
                showToast(context, message)
        }
    }
}