package com.github.teamapple.widget

import android.app.Dialog

import android.app.TimePickerDialog
import android.content.Context
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.widget.TimePicker
import com.github.teamapple.gencon.domain.model.TimeModel
import java.util.*

class TimePickerDialogFragment : DialogFragment(), TimePickerDialog.OnTimeSetListener {
    private var listener: Listener? = null

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is Listener) {
            listener = context
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val c = Calendar.getInstance()
        val hour = c.get(Calendar.HOUR_OF_DAY)
        val minute = c.get(Calendar.MINUTE)
        return TimePickerDialog(activity, this, hour, minute,true)
    }

    override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
        listener?.onTimeSelect(TimeModel(hourOfDay, minute))
    }

    fun setListener(listener:Listener){
        this.listener = listener
    }

    interface Listener {
        fun onTimeSelect(date: TimeModel)
    }

    companion object {
        fun newInstance() = TimePickerDialogFragment()
    }
}
