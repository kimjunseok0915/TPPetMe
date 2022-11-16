package com.snowhitejsk.tppetme

import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Query

interface NaverApiRetrofitService {

    //우선 naver 검색 api의 json 결과를 파싱하지 않고 그냥 문자열로 받아오는 기능 추상메소드 작성
    @GET("v1/search/local.json")
    fun searchDataString(@Query("query") query: String, @Header("X-Naver-Client-Id") clientId:String, @Header("X-Naver-Client-Secret") clientSecret:String): Call<String>

    //검색결과 json 형식을 NaverSearchResponse 객체로 자동 파싱하여 받아오는 기능 추상메소드 작성
    //Header 에 값이 고정적이며 여러개라면..
    @Headers("X-Naver-Client-Id:ZfgL0fZAIGDUQRuCqoRH","X-Naver-Client-Secret:wN4s1eB3QP" )
    @GET("v1/search/local.json")
    fun searchData(@Query("query") query: String, @Query("display") display: String): Call<NaverSearchResponse>
}


object ApiObject {
    private val BASE_URL = "https://openapi.naver.com"

    var gson = GsonBuilder().setLenient().create()

    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))

            .build()
    }


}