package com.example.agro_markt.view.ui.activities


import android.app.PendingIntent
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.agro_markt.R
import com.example.agro_markt.databinding.ActivityLoginBinding
import com.firebase.ui.auth.AuthUI
import com.google.firebase.auth.*
import com.example.agro_markt.view.ui.activities.MainActivity as MainActivity
import com.google.firebase.auth.OAuthProvider
import java.util.concurrent.TimeUnit


class LoginActivity : AppCompatActivity() {


    private lateinit var binding: ActivityLoginBinding
    val AUTH_REQUEST_CODE = 1234
    lateinit var firebaseAuth: FirebaseAuth
    lateinit var listener: FirebaseAuth.AuthStateListener
    lateinit var providers: List<AuthUI.IdpConfig>



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        providers = arrayListOf(
            AuthUI.IdpConfig.GoogleBuilder().build(),
            AuthUI.IdpConfig.EmailBuilder().build(),
            AuthUI.IdpConfig.PhoneBuilder().build()

        )


        val intent = Intent(this, MainActivity::class.java)
        firebaseAuth = FirebaseAuth.getInstance()
        listener = FirebaseAuth.AuthStateListener { p0 ->
            val user = p0.currentUser
            if (user != null) {
                startActivity(intent)
            } else {
                startActivityForResult(AuthUI.getInstance()
                    .createSignInIntentBuilder()
                    .setAvailableProviders(providers)
                    .setLogo(R.drawable.icono_intro)
                    .setTheme(R.style.LoginTheme)
                    .build(),AUTH_REQUEST_CODE)
            }
        }
    }

    override fun onStart(){
        super.onStart()
        firebaseAuth.addAuthStateListener(listener)

    }

    override fun onStop() {
        if (listener != null)
            firebaseAuth.removeAuthStateListener (listener)
        super.onStop()
    }
}