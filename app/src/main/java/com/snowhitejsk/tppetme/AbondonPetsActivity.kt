package com.snowhitejsk.tppetme

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.ListAdapter
import com.snowhitejsk.tppetme.databinding.ActivityAbondonpetsBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.SimpleDateFormat
import java.util.*

class AbondonPetsActivity : AppCompatActivity() {

    var list: MutableList<Animals> = mutableListOf()

    private val binding: ActivityAbondonpetsBinding by lazy { ActivityAbondonpetsBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val retrofit= AbondonmentApiObject.getRetrofit()
        val retrofitService= retrofit.create(AbAPI::class.java)

        //필요한 요청변수들
        // 7일 전
        val bgnde = SimpleDateFormat("yyyyMMdd").format(System.currentTimeMillis()-1000*60*60*24*7) //
        val endde = SimpleDateFormat("yyyyMMdd").format(Date())
        var upkind =""// intent 으로 받아옴 (고양이 or 개)
        var upr_Cd= "6110000" //서울
        val type="json"
        var numOfRows = "999"
        val serviceKey= "jT1odgJTIqRW1BamLrq/B/xDrfT3g04w/36arfQHMyu0myDGAmZCgs2w6zrH8wXFwuUTKSKxEBmDgs/iaijdIA=="

        // intent로 받아오는 값
        intent.getStringExtra("upkind")?.let { upkind = it }

        retrofitService.getAnimal(bgnde,endde,upkind,upr_Cd,type,serviceKey,numOfRows).enqueue(
            object : Callback<First> {
                override fun onResponse(call: Call<First>, response: Response<First>) {

                    val apiResponse= response.body()
                    list= apiResponse!!.response.body.items.item
                    binding.abondonRecyclerView.adapter=AbondonListAdapter(this@AbondonPetsActivity,list)
                    //binding.abondonRecyclerView.adapter?.notifyDataSetChanged()
                    Log.i("Tag",list.size.toString())
                }

                override fun onFailure(call: Call<First>, t: Throwable) {
                    Log.i("Tag", t.message!!)
                    Toast.makeText(this@AbondonPetsActivity, t.message, Toast.LENGTH_SHORT).show()

                }


            })




    }
}