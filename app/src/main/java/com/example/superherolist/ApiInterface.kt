package com.example.superherolist

import io.reactivex.Single
import retrofit2.http.GET

interface ApiInterface {

    @GET("superhero-api/api/all.json")
    fun getSuperhero(): Single<List<Superhero>>
}