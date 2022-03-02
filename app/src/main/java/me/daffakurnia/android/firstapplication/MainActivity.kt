package me.daffakurnia.android.firstapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import me.daffakurnia.android.firstapplication.barvolume.BarVolumeActivity
import me.daffakurnia.android.firstapplication.fragment.FragmentActivity
import me.daffakurnia.android.firstapplication.intent.IntentActivity

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

        // Fragment in Activity Button
        val btnFlexibleFragment: Button = findViewById(R.id.btnFlexibleFragment)

        btnFlexibleFragment.setOnClickListener {
            startActivity(Intent(this@MainActivity, FragmentActivity::class.java))
        }
    }
}