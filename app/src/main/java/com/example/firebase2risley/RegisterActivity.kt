package com.example.firebase2risley

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase

class RegisterActivity : AppCompatActivity() {

    lateinit var edtregname: EditText
    lateinit var edtregemail: EditText
    lateinit var edtregpassword: EditText
    lateinit var btnregaccount: Button

    lateinit var auth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        edtregname = findViewById(R.id.edtregname)
        edtregemail = findViewById(R.id.edtregemail)
        edtregpassword = findViewById(R.id.edtregpassword)
        btnregaccount = findViewById(R.id.btnregaccount)


        auth = FirebaseAuth.getInstance()

        btnregaccount.setOnClickListener {

            var name = edtregname.text.toString().trim()
            var email = edtregemail.text.toString().trim()
            var password = edtregpassword.text.toString().trim()

            //validate your inputs

            if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {

                Toast.makeText(this, "One of the Fields is Empty", Toast.LENGTH_SHORT).show()

            } else {
                //Create a User in Firebase
                auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this) {

                    if (it.isSuccessful) {
                        Toast.makeText(this, "User Created Successfully", Toast.LENGTH_SHORT).show()
                        var gotologin = Intent(this, loginactivity::class.java)
                        startActivity(gotologin)
                        finish()
                    } else {
                        Toast.makeText(this, "Failed to Create Account", Toast.LENGTH_SHORT).show()
                    }
                }


            }

        }

    }
}

