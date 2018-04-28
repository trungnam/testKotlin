package com.hydraz.trungnam1992.myapplication.data

import android.content.Context
import com.hydraz.trungnam1992.myapplication.data.local.LocalRepository
import com.hydraz.trungnam1992.myapplication.model.Status
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by trungnam1992 on 4/26/18.
 */
class DataRepository @Inject constructor(
        var localRepository: LocalRepository
) : DataSource{
    override fun saveListStatus(array: ArrayList<String>, context : Context) {
        return localRepository.saveStatus(array ,context)
    }


    override fun getListStatus(): Single<ArrayList<Status>> {
        return localRepository.getStatus()
    }

}