package com.hydraz.trungnam1992.myapplication

import android.util.Log
import com.hydraz.trungnam1992.myapplication.ui.presenter.FragmentUserInputPresenter
import org.hamcrest.core.Is.`is`
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import javax.inject.Inject

/**
 * Created by trungnam1992 on 4/25/18.
 */
class UserInputUnitTest{


    lateinit var userInputPresenter : FragmentUserInputPresenter

    @Before
    fun setUp(){

        userInputPresenter = FragmentUserInputPresenter()


    }

    @Test
    fun testSplitMessage(){
//        var arrTest = userInputPresenter.splitMessage("I can't believe Tweeter now supports chunking my messages, so I don't have to do it myself. hahahahahahahaha gigigigi")
//        var arrStub = arrayListOf("I can't believe Tweeter now supports chunking my messages, so I don't have to do it myself.")


    }
}