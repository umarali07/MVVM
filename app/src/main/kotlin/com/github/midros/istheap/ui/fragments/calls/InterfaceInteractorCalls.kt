package com.github.midros.istheap.ui.fragments.calls

import com.github.midros.istheap.di.PerActivity
import com.github.midros.istheap.ui.activities.base.InterfaceInteractor

/**
 * Created by luis rafael on 12/03/18.
 */
@PerActivity
interface InterfaceInteractorCalls<V : InterfaceViewCalls> : InterfaceInteractor<V> {
    fun stopAudioCallHolder()
}