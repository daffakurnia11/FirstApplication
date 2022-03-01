package me.daffakurnia.android.firstapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class IntentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent)

        val btnMainActivity: Button = findViewById(R.id.btnMainActivity)
        val btnMoveData: Button = findViewById(R.id.btnMoveData)


        btnMainActivity.setOnClickListener {
            when (it.id) {
                R.id.btnMainActivity -> {
                    startActivity(Intent(this@IntentActivity, MainActivity::class.java))
                }
            }
        }

        btnMoveData.setOnClickListener {
            when (it.id) {
                R.id.btnMoveData -> {
                    val moveWithData = Intent(this@IntentActivity, DataActivity::class.java)
                    moveWithData.putExtra(DataActivity.FULL_NAME, "Daffa Kurnia Fatah")
                    moveWithData.putExtra(DataActivity.AGE, 21)
                    startActivity(moveWithData)
                }
            }
        }
    }
}