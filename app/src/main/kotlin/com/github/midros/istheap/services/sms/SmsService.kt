package com.github.midros.istheap.services.sms

import android.content.Intent
import com.github.midros.istheap.services.base.BaseService
import com.github.midros.istheap.utils.Consts.SMS_ADDRESS
import com.github.midros.istheap.utils.Consts.SMS_BODY
import com.github.midros.istheap.utils.Consts.TYPE_SMS
import javax.inject.Inject

/**
 * Created by luis rafael on 13/03/18.
 */
class SmsService : BaseService(), InterfaceServiceSms {

    @Inject lateinit var interactor: InterfaceInteractorSms<InterfaceServiceSms>

    override fun onCreate() {
        super.onCreate()
        if (getComponent() != null) {
            getComponent()!!.inject(this)
            interactor.onAttach(this)
        }
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        intent?.setSmsIntent()
        return super.onStartCommand(intent, flags, startId)
    }

    private fun Intent.setSmsIntent() {
        getStringExtra(SMS_ADDRESS)?.let { getStringExtra(SMS_BODY)?.let { it1 -> interactor.setPushSms(it, it1,getIntExtra(TYPE_SMS,0)) } }
    }

    override fun stopServiceSms() {
        stopSelf()
    }

    override fun onDestroy() {
        interactor.onDetach()
        super.onDestroy()
    }


}