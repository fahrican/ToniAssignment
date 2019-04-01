package com.example.android.toniassignment

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.result_layout.*

class ResultActivity : AppCompatActivity() {

    private lateinit var resultTextView: TextView
    private lateinit var backButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.result_layout)

        resultTextView = result_text_view
        backButton = btn_back
        val mainActivityIntent = Intent(this, MainActivity::class.java)
        mainActivityIntent.putExtra("test", "test")
        mainActivityIntent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP

        val temp = intent.getStringExtra(MainActivity.RESULT_TEXT)
        resultTextView.text = "Ihr Ergebnis ${intent.getStringExtra(MainActivity.RESULT_TEXT)}"

        backButton.setOnClickListener {
            startActivity(mainActivityIntent)
        }
    }
}