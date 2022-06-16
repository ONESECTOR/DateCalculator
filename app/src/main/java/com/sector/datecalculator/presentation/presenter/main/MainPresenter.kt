package com.sector.datecalculator.presentation.presenter.main

import com.sector.datecalculator.presentation.presenter.BaseMvpPresenter
import com.sector.datecalculator.presentation.view.main.MainView
import moxy.InjectViewState
import javax.inject.Inject

@InjectViewState
class MainPresenter
@Inject
constructor() : BaseMvpPresenter<MainView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
    }
}