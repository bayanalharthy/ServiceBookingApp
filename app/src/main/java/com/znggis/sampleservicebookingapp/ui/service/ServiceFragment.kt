package com.znggis.sampleservicebookingapp.ui.service

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.znggis.sampleservicebookingapp.R
import com.znggis.sampleservicebookingapp.databinding.FragmentServiceBinding
import com.znggis.sampleservicebookingapp.di.injector.inject
import com.znggis.sampleservicebookingapp.repo.remote.data.Service
import com.znggis.sampleservicebookingapp.ui.FullScreenDialogFragment
import com.znggis.sampleservicebookingapp.ui.image.ImageLoader
import com.znggis.sampleservicebookingapp.ui.setupSnackbar
import com.znggis.sampleservicebookingapp.ui.viewBinding
import javax.inject.Inject


class ServiceFragment : FullScreenDialogFragment() {

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    @Inject
    lateinit var imageLoader: ImageLoader

    private val viewModel: ServicesViewModel by viewModels { factory }

    private val binding: FragmentServiceBinding by viewBinding(FragmentServiceBinding::bind)

    @Inject
    lateinit var serviceAdaptor: ServiceAdaptor

    override fun onAttach(context: Context) {
        super.onAttach(context)
        inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_service, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnBack.setOnClickListener {
            findNavController().navigateUp()
        }
        binding.root.setupSnackbar(viewLifecycleOwner, viewModel.error, Snackbar.LENGTH_LONG)
        viewModel.loading.observe(viewLifecycleOwner, {
            it?.let {
                it.getContentIfNotHandled()?.let { visible ->
                    binding.includeProgressLayout.progress.visibility =
                        if (visible) View.VISIBLE else View.INVISIBLE
                }
            }
        })

        viewModel.data.observe(viewLifecycleOwner, {
            it?.let { data ->
                binding.serviceData = data
                loadImage(data.image)
                showServices(data.services)
            }
        })

        arguments?.let { arg ->
            arg.getString(getString(R.string.arg_category))?.let { category ->
                viewModel.fetchServices(category)
            }
        }
    }

    private fun showServices(services: List<Service>) {
        binding.rvServices.adapter = serviceAdaptor
        binding.rvServices.layoutManager = GridLayoutManager(
            requireContext(),
            2,
            GridLayoutManager.VERTICAL,
            false
        )

        serviceAdaptor.submitList(services)
    }

    private fun loadImage(image: String) {
        imageLoader.loadImage(binding.imgService, image)
    }


}