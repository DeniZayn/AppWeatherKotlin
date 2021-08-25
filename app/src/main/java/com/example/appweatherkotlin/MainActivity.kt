package com.example.appweatherkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.MenuItem
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*
import kotlin.text.contains as contains1

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: WeatherAdapter
    private lateinit var counter: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Repository.weatherList
        test()
        LikeObject()
        supportActionBar?.title = (getFullName(packageName, getString(R.string.app_name)))

        initAdapter()
        counter = findViewById(R.id.textView)

        addFilter()


        counter.setOnClickListener {
            Toast.makeText(this@MainActivity, "Test", Toast.LENGTH_LONG).show()
        }
    }

    private fun addFilter() {
        findViewById<EditText>(R.id.textView).addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(p0: CharSequence, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(p0: Editable) {
                applyFilter(p0.toString())
            }
        }


        )
    }

    private fun applyFilter (p0:String) {

        val filteredWeatherList: MutableList<Weather> = mutableListOf()
        for (weather in Repository.weatherList){
            if (weather.town.lowercase(Locale.getDefault()).contains1(p0.lowercase(Locale.getDefault()))){
                filteredWeatherList.add(weather)
            }
        }
        adapter.weatherList = filteredWeatherList
        setCounter(filteredWeatherList.size)
    }

    private fun initAdapter() {
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        adapter.weatherList
        adapter = WeatherAdapter()
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
        adapter.weatherList = Repository.weatherList
        setCounter(adapter.weatherList.size)
    }
    private fun setCounter(count: Int){
        if (count == 0) {
            counter.text = "No cities"}
        else {
            counter.text = String.format("City: %d", count)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if (item.itemId == android.R.id.home) {
            onBackPressed()
            true
        } else {
            super.onOptionsItemSelected(item)
        }
    }


    class LikeObject : Any() {
    }

    fun test(text: String = "Test text"): Unit {

        print(text)
    }

}







