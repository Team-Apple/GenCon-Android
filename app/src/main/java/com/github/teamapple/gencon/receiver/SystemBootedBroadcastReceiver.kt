package com.github.teamapple.gencon.receiver

import android.annotation.SuppressLint
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import timber.log.Timber

class SystemBootedBroadcastReceiver :BroadcastReceiver() {


    @SuppressLint("UnsafeProtectedBroadcastReceiver")
    override fun onReceive(context: Context, intent: Intent?) {
        Timber.d("onReceive booted")
        Log.d("BootedBroadcastReceive","onReceive boodted2")
    }
}
