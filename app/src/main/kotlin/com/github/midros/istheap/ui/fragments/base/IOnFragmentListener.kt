package com.github.midros.istheap.ui.fragments.base

interface IOnFragmentListener {
    fun onBackPressed(): Boolean
    fun onHideFragment()
}