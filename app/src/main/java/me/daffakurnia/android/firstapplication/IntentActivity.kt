package me.daffakurnia.android.firstapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class IntentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent)

        var btnMainActivity: Button = findViewById(R.id.btnMainActivity)

        btnMainActivity.setOnClickListener {
            when (it.id) {
                R.id.btnMainActivity -> {
                    startActivity(Intent(this@IntentActivity, MainActivity::class.java))
                }
            }
        }
    }
}