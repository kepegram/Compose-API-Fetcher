package edu.towson.cosc435.pegram.assignment4.restapi

import retrofit2.http.GET

interface UserService {
    @GET("/photos?albumId=1")
    suspend fun fetchUser(): List<Photos>
}