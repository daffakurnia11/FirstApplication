package me.daffakurnia.android.firstapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var editLength: EditText = findViewById(R.id.editLength)
        var editWidth: EditText = findViewById(R.id.editWidth)
        var editHeight: EditText = findViewById(R.id.editHeight)
        var btnCalculate: Button = findViewById(R.id.btnCalculate)
        var textResult: TextView = findViewById(R.id.textResult)

        btnCalculate.setOnClickListener {
            if (it.id == R.id.btnCalculate) {
                val inputLength = editLength.text.toString().trim()
                val inputWidth = editWidth.text.toString().trim()
                val inputHeight = editHeight.text.toString().trim()

                val volume = inputLength.toDouble() * inputWidth.toDouble() * inputHeight.toDouble()
                textResult.text = volume.toString()
            }
        }
    }
}