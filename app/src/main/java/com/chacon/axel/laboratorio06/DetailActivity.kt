package com.chacon.axel.laboratorio06

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.chacon.axel.laboratorio06.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    val PARAMETER_EXTRA_CODE = "code"
    val PARAMETER_EXTRA_FULL_NAME = "fullname"
    val PARAMETER_EXTRA_AMOUNT = "amount"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val extras = this.intent.extras

        if (extras != null) {
            if (extras.get(PARAMETER_EXTRA_CODE) != null) {
                binding.codeText.text = extras.getString(PARAMETER_EXTRA_CODE)
            }

            if (extras.get(PARAMETER_EXTRA_FULL_NAME) != null ) {
                binding.fullnameText.text = extras.getString(PARAMETER_EXTRA_FULL_NAME)
            }

            if (extras.get(PARAMETER_EXTRA_AMOUNT) != null ) {
                binding.amountText.text = extras.getString(PARAMETER_EXTRA_AMOUNT)
            }
        }
    }
}