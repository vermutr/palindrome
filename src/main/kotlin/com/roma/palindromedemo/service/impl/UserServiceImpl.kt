package com.roma.palindromedemo.service.impl

import com.roma.palindromedemo.config.exception.UserSaveException
import com.roma.palindromedemo.entity.User
import com.roma.palindromedemo.repository.impl.UserRepositoryImpl
import com.roma.palindromedemo.service.UserService

class UserServiceImpl : UserService {

    val userRepository: UserRepositoryImpl = UserRepositoryImpl()

    override fun getUserById(id: Int): User {
        return userRepository.getUserById(id)
    }

    override fun saveUser(user: User) {
        if (userRepository.userList.contains(user)) {
            throw UserSaveException("this user already in system: ${user.name}")
        }
        userRepository.saveUser(user)
    }

    override fun deleteUser(id: Int) {
        userRepository.deleteUser(id)
    }

    override fun getAllUsers(): List<User> {
        return userRepository.getAllUsers()
    }

    override fun getUsersTopRating(limit: Int): List<User> {
        return userRepository.getUsersTopRating(limit)
    }

    override fun savePhrase(user: User, phrase: String) {
        if (checkUniquePhrase(user.phrase, phrase)) {
            user.phrase.add(phrase)
        }
    }

    override fun savePoints(user: User, points: Int) {
        user.point = user.point.plus(points)
    }

    private fun checkUniquePhrase(userPhrases: List<String>, phrase: String): Boolean {
        if (userPhrases.contains(phrase)) {
            println("already wrote")
            return false
        }
        return true
    }

}