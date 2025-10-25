package com.williamtdepaula.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.williamtdepaula.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left + binding.main.paddingStart, systemBars.top, systemBars.right + binding.main.paddingEnd, systemBars.bottom)
            insets
        }

        binding.btnLinearLayout.setOnClickListener(this)
        binding.btnCompose.setOnClickListener(this)
        binding.btnRelativeLayout.setOnClickListener(this)
        binding.btnConstraint.setOnClickListener(this)

    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.btn_linear_layout -> {
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
            }
            R.id.btn_compose -> {
                val intent = Intent(this, LoginComposeView::class.java)
                startActivity(intent)
            }
            R.id.btn_relative_layout -> {
                val intent = Intent(this, HomeRelativeLayoutActivity::class.java)
                startActivity(intent)
            }
            R.id.btn_constraint -> {
                val intent = Intent(this, ConstraintActivity::class.java)
                startActivity(intent)
            }
        }
    }
}