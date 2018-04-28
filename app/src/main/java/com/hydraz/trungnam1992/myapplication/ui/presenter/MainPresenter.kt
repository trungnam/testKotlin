package com.hydraz.trungnam1992.myapplication.ui.presenter

import android.os.Bundle
import com.hydraz.trungnam1992.myapplication.ui.contact.MainActivityContact
import com.hydraz.trungnam1992.myapplication.ui.view.FragmentListStatus
import com.hydraz.trungnam1992.myapplication.ui.view.FragmentUserInput
import javax.inject.Inject

/**
 * Created by trungnam1992 on 4/24/18.
 */
class MainPresenter @Inject constructor(
        //to do service
)
    : BasePresenter<MainActivityContact.MainView>(), MainActivityContact.Presenter {

    private lateinit var mView : MainActivityContact.MainView

    override fun detachView(view: MainActivityContact.MainView) {

    }

    override fun attachView(view: MainActivityContact.MainView) {
        mView = view
    }

    override fun statInputFragment() {
        mView.startInputFragment(FragmentUserInput.newInstance(Bundle()))
//        mView.startInputFragment(FragmentListStatus.newInstance(Bundle()))
    }
}