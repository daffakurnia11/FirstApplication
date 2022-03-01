package me.daffakurnia.android.firstapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var textResult: TextView

    companion object {
        private const val RESULT = "result"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var editLength: EditText = findViewById(R.id.editLength)
        var editWidth: EditText = findViewById(R.id.editWidth)
        var editHeight: EditText = findViewById(R.id.editHeight)
        var btnCalculate: Button = findViewById(R.id.btnCalculate)
        textResult = findViewById(R.id.textResult)

        // Intent Activity Button
        var btnIntentActivity: Button = findViewById(R.id.btnIntentActivity)

        btnCalculate.setOnClickListener {
            val inputLength = editLength.text.toString().trim()
            val inputWidth = editWidth.text.toString().trim()
            val inputHeight = editHeight.text.toString().trim()

            var isEmptyState = false

            if (inputLength.isEmpty()) {
                isEmptyState = true
                editLength.error = "Length must not be empty!"
            }
            if (inputWidth.isEmpty()) {
                isEmptyState = true
                editWidth.error = "Width must not be empty!"
            }
            if (inputHeight.isEmpty()) {
                isEmptyState = true
                editHeight.error = "Height must not be empty!"
            }

            if (!isEmptyState) {
                val volume = inputLength.toDouble() * inputWidth.toDouble() * inputHeight.toDouble()
                textResult.text = volume.toString()
            }
        }

        if (savedInstanceState != null) {
            val result = savedInstanceState.getString(RESULT)
            textResult.text = result
        }

        // Intent Activity Button on Click
        btnIntentActivity.setOnClickListener {
            startActivity(Intent(this@MainActivity, IntentActivity::class.java))
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(RESULT, textResult.text.toString())
    }
}