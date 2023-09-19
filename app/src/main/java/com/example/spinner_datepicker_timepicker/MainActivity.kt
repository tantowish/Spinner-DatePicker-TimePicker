        package com.example.spinner_datepicker_timepicker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.spinner_datepicker_timepicker.databinding.ActivityMainBinding

        class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var provinces: Array<String>
    private val countries = arrayOf(
        "Indonesia",
        "United States",
        "United Kingdom",
        "Germany",
        "France",
        "Australia",
        "Japan",
        "China",
        "Brazil",
        "Canada",
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        provinces = resources.getStringArray(R.array.provinces)

        with(binding){
            val adapterCountry = ArrayAdapter(this@MainActivity, com.google.android.material.R.layout.support_simple_spinner_dropdown_item, countries)
            adapterCountry.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinnerCountry.adapter= adapterCountry

            val adapterProvinces = ArrayAdapter(this@MainActivity, com.google.android.material.R.layout.support_simple_spinner_dropdown_item, provinces)
            adapterProvinces.setDropDownViewResource(android.R.layout.simple_expandable_list_item_1)
            spinnerProvince.adapter = adapterProvinces

            datePicker.init(datePicker.year, datePicker.month, datePicker.dayOfMonth){
                    _, year, monthOfYear, dayOfMonth ->
                val selectedDate = "$dayOfMonth/${monthOfYear + 1}/$year"
                Toast.makeText(this@MainActivity, selectedDate, Toast.LENGTH_SHORT).show()
            }

            timePicker.setOnTimeChangedListener{
                view, hourOfDay, minute ->
                val selectedTime = String.format("%02d%02d", hourOfDay,minute)
                Toast.makeText(this@MainActivity, selectedTime, Toast.LENGTH_SHORT).show()
            }
        }
    }
}