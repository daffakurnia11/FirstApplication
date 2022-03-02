package me.daffakurnia.android.firstapplication.layouts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import me.daffakurnia.android.firstapplication.MainActivity
import me.daffakurnia.android.firstapplication.R

class LayoutsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_layouts)

        val btnBackMain: Button = findViewById(R.id.btnBackMain)
        btnBackMain.setOnClickListener {
            startActivity(Intent(this@LayoutsActivity, MainActivity::class.java))
        }
    }
}