package me.daffakurnia.android.firstapplication.intent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import me.daffakurnia.android.firstapplication.R

class ObjectActivity : AppCompatActivity() {

    companion object {
        const val PERSON_OBJECT = "person_object"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_object)

        val textObjectReceived: TextView = findViewById(R.id.textObjectReceived)
        val btnIntentActivity: Button = findViewById(R.id.btnIntentActivity)

        val personObject = intent.getParcelableExtra<PersonData>(PERSON_OBJECT) as PersonData
        val textRendered = """
            Name : ${personObject.name.toString()}
            Email : ${personObject.email.toString()}
            Age : ${personObject.age.toString()}
            City : ${personObject.city.toString()}
        """.trimIndent()
        textObjectReceived.text = textRendered

        btnIntentActivity.setOnClickListener {
            startActivity(Intent(this@ObjectActivity, IntentActivity::class.java))
        }
    }
}