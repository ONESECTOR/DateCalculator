package com.sector.datecalculator.presentation.presenter.root

import com.sector.datecalculator.extensions.withMain
import com.sector.datecalculator.presentation.presenter.BaseMvpPresenter
import com.sector.datecalculator.presentation.view.root.RootView
import kotlinx.coroutines.launch
import moxy.InjectViewState
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject
import kotlin.math.abs

@InjectViewState
class RootPresenter
@Inject
constructor() : BaseMvpPresenter<RootView>() {

    private var formatter = SimpleDateFormat("d-M-yyyy", Locale.getDefault())

    private var firstDate: Date? = null
    private var secondDate: Date? = null

    fun formatDate(viewIndex: Int, day: Int, month: Int, year: Int) {
        val text = "$day-${month + 1}-$year"
        val date = formatter.parse(text)

        when (viewIndex) {
            0 -> firstDate = date
            1 -> secondDate = date
        }
    }

    fun calculateDate() {
        scope.launch {
            val difference = abs(firstDate!!.time - secondDate!!.time)
            val days = difference / (24 * 60 * 60 * 1000)
            val result = days.toString()

            withMain {
                viewState.printResult(result)
            }
        }
    }
}