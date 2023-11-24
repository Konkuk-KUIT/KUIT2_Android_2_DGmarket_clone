package com.example.carrotmarket

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.carrotmarket.databinding.ActivitySignupBinding
import com.example.carrotmarket.remote.AuthService
import com.example.carrotmarket.remote.SignupView

class SignupActivity : AppCompatActivity(), SignupView {
    lateinit var binding : ActivitySignupBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSignin.setOnClickListener {
            val id = binding.etSigninId.text.toString()
            val pw = binding.etSigninPw.text.toString()
            val name = binding.etSigninName.text.toString()
            val authService = AuthService()
            authService.setSignupView(this)
            authService.signUp(id,pw,name)
        }
    }

    override fun SignupLoading() {
        //show loading process bar
    }

    override fun SignupSuccess() {
        Toast.makeText(this,"회원가입에 성공했습니다. 해당 계정으로 로그인해주세요.",Toast.LENGTH_SHORT).show()
        onBackPressed()
    }

    override fun SignupFailure(code: Int, msg : String) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show()
    }
}