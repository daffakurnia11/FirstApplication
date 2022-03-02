package me.daffakurnia.android.firstapplication.fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import me.daffakurnia.android.firstapplication.fragment.HomeFragment
import me.daffakurnia.android.firstapplication.R

class FragmentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)

        /*
            FragmentTransaction is a function to perform operations on fragments such as
            add(), replace(), commit(), etc
         */

        val mFragmentManager = supportFragmentManager
        val mHomeFragment = HomeFragment()
        val fragment = mFragmentManager.findFragmentByTag(HomeFragment::class.java.simpleName)

        if (fragment !is HomeFragment) {
            Log.d("MyFelxibleFragment", "Fragment Name : " + HomeFragment::class.java.simpleName)
            mFragmentManager
                .beginTransaction() // Start the changes
                // add() is used to add an fragment object to the container layout
                .add(R.id.frameContainer, mHomeFragment, HomeFragment::class.java.simpleName)
                .commit()
        }
    }
}