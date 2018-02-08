package com.github.teamapple.gencon.persentaion.taskDetail

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.github.teamapple.gencon.R
import com.github.teamapple.gencon.data.api.GenConApiClient
import com.github.teamapple.gencon.data.api.params.TaskParams
import com.github.teamapple.gencon.databinding.ActivityTaskDetailBinding
import com.github.teamapple.gencon.util.DateFormatter
import com.github.teamapple.gencon.util.TimeFormatter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposables
import org.threeten.bp.LocalDateTime
import org.threeten.bp.LocalTime
import timber.log.Timber
import javax.inject.Inject


class TaskDetailActivity : AppCompatActivity() {

    val binding: ActivityTaskDetailBinding by lazy {
        DataBindingUtil.setContentView<ActivityTaskDetailBinding>(this, R.layout.activity_task_detail)
    }

    @Inject
    lateinit var apiClient: GenConApiClient
    var disposable = Disposables.disposed()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setSupportActionBar(binding.toolbar)
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowTitleEnabled(false)
        }

        binding.startDate.setOnClickListener {
            val now = LocalDateTime.now()
            DatePickerDialog(this, DatePickerDialog.OnDateSetListener { _, year, month, day ->
                binding.startDate.setText(DateFormatter.format(year, month + 1, day))
            }, now.year, now.monthValue, now.dayOfMonth).show()
        }
        binding.startTime.setOnClickListener {
            val now = LocalTime.now()
            TimePickerDialog(this, TimePickerDialog.OnTimeSetListener { _, hour, minute ->
                binding.startTime.setText(TimeFormatter.format(hour, minute))
            }, now.hour, now.hour, true).show()
        }
        binding.deadlineDate.setOnClickListener {
            val now = LocalDateTime.now()
            DatePickerDialog(this, DatePickerDialog.OnDateSetListener { _, year, month, day ->
                binding.deadlineDate.setText(DateFormatter.format(year, month + 1, day))
            }, now.year, now.monthValue, now.dayOfMonth).show()
        }
        binding.deadlineTime.setOnClickListener {
            val now = LocalTime.now()
            TimePickerDialog(this, TimePickerDialog.OnTimeSetListener { _, hour, minute ->
                binding.deadlineTime.setText(TimeFormatter.format(hour, minute))
            }, now.hour, now.hour, true).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_task_detail, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_item_task_submit -> {
                submit()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }

    }

    private fun submit() {
        val params = TaskParams.CreateParams(
                title = binding.titleText.text.toString(),
                memo = binding.memoEditText.text.toString(),
                startFromDate = binding.startDate.text.toString(),
                startFromTime = binding.startTime.text.toString(),
                deadlineDate = binding.deadlineDate.text.toString(),
                deadlineTime = binding.deadlineTime.text.toString(),
                priority = "normal"
        );

        if (disposable.isDisposed) {
            disposable = apiClient.createTask(params)
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(
                            {
                                finish()
                            },
                            {
                                Timber.e(it)
                            })
        }
    }
}
