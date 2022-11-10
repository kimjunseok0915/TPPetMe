package com.snowhitejsk.tppetme


import android.content.ClipData
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.snowhitejsk.tppetme.databinding.RecyclerAbondonItemBinding


class AbondonListAdapter constructor(var context: Context, var animalList: MutableList<Animals>) : RecyclerView.Adapter<com.snowhitejsk.tppetme.AbondonListAdapter.VH>() {


    inner class VH constructor(itemView: View): RecyclerView.ViewHolder(itemView){
        val binding: RecyclerAbondonItemBinding= RecyclerAbondonItemBinding.bind(itemView)
        init { binding.root.setOnClickListener { clickItem(adapterPosition) }

        }



    }
    fun clickItem(position: Int){
        var dialog =AlertDialog.Builder(context).setView(R.layout.alertdialog_abondonment).show()

        var popfile=dialog.findViewById<ImageView>(R.id.iv_popfile)
        var kindCd=dialog.findViewById<TextView>(R.id.tv_kindCd)
        var age=dialog.findViewById<TextView>(R.id.tv_age)
        var sexCd=dialog.findViewById<TextView>(R.id.tv_SexCd)
        var weight=dialog.findViewById<TextView>(R.id.tv_weight)
        var specialMark=dialog.findViewById<TextView>(R.id.tv_specialMark)
        var careNm=dialog.findViewById<TextView>(R.id.tv_careNm)
        var careTel=dialog.findViewById<TextView>(R.id.tv_careTel)
        var careAddr=dialog.findViewById<TextView>(R.id.tv_careAddr)


        Glide.with(context).load(animalList[position].popfile).error(R.drawable.simple_dog).into(popfile!!)
        kindCd?.text= "품종 ${animalList[position].kindCd}"
        age?.text= "나이 ${animalList[position].age}"
        sexCd?.text= "성: ${animalList[position].sexCd}"
        weight?.text="몸무게: ${animalList[position].weight}"
        specialMark?.text= "특징: ${animalList[position].specialMark}"
        careNm?.text="보호소 이름: ${animalList[position].careNm}"
        careTel?.text="보호소 전화번호: ${animalList[position].careTel}"
        careAddr?.text= "보호소 주소: ${animalList[position].careAddr}"



    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): com.snowhitejsk.tppetme.AbondonListAdapter.VH {
        val layoutInflater : LayoutInflater = LayoutInflater.from(context)
        val itemView: View = layoutInflater.inflate(R.layout.recycler_abondon_item,parent,false)
        return VH(itemView)
    }

    override fun onBindViewHolder(holder:com.snowhitejsk.tppetme.AbondonListAdapter.VH, position: Int) {
        val item: Animals = animalList[position]
        holder.binding.tvSexCd.text = "성: ${item.sexCd}"
        holder.binding.tvAge.text= "나이: ${item.age} "
        holder.binding.tvWeight.text= "몸무게: ${item.weight}"
        holder.binding.tvSpecialMark.text="특징: ${item.specialMark}"


        Glide.with(context).load(item.popfile).error(R.drawable.simple_dog).into(holder.binding.ivPopfile)






    }

    override fun getItemCount(): Int {
       // Log.d("Tag",animalList.size.toString())


        return animalList.size


    }

}
