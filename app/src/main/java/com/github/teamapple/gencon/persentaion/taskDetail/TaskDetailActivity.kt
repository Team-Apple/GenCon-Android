package com.github.teamapple.gencon.persentaion.taskDetail

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.github.teamapple.gencon.R
import com.github.teamapple.gencon.databinding.ActivityTaskDetailBinding


class TaskDetailActivity : AppCompatActivity() {

    val binding: ActivityTaskDetailBinding by lazy {
        DataBindingUtil.setContentView<ActivityTaskDetailBinding>(this, R.layout.activity_task_detail)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setSupportActionBar(binding.toolbar)
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowTitleEnabled(false)
        }
        /*
        binding.startDateEditText.setOnClickListener {
            val now = LocalDateTime.now()
            DatePickerDialog(this, DatePickerDialog.OnDateSetListener { _, year, month, day ->
                binding.startDateEditText.setText(DateFormatter.format(year, month + 1, day))
            }, now.year, now.monthValue, now.dayOfMonth).show()
        }
        binding.startTimeEditText.setOnClickListener {
            val now = LocalTime.now()
            TimePickerDialog(this, TimePickerDialog.OnTimeSetListener { _, hour, minute ->
                binding.startTimeEditText.setText(TimeFormatter.format(hour, minute))
            }, now.hour, now.hour, true).show()
        }
        binding.endDateEditText.setOnClickListener {
            val now = LocalDateTime.now()
            DatePickerDialog(this, DatePickerDialog.OnDateSetListener { _, year, month, day ->
                binding.endDateEditText.setText(DateFormatter.format(year, month + 1, day))
            }, now.year, now.monthValue, now.dayOfMonth).show()
        }
        binding.endTimeEditText.setOnClickListener {
            val now = LocalTime.now()
            TimePickerDialog(this, TimePickerDialog.OnTimeSetListener { _, hour, minute ->
                binding.endTimeEditText.setText(TimeFormatter.format(hour, minute))
            }, now.hour, now.hour, true).show()
        }*/
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

    }
}
