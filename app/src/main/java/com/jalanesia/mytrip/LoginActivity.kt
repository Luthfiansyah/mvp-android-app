package com.jalanesia.mytrip

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.jalanesia.mytrip.data.auth.LoginResponse
import com.jalanesia.mytrip.data.auth.OTPRequest
import com.jalanesia.mytrip.service.NetworkConfig
import kotlinx.android.synthetic.main.activity_login.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // var sessionManager = SessionManager(this)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.title = "Skip for now"

        toolbar.setNavigationIcon(R.drawable.ic_arrow_backward_24dp)

        btnLogin.setOnClickListener() {
            val usernameValue: String = inputUsername.text.toString()
            val passwordValue: String = inputPassword.text.toString()
            if (usernameValue.trim() == "") {
                Toast.makeText(this, "please input your username", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            if (passwordValue.trim() == "") {
                Toast.makeText(this, "please input your password", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            NetworkConfig().getService()
            .authOTP(OTPRequest(username = usernameValue, password = passwordValue))
            .enqueue(object : Callback<LoginResponse> {
                override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                    Toast.makeText(this@LoginActivity, "Communication Error, please try again", Toast.LENGTH_LONG).show()
                }

                override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                    if(response.code() == 200) {
                        if (response.body()?.generalResponse?.responseStatus == true) {
                            val intent = Intent(this@LoginActivity,OTPActivity::class.java)
                            intent.putExtra("username",usernameValue)
                            intent.putExtra("password",passwordValue)
                            startActivity(intent)
                            overridePendingTransition(R.anim.slide_from_right,R.anim.slide_to_left)
                        }else {
                            Toast.makeText( this@LoginActivity, response.body()?.generalResponse?.responseMessage.toString(), Toast.LENGTH_LONG).show()
                        }
                    }else {
                        Toast.makeText( this@LoginActivity, response.body()?.generalResponse?.responseMessage.toString(), Toast.LENGTH_LONG).show()
                    }
                }
            })
        }

        // GO TO REGISTER
        textRegisterLink.setOnClickListener(){
            val intent = Intent(this@LoginActivity,RegisterActivity::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.slide_from_left,R.anim.slide_to_right)
        }
    }

    override fun onBackPressed() {
        // super.onBackPressed();
        // Toast.makeText(this@MainActivity, "There is no back action", Toast.LENGTH_LONG).show()
        val intent = Intent(this@LoginActivity,MainActivity::class.java)
        startActivity(intent)
        return
    }
}
