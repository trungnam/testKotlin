package com.hydraz.trungnam1992.myapplication.ui.contact

import com.hydraz.trungnam1992.myapplication.ui.presenter.BasePresenter
import com.hydraz.trungnam1992.myapplication.ui.view.BaseFragment
import com.hydraz.trungnam1992.myapplication.ui.view.BaseView

/**
 * Created by trungnam1992 on 4/24/18.
 */
class MainActivityContact{

    interface MainView : BaseView{
        fun startInputFragment(fragment: BaseFragment)
    }

    interface Presenter{
        //to do
        fun statFragment(){

        }
    }
}