package com.example.likebattle

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import java.util.prefs.AbstractPreferences

class MainActivity : AppCompatActivity() {

    var up: Int = 0
    var down: Int = 0
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sharedPreferences = getPreferences(Context.MODE_PRIVATE)

        Log.d("MainActivity", "onCreate")

        textViewThumbsUpCount.text = up.toString()
        textViewThumbsDownCount.text = down.toString()

        imageViewThumbsUp.setOnClickListener {
            up++
            textViewThumbsUpCount.text = up.toString()
        }
        imageViewThumbsDown.setOnClickListener {
            down++
            textViewThumbsDownCount.text = down.toString()
        }
    }

    override fun onStart() {
        Log.d("MainActivity","onStart")
        super.onStart()
    }

    override fun onResume() {
        Log.d("MainActivity","onResume")

        up = sharedPreferences.getInt(getString(R.string.up),0).toInt()
        down = sharedPreferences.getInt(getString(R.string.down),0).toInt()
        textViewThumbsUpCount.text = up.toString()
        textViewThumbsDownCount.text = down.toString()

        super.onResume()
    }

    override fun onPause() {
        Log.d("MainActivity","onPause")

        with (sharedPreferences.edit()) {
            putInt(getString(R.string.up), up)
            putInt(getString(R.string.down), down)
            apply()
        }

        super.onPause()
    }

    override fun onStop() {
        Log.d("MainActivity","onStop")
        super.onStop()
    }

    override fun onDestroy() {
        Log.d("MainActivity","onDestroy")
        super.onDestroy()
    }
}
