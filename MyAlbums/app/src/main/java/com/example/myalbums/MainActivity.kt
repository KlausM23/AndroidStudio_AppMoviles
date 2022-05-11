package com.example.myalbums

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.myalbums.activities.DetailActivity
import com.example.myalbums.activities.ListActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btDetail = findViewById<Button>(R.id.btDetail)
        val btList = findViewById<Button>(R.id.btList)

        btDetail.setOnClickListener {
            goDetail()
        }

        btList.setOnClickListener {
            goList()
        }

    }

    private fun goList() {
        val intent = Intent(this, ListActivity::class.java).apply {
        }

        startActivity(intent)
    }

    private fun goDetail() {
        val intent = Intent(this, DetailActivity::class.java).apply {
        }

        startActivity(intent)
    }
}