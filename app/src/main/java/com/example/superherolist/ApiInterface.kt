package com.example.superherolist

import io.reactivex.Single
import retrofit2.http.GET

interface ApiInterface {

    @GET("/api/all.json/")
    fun getSuperhero(): Single<SuperheroResponse>
}