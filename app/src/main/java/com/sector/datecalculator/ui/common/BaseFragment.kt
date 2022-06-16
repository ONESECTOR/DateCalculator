package com.sector.datecalculator.ui.common

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import com.sector.datecalculator.presentation.view.BaseMvpView
import moxy.MvpAppCompatFragment

abstract class BaseFragment<T: ViewBinding> : MvpAppCompatFragment(), BaseMvpView {

    var binding: T? = null

    abstract fun onViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = onViewBinding(inflater, container).let {
        binding = it
        it.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}