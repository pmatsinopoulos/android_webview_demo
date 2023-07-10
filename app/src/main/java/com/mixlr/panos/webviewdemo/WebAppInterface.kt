package com.mixlr.panos.webviewdemo

import android.content.Context
import android.webkit.JavascriptInterface
import android.widget.Toast

class WebAppInterface(private val mContext: Context) {
    // This is meant to be called by the WebView
    // Look at the project: https://github.com/pmatsinopoulos/simple_html_with_javascript
    //
    @JavascriptInterface
    fun showToast(toast: String) {
        Toast.makeText(mContext, toast, Toast.LENGTH_SHORT).show()
    }
}
