package com.hydraz.trungnam1992.myapplication.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hydraz.trungnam1992.myapplication.R

class FragmentUserInput : BaseFragment() {

    companion object {
        @JvmStatic
        fun newInstance(bundle: Bundle) : FragmentUserInput{
            return FragmentUserInput()
        }
    }


    override fun initPresenter() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater?.inflate(R.layout.fragment_fragment_user_input, container, false)
    }

}
