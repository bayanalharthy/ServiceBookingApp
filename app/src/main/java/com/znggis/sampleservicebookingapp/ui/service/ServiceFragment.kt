package com.znggis.sampleservicebookingapp.ui.service

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.znggis.sampleservicebookingapp.R
import com.znggis.sampleservicebookingapp.ui.FullScreenDialogFragment


class ServiceFragment : FullScreenDialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_service, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let { arg ->
            val category = arg.getString(getString(R.string.arg_category))
            Log.e("ServiceFrg",category!!)
        }
    }


}