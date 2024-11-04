package com.example.signupusingfirebase

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class WelcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_welcome)

           val name = intent.getStringExtra(LoginActivity.KEY1)
        val email = intent.getStringExtra(LoginActivity.KEY2)
        val userName = intent.getStringExtra(LoginActivity.KEY3)
        val WelcomeText = findViewById<TextView>(R.id.tvWelcome)
        val tvDatabaseText = findViewById<TextView>(R.id.tvDatabaseText)
        val btnEmail = findViewById<Button>(R.id.btnEmail)
        val btnUserName = findViewById<Button>(R.id.btnUserName)
        WelcomeText.setText("Welcome $name")
        btnEmail.setText("Email : $email")
        btnUserName.setText("UserName : $userName")

    }
}