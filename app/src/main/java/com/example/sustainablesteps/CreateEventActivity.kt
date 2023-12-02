package com.example.sustainablesteps

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.sustainablesteps.databinding.ActivityCreateEventBinding
import com.example.sustainablesteps.databinding.ActivityUpcomingEventsBinding
import com.google.firebase.database.core.view.View

class CreateEventActivity : AppCompatActivity() {
    private  val binding: ActivityCreateEventBinding by lazy {
        ActivityCreateEventBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        ArrayAdapter.createFromResource(
            this,
            R.array.event_types,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            binding.eventTypeSpinner.adapter = adapter
        }

        binding.datePickButton.setOnClickListener {
            openDatePicker()
        }

        binding.timePickButton.setOnClickListener{
            openTimePicker()
        }

    }

    private fun openTimePicker() {
        val timePickerDialog = TimePickerDialog(
            this,
            TimePickerDialog.OnTimeSetListener { _, hour, minute ->
                // Showing the picked value in the textView
                binding.showTime.text = "$hour:$minute"
            },
            15,
            30,
            false
        )

        timePickerDialog.show()
    }

    private fun openDatePicker() {
        val datePickerDialog = DatePickerDialog(
            this,
            null,
            2023,
            0,
            20
        )

        datePickerDialog.setOnDateSetListener { _, year, month, day ->
            // Showing the picked value in the textView
            binding.showDate.text = "$year.${month + 1}.$day"
        }

        datePickerDialog.show()
    }
}