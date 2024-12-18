package com.mobileapps

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.mobileapps.lesson2.R
import com.mobileapps.lesson2.databinding.ActivityFragmentBinding

open class FragmentActivityExample : AppCompatActivity() {

    lateinit var binding : ActivityFragmentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFragmentBinding.inflate(layoutInflater)
        setContentView(binding.root)



        if (savedInstanceState==null)
        {
            replaceFragment((FragmentA()))
            binding.button.text = "Switch to Fragment B"
        }

        binding.button.setOnClickListener {
                val currentFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainer)
                if (currentFragment is FragmentA)
                {
                    replaceFragment(FragmentB())
                    binding.button.text = "Switch to Fragment A"

                } else
                {
                    replaceFragment(FragmentA())
                    binding.button.text = "Switch to Fragment B"
                }

        }

    }

    private fun replaceFragment (fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainer,fragment)
        fragmentTransaction.commit()
    }
}