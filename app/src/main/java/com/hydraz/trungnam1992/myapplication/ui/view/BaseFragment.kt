package com.hydraz.trungnam1992.myapplication.ui.view

import android.app.Fragment

/**
 * Created by trungnam1992 on 4/24/18.
 */
abstract class BaseFragment : Fragment(), BaseView {

    protected abstract fun initPresenter()

}