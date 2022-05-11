package com.example.myalbums.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myalbums.R
import com.example.myalbums.adapter.DetailAdapter
import com.example.myalbums.entity.Detail
import com.example.myalbums.service.DetailService
import com.google.android.material.textfield.TextInputEditText
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class DetailActivity : AppCompatActivity() {

    lateinit var detail: Detail
    lateinit var detailAdapter: DetailAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val btSearch =findViewById<Button>(R.id.btSearchDetail)
        val rvDetail = findViewById<RecyclerView>(R.id.rvDetail)
        //val clCard = findViewById<ConstraintLayout>(R.id.clCard)


        btSearch.setOnClickListener {
            searchDetail()
        }
    }

    fun sendMessage(){
        Toast.makeText(this, "xd", Toast.LENGTH_LONG).show()
    }

    private fun searchDetail() {
        val etDetail = findViewById<TextInputEditText>(R.id.etSearch)
        val search = etDetail.text.toString()

        val retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(DetailService::class.java)

        val request = service.getDetailInfo(search)

        val rvDetail = findViewById<RecyclerView>(R.id.rvDetail)

        if(etDetail.text.toString().toInt() >= 1 && etDetail.text.toString().toInt() <= 100){
            request.enqueue(object : Callback<Detail> {
                override fun onResponse(call: Call<Detail>, response: Response<Detail>) {
                    detail = response.body()!!

                    detailAdapter = DetailAdapter(detail)

                    rvDetail.adapter = detailAdapter
                    rvDetail.layoutManager = LinearLayoutManager(this@DetailActivity)
                }

                override fun onFailure(call: Call<Detail>, t: Throwable) {
                    Log.d("MainActivity", t.toString())
                }

            })
        }else{
            Toast.makeText(this, "Solo hay ids entre 1 y 100", Toast.LENGTH_LONG).show()
        }
    }
}