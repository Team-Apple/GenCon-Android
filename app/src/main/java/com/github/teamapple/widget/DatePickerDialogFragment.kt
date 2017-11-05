package com.github.teamapple.widget

import android.app.DatePickerDialog
import android.app.Dialog

import android.content.Context
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.widget.DatePicker
import com.github.teamapple.gencon.domain.model.DateModel
import java.util.*

class DatePickerDialogFragment : DialogFragment(), DatePickerDialog.OnDateSetListener {
    private var listener: Listener? = null

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is Listener) {
            listener = context
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)
        return DatePickerDialog(activity, this, year, month, day)
    }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        listener?.onDateSelect(DateModel(year, month + 1, dayOfMonth))
    }

    fun setListener(listener: Listener){
        this.listener = listener
    }
    interface Listener {
        fun onDateSelect(date: DateModel)
    }

    companion object {
        fun newInstance() = DatePickerDialogFragment()
    }
}
