package com.jalanesia.mytrip

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.jalanesia.mytrip.utils.Auth

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var auth = Auth()
        if (!auth.isLogin(this)){
            val intent = Intent(this@MainActivity,LoginActivity::class.java)
            startActivity(intent)
        }else {
            setContentView(R.layout.activity_main)
        }

//        NetworkConfig().getService()
//        .getUsers()
//        .enqueue(object : Callback<List<UserItem>> {
//            override fun onFailure(call: Call<List<UserItem>>, t: Throwable) {
//                Toast.makeText(this@MainActivity, t.localizedMessage, Toast.LENGTH_SHORT).show()
//            }
//
//            override fun onResponse(
//                call: Call<List<UserItem>>,
//                response: Response<List<UserItem>>
//            ) {
//                rvUser.adapter =
//                    UsersAdapter(response.body())
//            }
//        })


    }
}
