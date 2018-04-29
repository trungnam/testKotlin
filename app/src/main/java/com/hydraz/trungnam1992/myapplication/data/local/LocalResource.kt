package com.hydraz.trungnam1992.myapplication.data.local

import android.content.Context
import com.hydraz.trungnam1992.myapplication.model.Status
import io.reactivex.Single
import java.security.AccessControlContext

/**
 * Created by trungnam1992 on 4/24/18.
 */
interface LocalResource {
    fun getStatus(): Single<ArrayList<Status>>
    fun saveStatus(array: ArrayList<String>, context: Context)
}