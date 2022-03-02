package me.daffakurnia.android.firstapplication.intent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import me.daffakurnia.android.firstapplication.R

class DataActivity : AppCompatActivity() {

    companion object {
        const val FULL_NAME = "full_name"
        const val AGE = "age"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data)

        val textDataReceived: TextView = findViewById(R.id.textDataReceived)
        val btnIntentActivity: Button = findViewById(R.id.btnIntentActivity)

        val fullName = intent.getStringExtra(FULL_NAME)
        val age = intent.getIntExtra(AGE, 0)

        val textRendered = "Hello, $fullName. You are $age years old."
        textDataReceived.text = textRendered

        btnIntentActivity.setOnClickListener {
            startActivity(Intent(this@DataActivity, IntentActivity::class.java))
        }
    }
}