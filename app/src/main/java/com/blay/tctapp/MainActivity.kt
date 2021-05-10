package com.blay.tctapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.blay.tctapp.databinding.ActivityMainBinding
import com.blay.tctapp.fragments.MainFragment

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null

    // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        supportFragmentManager.beginTransaction()
            .replace(R.id.container, MainFragment())
            .commitNow()

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null

    }
}