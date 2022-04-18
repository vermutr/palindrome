package com.roma.palindromedemo.service

import com.roma.palindromedemo.entity.User

interface UserService {

    fun getUsersTopRating(limit: Int): List<User>

    fun savePhrase(user: User, phrase: String)

    fun savePoints(user: User, points: Int)

    fun getUserById(id: Int): User

    fun saveUser(user: User)

    fun deleteUser(id: Int)

    fun getAllUsers(): List<User>

}