package com.roma.palindromedemo.repository

import com.roma.palindromedemo.entity.User

interface UserRepository {

    //we have to choose how our data will be stored and then implement the method
    //@Query(select qwe from User qwe order by qwe.rating limit ?)
    fun getUsersTopRating(limit: Int): List<User>

    fun getUserById(id: Int): User

    fun saveUser(user: User)

    fun deleteUser(id: Int)

    fun getAllUsers(): List<User>

}