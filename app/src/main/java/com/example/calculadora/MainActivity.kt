package com.example.calculadora

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.calculadora.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonEntrar.setOnClickListener{
            val username = binding.editUsername.text.toString().trim()
            val password = binding.editPassword.text.toString().trim()

            if (username.equals("user") && password.equals("senha")) {
                Toast.makeText(applicationContext, "Login OK", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, MenuActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(applicationContext, "Login inválido", Toast.LENGTH_SHORT).show()
            }

            binding.editUsername.setText("")
            binding.editPassword.setText("")
        }
    }
}