package me.daffakurnia.android.firstapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts

class IntentActivity : AppCompatActivity() {

    private lateinit var textResultActivity: TextView

    private val resultLauncher: ActivityResultLauncher<Intent> = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == ResultActivity.RESULT_CODE && result.data != null) {
            val selectedValue =
                result.data?.getStringExtra(ResultActivity.SELECTED_VALUE)
            textResultActivity.text = "Result : $selectedValue"
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent)

        val btnMainActivity: Button = findViewById(R.id.btnMainActivity)
        val btnMoveData: Button = findViewById(R.id.btnMoveData)
        val btnMoveObject: Button = findViewById(R.id.btnMoveObject)
        val btnDialNumber: Button = findViewById(R.id.btnDialNumber)
        textResultActivity = findViewById(R.id.textResultActivity)
        val btnResultActivity: Button = findViewById(R.id.btnResultActivity)

        btnMainActivity.setOnClickListener {
            when (it.id) {
                R.id.btnMainActivity -> {
                    startActivity(Intent(this@IntentActivity, MainActivity::class.java))
                }
            }
        }

        // Move Data using Explicit Intent
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

        // Move Data using Explicit Intent with Parcelable
        btnMoveObject.setOnClickListener {
            when (it.id) {
                R.id.btnMoveObject -> {
                    val personData = PersonData(
                        "Daffa Kurnia Fatah",
                        22,
                        "daffakurniaf11@gmail.com",
                        "Sidoarjo"
                    )
                    val moveWithObject = Intent(this@IntentActivity, ObjectActivity::class.java)
                    moveWithObject.putExtra(ObjectActivity.PERSON_OBJECT, personData)
                    startActivity(moveWithObject)
                }
            }
        }

        // Dial Number using Implicit Intent
        btnDialNumber.setOnClickListener {
            when (it.id) {
                R.id.btnDialNumber -> {
                    val phoneNumber = "085163622012"
                    startActivity(Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber")))
                }
            }
        }

        // Move Data with ResultActivity
        btnResultActivity.setOnClickListener {
            when (it.id) {
                R.id.btnResultActivity -> {
                    val resultActivity = Intent(this@IntentActivity, ResultActivity::class.java)
                    resultLauncher.launch(resultActivity)
                }
            }
        }
    }
}