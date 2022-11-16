package com.snowhitejsk.tppetme

import android.app.Activity
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import com.snowhitejsk.tppetme.databinding.ActivitySearchedListBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SearchedListActivity : AppCompatActivity() {

    //val filteredList: MutableList<FacilityPlaces> = mutableListOf()
    private val binding: ActivitySearchedListBinding by lazy { ActivitySearchedListBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btn.setOnClickListener { searchItems() }
    }

    private fun searchItems(){
        //Naver 검색 API를 사용하여 검색어의 결과를 받아오기

        val imm: InputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE ) as InputMethodManager
        imm.hideSoftInputFromWindow(currentFocus?.windowToken,0 )

        val retrofit= ApiObject.getRetrofit()

//        //Retrofit을 이용하여 HTTP 통신 시작
//        val retrofit: Retrofit = Retrofit.Builder()
//            .baseUrl("https://openapi.naver.com")
//            .addConverterFactory(ScalarsConverterFactory.create())
//            .addConverterFactory(GsonConverterFactory.create()).build()

        val retrofitService = retrofit.create(NaverApiRetrofitService::class.java)
        // intent로 받아오는 값   장소
        var facility :String =""
        intent.getStringExtra("facility")?.let { facility = it }

        retrofitService.searchData(binding.et.text.toString()+ facility,"100").enqueue(object :
            Callback<NaverSearchResponse> {
            override fun onResponse(
                call: Call<NaverSearchResponse>,
                response: Response<NaverSearchResponse>
            ) {
                val apiResponse: NaverSearchResponse?= response.body()
                apiResponse?.items?.let {
                    binding.recyclerView.adapter= FacilityNaverSearchAdapter(this@SearchedListActivity,it)


                }
            }

            override fun onFailure(call: Call<NaverSearchResponse>, t: Throwable) {
                Toast.makeText(this@SearchedListActivity, "error : ${t.message}", Toast.LENGTH_SHORT).show()
            }

        })

    }
    fun clickItem(){

    }
}