package com.github.teamapple.gencon.presentation.common.dialogs

import android.app.Dialog
import android.os.Bundle
import android.support.v4.app.DialogFragment

class PrioritySelectDialogFragment:DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return super.onCreateDialog(savedInstanceState)
    }

    companion object {
        fun newInstance() = PrioritySelectDialogFragment()
    }
}
