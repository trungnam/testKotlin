package com.hydraz.trungnam1992.myapplication.ui.presenter

import com.hydraz.trungnam1992.myapplication.data.DataRepository
import com.hydraz.trungnam1992.myapplication.model.Status
import com.hydraz.trungnam1992.myapplication.ui.contact.FragmentListStatusContact
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

/**
 * Created by trungnam1992 on 4/27/18.
 */
open class FragmentListStatusPresenter
@Inject constructor(
        private var dataRepository: DataRepository,
        private var compositeDisposable: CompositeDisposable)
    : BasePresenter<FragmentListStatusContact.ListStatusFragmentView>(), FragmentListStatusContact.Presenter {

    lateinit var mView: FragmentListStatusContact.ListStatusFragmentView

    override fun detachView(view: FragmentListStatusContact.ListStatusFragmentView) {

    }

    override fun attachView(view: FragmentListStatusContact.ListStatusFragmentView) {
        mView = view
    }

    override fun loadListStatusData() {
        mView.showLoadingBar()
        val disposable = dataRepository.getListStatus()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ t: ArrayList<Status> ->
                    mView.disPlayListStatus(t)
                    mView.hideLoadingBar()
                }, { t: Throwable ->
                    //todo
                    mView.hideLoadingBar()
                })
        compositeDisposable.add(disposable)
    }
}