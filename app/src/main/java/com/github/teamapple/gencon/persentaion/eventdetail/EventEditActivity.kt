package com.github.teamapple.gencon.persentaion.eventdetail

import android.content.Context
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v4.graphics.drawable.DrawableCompat
import android.support.v7.app.AppCompatActivity
import com.github.teamapple.gencon.R
//import com.github.teamapple.gencon.databinding.ActivityEventDetailBinding
import com.github.teamapple.gencon.domain.model.EventModel
import com.github.teamapple.gencon.domain.model.PriorityModel
/*
class EventEditActivity : AppCompatActivity() {
    companion object {
        fun start(context: Context) {
            context.startActivity(Intent(context, EventEditActivity::class.java))
        }
    }

    private val binging: ActivityEventDetailBinding by lazy { DataBindingUtil.setContentView<ActivityEventDetailBinding>(this, R.layout.activity_task_detail) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setSupportActionBar(binging.toolBar)
        supportActionBar?.apply {
            setDisplayShowTitleEnabled(false)
            setDisplayHomeAsUpEnabled(true)
            val drawable = getDrawable(R.drawable.ic_close_black_24dp)
            DrawableCompat.setTint(drawable, ContextCompat.getColor(this@EventEditActivity, R.color.white))
            setHomeAsUpIndicator(drawable)
        }
        if (savedInstanceState != null) {
            val model = EventModel(
                    id = 512,
                    name = "プロ応用",
                    memo = "none",
                    startAt = "",
                    endAt = "",
                    priority = PriorityModel.Normal
            )
            /*supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, EventDetailFragment.newInstance(model))
                    .commit()*/
        }
        /*val now = ZonedDateTime.now()
        val date = formatDate(now)
        val time = formatTime(now)
        val apiClient = App.appComponent(this).apiclient()
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
                    binging.startDayText.text = "${"%04d".format(date.year)}-${"%02d".format(date.month)}-${"%02d".format(date.day)}"
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
                    binging.endDayText.text = "${"%04d".format(date.year)}-${"%02d".format(date.month)}-${"%02d".format(date.day)}"
                }
            })
            dialog.show(supportFragmentManager, "DatePickerDialogFragment")

        }

        binging.endTimeText.setOnClickListener {
            val dialog = TimePickerDialogFragment()
            dialog.setListener(object : TimePickerDialogFragment.Listener {
                override fun onTimeSelect(date: TimeModel) {
                    binging.endTimeText.text = "${"%02d".format(date.hour)}-${"%02d".format(date.minute)}"
                }
            })
            dialog.show(supportFragmentManager, "TimePickerDialogFragment")
        }

        binging.sendButton.setOnClickListener {
            val param = EventCreateParams(
                    title = binging.titleText.text.toString().let {
                        if (it.isEmpty()) "無題"
                        else it
                    },
                    startDate = binging.startDayText.text.toString(),
                    statTime = binging.startTimeText.text.toString(),
                    endDate = binging.endDayText.text.toString(),
                    endAt = binging.endTimeText.text.toString(),
                    priority = "normal",
                    memo = binging.memoEditText.text.toString())
            if (disposable.isDisposed) {
                disposable = apiClient.createEvent(param)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(
                                {
                                    Toast.makeText(this, "作成したよ", Toast.LENGTH_SHORT).show()
                                    finish()
                                },
                                {
                                    Timber.d(it)
                                    Toast.makeText(this, "エラーだよ！！", Toast.LENGTH_SHORT).show()
                                }
                        )

            }
            binging.closeButton.setOnClickListener {
                finish()
            }
        }*/
    }
}
*/
