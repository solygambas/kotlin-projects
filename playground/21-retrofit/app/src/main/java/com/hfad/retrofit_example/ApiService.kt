package com.hfad.retrofit_example

import com.hfad.retrofit_example.models.Comment
import com.hfad.retrofit_example.models.Post
import com.hfad.retrofit_example.models.User
import retrofit2.Response
import retrofit2.http.*

interface ApiService {
    @GET("users")
    suspend fun getUsers(): Response<MutableList<User>>

    @GET("posts/{num}")
    suspend fun getPostById(@Path("num") num : Int): Response<Post>

    @GET("comments")
    suspend fun getCommentsByPost(@Query("postId") postId: Int): Response<MutableList<Comment>>

    @POST("posts")
    suspend fun createPost(@Body post: POST): Response<Post>
}
