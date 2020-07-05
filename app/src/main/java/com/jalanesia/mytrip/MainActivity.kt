package com.jalanesia.mytrip

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.jalanesia.mytrip.adapter.UsersAdapter
import com.jalanesia.mytrip.data.user.UserItem
import com.jalanesia.mytrip.service.NetworkConfig
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var sessionManager = SessionManager(this)
        Log.e("Session", sessionManager.fetchAuthToken().toString())

        if (sessionManager.fetchAuthToken() == null){
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
