package com.example.todolist


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class login : AppCompatActivity() {

    lateinit var btn_login: Button
    lateinit var btn_signup: Button
    lateinit var edt_email: EditText
    lateinit var edt_password: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btn_login=findViewById(R.id.btn_login)
        btn_signup=findViewById(R.id.btn_signup)
        edt_email=findViewById(R.id.edt_email)
        edt_password=findViewById(R.id.edt_password)

        btn_login.setOnClickListener{
            val email = edt_email.text.toString()
            val password = edt_password.text.toString()

            Log.d("Login", "Attempt login with email/pw: $email/***")
            FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        val intent =  Intent(this,MainActivity::class.java)
                        startActivity(intent)
                        finish()
                    } else {
                        // If sign in fails, display a message to the user.
                        //  Log.w(TAG, "signInWithEmail:failure", task.exception)
                        Toast.makeText(baseContext, "Authentication failed.",
                            Toast.LENGTH_SHORT).show()
                        // ...
                    }

                    // ...
                }

        }


        btn_signup.setOnClickListener{
            val intent = Intent(this,register::class.java)
            startActivity(intent)

        }
    }
}