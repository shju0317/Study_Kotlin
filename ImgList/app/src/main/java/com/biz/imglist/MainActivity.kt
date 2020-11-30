package com.biz.imglist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private val petList = arrayListOf<PetVO>(
        PetVO("별루",10,"F","pet1"),
        PetVO("꼼데",10,"M","pet2"),
        PetVO("가르송",10,"M","pet3"),
        PetVO("아담",10,"F","pet4"),
        PetVO("이브",10,"F","pet5"),
        PetVO("누구얌",10,"F","")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val petListView = findViewById<RecyclerView>(R.id.pet_list)
        petListView.layoutManager = LinearLayoutManager(this)
        petListView.setHasFixedSize(true)
        petListView.adapter = PetViewAdapter(petList, this)
    }
}