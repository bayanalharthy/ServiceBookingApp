package com.znggis.sampleservicebookingapp.ui.home

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.znggis.sampleservicebookingapp.R
import com.znggis.sampleservicebookingapp.databinding.FragmentHomeBinding
import com.znggis.sampleservicebookingapp.di.injector.inject
import com.znggis.sampleservicebookingapp.repo.remote.data.Category
import com.znggis.sampleservicebookingapp.repo.remote.data.Promotion
import com.znggis.sampleservicebookingapp.ui.setupSnackbar
import com.znggis.sampleservicebookingapp.ui.viewBinding
import javax.inject.Inject

class HomeFragment : Fragment() {

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    private val viewModel: HomeViewModel by viewModels { factory }

    private val binding: FragmentHomeBinding by viewBinding(FragmentHomeBinding::bind)

    @Inject
    lateinit var servicesAdaptor: ServiceAdaptor


    @Inject
    lateinit var promotionsAdaptor: PromotionsAdaptor


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
                bindRvServices(it.categories)
                bindRvPromotions(it.promotions)
            }
        })

        viewModel.fetch()
    }

    private fun bindRvPromotions(promotions: List<Promotion>) {
        binding.rvPromotions.layoutManager = LinearLayoutManager(
            requireContext(), LinearLayoutManager.HORIZONTAL, false
        )
        binding.rvPromotions.adapter = promotionsAdaptor
        promotionsAdaptor.submitList(promotions)
    }

    private fun bindRvServices(categories: List<Category>) {
        binding.rvService.layoutManager = LinearLayoutManager(
            requireContext(), LinearLayoutManager.HORIZONTAL, false
        )
        binding.rvService.adapter = servicesAdaptor
        servicesAdaptor.submitList(categories)
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }

}