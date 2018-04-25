package com.hydraz.trungnam1992.myapplication.data.local

import com.hydraz.trungnam1992.myapplication.data.LocalResource
import com.hydraz.trungnam1992.myapplication.model.Status
import io.reactivex.Single
import io.realm.Realm
import javax.inject.Inject

/**
 * Created by trungnam1992 on 4/24/18.
 */
class LocalRepository @Inject constructor(realm: Realm) : LocalResource{
    val mRealm: Realm = realm
    override fun getStatus(): Single<Status> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }



}