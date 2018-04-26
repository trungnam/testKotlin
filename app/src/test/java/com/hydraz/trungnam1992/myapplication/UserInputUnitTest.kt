package com.hydraz.trungnam1992.myapplication

import android.text.TextUtils
import com.hydraz.trungnam1992.myapplication.ui.presenter.FragmentUserInputPresenter
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers.any
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.powermock.api.mockito.PowerMockito
import org.powermock.api.mockito.PowerMockito.mockStatic
import org.powermock.core.classloader.annotations.PrepareForTest
import org.powermock.modules.junit4.PowerMockRunner


/**
 * Created by trungnam1992 on 4/25/18.
 */
@PrepareForTest(TextUtils::class)
@RunWith(PowerMockRunner::class)
class UserInputUnitTest{

    @Mock lateinit var userInputPresenter : FragmentUserInputPresenter

    @Before
    fun setUp(){
        MockitoAnnotations.initMocks(this);
        mockStatic(TextUtils::class.java)
        PowerMockito.`when`(TextUtils.isEmpty(any(CharSequence::class.java))).thenAnswer { invocation ->
            val a = invocation.arguments[0] as CharSequence
            return@thenAnswer !(a.isNotEmpty())
        }
        userInputPresenter = FragmentUserInputPresenter()

    }

    @Test
    fun testSplitMessage(){
        //91 char case
        val str91lenght = "I can't believe Tweeter now supports chunking my messages, so I don't have to do it myself."
        val arrStub = userInputPresenter.splitMessage(str91lenght)
        Assert.assertEquals(50,arrStub[0].length)
        Assert.assertEquals(50,arrStub[1].length)

        // = 50 char case
        val str50lenght = "I can't believe Tweeter now supports chunking"
        val arrSameStub = userInputPresenter.splitMessage(str50lenght)
        Assert.assertEquals(str50lenght.length,arrSameStub[0].length)

        // < 50 char case
        val strbellow50lenght = "I can't believe Tweeter now supports"
        val arrLowStub = userInputPresenter.splitMessage(strbellow50lenght)
        Assert.assertEquals(strbellow50lenght.length,arrLowStub[0].length)


        // dangerous msg case
        val strbUserInputErrorSpan = "I can't believe Tweeter now supports thisthisthisthisthisthisthisthisthisthis"
        val arrbUserInputErrorSpan = userInputPresenter.splitMessage(strbUserInputErrorSpan)
        Assert.assertEquals(true ,arrbUserInputErrorSpan.isEmpty())

    }
}