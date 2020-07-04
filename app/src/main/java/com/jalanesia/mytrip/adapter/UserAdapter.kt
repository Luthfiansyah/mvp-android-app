package com.jalanesia.mytrip.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jalanesia.mytrip.R
import com.jalanesia.mytrip.data.user.UserItem
import kotlinx.android.synthetic.main.activity_user_list.view.*

class UsersAdapter(val data: List<UserItem>?) : RecyclerView.Adapter<UsersAdapter.MyHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val v =
            LayoutInflater.from(parent.context).inflate(R.layout.activity_user_list, parent, false)
        return MyHolder(v)
    }

    override fun getItemCount(): Int =
        data?.size ?: 0

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.bind(data?.get(position))
    }

    class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(get: UserItem?) {
            itemView.nama.text = get?.name
            itemView.email.text = get?.email
            itemView.notelp.text = get?.phone

            val address =
                "${get?.address?.street}, ${get?.address?.city}, ${get?.address?.suite}, ${get?.address?.zipcode}"
            itemView.alamat.text = address
        }
    }
}