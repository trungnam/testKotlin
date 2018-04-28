package com.hydraz.trungnam1992.myapplication

import android.text.TextUtils
import com.hydraz.trungnam1992.myapplication.data.DataRepository
import com.hydraz.trungnam1992.myapplication.ui.contact.FragmentUserInputContact
import com.hydraz.trungnam1992.myapplication.ui.presenter.FragmentUserInputPresenter
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers.any
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations
import org.powermock.api.mockito.PowerMockito
import org.powermock.api.mockito.PowerMockito.`when`
import org.powermock.api.mockito.PowerMockito.mockStatic
import org.powermock.core.classloader.annotations.PrepareForTest
import org.powermock.modules.junit4.PowerMockRunner


/**
 * Created by trungnam1992 on 4/25/18.
 */
@PrepareForTest(TextUtils::class, CompositeDisposable::class, DataRepository::class, Observable::class)
@RunWith(PowerMockRunner::class)
class UserInputUnitTest {
    @Mock
    lateinit var userInputPresenter: FragmentUserInputPresenter
    @Mock
    lateinit var compositeDisposable: CompositeDisposable
    @Mock
    lateinit var dataRepository: DataRepository
    @Mock
    lateinit var view: FragmentUserInputContact.FragmentUserInputView
    @Mock
    lateinit var presentInterface: FragmentUserInputContact.Presenter

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this);
        //for TextUtils mock
        mockStatic(TextUtils::class.java)
        PowerMockito.`when`(TextUtils.isEmpty(any(CharSequence::class.java))).thenAnswer { invocation ->
            val a = invocation.arguments[0] as CharSequence
            return@thenAnswer !(a.isNotEmpty())
        }
        //Presenter
        compositeDisposable = CompositeDisposable()
        userInputPresenter = FragmentUserInputPresenter(dataRepository, compositeDisposable)
        userInputPresenter.attachView(view)


    }

    @Test
    fun testSplitMessage() {
        //91 char case

        val str91lenght = "I can't believe Tweeter now supports chunking my messages, so I don't have to do it myself."
        val arrStub = userInputPresenter.splitMessage(str91lenght)
        Assert.assertEquals(50, arrStub[0].length)
        Assert.assertEquals(50, arrStub[1].length)

        // = 50 char case
        val str50lenght = "I can't believe Tweeter now supports chunking"
        val arrSameStub = userInputPresenter.splitMessage(str50lenght)
        Assert.assertEquals(str50lenght.length, arrSameStub[0].length)

        // < 50 char case
        val strbellow50lenght = "I can't believe Tweeter now supports"
        val arrLowStub = userInputPresenter.splitMessage(strbellow50lenght)
        Assert.assertEquals(strbellow50lenght.length, arrLowStub[0].length)


        // dangerous msg case
        val strbUserInputErrorSpan = "I can't believe Tweeter now supports thisthisthisthisthisthisthisthisthisthis"
        val arrbUserInputErrorSpan = userInputPresenter.splitMessage(strbUserInputErrorSpan)
        Assert.assertEquals(true, arrbUserInputErrorSpan.isEmpty())

    }

    @Test
    fun `user input error status`() {

        stubErrMessageObserverble()
        verify(view).enableSummirButton(false)
        verify(view).showError("Message cannot chunk")

    }

    @Test
    fun `user input empty status`() {

        stubEmptyMessageObserverble()
        verify(view).enableSummirButton(false)
        verify(view).showError("Empty")

    }

    @Test
    fun `user input normal status`() {

        stubNormalMessageObserverble()
        verify(view).enableSummirButton(true)

    }

    fun stubNormalMessageObserverble() {
        val str91lenght = "I can't believe Tweeter now supports chunking my messages, so I don't have to do it myself."
        val array = userInputPresenter.splitMessage(str91lenght)

        `when`(presentInterface.splitMessageObserverble(str91lenght))
                .thenReturn(Observable.just(array))
        presentInterface.splitMessageObserverble(str91lenght).subscribe { t: java.util.ArrayList<String> ->
            when {
                !t.isEmpty() -> {
                    view.enableSummirButton(true)
                }
            }
        }
    }

    fun stubEmptyMessageObserverble() {
        val strbUserInputErrorSpan = ""
        val arrbUserInputErrorSpan = userInputPresenter.splitMessage(strbUserInputErrorSpan)

        `when`(presentInterface.splitMessageObserverble(strbUserInputErrorSpan))
                .thenReturn(Observable.just(arrbUserInputErrorSpan))
        presentInterface.splitMessageObserverble(strbUserInputErrorSpan).subscribe { t: java.util.ArrayList<String> ->
            when {
                t.isEmpty() -> {
                    view.enableSummirButton(false)
                    view.showError("Empty")

                }
            }
        }
    }

    fun stubErrMessageObserverble() {
        val strbUserInputErrorSpan = "I can't believe Tweeter now supports thisthisthisthisthisthisthisthisthisthis"
        val arrbUserInputErrorSpan = userInputPresenter.splitMessage(strbUserInputErrorSpan)

        `when`(presentInterface.splitMessageObserverble(strbUserInputErrorSpan))
                .thenReturn(Observable.just(arrbUserInputErrorSpan))
        presentInterface.splitMessageObserverble(strbUserInputErrorSpan).subscribe { t: java.util.ArrayList<String> ->
            when {
                t.isEmpty() -> {
                    view.enableSummirButton(false)
                    view.showError("Message cannot chunk")

                }
            }
        }
    }
}