package com.example.users_sp_da

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.users_sp_da.databinding.ItemUserBinding

class UserAdapter(private val users: List<User>) : RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context

        val view = LayoutInflater.from(context).inflate(R.layout.item_user, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int = users.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user = users.get(position)

        with(holder){
            binding.tvOrder.text = (position+1).toString()
            binding.tvName.text = user.nombre
            Glide.with(context)
                .load(user.url)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop()
                .circleCrop()
                .into(binding.imgPhoto)
        }
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val binding = ItemUserBinding.bind(view)
    }
}