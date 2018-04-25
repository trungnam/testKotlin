package com.hydraz.trungnam1992.myapplication.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hydraz.trungnam1992.myapplication.R
import com.hydraz.trungnam1992.myapplication.ui.contact.FragmentUserInputContact
import com.hydraz.trungnam1992.myapplication.ui.contact.MainActivityContact
import com.hydraz.trungnam1992.myapplication.ui.presenter.FragmentUserInputPresenter
import javax.inject.Inject

class FragmentUserInput : BaseFragment(), FragmentUserInputContact.FragmentUserInputView {

    @Inject
    lateinit var mPresenter : FragmentUserInputPresenter

    override fun summitStatus() {

    }

    override fun changeFragment() {

    }

    override fun inputMessage() {

    }

    companion object {
        @JvmStatic
        fun newInstance(bundle: Bundle) : FragmentUserInput{
            return FragmentUserInput()
        }
    }


    override fun initPresenter() {
        mPresenter.attachView(this)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater?.inflate(R.layout.fragment_fragment_user_input, container, false)
    }

}
