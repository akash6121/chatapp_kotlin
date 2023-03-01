package com.example.chatappkot

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class Signup : AppCompatActivity() {
    private lateinit var emailName: EditText
    private lateinit var passName: EditText
    private lateinit var userName: EditText
    private lateinit var registerBtn: Button
    private lateinit var auth: FirebaseAuth
    private lateinit var db: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        emailName = findViewById(R.id.emailfield)
        passName = findViewById(R.id.passfield)
        userName = findViewById(R.id.nametext)
        registerBtn = findViewById(R.id.registerbtn)
        auth = Firebase.auth

        db = Firebase.firestore

        registerBtn.setOnClickListener {
            val name = userName.text.toString()
            val email = emailName.text.toString()
            val password = passName.text.toString()

            signUp(name, email, password)
        }

    }

    private fun signUp(name: String, email: String, password: String) {
        val userName = mapOf("name" to name)
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val intent = Intent(
                        this,
                        MainActivity::class.java
                    )  // Sign in success, update UI with the signed-in user's information
                    startActivity(intent)
                    val uid: String? = task.result?.user?.uid
                    if (!uid.isNullOrEmpty()) {
                        //Call db
                        db.collection("user").document(uid).set(userName)
                        println(uid)
                    } else {
                        //Show error
                        Toast.makeText(this, "Can't get user id", Toast.LENGTH_LONG).show()
                    }

                } else {
                    // If sign in fails, display a message to the user.
                    Toast.makeText(this, "Error Occurred while Signing you in", Toast.LENGTH_LONG)
                        .show()
                }
            }
    }
}