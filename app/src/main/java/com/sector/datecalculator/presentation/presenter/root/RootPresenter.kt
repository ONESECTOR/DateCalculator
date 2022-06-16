package com.sector.datecalculator.presentation.presenter.root

import com.sector.datecalculator.presentation.presenter.BaseMvpPresenter
import com.sector.datecalculator.presentation.view.root.RootView
import moxy.InjectViewState
import javax.inject.Inject

@InjectViewState
class RootPresenter
@Inject
constructor(): BaseMvpPresenter<RootView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
    }

}