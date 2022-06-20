package com.example.batmanfilms.view.activity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.batmanfilms.R
import com.example.batmanfilms.view.fragment.BatmanFragment

class BatmanMainActivity : SingleFragmentActivity() {

    companion object {

        // this function use BatmanMainActivity by Intent
        public fun newIntent(context: Context): Intent {
            return Intent(context, BatmanMainActivity::class.java)
        }
    }


    override fun createFragment(): Fragment? {
       return BatmanFragment.newInstance()
    }
}