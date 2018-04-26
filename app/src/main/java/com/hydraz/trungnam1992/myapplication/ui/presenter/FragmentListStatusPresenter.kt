package com.hydraz.trungnam1992.myapplication.ui.presenter

import com.hydraz.trungnam1992.myapplication.data.DataRepository
import com.hydraz.trungnam1992.myapplication.ui.contact.FragmentListStatusContact
import com.hydraz.trungnam1992.myapplication.ui.view.FragmentListStatus
import javax.inject.Inject

/**
 * Created by trungnam1992 on 4/27/18.
 */
open class FragmentListStatusPresenter
    @Inject constructor(
            var  mDataRepository: DataRepository
    )
    : BasePresenter<FragmentListStatusContact.ListStatusFragmentView>(){

    lateinit var mView : FragmentListStatusContact.ListStatusFragmentView

    override fun detachView(view: FragmentListStatusContact.ListStatusFragmentView) {
        //
    }

    override fun attachView(view: FragmentListStatusContact.ListStatusFragmentView) {
        mView = view
    }


}