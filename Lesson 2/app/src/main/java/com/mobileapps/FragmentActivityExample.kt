package com.mobileapps.lesson2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.mobileapps.lesson2.databinding.ActivityFragmentBinding

class FragmentActivityExample : AppCompatActivity() {

    lateinit var binding : ActivityFragmentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFragmentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState==null)
        {
            replaceFragment((FragmentA()))
        }

        binding.button.setOnClickListener {
                val currentFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainer)
                if (currentFragment is FragmentA)
                {
                    replaceFragment(FragmentB())
                } else
                {
                    replaceFragment(FragmentA())
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