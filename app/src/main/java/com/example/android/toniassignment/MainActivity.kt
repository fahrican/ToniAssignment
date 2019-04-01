package com.example.android.toniassignment

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.ArrayAdapter


class MainActivity : AppCompatActivity() {

    private lateinit var headline: TextView
    private lateinit var userInput: EditText
    private lateinit var spinner: Spinner
    private lateinit var addButton: Button
    private lateinit var subtractButton: Button

    companion object {
        val RESULT_TEXT by lazy { "RESULT" }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        headline = text_headline
        userInput = user_input
        addButton = btn_addieren
        subtractButton = btn_subtrahieren
        spinner = auswahlfeld
        var intent = Intent(this, ResultActivity::class.java)

        val numbers: Array<Int> = arrayOf(10, 100, 1000)
        val adapter = ArrayAdapter<Int>(
            this,
            android.R.layout.simple_spinner_item, numbers
        )
        spinner.adapter = adapter

        var test = ""

        addButton.setOnClickListener {
            test = userInput.text.toString()
            View.OnClickListener { Log.v("Mainactivity", "user input: ${test}") }
            headline.text = (test.toInt() + (spinner.selectedItem as Int)).toString()
            val resultText: String = (test.toInt() + (spinner.selectedItem as Int)).toString()
            intent.putExtra(MainActivity.RESULT_TEXT, resultText)
            startActivity(intent)
        }

        subtractButton.setOnClickListener {
            test = userInput.text.toString()
            View.OnClickListener { Log.v("Mainactivity", "user input: ${test}") }
            headline.text = (test.toInt() - (spinner.selectedItem as Int)).toString()
            val resultText: String = (test.toInt() - (spinner.selectedItem as Int)).toString()
            intent.putExtra(MainActivity.RESULT_TEXT, resultText)
            startActivity(intent)
        }
    }
}
