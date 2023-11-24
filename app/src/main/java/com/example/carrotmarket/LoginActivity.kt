package com.example.carrotmarket

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.carrotmarket.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.loginSignupBtn.setOnClickListener{ // 회원가입(signup)버튼 눌렀을 때
            val signupIntent = Intent(this, SignupActivity::class.java)
            startActivity(signupIntent) // 인텐트로 signup activity로 넘어가도록 함
        }
    }
}