package com.mixlr.panos.webviewdemo

import android.util.Log
import android.webkit.ConsoleMessage
import android.webkit.WebChromeClient

class MyWebChromeClient : WebChromeClient() {
    override fun onConsoleMessage(consoleMessage: ConsoleMessage?): Boolean {
        Log.d(
            MainActivity.logTag,
            "File: ${consoleMessage?.sourceId()}, line: ${consoleMessage?.lineNumber()}, ${consoleMessage?.message()}"
        )
        return true
    }
}
