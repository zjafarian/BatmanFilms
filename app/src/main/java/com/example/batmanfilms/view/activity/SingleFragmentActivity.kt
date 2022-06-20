package com.example.batmanfilms.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.batmanfilms.R
import com.example.batmanfilms.databinding.ActivitySingleFragmentBinding

abstract class SingleFragmentActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySingleFragmentBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_single_fragment)

        val fragmentManager = supportFragmentManager
        val fragment = fragmentManager.findFragmentById(R.id.fragment_container)

        //check fragment is null or not
        if (fragment == null) {

            //if fragment is null add fragment by fragmentManager and beginTransaction
            createFragment()?.let {
                fragmentManager
                    .beginTransaction()
                    .add(R.id.fragment_container, it, FRAGMENT_TAG)
                    .commit()
            }

        } else {
            //if fragment isn't null, replace new fragment instead old fragment by fragmentManager and beginTransaction
            createFragment()?.let {
                fragmentManager
                    .beginTransaction()
                    .replace(R.id.fragment_container, it, FRAGMENT_TAG)
                    .commit()
            }

        }

    }


    abstract fun createFragment(): Fragment?

    companion object {
        const val FRAGMENT_TAG = "FragmentActivity"
    }
}