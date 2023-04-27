package com.example.firebase2risley

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class loginactivity : AppCompatActivity() {

    lateinit var edtemail: EditText
    lateinit var edtpassword: EditText
    lateinit var btnlogin: Button
    lateinit var btnregister: Button


    lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loginactivity)


        edtemail = findViewById(R.id.edtemail)
        edtpassword = findViewById(R.id.edtpassword)
        btnlogin = findViewById(R.id.btnlogin)
        btnregister = findViewById(R.id.btnregister)

        auth = FirebaseAuth.getInstance()

        btnlogin.setOnClickListener{

            var email = edtemail.text.toString().trim()
            var password = edtpassword.text.toString().trim()



            if ( email.isEmpty() || password.isEmpty()){
                Toast.makeText(this, "One of the Fields is Empty", Toast.LENGTH_SHORT).show()
            }else{

                auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this){
                    if (it.isSuccessful){
                        Toast.makeText(this, "Login Succes", Toast.LENGTH_SHORT).show()

                        var gotomain = Intent(this, MainActivity::class.java)
                        startActivity(gotomain)
                        finish()

                    }else{
                        Toast.makeText(this, "Login Failed", Toast.LENGTH_SHORT).show()
                    }

                }

            }

        }


    }
}

