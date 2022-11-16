package com.snowhitejsk.tppetme

import android.content.Context
import android.content.Intent
import android.location.Geocoder
import android.net.Uri
import android.text.Spanned
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.core.text.HtmlCompat
import androidx.recyclerview.widget.RecyclerView
import com.snowhitejsk.tppetme.databinding.RecyclerFacilityItemBinding
import java.util.*

class FacilityNaverSearchAdapter constructor(var context: Context, var items:MutableList<FacilityPlaces>) : RecyclerView.Adapter<FacilityNaverSearchAdapter.VH>(){

    inner class VH constructor(itemView: View): RecyclerView.ViewHolder(itemView){
        val binding: RecyclerFacilityItemBinding = RecyclerFacilityItemBinding.bind(itemView)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val itemView: View = LayoutInflater.from(context).inflate(R.layout.recycler_facility_item,parent,false)
        return VH(itemView)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        var title: Spanned = HtmlCompat.fromHtml(items[position].title, HtmlCompat.FROM_HTML_MODE_COMPACT)
        holder.binding.tvLink.text= items[position].link
        holder.binding.tvAddress.text= items[position].address
        holder.binding.tvTitle.text= items[position].title
        holder.binding.tvCategory.text= items[position].category
        //Glide.with(context).load(items[position].)

        holder.binding.tvLink.setOnClickListener{

            context.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(items[position].link)))
        }
        holder.binding.iv.setOnClickListener {


           context.startActivity(Intent(Intent.ACTION_VIEW,Uri.parse("geo:${items[position].mapy},${items[position].mapx}?z=15")))
/////////////////////////////
        }
    }

    override fun getItemCount(): Int = items.size

}