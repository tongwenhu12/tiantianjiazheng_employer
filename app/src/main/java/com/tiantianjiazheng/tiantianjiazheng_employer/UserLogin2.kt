package com.tiantianjiazheng.tiantianjiazheng_employer


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.view.View
import android.widget.EditText
import com.google.firebase.auth.FirebaseAuth
import android.widget.Toast
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.AuthResult
import com.google.android.gms.tasks.Task
import com.google.android.gms.tasks.OnCompleteListener
import android.R.attr.password
import android.content.Intent


class UserLogin2 : AppCompatActivity() {

    var tt_username: EditText? = null
    var tt_password: EditText? = null
    val mAuth = FirebaseAuth.getInstance()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_login2)

        tt_username = findViewById(R.id.tt_email2)
        tt_password = findViewById(R.id.tt_password2)

        if (mAuth.currentUser != null) {
            logIn()
        }
    }


    fun tt_login2(view: View) {
        // Check if we can log in the user
        mAuth.signInWithEmailAndPassword(tt_username?.text.toString(), tt_password?.text.toString())
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    logIn()
                } else {
                    // Sign up the user
                    mAuth.createUserWithEmailAndPassword(tt_username?.text.toString(), tt_password?.text.toString()).addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            logIn()
                        } else {
                            Toast.makeText(this,"Login Failed. Try Again.", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            }
    }


    fun logIn() {
        // Move to next Activity
        val intent = Intent(this, DidLogin::class.java)
        startActivity(intent)

    }
}