package com.example.batmanfilms.view.activity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.batmanfilms.view.fragment.DetailFilmFragment

class DetailFilmActivity : SingleFragmentActivity() {


    companion object {
        private const val EXTRA_IMDB_ID = "com.example.joyapp.imdbId"


        // this function use DetailFilmActivity by Intent
        public fun newIntent(context: Context, imdbID : String): Intent {
            val intent = Intent(context, DetailFilmActivity::class.java)
            intent.putExtra(EXTRA_IMDB_ID,imdbID)
            return intent
        }
    }
    override fun createFragment(): Fragment? {
        val imdbId = intent.getStringExtra(EXTRA_IMDB_ID)
        return DetailFilmFragment.newInstance(imdbId)
    }

}