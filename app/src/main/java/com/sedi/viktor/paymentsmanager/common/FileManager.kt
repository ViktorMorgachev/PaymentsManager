package com.sedi.viktor.paymentsmanager.common

import android.content.Context
import java.io.*

fun read(context: Context, fileName: String): String? {
    return try {
        val fis: FileInputStream = context.openFileInput(fileName)
        val isr = InputStreamReader(fis)
        val bufferedReader = BufferedReader(isr)
        val sb = StringBuilder()
        var line: String?
        while (bufferedReader.readLine().also { line = it } != null) {
            sb.append(line)
        }
        sb.toString()
    } catch (fileNotFound: FileNotFoundException) {
        null
    } catch (ioException: IOException) {
        null
    }
}

fun save(
    context: Context,
    fileName: String,
    jsonString: String?
): Boolean {

    return try {
        val fos: FileOutputStream = context.openFileOutput(fileName, Context.MODE_PRIVATE)
        if (jsonString != null) {
            fos.write(jsonString.toByteArray())
        }
        fos.close()
        true
    } catch (fileNotFound: FileNotFoundException) {
        false
    } catch (ioException: IOException) {
        false
    }
}

fun isFilePresent(context: Context, fileName: String): Boolean {
    val path: String = context.filesDir.absolutePath.toString() + "/" + fileName
    val file = File(path)
    return file.exists()
}