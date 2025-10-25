package com.williamtdepaula.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.williamtdepaula.myapplication.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityLoginBinding.inflate(layoutInflater)

        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left + 16, systemBars.top + 16, systemBars.right + 16, systemBars.bottom + 16)
            insets
        }

        binding.btnLogin.setOnClickListener(this)
        binding.btnRegister.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        view?.let {
            when (it.id) {
                R.id.btn_login -> {
                    val intent = Intent(this, HomeActivity::class.java)

                    val email = binding.loginField.text.toString()

                    intent.putExtra("EMAIL", email)
                    startActivity(intent)
                }
                R.id.btn_register -> {
                    Toast.makeText(this, "Hey this functionality is being developed", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}