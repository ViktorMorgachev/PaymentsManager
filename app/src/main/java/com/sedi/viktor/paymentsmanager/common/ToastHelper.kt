package com.sedi.viktor.paymentsmanager.common

import android.content.Context
import android.widget.Toast

fun showToast(context: Context, message: String, longToast: Boolean = false) {
    if (longToast)
        Toast.makeText(context, message , Toast.LENGTH_LONG).show()
    else Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
}