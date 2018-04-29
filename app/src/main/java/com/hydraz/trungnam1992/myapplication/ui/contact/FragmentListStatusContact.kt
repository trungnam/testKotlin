package com.hydraz.trungnam1992.myapplication.ui.contact

import com.hydraz.trungnam1992.myapplication.model.Status
import com.hydraz.trungnam1992.myapplication.ui.view.base.BaseFragment
import com.hydraz.trungnam1992.myapplication.ui.view.base.BaseView

/**
 * Created by trungnam1992 on 4/27/18.
 */
class FragmentListStatusContact {
    interface ListStatusFragmentView : BaseView {

        fun showLoadingBar()

        fun hideLoadingBar()

        fun disPlayListStatus(array: ArrayList<Status>)

        fun backToInput(fragment: BaseFragment)
    }

    interface Presenter {
        fun loadListStatusData()
    }
}