package com.github.teamapple.gencon.presentation.common.dialogs

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v7.app.AlertDialog
import android.view.LayoutInflater
import com.github.teamapple.gencon.R
import com.github.teamapple.gencon.domain.model.PriorityModel
import kotlinx.android.synthetic.main.dialog_priority_select.*

class PrioritySelectDialogFragment : DialogFragment() {

    private var listener: SelectListener? = null

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is SelectListener) {
            listener = context
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val view = LayoutInflater.from(context).inflate(R.layout.dialog_priority_select, null, false)
        return AlertDialog.Builder(context)
                .setTitle(R.string.common_priority)
                .setNegativeButton(R.string.common_cancel, null)
                .setView(view)
                .create()
    }

    override fun onResume() {
        super.onResume()
        with(dialog) {
            priorityHighText.setOnClickListener {
                listener?.onSelectPriority(PriorityModel.High)
            }
            priorityNormalText.setOnClickListener {
                listener?.onSelectPriority(PriorityModel.Normal)
            }
            priorityLowText.setOnClickListener {
                listener?.onSelectPriority(PriorityModel.Low)
            }
        }
    }

    interface SelectListener {
        fun onSelectPriority(priority: PriorityModel)
    }

    companion object {
        fun newInstance() = PrioritySelectDialogFragment()
    }
}
