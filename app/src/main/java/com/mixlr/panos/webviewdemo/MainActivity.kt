package com.mixlr.panos.webviewdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mixlr.panos.webviewdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.wvDemo.loadUrl("https://www.mixlr.com")
    }
}
