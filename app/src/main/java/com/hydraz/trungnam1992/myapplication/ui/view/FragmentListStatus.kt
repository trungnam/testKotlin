package com.hydraz.trungnam1992.myapplication.ui.view

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hydraz.trungnam1992.myapplication.App
import com.hydraz.trungnam1992.myapplication.R
import com.hydraz.trungnam1992.myapplication.data.DataRepository
import com.hydraz.trungnam1992.myapplication.model.Status
import com.hydraz.trungnam1992.myapplication.ui.contact.FragmentListStatusContact
import com.hydraz.trungnam1992.myapplication.ui.presenter.FragmentListStatusPresenter
import com.hydraz.trungnam1992.myapplication.ui.view.base.BaseFragment
import javax.inject.Inject


class FragmentListStatus
    : BaseFragment(), FragmentListStatusContact.ListStatusFragmentView {

    @Inject
    lateinit var mPresenter: FragmentListStatusPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            //to do
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater?.inflate(R.layout.fragment_list_status, container, false)
    }

    override fun initializeDagger() {
        App.appComponent.inject(this@FragmentListStatus)
    }

    override fun initializePresenter() {
        mPresenter.attachView(this)
    }

    override fun onDetach() {
        super.onDetach()
        mPresenter.detachView(this)
    }
    override fun showLoadingBar() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hideLoadingBar() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun disPlayListStatus(array: ArrayList<Status>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}