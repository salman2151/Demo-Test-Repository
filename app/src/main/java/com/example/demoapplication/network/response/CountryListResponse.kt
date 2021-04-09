package com.example.demoapplication.network.response

import com.example.demoapplication.ui.fragment.child_fragment.dto.DtoCountry
import com.google.gson.annotations.SerializedName

class CountryListResponse {
    @SerializedName("code")
    var code: Int = -1

    @SerializedName("result")
    var arrayListCountry: ArrayList<DtoCountry>? = null
}
