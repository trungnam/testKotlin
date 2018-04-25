package com.hydraz.trungnam1992.myapplication.ui.presenter

import com.hydraz.trungnam1992.myapplication.ui.contact.FragmentUserInputContact
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject
import java.util.ArrayList
import java.util.concurrent.TimeUnit
import javax.inject.Inject

/**
 * Created by trungnam1992 on 4/25/18.
 */
class FragmentUserInputPresenter @Inject constructor() : BasePresenter<FragmentUserInputContact.FragmentUserInputView>() , FragmentUserInputContact.Presenter {


    private lateinit var mView : FragmentUserInputContact.FragmentUserInputView

    override fun detachView(view: FragmentUserInputContact.FragmentUserInputView) = Unit

    override fun attachView(view: FragmentUserInputContact.FragmentUserInputView) {
        mView = view
    }

    override fun checkInputMessage(strMsg: String) {
        PublishSubject.just(strMsg)
                .debounce(300, TimeUnit.MILLISECONDS)
                .map({
                    //check empty before split msg
                    if(it.isEmpty()){
                        throw Exception("Empty")
                    }
                    return@map it
                })
                .flatMap(
                        {
                          return@flatMap  splitMessageObserverble(it)
                        }
                ).subscribe(
                        { t : ArrayList<String> ->
                            //to do save to DB
                        },
                        { t : Throwable->
                            //
                        })


    }

    override fun splitMessageObserverble(strMsg: String): Observable<ArrayList<String>> {

        return Observable.create {
            try {

                it.onNext(splitMessage(strMsg))

            }catch (e : Exception){

            }
        }
    }

    fun splitMessage(str : String) : ArrayList<String>{

        var arrayList : ArrayList<String> = ArrayList()

        when {
            str.length < 50 ->
                return arrayListOf(str)
            str.length > 50 -> {
                //to do
                val strMsg=  str
                val lenghthofmsg= strMsg.length
                val size = strMsg.length / 50
               if(strMsg.length%50 !=0){
                   size + 1 // increase 1
               }
               val arrayindicator : ArrayList<String> = ArrayList()
               for ( i in 0..size ){
                   val idstr = "$i-$size "
                   arrayindicator.add(idstr)
               }
                var finalStr = strMsg
                for (a : String in arrayindicator){
                   finalStr+= a
               }
                //return arr
                var currindex = 0
                var idicatorleng = 0
                var strTmp = ""
                (0..size).forEach { i ->
                    strTmp += arrayindicator[i]

                    when (i) {
                        0 -> {
                            for (j in 0 ..(50 - arrayindicator[i].length-1)){
                                strTmp += strMsg.toCharArray()[j]
                                currindex = j
                            }
                            idicatorleng += arrayindicator[i].length
                            arrayList.add(strTmp)
                        }
                        else -> {
                            strTmp = "" //clear
                            strTmp += arrayindicator[i]
                            currindex+1
                            idicatorleng += arrayindicator[i].length
                            when {
                                50*(i+1) > finalStr.length -> for (k in currindex..(lenghthofmsg-1)){
                                    strTmp += strMsg.toCharArray()[k]
                                }
                                else -> {
                                    for (k in currindex..(50*(i+1) - (idicatorleng) - 1)){
                                        strTmp += strMsg.toCharArray()[k]
                                        currindex = k
                                    }
                                    idicatorleng += arrayindicator[i].length
                                }
                            }
                            //save to array
                            arrayList.add(strTmp)
                        }
                    }
                }

            }
        }

        return arrayList
    }

}