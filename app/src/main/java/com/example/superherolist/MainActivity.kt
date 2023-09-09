package com.example.superherolist

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainActivity : Activity() {

    private lateinit var listView: RecyclerView

    @SuppressLint("CheckResult")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_layout)
        listView = findViewById(R.id.listView)
        val api = ApiClient.client.create(ApiInterface::class.java)
        api.getSuperhero()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                if (it.isNotEmpty()) {
                    val superheroes = it
                    val myAdapter = SuperheroAdapter(superheroes, {})
                    listView.adapter = myAdapter
                }
            }, {
                Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
            })
        listView.layoutManager = LinearLayoutManager(this)
    }
}

data class Superhero(val name: String, val images: Images)
data class Images(val xs: String)