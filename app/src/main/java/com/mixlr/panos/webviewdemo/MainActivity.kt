package com.mixlr.panos.webviewdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView

class MainActivity : AppCompatActivity() {
    private lateinit var wvDemo: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        wvDemo = WebView(this)
        setContentView(wvDemo)
    }

    override fun onStart() {
        super.onStart()

        wvDemo.loadUrl("https://www.mixlr.com")
    }
}
