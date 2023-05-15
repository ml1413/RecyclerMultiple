package com.ooommm.recyclermultiple

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var cv_delete: CardView
    private var listHuman: MutableList<Human> = mutableListOf(
        Human("name1", "last Name 1"),
        Human("name2", "last Name 2"),
        Human("name3", "last Name 3"),
        Human("name4", "last Name 4"),
        Human("name5", "last Name 5"),
        Human("name6", "last Name 6"),
        Human("name7", "last Name 7"),
        Human("name8", "last Name 8"),
        Human("name9", "last Name 9"),
        Human("name10", "last Name 10"),
    )
    private lateinit var recyclerHumanAdapter: RecyclerHumanAdapter
    private lateinit var recycler: RecyclerView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        cv_delete = findViewById(R.id.cv_delete)
        recyclerHumanAdapter = RecyclerHumanAdapter(this, cv_delete)

        recyclerHumanAdapter.humanList = listHuman
        recycler = findViewById(R.id.rv_Main)
        recycler.adapter = recyclerHumanAdapter

        cv_delete.setOnClickListener {
            listHuman.removeAll(recyclerHumanAdapter.humanDeleteList)
            recyclerHumanAdapter.humanList = listHuman
            cv_delete.visibility = View.GONE
        }

    }
}