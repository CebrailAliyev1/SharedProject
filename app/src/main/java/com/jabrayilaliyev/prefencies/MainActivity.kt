package com.jabrayilaliyev.prefencies

import android.app.Activity
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jabrayilaliyev.prefencies.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
lateinit var binding :ActivityMainBinding
lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

 sharedPreferences=getSharedPreferences("Person", MODE_PRIVATE)
       setupclickListener()
       getData()
    }


fun setupclickListener(){
    binding.button.setOnClickListener{
        save()
    }



}
    fun save(){
val personName=binding.etPersonName.text.toString()
sharedPreferences.edit().putString("PersonName",personName).apply()
    }

    fun getData(){
        val saveData=sharedPreferences.getString("PersonName","")
        binding.etPersonName.setText(saveData)
    }


}
