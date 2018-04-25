package com.hydraz.trungnam1992.myapplication.ui.presenter

import android.os.Bundle
import com.hydraz.trungnam1992.myapplication.ui.view.BaseView

/**
 * Created by trungnam1992 on 4/24/18.
 */
abstract class BasePresenter<in T : BaseView>{

    abstract fun detachView(view: T)
    abstract fun attachView(view: T)


    open fun initialize (extras: Bundle) {}

}