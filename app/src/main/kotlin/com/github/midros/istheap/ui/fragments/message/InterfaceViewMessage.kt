package com.github.midros.istheap.ui.fragments.message

import com.github.midros.istheap.ui.activities.base.InterfaceView
import com.github.midros.istheap.ui.adapters.smsadapter.SmsRecyclerAdapter

/**
 * Created by luis rafael on 20/03/18.
 */
interface InterfaceViewMessage : InterfaceView {

    fun setRecyclerAdapter(smsRecyclerAdapter: SmsRecyclerAdapter)

}