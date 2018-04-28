package com.hydraz.trungnam1992.myapplication.ui.view

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hydraz.trungnam1992.myapplication.App
import com.hydraz.trungnam1992.myapplication.R
import com.hydraz.trungnam1992.myapplication.model.Status
import com.hydraz.trungnam1992.myapplication.ui.adapter.StatusRecycleAdapter
import com.hydraz.trungnam1992.myapplication.ui.contact.FragmentListStatusContact
import com.hydraz.trungnam1992.myapplication.ui.presenter.FragmentListStatusPresenter
import com.hydraz.trungnam1992.myapplication.ui.view.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_list_status.*
import javax.inject.Inject


class FragmentListStatus
    : BaseFragment(), FragmentListStatusContact.ListStatusFragmentView {

    @Inject
    lateinit var mPresenter: FragmentListStatusPresenter
    companion object {
        @JvmStatic
        fun newInstance(bundle: Bundle) : FragmentUserInput{
            return FragmentUserInput()
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater?.inflate(R.layout.fragment_list_status, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val arr : ArrayList<Status> = ArrayList()
        val adapter = StatusRecycleAdapter(arr)

        activity?.let {
            recycleViewStatus.layoutManager = LinearLayoutManager(it).apply {
                orientation = LinearLayoutManager.VERTICAL
            }
            recycleViewStatus.adapter = adapter
            adapter.notifyDataSetChanged()
        }
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
    }

    override fun hideLoadingBar() {
    }

    override fun disPlayListStatus(array: ArrayList<Status>) {
        val adapter = StatusRecycleAdapter(array)
        activity?.let {
            recycleViewStatus.layoutManager = LinearLayoutManager(it).apply {
                orientation = LinearLayoutManager.VERTICAL
            }
            recycleViewStatus.adapter = adapter
            adapter.notifyDataSetChanged()
        }

    }
}