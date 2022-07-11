package com.example.registro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.Toast
import com.example.registro.SharedPreferences.Companion.prefs
import com.example.registro.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initUI()
        checkUserValues()
    }

    fun initUI() {
        binding.btnRegister.setOnClickListener {
            accessSharedPreferences()
        }
    }

    fun checkUserValues() {
       if (prefs.getFullName().isNotEmpty()) {
            goAccess()
        }
    }

    fun accessSharedPreferences() {
        if (binding.etName.text.toString().isNotEmpty() &&
            binding.etUserName.text.toString().isNotEmpty() &&
            binding.etEmail.text.toString().isNotEmpty() &&
            binding.etPassword.text.toString().isNotEmpty() &&
            binding.etRePassword.text.toString().isNotEmpty()
        ) {
            prefs.saveFullName(binding.etName.text.toString())
            prefs.saveName(binding.etUserName.text.toString())
            prefs.saveEmail(binding.etEmail.text.toString())
            prefs.savePassword(binding.etPassword.text.toString())
            prefs.savePassword2(binding.etRePassword.text.toString())

            goAccess()
        } else {
            Toast.makeText(this, "Debe rellenar el nombre", Toast.LENGTH_SHORT).show()
        }
    }
    fun onRadioButtonClicked(view:View) {
        if (view is RadioButton) {
            val checked = view.isChecked
            when (view.getId()) {
                R.id.rbFemale ->
                    if (checked) {
                        prefs.saveGender("Female")
                    }
                R.id.rbMale ->
                    if (checked) {
                        prefs.saveGender("Male")
                    }
            }
        }
        goAccess()
    }
    private fun goAccess() {
       startActivity(Intent(this, RegisterActivity::class.java))
    }
}
