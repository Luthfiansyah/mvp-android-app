package com.jalanesia.mytrip

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.jalanesia.mytrip.data.auth.LoginResponse
import com.jalanesia.mytrip.data.auth.OTPRequest
import com.jalanesia.mytrip.data.auth.RegisterRequest
import com.jalanesia.mytrip.data.auth.RegisterResponse
import com.jalanesia.mytrip.data.common.GeneralResponse
import com.jalanesia.mytrip.service.NetworkConfig
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_login.inputPassword
import kotlinx.android.synthetic.main.activity_register.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        // var sessionManager = SessionManager(this)
        btnRegister.setOnClickListener() {
            val fullNameValue: String = inputFullName.text.toString()
            val phoneValue: String = inputPhone.text.toString()
            val emailValue: String = inputEmail.text.toString()
            val passwordValue: String = inputPassword.text.toString()

            if (fullNameValue.trim() == "") {
                Toast.makeText(this, "please input your username", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            if (phoneValue.trim() == "") {
                Toast.makeText(this, "please input your phone number", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            if (emailValue.trim() == "") {
                Toast.makeText(this, "please input your email", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            if (passwordValue.trim() == "") {
                Toast.makeText(this, "please input your password", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            NetworkConfig().getService()
            .register(RegisterRequest(fullname = fullNameValue, phone = phoneValue, email = emailValue, password = passwordValue))
            .enqueue(object : Callback<RegisterResponse> {
                override fun onFailure(call: Call<RegisterResponse>, t: Throwable) {
                    Toast.makeText(this@RegisterActivity, "Communication Error, please try again", Toast.LENGTH_LONG).show()
                }

                override fun onResponse(call: Call<RegisterResponse>, response: Response<RegisterResponse>) {
                    if(response.code() == 200) {
                        if (response.body()?.generalResponse?.responseStatus == true) {

                            Toast.makeText( this@RegisterActivity, response.body()?.generalResponse?.responseMessage.toString(), Toast.LENGTH_LONG).show()

                            val intent = Intent(this@RegisterActivity,LoginActivity::class.java)
                            intent.putExtra("username",emailValue)
                            intent.putExtra("password",passwordValue)
                            startActivity(intent)
                            overridePendingTransition(R.anim.slide_from_left,R.anim.slide_to_right)
                        }else {
                            Toast.makeText( this@RegisterActivity, response.body()?.generalResponse?.responseMessage.toString(), Toast.LENGTH_LONG).show()
                        }
                    }else {
                        Toast.makeText( this@RegisterActivity, response.body()?.generalResponse?.responseMessage.toString(), Toast.LENGTH_LONG).show()
                    }
                }
            })
        }

        // GO TO LOGIN
        textLoginLink.setOnClickListener(){
            val intent = Intent(this@RegisterActivity,LoginActivity::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.slide_from_right,R.anim.slide_to_left)
        }
    }
}
