package com.sedi.viktor.paymentsmanager.storage

import android.content.Context
import com.google.gson.Gson
import com.sedi.viktor.paymentsmanager.common.isFilePresent
import com.sedi.viktor.paymentsmanager.common.read
import com.sedi.viktor.paymentsmanager.common.save
import com.sedi.viktor.paymentsmanager.common.showToast
import com.sedi.viktor.paymentsmanager.data.MessagesData
import com.sedi.viktor.paymentsmanager.interfaces.IPayments

class PaymentsManager private constructor() : IPayments {

    private var messagesFile: String = "messages.json"

    companion object {
        private var instance = PaymentsManager()
        fun Instance(): PaymentsManager {
            return instance
        }
    }

    override fun saveMessage(context: Context, message: String) {
        val isFilePresent: Boolean = isFilePresent(context, messagesFile)
        if (isFilePresent) {
            val jsonFile =
                Gson().fromJson(read(context, messagesFile), MessagesData::class.java)
            if (jsonFile != null) {
                var messages: ArrayList<String> = jsonFile.messages
                messages.add(message)
                jsonFile.messages = messages
                if (save(context, messagesFile, Gson().toJson(jsonFile)))
                    showToast(context, "Успешно сохранили сообщение")
            }
        }
    }

    override fun getAllMessages(context: Context): ArrayList<String> {
        val isFilePresent: Boolean = isFilePresent(context, messagesFile)
        return if (!isFilePresent) {
            arrayListOf()
        } else {
            val jsonFile =
                Gson().fromJson(read(context, messagesFile), MessagesData::class.java)
            jsonFile.messages
        }

    }


}
