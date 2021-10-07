package com.github.midros.istheap.di.component

import com.github.midros.istheap.di.PerService
import com.github.midros.istheap.di.component.AppComponent
import com.github.midros.istheap.di.module.ServiceModule
import com.github.midros.istheap.services.calls.CallsService
import com.github.midros.istheap.services.sms.SmsService
import com.github.midros.istheap.services.social.MonitorService
import dagger.Component

/**
 * Created by luis rafael on 13/03/18.
 */
@PerService
@Component(dependencies = [AppComponent::class], modules = [ServiceModule::class])
interface ServiceComponent {

    fun inject(callsService: CallsService)
    fun inject(smsService: SmsService)
    fun inject(monitorService: MonitorService)

}