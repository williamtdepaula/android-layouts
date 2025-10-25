package com.williamtdepaula.myapplication

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.williamtdepaula.myapplication.databinding.ActivityHomeBinding
import com.williamtdepaula.myapplication.databinding.ActivityHomeRelativeLayoutBinding

class HomeRelativeLayoutActivity : AppCompatActivity() {
    lateinit var binding: ActivityHomeRelativeLayoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityHomeRelativeLayoutBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_home_relative_layout)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left + binding.main.paddingStart, systemBars.top, systemBars.right + binding.main.paddingEnd, systemBars.bottom)
            insets
        }
    }
}