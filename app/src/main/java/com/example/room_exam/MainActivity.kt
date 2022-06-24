package com.example.room_exam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import com.example.room_exam.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,"database-name"
        ).allowMainThreadQueries()
            .build()

        binding.result.text=db.todoDao().getAll().toString()

        binding.btn.setOnClickListener {
            db.todoDao().insert(Todo(binding.edit.text.toString()))
            binding.result.text = db.todoDao().getAll().toString()
        }
    }
}