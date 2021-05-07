package com.znggis.sampleservicebookingapp.ui.service

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.znggis.sampleservicebookingapp.R
import com.znggis.sampleservicebookingapp.databinding.FragmentServiceBinding
import com.znggis.sampleservicebookingapp.ui.FullScreenDialogFragment
import com.znggis.sampleservicebookingapp.ui.viewBinding
import javax.inject.Inject


class ServiceFragment : FullScreenDialogFragment() {

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    private val viewModel: ServicesViewModel by viewModels { factory }

    private val binding: FragmentServiceBinding by viewBinding(FragmentServiceBinding::bind)


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