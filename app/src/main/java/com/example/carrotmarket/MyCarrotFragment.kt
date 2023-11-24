package com.example.carrotmarket

import android.content.Intent
import android.opengl.Visibility
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.example.carrotmarket.databinding.FragmentMyBinding
import com.example.carrotmarket.local.getJwt
import com.example.carrotmarket.local.removeJwt
import com.example.carrotmarket.remote.AuthService
import com.example.carrotmarket.remote.UserView
import com.example.carrotmarket.remote.XAccessTokenInterceptor

class MyCarrotFragment : Fragment(), UserView {
    lateinit var binding : FragmentMyBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMyBinding.inflate(layoutInflater)
        userLogInManager()

        binding.tvBtnLogin.setOnClickListener {
            val logIntent = Intent(requireContext(),LoginActivity::class.java)
            startActivity(logIntent)
        }

        binding.tvBtnLogout.setOnClickListener {
            removeJwt()
            binding.tvBtnLogout.isGone = true
            binding.tvBtnLogin.isVisible = true
            binding.tvLoginNickname.text = "로그인 후 이용해주세요"

        }

        return binding.root
    }

    private fun userLogInManager() {
        val token = getJwt()
        Log.d("token", token)
        if(token.isNotEmpty()) {
            val authService = AuthService()
            authService.setUserView(this)
            authService.userInfo()
        } else {
            binding.tvBtnLogout.isGone = true
            binding.tvBtnLogin.isVisible = true
            binding.tvLoginNickname.text = "로그인 후 이용해주세요"
        }
    }


    override fun UserLoading() {
        // loading progress bar 보여주기
    }

    override fun UserSuccess(userId: String, nickname: String) {
        binding.tvLoginNickname.text = nickname
        binding.tvBtnLogout.isVisible = true
        binding.tvBtnLogin.isGone = true
    }

    override fun onResume() {
        super.onResume()
        userLogInManager()
    }

}