package com.mixlr.panos.webviewdemo

import android.os.Bundle
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var wvDemo: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        wvDemo = WebView(this)
        wvDemo.settings.javaScriptEnabled = true
        wvDemo.addJavascriptInterface(WebAppInterface(this), "Android")
        // Will allow the navigation links to make the user stay within the app and not
        // open the default browser.
        wvDemo.webViewClient = MyWebViewClient(this)
        setContentView(wvDemo)
    }

    override fun onStart() {
        super.onStart()

        loadHtml()
    }

    private fun loadHtml() {
        wvDemo.loadUrl("https://simple-html-with-javascript.vercel.app")
    }
}
