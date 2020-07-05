package com.sedi.viktor.paymentsmanager.interfaces

import android.content.Context
import com.sedi.viktor.paymentsmanager.common.isFilePresent

interface IPayments {
    fun saveMessage(context: Context, message: String)
    fun getAllMessages(context: Context): ArrayList<String>
}