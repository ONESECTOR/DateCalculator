package com.sector.datecalculator.ui.fragments.root

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sector.datecalculator.databinding.FragmentRootBinding
import com.sector.datecalculator.presentation.presenter.root.RootPresenter
import com.sector.datecalculator.presentation.view.root.RootView
import com.sector.datecalculator.ui.common.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import moxy.ktx.moxyPresenter
import javax.inject.Inject
import javax.inject.Provider

@AndroidEntryPoint
class RootFragment : BaseFragment<FragmentRootBinding>(), RootView {

    @Inject
    lateinit var presenterProvider: Provider<RootPresenter>

    private val rootPresenter: RootPresenter by moxyPresenter { presenterProvider.get() }

    override fun onViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentRootBinding = FragmentRootBinding.inflate(
        inflater,
        container,
        false
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.apply {
            btnCalculate.setOnClickListener {
                listOf(
                    firstDate,
                    secondDate
                ).forEachIndexed { viewIndex, datePicker ->
                    rootPresenter.formatDate(
                        viewIndex,
                        datePicker.dayOfMonth,
                        datePicker.month,
                        datePicker.year
                    )
                }.apply {
                    rootPresenter.calculateDate()
                }
            }
        }
    }
}