package com.znggis.sampleservicebookingapp.ui.home

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.snackbar.Snackbar
import com.znggis.sampleservicebookingapp.R
import com.znggis.sampleservicebookingapp.databinding.FragmentHomeBinding
import com.znggis.sampleservicebookingapp.di.injector.inject
import com.znggis.sampleservicebookingapp.repo.remote.data.HomeData
import com.znggis.sampleservicebookingapp.ui.setupSnackbar
import com.znggis.sampleservicebookingapp.ui.viewBinding
import javax.inject.Inject

class HomeFragment : Fragment() {

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    private val viewModel: HomeViewModel by viewModels { factory }

    private val binding: FragmentHomeBinding by viewBinding(FragmentHomeBinding::bind)

    override fun onAttach(context: Context) {
        super.onAttach(context)
        inject(this)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.root.setupSnackbar(viewLifecycleOwner, viewModel.error, Snackbar.LENGTH_LONG)
        viewModel.loading.observe(viewLifecycleOwner, {
            it?.let {
                it.getContentIfNotHandled()?.let { visible ->
                    binding.progress.visibility = if (visible) View.VISIBLE else View.INVISIBLE
                }
            }
        })

        viewModel.data.observe(viewLifecycleOwner, {
            it?.let {
                bindRv(it)
            }
        })

        viewModel.fetch()
    }

    private fun bindRv(data: HomeData) {

    }

    override fun onDestroyView() {
        super.onDestroyView()
    }

}