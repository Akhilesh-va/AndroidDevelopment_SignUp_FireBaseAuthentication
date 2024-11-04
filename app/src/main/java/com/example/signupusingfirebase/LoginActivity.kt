package com.example.signupusingfirebase

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatEditText
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputLayout
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class LoginActivity : AppCompatActivity() {
    companion object{
       const val KEY1 ="com.example.signupusingfirebase.LoginActivity.name"
        const val KEY2 ="com.example.signupusingfirebase.LoginActivity.mail"

        const val KEY3 ="com.example.signupusingfirebase.LoginActivity.userName"    }
    lateinit var databaseRefrence :DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
       val btnSignIn = findViewById<Button>(R.id.btnSignIn)
        val etSignInUserName = findViewById<AppCompatEditText>(R.id.etSignInUserName)

        btnSignIn.setOnClickListener{
            // User tk ka address lena hai firebase me
            val uniqueId = etSignInUserName.text.toString()
            if(uniqueId.isNotEmpty()){
                readData(uniqueId)
            }else{
                Toast.makeText(this, "Please Enter UserName", Toast.LENGTH_SHORT).show()

            }
        }
    }

     fun readData(uniqueId: String) {
        databaseRefrence=FirebaseDatabase.getInstance().getReference("Users")
         databaseRefrence.child(uniqueId).get().addOnSuccessListener { 
             if(it.exists()){
                 // user ko next screen pe bhej denge
                 // it is itterator
                 val email=it.child("email").value
                 val name = it.child("name").value
                 val password = it.child("password").value
                 val userName = it.child("userName").value
                  val intent = Intent(this, WelcomeActivity::class.java)
                 intent.putExtra(KEY2,email.toString())
                 intent.putExtra(KEY1,name.toString())
                 intent.putExtra(KEY3,userName.toString())
                 startActivity(intent)

             }else{
                 Toast.makeText(this, "User Doesn't Exist", Toast.LENGTH_SHORT).show()
             }
         }.addOnFailureListener {
             Toast.makeText(this, "User Doesn't Exist, Please register", Toast.LENGTH_SHORT).show()
         }

    }


}