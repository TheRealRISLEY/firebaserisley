package com.example.firebase2risley

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {

    lateinit var edtcarmake:EditText
    lateinit var edtcarmodel:EditText
    lateinit var edtcarprice:EditText
    lateinit var btncarphoto:Button
    lateinit var btncardata:Button
    lateinit var btnuploadedcars:Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtcarmake = findViewById(R.id.edtcarmake)
        edtcarmodel = findViewById(R.id.edtcarmodel)
        edtcarprice = findViewById(R.id.edtcarprice)
        btncarphoto = findViewById(R.id.btncarphoto)
        btncardata = findViewById(R.id.btncardata)
        btnuploadedcars = findViewById(R.id.btnuploadedcars)

        var database = FirebaseDatabase.getInstance()
        var databaseref = database.getReference("Car")


        btncarphoto.setOnClickListener {


        }

        btncardata.setOnClickListener {

            var carmake = edtcarmake.text.toString().trim()
            var carmodel = edtcarmodel.text.toString().trim()
            var carprice = edtcarprice.text.toString().trim()



            if (carmake.isEmpty() || carmodel.isEmpty() || carprice.isEmpty()){
                Toast.makeText(this, "Cannot Submit Empty Field", Toast.LENGTH_SHORT).show()
            }else{

                //saving info to firebase db


                var usercar = car(carmake,carmake,carprice)

                var ref = FirebaseDatabase.getInstance().getReference().child("cars")

                ref.setValue(usercar).addOnCompleteListener{

                    if (it.isSuccessful){
                        Toast.makeText(this,"Car Data Uploaded Successfully",
                            Toast.LENGTH_LONG).show()
                    }else{
                        Toast.makeText(this,"Failed tO Save Car Info",
                            Toast.LENGTH_LONG).show()
                    }

                }


            }


        }

        btnuploadedcars.setOnClickListener {


        }


    }
}