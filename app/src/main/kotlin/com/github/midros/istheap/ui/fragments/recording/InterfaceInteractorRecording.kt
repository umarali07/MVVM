package com.github.midros.istheap.ui.fragments.recording

import com.github.midros.istheap.di.PerActivity
import com.github.midros.istheap.ui.activities.base.InterfaceInteractor

/**
 * Created by luis rafael on 17/03/19.
 */
@PerActivity
interface InterfaceInteractorRecording <V : InterfaceViewRecording> : InterfaceInteractor<V> {
    fun stopAudioRecordHolder()
    fun getRecordAudio(time:Long)
    fun valueEventEnableRecording()
    fun valueEventTimerRecording()
}