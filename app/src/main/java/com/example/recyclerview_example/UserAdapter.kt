package com.example.recyclerview_example

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class UserAdapter(private val users: List<com.example.recyclerview_example.User>) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = users[position]
        holder.bind(user)
    }

    override fun getItemCount(): Int = users.size

    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val profileImage: ImageView = itemView.findViewById(R.id.profile_image)
        private val name: TextView = itemView.findViewById(R.id.name)
        private val username: TextView = itemView.findViewById(R.id.username)
        private val email: TextView = itemView.findViewById(R.id.email)
        private val phone: TextView = itemView.findViewById(R.id.phone)
        private val address: TextView = itemView.findViewById(R.id.address)
        private val company: TextView = itemView.findViewById(R.id.company)
        private val country: TextView = itemView.findViewById(R.id.country)

        fun bind(user: com.example.recyclerview_example.User) {
            name.text = user.name
            username.text = user.username
            email.text = user.email
            phone.text = user.phone
            address.text = user.address
            company.text = user.company
            country.text = user.country

            Glide.with(itemView.context)
                .load(user.photo)
                .circleCrop()
                .into(profileImage)
        }
    }
}
