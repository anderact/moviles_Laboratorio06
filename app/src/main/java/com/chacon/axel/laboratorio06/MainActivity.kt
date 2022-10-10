package com.chacon.axel.laboratorio06

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.chacon.axel.laboratorio06.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    val PARAMETER_EXTRA_FULL_NAME = "fullname"
    val PARAMETER_EXTRA_EMAIL = "email"
    val PARAMETER_EXTRA_PHONE_NUMBER = "phoneNumber"
    val PARAMETER_EXTRA_OFFICE = "office"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSaveExplicit.setOnClickListener{

            val fullName = binding.fullNameInput.text.toString()
            val email = binding.emailInput.text.toString()
            val phoneNumber = binding.phoneNumberInput.text.toString()
            val office = binding.officeInput.text.toString()

            if (fullName == "" || email == "" || phoneNumber == "" || office == ""){
                Toast.makeText(this, "Completa todos los cuadros! ><", Toast.LENGTH_SHORT).show()
            }else{
                val intent = Intent(this, DetailActivity::class.java)

                intent.putExtra(PARAMETER_EXTRA_FULL_NAME, fullName)
                intent.putExtra(PARAMETER_EXTRA_EMAIL, email)
                intent.putExtra(PARAMETER_EXTRA_PHONE_NUMBER, phoneNumber)
                intent.putExtra(PARAMETER_EXTRA_OFFICE, office)

                startActivity(intent)
            }
        }
    }
}