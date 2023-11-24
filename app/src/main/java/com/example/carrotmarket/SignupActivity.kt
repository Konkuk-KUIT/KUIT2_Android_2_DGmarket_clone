package com.example.carrotmarket

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.carrotmarket.databinding.ActivitySignupBinding
import com.example.carrotmarket.remote.AuthService

class SignupActivity : AppCompatActivity() {

    lateinit var binding : ActivitySignupBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.signinBtn.setOnClickListener {
            val id = binding.signinIdEt.text.toString()
            val pw = binding.signinPwEt.text.toString()
            val name = binding.signinNameEt.text.toString()
            val authService = AuthService()
            authService.signUp(id, pw, name)
        }
    }
}