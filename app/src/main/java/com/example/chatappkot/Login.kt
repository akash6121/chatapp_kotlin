package com.example.chatappkot

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class Login : AppCompatActivity() {
    private lateinit var emailText:EditText
    private lateinit var passText:EditText
    private lateinit var loginBtn:Button
    private lateinit var registerBtn:Button
    private lateinit var mAuth:FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)
        registerBtn=findViewById(R.id.regbtn)
        loginBtn=findViewById(R.id.logbtn)
        emailText=findViewById(R.id.emailtext)
        passText=findViewById(R.id.passtext)

        mAuth= FirebaseAuth.getInstance()

        // Navigate to register Screen
        registerBtn.setOnClickListener {
            val intent = Intent(this,Signup::class.java)
            startActivity(intent)
        }

        loginBtn.setOnClickListener{
            val email=emailText.text.toString()
            val password=passText.text.toString()
            login(email,password)
        }

    }

    private fun login(email: String, password: String) {
        TODO("Not yet implemented")
    }

}