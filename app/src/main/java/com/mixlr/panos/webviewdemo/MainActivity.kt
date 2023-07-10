package com.mixlr.panos.webviewdemo

import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity
import androidx.webkit.WebViewCompat

class MainActivity : AppCompatActivity() {
    companion object {
        const val logTag = "WebViewDemo"
    }

    private lateinit var wvDemo: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        wvDemo = WebView(this)
        wvDemo.settings.javaScriptEnabled = true
        wvDemo.addJavascriptInterface(WebAppInterface(this), "Android")
        // By default the viewport is set to a large size. 980px wide. 
        wvDemo.settings.useWideViewPort = true
        // Will allow the navigation links to make the user stay within the app and not
        // open the default browser.
        wvDemo.webViewClient = MyWebViewClient(this)
        setContentView(wvDemo)

        logWebViewPackageInfo()
    }

    override fun onStart() {
        super.onStart()

        loadHtml()
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK && wvDemo.canGoBack()) {
            wvDemo.goBack()
            return true
        }
        return super.onKeyDown(keyCode, event)
    }

    private fun loadHtml() {
        wvDemo.loadUrl("https://simple-html-with-javascript.vercel.app")
    }

    private fun logWebViewPackageInfo() {
        val webViewPackageInfo = WebViewCompat.getCurrentWebViewPackage(this.applicationContext)
        Log.d(logTag, "WebView version: ${webViewPackageInfo?.versionName}")
    }
}
