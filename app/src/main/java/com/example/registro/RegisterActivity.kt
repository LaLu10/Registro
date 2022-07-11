package com.example.registro

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.example.registro.SharedPreferences.Companion.prefs
import com.example.registro.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initUI()
    }
        @SuppressLint("SetTextI18n")
        fun initUI(){
            binding.btnVolver.setOnClickListener {
                prefs.wipeData()
                onBackPressed()
            }
            val fullname = prefs.getFullName()
            val name = prefs.getName()
            val email = prefs.getEmail()
            val password = prefs.getPassword()
            val genero= prefs.getGender()
            binding.tvDatos.text = "Los datos de su registro son los siguientes:\n" +
                    "FullName: $fullname\n" +
                    "UserName: $name\n" +
                    "Email: $email\n" +
                    "Password: $password\n" +
                    "Género: $genero"

        }
    }
