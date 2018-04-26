package com.hydraz.trungnam1992.myapplication.data

import android.content.Context
import android.os.AsyncTask
import com.hydraz.trungnam1992.myapplication.model.Status
import io.reactivex.Single

/**
 * Created by trungnam1992 on 4/26/18.
 */
interface DataSource{

    fun getListStatus () : Single<ArrayList<Status>>
    fun saveListStatus(array: ArrayList<String>, context : Context)
}