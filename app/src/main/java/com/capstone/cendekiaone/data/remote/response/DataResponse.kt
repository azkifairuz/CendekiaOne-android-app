package com.capstone.cendekiaone.data.remote.response

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class DataResponse(
    @field:SerializedName("error")
    val error: Boolean,

    @field:SerializedName("message")
    val message: String
)

// login response
data class LoginResponse(

    @field:SerializedName("data")
    val loginResult: LoginResult,

    @field:SerializedName("status")
    val message: String
)

data class LoginResult(

    @field:SerializedName("token")
    val name: String,

    @field:SerializedName("id_user")
    val userId: String,

    @field:SerializedName("username")
    val token: String
)

data class StoryResponse(

    @field:SerializedName("listStory")
    val listStory: List<ListStory>,

    @field:SerializedName("error")
    val error: Boolean,

    @field:SerializedName("message")
    val message: String
)


@Entity(tableName = "stories")
data class ListStory(

    @field:SerializedName("photoUrl")
    val photoUrl: String,

    @field:SerializedName("createdAt")
    val createdAt: String,

    @field:SerializedName("name")
    val name: String,

    @field:SerializedName("description")
    val description: String,

    @field:SerializedName("lon")
    val lon: Double,

    @PrimaryKey
    @field:SerializedName("id")
    val id: String,

    @field:SerializedName("lat")
    val lat: Double
)