package com.github.midros.istheap.ui.widget

import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.github.clans.fab.FloatingActionButton
import com.pawegio.kandroid.show
import com.pawegio.kandroid.hide

/**
 * Created by luis rafael on 20/03/18.
 */
class OnScrollListener(private val floating: FloatingActionButton, private val lManager: LinearLayoutManager) : RecyclerView.OnScrollListener() {

    private var visibleThreshold = 2
    private var firstVisibleItem = 0
    private var visibleItemCount = 0
    private var totalItemCount = 0

    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        super.onScrolled(recyclerView, dx, dy)
        visibleItemCount = recyclerView.childCount
        totalItemCount = lManager.itemCount
        firstVisibleItem = lManager.findFirstVisibleItemPosition()

        if ((totalItemCount - visibleItemCount) <= (firstVisibleItem + visibleThreshold)) floating.hide(true)
        else floating.show(true)

    }
}