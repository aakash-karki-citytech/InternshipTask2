package com.example.internshiptask2.data.api

import com.example.internshiptask2.data.model.User
import retrofit2.http.GET
import retrofit2.http.Query

interface GitHubApi {
    @GET("users")
    suspend fun  User(
        @Query("since") since: Int = 0,
        @Query("per_page") perPage: Int = 20
    ): List<User>
}