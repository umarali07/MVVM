package com.github.midros.istheap.services.calls

import com.github.midros.istheap.di.PerService
import com.github.midros.istheap.services.base.InterfaceInteractorService

/**
 * Created by luis rafael on 27/03/18.
 */
@PerService
interface InterfaceInteractorCalls<S : InterfaceServiceCalls> : InterfaceInteractorService<S> {

    fun startRecording(phoneNumber:String?,type:Int)
    fun stopRecording()

}