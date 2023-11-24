package com.example.carrotmarket

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.carrotmarket.databinding.ActivitySignupBinding
import com.example.carrotmarket.remote.AuthService
import com.example.carrotmarket.remote.SignUpView

class SignUpActivity : AppCompatActivity(), SignUpView {
    lateinit var binding: ActivitySignupBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.signinBtn.setOnClickListener {
            val id = binding.signinIdEt.text.toString()
            val pw = binding.signinPwEt.text.toString()
            val name = binding.signinNameEt.text.toString()
            val authService = AuthService()
            authService.setSignUpView(this)
            authService.signUp(id, pw, name)
        }
    }

    override fun SignUpLoading() {
        // loading progress bar 보여주기
    }

    override fun SignUpSuccess() {
        Toast.makeText(this,"회원가입에 성공했습니다. 해당 계정으로 로그인 해주세요.", Toast.LENGTH_SHORT).show()
        onBackPressed()
    }

    override fun SignUpFailure(code: Int, msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()

    }
}