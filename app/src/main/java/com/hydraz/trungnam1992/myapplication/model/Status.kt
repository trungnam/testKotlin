package com.hydraz.trungnam1992.myapplication.model

import io.realm.RealmObject
import java.util.*

/**
 * Created by trungnam1992 on 4/24/18.
 */
 open class Status  : RealmObject(){

 companion object {
   const val SINGLE_MSG = "single"
   const val SPLIT_MSG = "split"
 }

 var statusMsg : String = ""
 var typeMsg : String = SINGLE_MSG
}