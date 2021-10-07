package com.github.midros.istheap.ui.fragments.calls

import com.github.midros.istheap.ui.activities.base.InterfaceView
import com.github.midros.istheap.ui.adapters.callsadapter.CallsRecyclerAdapter

/**
 * Created by luis rafael on 12/03/18.
 */
interface InterfaceViewCalls : InterfaceView {

    fun setRecyclerAdapter(recyclerAdapter: CallsRecyclerAdapter)

}