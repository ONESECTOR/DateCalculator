package com.sector.datecalculator.presentation.presenter

import com.sector.datecalculator.presentation.view.BaseMvpView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancel
import moxy.MvpPresenter
import kotlin.coroutines.CoroutineContext

abstract class BaseMvpPresenter<View : BaseMvpView> : MvpPresenter<View>() {

    private val job = Job()
    private val coroutineContext: CoroutineContext = Dispatchers.IO + job

    val scope = CoroutineScope(coroutineContext)

    override fun onDestroy() {
        coroutineContext.cancel()
        super.onDestroy()
    }
}