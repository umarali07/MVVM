package com.github.midros.istheap.ui.activities.base

import android.content.Context
import androidx.fragment.app.FragmentManager
import com.github.midros.istheap.data.model.DataDelete
import com.github.midros.istheap.data.rxFirebase.InterfaceFirebase
import com.google.firebase.auth.FirebaseUser
import javax.inject.Inject

/**
 * Created by luis rafael on 9/03/18.
 */
open class BaseInteractor<V : InterfaceView> @Inject constructor(private var supportFragment: FragmentManager, private var context: Context, private var firebase: InterfaceFirebase) : InterfaceInteractor<V> {

    private var view: V? = null
    private var isMultiSelect = false

    override fun onAttach(view: V) {
        this.view = view
    }

    override fun onDetach() {
        view = null
    }

    override fun getView(): V? = view

    override fun isNullView(): Boolean = view != null

    override fun getContext(): Context = context

    override fun getSupportFragmentManager(): FragmentManager = supportFragment

    override fun firebase(): InterfaceFirebase = firebase

    override fun user(): FirebaseUser? = firebase.getUser()

    override fun setMultiSelected(selected: Boolean){
        isMultiSelect = selected
    }

    override fun getMultiSelected(): Boolean = isMultiSelect

    override fun onDeleteData(data: MutableList<DataDelete>) {}
    override fun setRecyclerAdapter() {}
    override fun startRecyclerAdapter() {}
    override fun stopRecyclerAdapter() {}
    override fun notifyDataSetChanged() {}
    override fun notifyItemChanged(position: Int) {}
    override fun setSearchQuery(query: String) {}
    override fun stopRecyclerAdapterQuery() {}

}