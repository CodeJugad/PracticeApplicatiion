package com.example.practiceapplicatiion

import retrofit2.http.GET

interface ApiService {
    @GET("posts/1")
    suspend fun getPost(): Post // Define your data model class for Post
}
