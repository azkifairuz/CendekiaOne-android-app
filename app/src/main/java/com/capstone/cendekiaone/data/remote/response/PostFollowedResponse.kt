package com.capstone.cendekiaone.data.remote.response

import com.google.gson.annotations.SerializedName

// Get Followed Post
data class GetPostFollowedResponse(
    @SerializedName("status")
    val status: String,
    @SerializedName("data")
    val data: List<GetPostFollowedData>,
    @SerializedName("pagination")
    val pagination: GetPostFollowedPagination
)

data class GetPostFollowedData(
    @SerializedName("idPost")
    val idPost: Int,
    @SerializedName("createBy")
    val createBy: String,
    @SerializedName("createById")
    val createById: Int,
    @SerializedName("profileCreator")
    val profileCreator: String,
    @SerializedName("postPicture")
    val postPicture: String,
    @SerializedName("postTitle")
    val postTitle: String,
    @SerializedName("postBody")
    val postBody: String,
    @SerializedName("category")
    val category: String,
    @SerializedName("subCatergory")
    val subCatergory: String,
    @SerializedName("likes")
    val likes: String,
    @SerializedName("comment")
    val comment: String,
    @SerializedName("isLike")
    val isLike: Boolean,
    @SerializedName("isSaved")
    val isSaved: Boolean,
)

data class GetPostFollowedPagination(
    @field:SerializedName("currentPage")
    val currentPage: Int,
    @field:SerializedName("totalPages")
    val totalPages: Int,
    @field:SerializedName("totalPosts")
    val totalPosts: Int,
)