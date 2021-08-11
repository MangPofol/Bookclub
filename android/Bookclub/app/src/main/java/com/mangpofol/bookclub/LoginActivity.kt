package com.mangpofol.bookclub

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mangpofol.bookclub.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)

        binding.logoButton.setOnClickListener {
            goMainActivity()
        }

        setContentView(binding.root)
    }

    private fun goMainActivity() {
        var intent: Intent = Intent(this@LoginActivity, MainActivity::class.java)
        startActivity(intent)
    }
}