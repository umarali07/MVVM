package com.github.midros.istheap.services.sms

import com.github.midros.istheap.di.PerService
import com.github.midros.istheap.services.base.InterfaceInteractorService

/**
 * Created by luis rafael on 27/03/18.
 */
@PerService
interface InterfaceInteractorSms<S : InterfaceServiceSms> : InterfaceInteractorService<S> {

    fun setPushSms(smsAddress: String, smsBody: String,type: Int)

}