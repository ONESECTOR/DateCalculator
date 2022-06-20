package com.sector.datecalculator

import android.os.Bundle
import androidx.core.view.WindowCompat
import com.sector.datecalculator.presentation.presenter.main.MainPresenter
import com.sector.datecalculator.presentation.view.main.MainView
import com.sector.datecalculator.ui.common.BaseActivity
import dagger.hilt.android.AndroidEntryPoint
import moxy.ktx.moxyPresenter
import javax.inject.Inject
import javax.inject.Provider

@AndroidEntryPoint
class MainActivity : BaseActivity(R.layout.activity_main), MainView {

    @Inject
    lateinit var mainPresenter: Provider<MainPresenter>

    private val presenter: MainPresenter by moxyPresenter { mainPresenter.get() }

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_DateCalculator)
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
    }
}