package com.jonitech.arraproject.footballclub

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast
class MainActivity : AppCompatActivity() {
    private var items : MutableList<ClubItem> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val clubList = findViewById<RecyclerView>(R.id.rv_football_club)
        initData()

        clubList.layoutManager = LinearLayoutManager(this)
        clubList.adapter = FootballAdapter(this, items){
            val toast = Toast.makeText(applicationContext, it.clubName, Toast.LENGTH_SHORT)
            toast.show()
        }
    }

    private fun initData(){
        val clubName = resources.getStringArray(R.array.club_name)
        val clubImage = resources.obtainTypedArray(R.array.club_image)
        items.clear()
        for (i in clubName.indices){
            items.add(ClubItem(clubName[i], clubImage.getResourceId(i,0)))
        }
        clubImage.recycle()
    }
}
