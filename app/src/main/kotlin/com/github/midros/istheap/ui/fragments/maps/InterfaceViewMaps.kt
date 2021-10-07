package com.github.midros.istheap.ui.fragments.maps

import com.github.midros.istheap.data.model.Location
import com.github.midros.istheap.ui.activities.base.InterfaceView
import com.google.firebase.database.DataSnapshot

/**
 * Created by luis rafael on 11/03/18.
 */
interface InterfaceViewMaps : InterfaceView {
    fun setLocation(location: Location)
    fun setValueState(dataSnapshot: DataSnapshot)
    fun setValuePermission(dataSnapshot: DataSnapshot)
}