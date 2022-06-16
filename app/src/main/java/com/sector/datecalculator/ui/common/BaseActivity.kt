package com.sector.datecalculator.ui.common

import androidx.annotation.LayoutRes
import com.sector.datecalculator.presentation.view.BaseMvpView
import moxy.MvpAppCompatActivity

abstract class BaseActivity(@LayoutRes layoutResId: Int):
    MvpAppCompatActivity(layoutResId),
    BaseMvpView {


}