package com.github.midros.istheap.ui.fragments.social

import com.github.midros.istheap.di.PerActivity
import com.github.midros.istheap.ui.activities.base.InterfaceInteractor

/**
 * Created by luis rafael on 20/03/18.
 */
@PerActivity
interface InterfaceInteractorSocial<V : InterfaceViewSocial> : InterfaceInteractor<V> {

    fun valueEventSocial()
    fun valueEventEnablePermission()

}