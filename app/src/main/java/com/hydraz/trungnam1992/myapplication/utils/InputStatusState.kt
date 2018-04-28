package com.hydraz.trungnam1992.myapplication.utils

/**
 * Created by trungnam1992 on 4/25/18.
 */
//seal class for alternative emun
sealed class InputStatusState{

    object NormalState : InputStatusState()

    data class ErrorState(val errmsg : String) : InputStatusState()

}
