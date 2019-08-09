package com.taras.apptest.data.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Comment(

        @SerializedName("postId")
        val postId: Int = 0,

        @SerializedName("id")
        val id: Int = 0,

        @SerializedName("name")
        val name: String = "",

        @SerializedName("email")
        val email: String = "",

        @SerializedName("body")
        val body: String = ""
) : Parcelable