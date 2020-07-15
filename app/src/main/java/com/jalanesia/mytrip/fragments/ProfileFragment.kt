package com.jalanesia.mytrip.fragments


import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.jalanesia.mytrip.LoginActivity
import com.jalanesia.mytrip.MainActivity
import com.jalanesia.mytrip.R
import com.jalanesia.mytrip.utils.Auth
import kotlinx.android.synthetic.main.fragment_profile.view.*


/**
 * A simple [Fragment] subclass.
 */
class ProfileFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view: View
        val auth = Auth()

//        if (!context?.let { auth.isLogin(it) }!!) {
////            val intent = Intent(activity, LoginActivity::class.java)
////            startActivity(intent)
//            view = inflater!!.inflate(R.layout.activity_login, container, false)
//            return view
//            Log.d("MASUK",  context?.let { auth.isLogin(it) }.toString()!!)
//        }

        view = inflater!!.inflate(R.layout.fragment_profile, container, false)

        view.btn_logout.setOnClickListener { view ->

            try {
                // REMOVE SESSION
                context?.let { auth.deleteSession(it) }
            }
            catch (e: Exception) {
                // SHOW MESSAGE
                Toast.makeText(context, e.toString(), Toast.LENGTH_LONG).show()
            }
            finally {
                // REDIRECT TO MAIN ACTIVITY
                val intent = Intent(activity, MainActivity::class.java)
                startActivity(intent)

                // SHOW MESSAGE
                Toast.makeText(context, "Logout is successfully", Toast.LENGTH_LONG).show()
            }
        }

        return view
    }
}
