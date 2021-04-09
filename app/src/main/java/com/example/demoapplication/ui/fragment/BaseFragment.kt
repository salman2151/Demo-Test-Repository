package com.example.demoapplication.ui.fragment

import android.app.Dialog
import android.app.ProgressDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.example.demoapplication.R

abstract class BaseFragment : Fragment() {
    abstract val layoutId: Int
    private var progressDialog: Dialog? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(layoutId, container, false)
    }

    private fun setProgressDialog() {
        activity?.let {
            val builder = AlertDialog.Builder(it).setView(R.layout.dialog_progress)
            progressDialog = builder.create()
        }
    }

    public fun showProgressDialog() {
        if (progressDialog == null)
            setProgressDialog()
        progressDialog?.let {
            if (!it.isShowing)
                it.show()
        }
    }

    public fun hideProgressDialog() {
        progressDialog?.let {
            if (it.isShowing)
                it.hide()
        }
    }
}