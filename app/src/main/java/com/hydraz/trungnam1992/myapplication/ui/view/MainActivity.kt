package com.hydraz.trungnam1992.myapplication.ui.view

import com.hydraz.trungnam1992.myapplication.App
import com.hydraz.trungnam1992.myapplication.R
import com.hydraz.trungnam1992.myapplication.ui.contact.MainActivityContact
import com.hydraz.trungnam1992.myapplication.ui.presenter.MainPresenter
import com.hydraz.trungnam1992.myapplication.ui.view.base.BaseActivity
import com.hydraz.trungnam1992.myapplication.ui.view.base.BaseFragment
import javax.inject.Inject

class MainActivity : BaseActivity(), MainActivityContact.MainView {

    @Inject
    internal lateinit var mPresenter : MainPresenter

    override val layoutId: Int
        get() {
            return R.layout.activity_main
        }

    override fun initializeDagger() {
        App.appComponent.inject(this@MainActivity)
    }

    override fun initializePresenter() {
        mPresenter.attachView(this)
        mPresenter.statFragment()
    }

    override fun startInputFragment(fragment: BaseFragment) {
        changeFragment(fragment)
    }

}
