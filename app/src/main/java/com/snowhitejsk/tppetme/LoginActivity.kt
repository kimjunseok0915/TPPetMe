package com.snowhitejsk.tppetme

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.kakao.sdk.auth.model.OAuthToken
import com.kakao.sdk.common.util.Utility
import com.kakao.sdk.user.UserApiClient
import com.snowhitejsk.tppetme.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    val binding: ActivityLoginBinding by lazy {ActivityLoginBinding.inflate(layoutInflater)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContentView(R.layout.activity_login)
        setContentView(binding.root)

        //둘러보기 글씨 클릭으로 로그인없이 Main 화면으로 이동
        binding.tvGo.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }

        binding.tvSignup.setOnClickListener{
            startActivity(Intent(this,SignupActivity::class.java))

        }

        //이메일 로그인
        binding.layoutEmail.setOnClickListener{
            startActivity(Intent(this, EmailLoginActivity::class.java))
        }

        //간편로그인 버튼들
        binding.btnLoginKakako.setOnClickListener{clickedLoginKakao()}
        binding.btnLoginGoogle.setOnClickListener{clickedLoginGoogle()}
        binding.btnLoginNaver.setOnClickListener{clickedLoginNaver()}

        //카카오 SDK 용 키해시 값 얻어오기
        var keyHash: String = Utility.getKeyHash(this)
        Log.i("KeyHash",keyHash)

    }
    private fun clickedLoginKakao() {
        //Kakao Login API를 이용하여 사용자 정보 취득

        // 로그인 시도한 결과를 받았을때 발동하는 콜백함수를 별도로 만들기
        val callback:( OAuthToken? , Throwable?)->Unit = { token, error ->
            if( error != null ) {
                Toast.makeText(this, "카카오로그인 실패", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this, "카카오로그인 성공", Toast.LENGTH_SHORT).show()

                //사용자 정보 요청
                UserApiClient.instance.me { user, error ->
                    if(user!=null){
                        var id:String = user.id.toString()
                        var email:String = user.kakaoAccount?.email ?: ""  //혹시 null이면 이메일의 기본값 ""

                        Toast.makeText(this, "사용자 이메일 정보 : $email", Toast.LENGTH_SHORT).show()
                        G.userAccount= UserAccount(id, email)

                        //로그인이 성공했으니.. Main 화면으로 전환
                        startActivity( Intent(this, MainActivity::class.java) )
                        finish()
                    }
                }
            }
        }

        // 카카오톡 로그인을 권장하지만 설치가 되어 있지 않다면 카카오계정으로 로그인 시도.
        if(UserApiClient.instance.isKakaoTalkLoginAvailable(this)){
            UserApiClient.instance.loginWithKakaoTalk(this, callback= callback )
        }else{
            UserApiClient.instance.loginWithKakaoAccount(this, callback = callback )
        }

    }
    private fun clickedLoginGoogle() {
        //구글 로그인 화면 (액티비티)를 실행하여 결과를 받아와서 사용자정보 취득


    }
    private fun clickedLoginNaver() {
        //사용자정보를 취득하는 토큰값을 발급받아  REST API 방식으로 사용자정보 취득

    }

}