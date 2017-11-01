package com.github.teamapple.gencon.presentation.ui.eventEdit

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.github.teamapple.gencon.presentation.common.dialogs.PrioritySelectDialogFragment

class EventEditActivity : AppCompatActivity() {

    companion object {
        fun start(context: Context) {
            context.startActivity(Intent(context, EventEditActivity::class.java))
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        PrioritySelectDialogFragment.newInstance().show(supportFragmentManager,"PrioritySelectDialogFragment")
    }
}
