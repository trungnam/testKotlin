package com.hydraz.trungnam1992.myapplication.ui.contact

import com.hydraz.trungnam1992.myapplication.ui.view.base.BaseFragment
import com.hydraz.trungnam1992.myapplication.ui.view.base.BaseView

/**
 * Created by trungnam1992 on 4/24/18.
 */
class MainActivityContact{

    interface MainView : BaseView {
        fun startInputFragment(fragment: BaseFragment)
    }

    interface Presenter{
        //to do
        fun statInputFragment(){

        }
    }
}