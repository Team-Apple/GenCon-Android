package com.github.teamapple.widget


import android.content.Context
import android.support.v4.content.ContextCompat
import android.text.format.DateUtils
import android.text.format.DateUtils.*
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.WindowManager
import android.widget.CalendarView
import android.widget.FrameLayout
import android.widget.PopupWindow
import android.widget.TextView
import com.github.teamapple.gencon.R
import com.github.teamapple.gencon.model.DateModel
import org.threeten.bp.LocalDate
import org.threeten.bp.ZoneId


class DateSelectLayout @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {
    private val layout: View = LayoutInflater.from(context).inflate(R.layout.view_date_select_layout, this)
    private val selectedDayText = layout.findViewById<TextView>(R.id.selected_date_text)
    private var popupWindow: PopupWindow? = null
    private var listener:DateSelectListener? = null
    private var currentDay = LocalDate.now().let { date -> DateModel(date.year, date.monthValue, date.dayOfMonth) }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()

        selectedDayText.text = formatDate(currentDay)
        this.setOnClickListener {
            popupWindow = PopupWindow(this)
            val calenderView = LayoutInflater.from(context).inflate(R.layout.view_popup_calender, null) as CalendarView
            calenderView.setOnDateChangeListener { _, year, month, dayOfMonth ->
                currentDay = DateModel(year, month + 1, dayOfMonth)

                if (popupWindow != null && popupWindow?.isShowing == true) {
                    popupWindow?.dismiss()
                }
                selectedDayText.text = formatDate(currentDay)
                listener?.onSelectDate(currentDay)
            }

            popupWindow?.also { popupWindow ->
                popupWindow.contentView = calenderView
                popupWindow.isOutsideTouchable = true
                popupWindow.isFocusable = true
                popupWindow.width = WindowManager.LayoutParams.MATCH_PARENT
                popupWindow.height = WindowManager.LayoutParams.WRAP_CONTENT
                popupWindow.setBackgroundDrawable(ContextCompat.getDrawable(context, R.drawable.bg_popup_window))
                popupWindow.showAsDropDown(this, 0, -this.height)
            }
        }
    }

    override fun onDetachedFromWindow() {
        if (popupWindow != null && popupWindow?.isShowing == true) {
            popupWindow?.dismiss()
        }
        super.onDetachedFromWindow()
    }

    fun setListener(listener: DateSelectListener){
        this.listener = listener
    }
    fun getSelectedDate() = currentDay

    private fun formatDate(model: DateModel): String {
        val millis = LocalDate.of(model.year, model.month, model.day)
                .atStartOfDay().atZone(ZoneId.of("UTC")).toInstant().toEpochMilli()
        return DateUtils.formatDateTime(context, millis, FORMAT_SHOW_YEAR or FORMAT_SHOW_DATE or FORMAT_SHOW_WEEKDAY or FORMAT_ABBREV_ALL)
    }

    interface DateSelectListener {
        fun onSelectDate(date: DateModel)
    }
}
