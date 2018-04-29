package com.hydraz.trungnam1992.myapplication.ui.contact

import android.content.Context
import com.hydraz.trungnam1992.myapplication.ui.view.base.BaseFragment
import com.hydraz.trungnam1992.myapplication.ui.view.base.BaseView
import com.hydraz.trungnam1992.myapplication.utils.InputStatusState
import io.reactivex.Observable
import java.util.*

/**
 * Created by trungnam1992 on 4/25/18.
 */
open class FragmentUserInputContact {

    interface FragmentUserInputView : BaseView {
        fun summitStatus()
        fun changeFragment(fragmentList: BaseFragment)
        fun inputMessage()
        fun showError(err: String)
        fun enableSummirButton(bool: Boolean)
        fun showLoadingBar()
        fun hideLoadingBar()
    }

    interface Presenter {
        var state: InputStatusState

        fun checkInputMessage(strMsg: String)

        fun splitMessageObserverble(strMsg: String): Observable<ArrayList<String>>

        fun saveStatus(context: Context)
    }

}