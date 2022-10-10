package com.chacon.axel.laboratorio06

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import com.chacon.axel.laboratorio06.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    val PARAMETER_EXTRA_FULL_NAME = "fullname"
    val PARAMETER_EXTRA_EMAIL = "email"
    val PARAMETER_EXTRA_PHONE_NUMBER = "phoneNumber"
    val PARAMETER_EXTRA_OFFICE = "office"

    @SuppressLint("IntentReset")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val extras = this.intent.extras

        if (extras != null) {

            if (extras.get(PARAMETER_EXTRA_FULL_NAME) != null) {
                binding.fullName.text = extras.getString(PARAMETER_EXTRA_FULL_NAME)
            }

            if (extras.get(PARAMETER_EXTRA_EMAIL) != null ) {
                binding.email.text = extras.getString(PARAMETER_EXTRA_EMAIL)
            }

            if (extras.get(PARAMETER_EXTRA_PHONE_NUMBER) != null ) {
                binding.phoneNumber.text = extras.getString(PARAMETER_EXTRA_PHONE_NUMBER)
            }

            if (extras.get(PARAMETER_EXTRA_OFFICE) != null ) {
                binding.office.text = extras.getString(PARAMETER_EXTRA_OFFICE)
            }
        }

        binding.actWhatsapp.setOnClickListener{

            val fullName = binding.fullName.text.toString()
            val email = binding.email.text.toString()
            val phoneNumber = binding.phoneNumber.text.toString()
            val office = binding.office.text.toString()

            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            intent.setPackage("com.whatsapp")
            intent.putExtra(Intent.EXTRA_TEXT, "Nombre: $fullName, Correo: $email, Numero de telefono: $phoneNumber, Oficina: $office")

            if (intent.resolveActivity(packageManager) == null) {
                Toast.makeText(this,
                    "Instala WhatsApp primero!", Toast.LENGTH_SHORT).show()
            }

            startActivity(intent)
        }

        binding.actCall.setOnClickListener{

            val phoneNumber = binding.phoneNumber.text.toString()

            val intent = Intent(Intent.ACTION_DIAL)

            startActivity(intent.setData(Uri.parse("tel:" + phoneNumber)))

        }

        binding.actSms.setOnClickListener{

            val fullName = binding.fullName.text.toString()
            val email = binding.email.text.toString()
            val phoneNumber = binding.phoneNumber.text.toString()
            val office = binding.office.text.toString()

            val intent = Intent(Intent.ACTION_SENDTO)
            intent.data = Uri.parse("smsto: ")
            intent.putExtra(Intent.EXTRA_TEXT, "Nombre: $fullName, Correo: $email, Numero de telefono: $phoneNumber, Oficina: $office")
            startActivity(intent)

        }

        binding.actEmail.setOnClickListener{

            val fullName = binding.fullName.text.toString()
            val email = binding.email.text.toString()
            val phoneNumber = binding.phoneNumber.text.toString()
            val office = binding.office.text.toString()

            val intent = Intent(Intent.ACTION_SEND)
            intent.data = Uri.parse("mailto: ")
            intent.type = "text/plain"
            intent.putExtra(Intent.EXTRA_TEXT, "Nombre: $fullName, Correo: $email, Numero de telefono: $phoneNumber, Oficina: $office")
            startActivity(intent)

        }

    }
}