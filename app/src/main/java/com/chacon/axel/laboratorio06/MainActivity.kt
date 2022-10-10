package com.chacon.axel.laboratorio06

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.chacon.axel.laboratorio06.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    val PARAMETER_EXTRA_CODE = "code"
    val PARAMETER_EXTRA_FULL_NAME = "fullname"
    val PARAMETER_EXTRA_AMOUNT = "amount"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnExplicit.setOnClickListener{
            val fullName = binding.fullnameInput.text.toString()
            val code = binding.codeInput.text.toString()
            val amount = binding.amountInput.text.toString()

            if (fullName == "" || code == "" || amount == ""){
                Toast.makeText(this, "Completa todos los cuadros! ><", Toast.LENGTH_SHORT).show()
            }else{
                val intent = Intent(this, DetailActivity::class.java)
                intent.putExtra(PARAMETER_EXTRA_CODE, code)
                intent.putExtra(PARAMETER_EXTRA_FULL_NAME, fullName)
                intent.putExtra(PARAMETER_EXTRA_AMOUNT, amount)

                startActivity(intent)
            }
        }

        binding.btnImplicit.setOnClickListener {
            val fullName = binding.fullnameInput.text.toString()
            val code = binding.codeInput.text.toString()
            val amount = binding.amountInput.text.toString()

            if (fullName == "" || code == "" || amount == ""){
                Toast.makeText(this, "Completa todos los cuadros! ><", Toast.LENGTH_SHORT).show()
            }else{
                val intent = Intent(Intent.ACTION_SEND)
                intent.putExtra(Intent.EXTRA_TEXT, "Code: $code, Fullname: $fullName, Amount: $amount")
                intent.type = "text/plain"
                startActivity(intent)
            }
        }
    }
}