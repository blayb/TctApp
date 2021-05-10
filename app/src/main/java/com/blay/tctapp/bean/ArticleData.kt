package com.blay.tctapp.bean

import com.google.gson.annotations.SerializedName
import java.util.*

data class ArticleDetails(
    @SerializedName("title")
    var title: String? = null,

    @SerializedName("imageUrl")
    var imageUrl: String? = null,

    @SerializedName("isSaved")
    var isSaved: Boolean? = null,

    @SerializedName("isLiked")
    var isLiked: Boolean? = null,

    @SerializedName("likesCount")
    var likesCount: Int = 0,

    @SerializedName("author")
    var author: Author? = null,

    @SerializedName("category")
    var category: String? = null,

    @SerializedName("metaData")
    var metaData: MetaData? = null
) 

data class ArticlesResponse(
    @SerializedName("data")
    val articles: List<ArticleDetails>? = null
) 

data class Author(
    @SerializedName("authorName")
    var authorName: String? = null,

    @SerializedName("authorAvatar")
    var authorAvatar: AuthorAvatar? = null
) 

data class AuthorAvatar(
    @SerializedName("imageUrl")
    var imageUrl: String? = null
) 

data class MetaData(
    @SerializedName("creationTime")
    var creationTime: Date? = null
) 

