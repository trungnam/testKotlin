package com.hydraz.trungnam1992.myapplication

import android.text.TextUtils
import com.hydraz.trungnam1992.myapplication.data.DataRepository
import com.hydraz.trungnam1992.myapplication.model.Status
import com.hydraz.trungnam1992.myapplication.ui.contact.FragmentListStatusContact
import com.hydraz.trungnam1992.myapplication.ui.presenter.FragmentListStatusPresenter
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.times
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations
import org.powermock.api.mockito.PowerMockito.`when`
import org.powermock.core.classloader.annotations.PrepareForTest
import org.powermock.modules.junit4.PowerMockRunner
import io.reactivex.schedulers.Schedulers
import io.reactivex.android.plugins.RxAndroidPlugins

/**
 * Created by trungnam1992 on 4/29/18.
 */
@PrepareForTest(TextUtils::class, CompositeDisposable::class, DataRepository::class, Single::class)
@RunWith(PowerMockRunner::class)
class FragmentListStatusPresenterUnitTest {
    @Mock
    lateinit var fragmentListStatusPresenter: FragmentListStatusPresenter
    @Mock
    lateinit var mDataRepository: DataRepository
    @Mock
    lateinit var compositeDisposable: CompositeDisposable
    @Mock
    lateinit var view: FragmentListStatusContact.ListStatusFragmentView

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        RxAndroidPlugins.setInitMainThreadSchedulerHandler { scheduler -> Schedulers.trampoline() }
        fragmentListStatusPresenter = FragmentListStatusPresenter(mDataRepository, compositeDisposable)
        fragmentListStatusPresenter.attachView(view)
    }

    @Test
    fun testStatusDisplayOK() {
        val arrStub = stubDataReponse()
        `when`(mDataRepository.getListStatus()).thenReturn(
                Single.just(arrStub)
        )
        fragmentListStatusPresenter.loadListStatusData()
        verify(view, times(1)).showLoadingBar();
        verify(view, times(1)).hideLoadingBar();
        verify(view, times(1)).disPlayListStatus(arrStub);

    }

    @Test
    fun testStatusDisplayError() {

        `when`(mDataRepository.getListStatus())
                .thenReturn(Single.error(NullPointerException()))

        fragmentListStatusPresenter.loadListStatusData()
        verify(view, times(1)).showLoadingBar();
        verify(view, times(1)).hideLoadingBar();

    }

    //fake data
    fun stubDataReponse(): ArrayList<Status> {
        val stubStatus: ArrayList<Status> = ArrayList()
        for (i in 0..10) {
            val status = Status().apply {
                typeMsg = Status.SINGLE_MSG
                statusMsg = "this is msg"
            }

            stubStatus.add(status)
        }
        return stubStatus
    }

}