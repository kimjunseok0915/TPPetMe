package com.snowhitejsk.tppetme

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.snowhitejsk.tppetme.databinding.ActivityLoginBinding
import com.snowhitejsk.tppetme.databinding.ActivitySignupBinding

class SignupActivity : AppCompatActivity() {

    val binding:ActivitySignupBinding by lazy { ActivitySignupBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_signup)
        setContentView(binding.root)

        //툴바를 액션바로 설정
        setSupportActionBar(binding.toolbar)
        //액션바에 업버튼 설정 및 제목글씨 제거
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_24)

        binding.btnSignup.setOnClickListener{ clickSignUp()}


    }

    //업버튼 클릭할때 자동 발동하는 콜백메소드
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }

    private fun clickSignUp(){
        //Firebase Firestore DB에 사용자 정보 저장하기[앱과 firebase 플랫폼 연동]

    }

}