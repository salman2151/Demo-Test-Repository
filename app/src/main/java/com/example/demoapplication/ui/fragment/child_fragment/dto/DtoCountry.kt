package com.example.demoapplication.ui.fragment.child_fragment.dto

import com.google.gson.annotations.SerializedName


data class DtoCountry(
    @SerializedName("name")
    val name: String?,
    @SerializedName("code")
    val code: String?
)