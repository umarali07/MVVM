package com.github.midros.istheap.app

import android.app.*
import android.content.Intent
import android.content.IntentFilter
import android.os.Build
import androidx.multidex.MultiDex
import com.chrisplus.rootmanager.RootManager
import com.github.midros.istheap.di.component.AppComponent
import com.github.midros.istheap.di.component.DaggerAppComponent
import com.github.midros.istheap.di.module.AppModule
import com.github.midros.istheap.di.module.FirebaseModule
import com.github.midros.istheap.utils.Consts.SIZE_CACHE_FIREBASE
import com.google.firebase.FirebaseApp
import com.google.firebase.database.FirebaseDatabase
import java.util.*

/**
 * Created by luis rafael on 28/03/18.
 */
class IsTheApp : Application() {

    companion object {
        @JvmStatic lateinit var appComponent: AppComponent
        lateinit var root: RootManager
        val CHANNEL_ID1 = "bonitocha"
    }

    override fun onCreate() {
        super.onCreate()
        MultiDex.install(this)

        appComponent = DaggerAppComponent.builder().appModule(AppModule(this)).firebaseModule(FirebaseModule()).build()
        appComponent.inject(this)

        root = RootManager.getInstance()

        if (FirebaseApp.getApps(this).isNotEmpty()) {
            val database = FirebaseDatabase.getInstance()
            database.setPersistenceEnabled(true)
            database.setPersistenceCacheSizeBytes(SIZE_CACHE_FIREBASE)
        }

//        createChannel()
//        registerPhoneUnlockedReceiver()
//        val cal = Calendar.getInstance()
//        cal.add(Calendar.SECOND, 30)
//        val time = cal.timeInMillis
//        Util.createAlarm(this, time)
//        Util.createAlarmLocationUpdate(this, time)

    }

//    private fun registerPhoneUnlockedReceiver() {
//        val receiver = PhoneUnlockedReceiver()
//        val filter = IntentFilter()
//        filter.addAction(Intent.ACTION_USER_PRESENT)
//        filter.addAction(Intent.ACTION_SCREEN_OFF)
//        registerReceiver(receiver, filter)
//    }
//
//    private fun createChannel() {
//        if (Build.VERSION.SDK_INT >= 26) {
//            val notificationChannel = NotificationChannel(ClientApp.CHANNEL_ID1, "Foreground Service", NotificationManager.IMPORTANCE_LOW)
//            notificationChannel.description = "Foreground Service"
//            val notificationManager = getSystemService(NotificationManager::class.java)
//            notificationManager?.createNotificationChannel(notificationChannel)
//        }
//    }
//
//    fun createAlarm() {
//        val interval = 3 * 60 * 1000.toLong() // 3 minute
//        val intent = Intent(this, MyBroadcastReceiver::class.java)
//        val pendingIntent = PendingIntent.getBroadcast(
//                this.applicationContext, 12890, intent, 0)
//        val alarmManager = getSystemService(ALARM_SERVICE) as AlarmManager
//        val c = Calendar.getInstance()
//        c.add(Calendar.SECOND, 5)
//        val afterTenSeconds = c.timeInMillis
//        //        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, afterTenSeconds
////                + 5000, interval, pendingIntent);
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//            alarmManager.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, afterTenSeconds, pendingIntent)
//        } else {
//            alarmManager.setExact(AlarmManager.RTC, afterTenSeconds, pendingIntent)
//        }
//    }
//
//    fun createAlarmLocationUpdate() {
//        val interval = 30 * 60 * 1000.toLong() // 30 minute
//        val intent = Intent(this, MyLocationUpdateBroadcastReceiver::class.java)
//        val pendingIntent = PendingIntent.getBroadcast(
//                this.applicationContext, 12891, intent, 0)
//        val alarmManager = getSystemService(ALARM_SERVICE) as AlarmManager
//        val c = Calendar.getInstance()
//        c.add(Calendar.SECOND, 60)
//        val afterTenSeconds = c.timeInMillis
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//            alarmManager.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, afterTenSeconds, pendingIntent)
//        } else {
//            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, afterTenSeconds
//                    + 60000, interval, pendingIntent)
//        }
//    }



}