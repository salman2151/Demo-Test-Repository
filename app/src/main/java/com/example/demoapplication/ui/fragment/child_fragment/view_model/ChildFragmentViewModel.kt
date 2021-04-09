package com.example.demoapplication.ui.fragment.child_fragment.view_model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.demoapplication.network.NetworkClass
import com.example.demoapplication.network.response.GenericResponse
import com.example.demoapplication.ui.fragment.child_fragment.dto.DtoCountry

class ChildFragmentViewModel : ViewModel() {
    var apiResponse = MutableLiveData<GenericResponse<DtoCountry>>()

    fun getCountries() {
        apiResponse.value = GenericResponse(apiStatus = GenericResponse.LOADING)
        NetworkClass.main {
            val dto = NetworkClass.getRepository().getCountries()
            apiResponse.value = dto.body()?.let { itBody ->
                if (itBody.code == 200)
                    GenericResponse(
                        apiStatus = GenericResponse.SUCCESS,
                        data = itBody.arrayListCountry
                    )
                else
                    GenericResponse(apiStatus = GenericResponse.ERROR)

            } ?: GenericResponse(apiStatus = GenericResponse.ERROR)
        }
    }
}