package me.daffakurnia.android.firstapplication.intent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioGroup
import me.daffakurnia.android.firstapplication.R

class ResultActivity : AppCompatActivity() {

    private lateinit var btnChoosePackage: Button
    private lateinit var packageGroup: RadioGroup

    companion object {
        const val SELECTED_VALUE = "selected_value"
        const val RESULT_CODE = 110
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        btnChoosePackage = findViewById(R.id.btnChoosePackage)
        packageGroup = findViewById(R.id.packageGroup)

        btnChoosePackage.setOnClickListener {
            if (packageGroup.checkedRadioButtonId > 0) {
                var packageName = ""
                when (packageGroup.checkedRadioButtonId) {
                    R.id.packageOne -> packageName = "Personal Branding"

                    R.id.packageTwo -> packageName = "Business Package"

                    R.id.packageThree -> packageName = "Enterprise Package"

                    R.id.packageFour -> packageName = "EduSmart Package"
                }

                var resultIntent = Intent()
                resultIntent.putExtra(SELECTED_VALUE, packageName)
                setResult(RESULT_CODE, resultIntent)
                finish()
            }
        }
    }
}