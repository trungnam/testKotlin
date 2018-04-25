package com.hydraz.trungnam1992.myapplication.utils

/**
 * Created by trungnam1992 on 4/25/18.
 */
//todo seal class
sealed class InputStatusState{

    object NormalState : InputStatusState()

    data class ErrorState(var errmsg : String) : InputStatusState()

}
