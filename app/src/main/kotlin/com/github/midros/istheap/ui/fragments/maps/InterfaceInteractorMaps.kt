package com.github.midros.istheap.ui.fragments.maps

import com.github.midros.istheap.di.PerActivity
import com.github.midros.istheap.ui.activities.base.InterfaceInteractor

/**
 * Created by luis rafael on 11/03/18.
 */
@PerActivity
interface InterfaceInteractorMaps<V : InterfaceViewMaps> : InterfaceInteractor<V> {
    fun valueEventLocation()
    fun valueEventEnableGps()
    fun valueEventEnablePermission()
}