package com.example.users_sp_da;

data class User (val id:Long, var nombre:String, var lastName: String, var url: String){
    fun getFullName(): String = "$nombre $lastName"
}