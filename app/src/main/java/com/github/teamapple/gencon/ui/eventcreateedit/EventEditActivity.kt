package com.github.teamapple.gencon.ui.eventcreateedit

import android.content.Context
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.github.teamapple.gencon.GenConApplication
import com.github.teamapple.gencon.R
import com.github.teamapple.gencon.databinding.ActivityEventEditBinding
import com.github.teamapple.gencon.domain.model.DateModel
import com.github.teamapple.gencon.domain.model.TimeModel
import com.github.teamapple.widget.DatePickerDialogFragment
import com.github.teamapple.widget.TimePickerDialogFragment
import kotlinx.android.synthetic.main.activity_event_edit.*
import org.threeten.bp.LocalDate
import org.threeten.bp.ZoneId
import org.threeten.bp.ZonedDateTime

class EventEditActivity : AppCompatActivity() {

    companion object {
        fun start(context: Context) {
            context.startActivity(Intent(context, EventEditActivity::class.java))
        }
    }

    val binging: ActivityEventEditBinding by lazy { DataBindingUtil.setContentView<ActivityEventEditBinding>(this, R.layout.activity_event_edit) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setSupportActionBar(toolBar)
        supportActionBar?.apply {
            setDisplayShowTitleEnabled(false)
        }
        val now = ZonedDateTime.now()
        val date = formatDate(now)
        val time = formatTime(now)
        val apiClient = GenConApplication.appComponent(this).apiclient()
        binging.startDayText.text = date
        binging.endDayText.text = date

        binging.startTimeText.text = time
        binging.endTimeText.text = time

        binging.startTimeText.setOnClickListener {
            val dialog = TimePickerDialogFragment()
            dialog.setListener(object : TimePickerDialogFragment.Listener {
                override fun onTimeSelect(date: TimeModel) {
                    binging.startTimeText.text = "${"%02d".format(date.hour)}-${"%02d".format(date.minute)}"
                }
            })
            dialog.show(supportFragmentManager, "TimePickerDialogFragment")
        }

        binging.startDayText.setOnClickListener {
            val dialog = DatePickerDialogFragment()

            dialog.setListener(object : DatePickerDialogFragment.Listener {
                override fun onDateSelect(date: DateModel) {
                    val millis = LocalDate.of(date.year, date.month, date.day)
                            .atStartOfDay().atZone(ZoneId.of("UTC")).toInstant().toEpochMilli()
                    binging.startDayText.text ="${"%04d".format(date.year)}-${"%02d".format(date.month)}-${"%02d".format(date.day)}"
                }
            })
            dialog.show(supportFragmentManager, "DatePickerDialogFragment")
        }

        binging.startTimeText.setOnClickListener {
            val dialog = TimePickerDialogFragment()
            dialog.setListener(object : TimePickerDialogFragment.Listener {
                override fun onTimeSelect(date: TimeModel) {
                    binging.startTimeText.text = "${"%02d".format(date.hour)}-${"%02d".format(date.minute)}"
                }
            })
            dialog.show(supportFragmentManager, "TimePickerDialogFragment")
        }

        binging.endDayText.setOnClickListener {
            val dialog = DatePickerDialogFragment()

            dialog.setListener(object : DatePickerDialogFragment.Listener {
                override fun onDateSelect(date: DateModel) {
                    val millis = LocalDate.of(date.year, date.month, date.day)
                            .atStartOfDay().atZone(ZoneId.of("UTC")).toInstant().toEpochMilli()
                    binging.endDayText.text ="${"%04d".format(date.year)}-${"%02d".format(date.month)}-${"%02d".format(date.day)}"
                }
            })
            dialog.show(supportFragmentManager, "DatePickerDialogFragment")

        }

        binging.endTimeText.setOnClickListener {
            val dialog = TimePickerDialogFragment()
            dialog.setListener(object : TimePickerDialogFragment.Listener {
                override fun onTimeSelect(date: TimeModel) {
                    binging.endTimeText.text = "${"%02d".format(date.hour)}:${"%02d".format(date.minute)}"
                }
            })
            dialog.show(supportFragmentManager, "TimePickerDialogFragment")
        }

        binging.sendButton.setOnClickListener {
            /*val titile = binging.titleText.text.toString().let {
                if (it.isEmpty()) "無題"
                else it
            }
            apiClient.createEvent(hashMapOf(
                    "title" to titile,
                    "start_at_date" to binging.startDayText.text.toString(),
                    "start_at_time" to binging.startTimeText.text.toString(),
                    "end_at_date" to binging.endDayText.text.toString(),
                    "end_at_time" to binging.endTimeText.text.toString(),
                    "memo" to binging.memoEditText.toString(),
                    "priority" to  "normal"))
                    .subscribeOn(Schedulers.io())
                    .subscribe(
                            {
                                Toast.makeText(this,"作成したよ",Toast.LENGTH_SHORT).show()
                            },
                            {
                                Toast.makeText(this,"エラーだよ！！",Toast.LENGTH_SHORT).show()
                            }
                    )*/

        }
        binging.closeButton.setOnClickListener {
            finish()
        }
    }



    private fun formatDate(date: ZonedDateTime): String {
        return "${"%04d".format(date.year)}-${"%02d".format(date.monthValue)}-${"%02d".format(date.dayOfMonth)}"
    }

    private fun formatTime(time: ZonedDateTime): String {
        return "${"%02d".format(time.hour)}-${"%02d".format(time.minute)}"

    }


}
