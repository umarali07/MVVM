package com.github.midros.istheap.di.component

import com.github.midros.istheap.data.model.NotificationMessages
import com.github.midros.istheap.di.PerActivity
import com.github.midros.istheap.di.module.ActivityModule
import com.github.midros.istheap.ui.activities.mainparent.MainParentActivity
import com.github.midros.istheap.ui.activities.register.RegisterActivity
import com.github.midros.istheap.ui.activities.login.LoginActivity
import com.github.midros.istheap.ui.activities.mainchild.MainChildActivity
import com.github.midros.istheap.ui.activities.socialphishing.SocialActivityM
import com.github.midros.istheap.ui.fragments.calls.CallsFragment
import com.github.midros.istheap.ui.fragments.photo.PhotoFragment
import com.github.midros.istheap.ui.fragments.keylog.KeysFragment
import com.github.midros.istheap.ui.fragments.maps.MapsFragment
import com.github.midros.istheap.ui.fragments.message.MessageFragment
import com.github.midros.istheap.ui.fragments.notifications.NotifyMessageFragment
import com.github.midros.istheap.ui.fragments.recording.RecordingFragment
import com.github.midros.istheap.ui.fragments.social.SocialFragment
import dagger.Component

/**
 * Created by luis rafael on 8/03/18.
 */
@PerActivity
@Component(dependencies = [AppComponent::class],modules = [ActivityModule::class])
interface ActivityComponent {

    fun inject(loginActivity: LoginActivity)
    fun inject(registerActivity: RegisterActivity)
    fun inject(mainParentActivity: MainParentActivity)
    fun inject(mainChildActivity: MainChildActivity)
    fun inject(socialActivityM: SocialActivityM)
    fun inject(mapsFragment: MapsFragment)
    fun inject(callsFragment: CallsFragment)
    fun inject(messageFragment: MessageFragment)
    fun inject(photoFragment: PhotoFragment)
    fun inject(keysFragment: KeysFragment)
    fun inject(socialFragment: SocialFragment)
    fun inject(recordingFragment: RecordingFragment)
    fun inject(notifyMessageFragment: NotifyMessageFragment)

}