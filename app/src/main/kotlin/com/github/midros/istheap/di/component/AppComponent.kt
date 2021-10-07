package com.github.midros.istheap.di.component

import com.github.midros.istheap.app.IsTheApp
import com.github.midros.istheap.data.rxFirebase.InterfaceFirebase
import com.github.midros.istheap.di.module.AppModule
import com.github.midros.istheap.di.module.FirebaseModule
import com.github.midros.istheap.services.accessibilityData.AccessibilityDataService
import com.github.midros.istheap.services.notificationService.NotificationService
import dagger.Component
import javax.inject.Singleton

/**
 * Created by luis rafael on 13/03/18.
 */
@Singleton
@Component(modules = [AppModule::class, FirebaseModule::class])
interface AppComponent {

    fun inject(app: IsTheApp)
    fun inject(accessibilityDataService: AccessibilityDataService)
    fun inject(notificationService: NotificationService)
    fun getInterfaceFirebase(): InterfaceFirebase

}