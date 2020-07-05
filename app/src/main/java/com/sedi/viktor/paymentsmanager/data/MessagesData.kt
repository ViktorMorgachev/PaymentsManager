package com.sedi.viktor.paymentsmanager.data

/**
 * Файл в котором будут временно хранится сообщения по платежам, по мере прихода
 * нового сообщения, будут сохранфятся в файле json
 * */
data class MessagesData(
    var messages: ArrayList<String>
)