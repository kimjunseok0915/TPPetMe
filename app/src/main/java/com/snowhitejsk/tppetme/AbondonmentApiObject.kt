package com.snowhitejsk.tppetme


import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

object AbondonmentApiObject {
    private val BASE_URL = "http://apis.data.go.kr/"

    var gson = GsonBuilder().setLenient().create()

    fun getRetrofit():Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))

            .build()
    }


}
interface AbAPI {


    @GET("1543061/abandonmentPublicSrvc/abandonmentPublic")
    fun getAnimal(
        @Query("bgnde")      bgnde : String,
        @Query("endde")      endde :  String,
        @Query("upkind")     upkind : String,
        @Query("upr_cd")     upr_cd : String,
        @Query("_type")       type : String,
        @Query("serviceKey") servicekey : String,
        @Query("numOfRows") numOfRows : String

    ): Call<First>

    @GET("1543061/abandonmentPublicSrvc/abandonmentPublic")
    fun getAnimalscal(
        @Query("bgnde")      bgnde : String,
        @Query("endde")      endde :  String,
        @Query("upkind")     upkind : String,
        @Query("upr_cd")     upr_cd : String,
        @Query("_type")       type : String,
        @Query("serviceKey") servicekey : String

    ): Call<String>
}