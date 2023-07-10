package com.mixlr.panos.webviewdemo

import android.os.Bundle
import android.util.Base64
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var wvDemo: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        wvDemo = WebView(this)
        setContentView(wvDemo)
    }

    override fun onStart() {
        super.onStart()

        loadHtml()
    }

    private fun loadHtml() {
        val unencodedHTML =
            "<html><head></head><body>'%23' is the percent code for '#'</body></html>"
        val encodedHTML = Base64.encodeToString(unencodedHTML.toByteArray(), Base64.NO_PADDING)
        wvDemo.loadData(encodedHTML, "text/html", "base64")
    }
}
