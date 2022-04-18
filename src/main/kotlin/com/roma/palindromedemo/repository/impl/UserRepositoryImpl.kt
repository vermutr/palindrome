package com.roma.palindromedemo.repository.impl

import com.roma.palindromedemo.entity.User
import com.roma.palindromedemo.repository.UserRepository

class UserRepositoryImpl : UserRepository {

    val userList: MutableList<User> = ArrayList()

    override fun getUsersTopRating(limit: Int): List<User> {
        return userList.sortedByDescending { it.point }.take(limit)
    }

    override fun getUserById(id: Int): User {
        return userList.first { it.id == id }
    }

    override fun saveUser(user: User) {
        userList.add(user)
    }

    override fun deleteUser(id: Int) {
        val userById = getUserById(id)
        userList.remove(userById)
    }

    override fun getAllUsers(): List<User> {
        return userList
    }

}