package com.example.batmanfilms.view.activity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.batmanfilms.view.fragment.DetailFilmFragment

class DetailFilmActivity : SingleFragmentActivity() {


    companion object {

        // this function use DetailFilmActivity by Intent
        public fun newIntent(context: Context): Intent {
            return Intent(context, DetailFilmActivity::class.java)
        }
    }
    override fun createFragment(): Fragment? {
        return DetailFilmFragment.newInstance()
    }

}