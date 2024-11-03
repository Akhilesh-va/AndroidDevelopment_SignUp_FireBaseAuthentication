package com.example.signupusingfirebase

import User
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {

    lateinit var database : DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val btnSignUp = findViewById<AppCompatButton>(R.id.btnSignUp)
        val etName=findViewById<AppCompatEditText>(R.id.etName)
        val etEmail=findViewById<AppCompatEditText>(R.id.etMail)
        val etUserName=findViewById<AppCompatEditText>(R.id.etUserName)
        val etPassword=findViewById<AppCompatEditText>(R.id.etPassword)
        btnSignUp.setOnClickListener{
            val name = etName.text.toString()
            val email = etEmail.text.toString()
            val userName = etUserName.text.toString()
            val password = etPassword.text.toString()
            val user = User(name, email, userName, password)
            etName.text?.clear()
            etEmail.text?.clear()
            etPassword.text?.clear()
            etUserName.text?.clear()
            database= FirebaseDatabase.getInstance().getReference("Users")
            database.child(name).setValue(user).addOnSuccessListener {
                Toast.makeText(this,"User Registered", Toast.LENGTH_SHORT).show()
            }.addOnFailureListener {
                Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show()
            }

        }

    }
}