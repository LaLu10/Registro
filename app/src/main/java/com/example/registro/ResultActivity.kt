package com.example.registro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.registro.databinding.ActivityMainBinding
import com.example.registro.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.ivBack.setOnClickListener {
            onBackPressed()
        }
    }
}