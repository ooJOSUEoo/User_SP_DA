package com.example.users_sp_da

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.example.users_sp_da.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var userAdapter: UserAdapter
    private lateinit var linearLayoutManager: RecyclerView.LayoutManager

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        userAdapter = userAdapter(getUsers())
        linearLayoutManager = linearLayoutManager(this)

        binding.recyclerView.apply{
            layoutManager = linearLayoutManager
            adapter = userAdapter

        }
    }

    private  fun getUsers(): MutableList<User>{
        val users = mutableListOf<User>()

        val josue = User(1, "Josue", "Muñoz","")
        val luis = User(2, "Luis", "Perez", "")

        users.add(josue)
        users.add(luis)

        return users
    }
}