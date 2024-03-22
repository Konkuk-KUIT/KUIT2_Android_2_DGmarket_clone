package com.example.carrotmarket

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.example.carrotmarket.databinding.ActivityLoginBinding
import com.example.carrotmarket.remote.AuthService

class LoginActivity : AppCompatActivity() {
    lateinit var binding : ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLoginSignup.setOnClickListener {
            val signupIntent = Intent(this,SignupActivity::class.java)
            startActivity(signupIntent)
        }
    }
}