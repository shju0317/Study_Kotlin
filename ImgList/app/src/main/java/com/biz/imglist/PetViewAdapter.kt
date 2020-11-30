package com.biz.imglist

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text

class PetViewAdapter(private val petList:ArrayList<PetVO>, private val context: Context) : RecyclerView.Adapter<PetViewAdapter.PetViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PetViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.pet_item, parent, false)
        return PetViewHolder(view)
    }

    override fun onBindViewHolder(holder: PetViewHolder, position: Int) {
        holder.txtName.text = petList[position].name
        holder.txtAge.text = petList[position].age.toString()
        holder.txtGender.text = petList[position].gender

        if(petList[position].photo != ""){
            // 이미지 이름에서 id값 추출하기
            val resId = context.resources.getIdentifier(petList[position].photo,"drawable",context.packageName)
            holder.imgPhoto.setImageResource(resId)
        }else{
            // 이미지가 없으면 안드로이드 기본 아이콘 보여주기
            holder.imgPhoto.setImageResource(R.mipmap.ic_launcher)
        }
    }

    override fun getItemCount(): Int {
        return petList.size
    }

    class PetViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var txtName:TextView = itemView.findViewById(R.id.pet_item_name)
        var txtAge = itemView.findViewById<TextView>(R.id.pet_item_age)
        var txtGender = itemView.findViewById<TextView>(R.id.pet_item_gender)
        var imgPhoto = itemView.findViewById<ImageView>(R.id.pet_item_img)
    }

}