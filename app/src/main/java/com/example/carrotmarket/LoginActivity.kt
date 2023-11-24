package com.example.carrotmarket

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.carrotmarket.databinding.ActivityLoginBinding
import com.example.carrotmarket.local.getJwt
import com.example.carrotmarket.local.saveJwt
import com.example.carrotmarket.remote.AuthService
import com.example.carrotmarket.remote.LogInView

class LoginActivity : AppCompatActivity(), LogInView {
    lateinit var binding : ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityLoginBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.loginSignupBtn.setOnClickListener {
            val signupIntent = Intent(this, SignUpActivity::class.java)
            startActivity(signupIntent)
        }

        binding.btnLogin.setOnClickListener {
            val id = binding.loginIdEt.text.toString()
            val pw = binding.loginPwEt.text.toString()
            val authService = AuthService()
            authService.setLogInView(this)
            authService.logIn(id, pw)
        }
    }

    override fun LogInLoading() {
        // loading progress bar 보여주기
    }

    override fun LogInSuccess(nickname: String, token : String) {
        Toast.makeText(this,"로그인 성공", Toast.LENGTH_SHORT).show()
        saveJwt(token)
        onBackPressed()
    }

    override fun LogInFailure(code: Int, msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()

    }
}