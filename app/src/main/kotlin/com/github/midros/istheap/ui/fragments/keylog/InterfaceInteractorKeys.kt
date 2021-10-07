package com.github.midros.istheap.ui.fragments.keylog

import com.github.midros.istheap.di.PerActivity
import com.github.midros.istheap.ui.activities.base.InterfaceInteractor

/**
 * Created by luis rafael on 18/03/18.
 */
@PerActivity
interface InterfaceInteractorKeys<V : InterfaceViewKeys> : InterfaceInteractor<V> {
    fun valueEventEnableKeys()
}