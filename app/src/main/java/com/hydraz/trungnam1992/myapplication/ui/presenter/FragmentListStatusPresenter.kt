package com.hydraz.trungnam1992.myapplication.ui.presenter

import com.hydraz.trungnam1992.myapplication.data.DataRepository
import com.hydraz.trungnam1992.myapplication.model.Status
import com.hydraz.trungnam1992.myapplication.ui.contact.FragmentListStatusContact
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by trungnam1992 on 4/27/18.
 */
open class FragmentListStatusPresenter
@Inject constructor(
        var mDataRepository: DataRepository)
    : BasePresenter<FragmentListStatusContact.ListStatusFragmentView>(), FragmentListStatusContact.Presenter {

    lateinit var mView: FragmentListStatusContact.ListStatusFragmentView

    override fun detachView(view: FragmentListStatusContact.ListStatusFragmentView) {

    }

    override fun attachView(view: FragmentListStatusContact.ListStatusFragmentView) {
        mView = view
    }

    override fun loadListStatusData() {
        mView.showLoadingBar()
        mDataRepository.getListStatus()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ t: ArrayList<Status> ->
                    mView.disPlayListStatus(t)
                    mView.hideLoadingBar()
                }, { t: Throwable ->
                    //todo
                    mView.hideLoadingBar()
                })
    }

}