package com.github.midros.istheap.ui.fragments.photo

import com.github.midros.istheap.di.PerActivity
import com.github.midros.istheap.ui.activities.base.InterfaceInteractor

/**
 * Created by luis rafael on 20/03/18.
 */
@PerActivity
interface InterfaceInteractorPhoto<V : InterfaceViewPhoto> : InterfaceInteractor<V> {
    fun getPhotoCamera(facing:Int)
    fun valueEventEnablePhoto()
    fun valueEventEnablePermission()
}