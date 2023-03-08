package com.example.basicnotepad

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Toolbar
import androidx.appcompat.app.ActionBar
import com.example.basicnotepad.Activities.TelaLogin
import com.example.basicnotepad.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.statusBarColor = Color.parseColor("#FB0303")
        supportActionBar!!.hide()

        Handler(Looper.getMainLooper()).postDelayed({
          val intent = Intent(this,TelaLogin::class.java)
          startActivity(intent)
        },1500)
    }
}


