package me.daffakurnia.android.firstapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Bar Volume Button
        val btnBarVolume: Button = findViewById(R.id.btnBarVolume)

        btnBarVolume.setOnClickListener {
            startActivity(Intent(this@MainActivity, BarVolumeActivity::class.java))
        }

        // Intent Activity Button
        val btnIntentActivity: Button = findViewById(R.id.btnIntentActivity)

        // Intent Activity Button on Click
        btnIntentActivity.setOnClickListener {
            startActivity(Intent(this@MainActivity, IntentActivity::class.java))
        }
    }
}