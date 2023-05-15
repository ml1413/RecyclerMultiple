package com.ooommm.recyclermultiple

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private var listHuman: MutableList<Human> = mutableListOf(
        Human("Oleg", "Olegov"),
        Human("Ivan", "Ivanov"),
        Human("Petr", "Petrov"),
        Human("Saimon", "Soy"),
        Human("Jet", "Jecit"),
    )
    private val recyclerHumanAdapter = RecyclerHumanAdapter()
    private lateinit var recycler: RecyclerView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerHumanAdapter.humanList = listHuman
        recycler = findViewById(R.id.rv_Main)
//        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = recyclerHumanAdapter

    }

}