package com.hydraz.trungnam1992.myapplication.ui.contact

import com.hydraz.trungnam1992.myapplication.ui.view.BaseView
import io.reactivex.Observable
import java.util.*

/**
 * Created by trungnam1992 on 4/25/18.
 */
class FragmentUserInputContact{

    interface FragmentUserInputView : BaseView{
        fun summitStatus()
        fun changeFragment()
        fun inputMessage()
        fun showError(err : String)
    }
    interface Presenter{
        //todo
        fun checkInputMessage(strMsg : String)
        fun splitMessageObserverble(strMsg: String) : Observable<ArrayList<String>>
    }

}