package com.hydraz.trungnam1992.myapplication.data

import com.hydraz.trungnam1992.myapplication.model.Status
import io.reactivex.Single

/**
 * Created by trungnam1992 on 4/24/18.
 */
interface LocalResource{

    fun getStatus() : Single<Status>

}