package com.hydraz.trungnam1992.myapplication.ui.view.base

import android.app.Fragment
import android.os.Bundle

/**
 * Created by trungnam1992 on 4/24/18.
 */
abstract class BaseFragment : Fragment(), BaseView {

    protected abstract fun initializeDagger()

    protected abstract fun initializePresenter()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initializeDagger()
        initializePresenter()
    }
}