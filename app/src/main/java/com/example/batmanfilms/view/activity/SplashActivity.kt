package com.example.batmanfilms.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.batmanfilms.R
import com.example.batmanfilms.databinding.ActivitySplashBinding
import com.example.batmanfilms.viewmodel.BatmanViewModel
import com.example.batmanfilms.viewmodel.SplashViewModel

class SplashActivity : AppCompatActivity() {

    private lateinit var binding : ActivitySplashBinding

    //define viewModel by lazy
    private val splashVM: SplashViewModel by lazy {
        ViewModelProvider(this).get(SplashViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_splash)

        //play splash
        binding.splashJoyApp.playAnimation()


        //fetch list of batman films
        splashVM.fetchGetBatmanFilms()


        //set observers
        setObservers()

    }

    //this function listens to observables
    private fun setObservers() {

        //if result equals "true", batman activity will start
        splashVM.result.observe(this, Observer {
            if (it){
                val intent = BatmanMainActivity.newIntent(this)
                startActivity(intent)
            }


        })
    }
}