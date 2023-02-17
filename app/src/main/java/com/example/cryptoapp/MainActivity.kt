package com.example.cryptoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

import androidx.lifecycle.ViewModelProvider

import com.example.cryptoapp.api.ListCryptoRepository
import com.example.cryptoapp.databinding.ActivityMainBinding
import com.example.cryptoapp.framework.ScreenSlidePagerAdapter

class MainActivity : AppCompatActivity() {
    lateinit var mBinding: ActivityMainBinding
    lateinit var mModel: CryptoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        mModel = ViewModelProvider(
            this,
            CryptoViewModelFactory(ListCryptoRepository())
        )[CryptoViewModel::class.java]
        setAdapterFragment()
        catchErrorMessege()

    }


    fun setAdapterFragment() {

        val lAdapter = ScreenSlidePagerAdapter(supportFragmentManager, lifecycle)
        lAdapter.addFragment(ListCryptFragment())
        mBinding.viewPagerMain.adapter = lAdapter

    }

    fun catchErrorMessege(){
        mModel.mResponse.observe(this){
            Toast.makeText(this, it.toString(), Toast.LENGTH_LONG).show()
        }
    }

}