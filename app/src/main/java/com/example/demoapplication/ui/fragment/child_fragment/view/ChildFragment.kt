package com.example.demoapplication.ui.fragment.child_fragment.view

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.demoapplication.R
import com.example.demoapplication.network.response.GenericResponse
import com.example.demoapplication.ui.fragment.BaseFragment
import com.example.demoapplication.ui.fragment.child_fragment.dto.DtoCountry
import com.example.demoapplication.ui.fragment.child_fragment.view_model.ChildFragmentViewModel

class ChildFragment : BaseFragment(), Observer<GenericResponse<DtoCountry>> {

    lateinit var viewModel: ChildFragmentViewModel

    override val layoutId: Int
        get() = R.layout.fragment_child

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ChildFragmentViewModel::class.java)
        activity?.let {
            viewModel.apiResponse.observe(it, this)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getCountries()
    }

    override fun onChanged(genericResponse: GenericResponse<DtoCountry>?) {
        when (genericResponse?.apiStatus) {
            GenericResponse.LOADING -> showProgressDialog()
            GenericResponse.SUCCESS -> {
                hideProgressDialog()
                setAdapter(genericResponse.data)
            }
            GenericResponse.ERROR -> {
                hideProgressDialog()
                Toast.makeText(activity, "Error", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun setAdapter(data: ArrayList<DtoCountry>?) {
        Toast.makeText(activity, "Adapter Called!", Toast.LENGTH_SHORT).show()
    }

}