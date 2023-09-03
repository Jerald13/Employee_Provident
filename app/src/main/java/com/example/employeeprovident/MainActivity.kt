package com.example.employeeprovident

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.employeeprovident.databinding.ActivityMainBinding
import java.util.Calendar

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var age = 0
    private val TRASFERABLE = 0.3

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

            val datePicker = binding.datePicker1
        val birth = Calendar.getInstance()
        val currentDate = Calendar.getInstance()
        datePicker.init(birth.get(Calendar.YEAR), birth.get(Calendar.MONTH),
            birth.get(Calendar.DAY_OF_MONTH)

        ) { view, year, month, day ->

            val selectedDate = Calendar.getInstance()
            selectedDate.set(year, month, day)

             age = calculateAge(selectedDate, currentDate)

            val month = month + 1
            val msg = "You Selected: $day/$month/$year\nYour Age: $age years"
        }

        binding.button.setOnClickListener{
            binding.age.text = age.toString()
            var result = calculateAllowInvest()
            binding.result.text = result.toString()
        }

    }
    fun calculateAge(birthdate: Calendar, currentDate: Calendar): Int {
        var age = currentDate.get(Calendar.YEAR) - birthdate.get(Calendar.YEAR)
        if (currentDate.get(Calendar.DAY_OF_YEAR) < birthdate.get(Calendar.DAY_OF_YEAR)) {
            age--
        }
        return age
    }

    fun calculateAllowInvest():Double{
        var total =0.0
        if(age in 16..20){
            total = 5000 * TRASFERABLE
        }else if(age in 21 .. 25){
            total = 14000 * TRASFERABLE
        }else if(age in 26 .. 30){
            total = 29000 * TRASFERABLE
        }else if(age in 31 .. 35){
            total = 50000 * TRASFERABLE
        }else if(age in 36 .. 40){
            total = 78000 * TRASFERABLE
        }else if(age in 41 .. 45){
            total = 116000 * TRASFERABLE
        }else if(age in 46 .. 50){
            total = 165000 * TRASFERABLE
        }else if(age in 51 .. 55){
            total = 228000 * TRASFERABLE
        }
        else{
            total = 0.0
        }
        return total
    }
}