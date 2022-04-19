package com.roma.palindromedemo.repository.impl

import com.roma.palindromedemo.entity.User
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class UserRepositoryImplTest {

    val userRepository: UserRepositoryImpl = UserRepositoryImpl()

    @BeforeEach
    fun init() {
        userRepository.userList.clear()
        userRepository.userList.add(User(1, "Roma", mutableListOf("topot"), 5))
        userRepository.userList.add(User(2, "Kolia", mutableListOf("ili"), 3))
        userRepository.userList.add(User(3, "Vasia", mutableListOf("tqwewqt"), 7))
        userRepository.userList.add(User(4, "Ira", mutableListOf("mommom"), 6))
        userRepository.userList.add(User(5, "Olia", mutableListOf("travavart"), 9))
        userRepository.userList.add(User(6, "Katia", mutableListOf("salassalas"), 10))
    }


    @Test
    fun saveUser() {
        userRepository.saveUser(User(7, "Roma1", mutableListOf("qqqtopotqqq"), 11))
        assertTrue(userRepository.userList.contains(User(7, "Roma1", mutableListOf("qqqtopotqqq"), 11)))
        assertTrue(userRepository.userList.size == 7)
    }

    @Test
    fun getUsersTopRating() {
        val usersTopRating = userRepository.getUsersTopRating(5)
        val listOfTopUsers = listOf(
            User(6, "Katia", mutableListOf("salassalas"), 10),
            User(5, "Olia", mutableListOf("travavart"), 9),
            User(3, "Vasia", mutableListOf("tqwewqt"), 7),
            User(4, "Ira", mutableListOf("mommom"), 6),
            User(1, "Roma", mutableListOf("topot"), 5)
        )
        assertTrue(usersTopRating.size == 5)
        assertTrue(userRepository.userList.containsAll(listOfTopUsers))
    }

    @Test
    fun getUserById() {
        val userById = userRepository.getUserById(4)
        assertEquals(User(4, "Ira", mutableListOf("mommom"), 6), userById)
    }

    @Test
    fun deleteUser() {
        assertTrue(userRepository.userList.contains(User(3, "Vasia", mutableListOf("tqwewqt"), 7)))
        userRepository.deleteUser(User(3, "Vasia", mutableListOf("tqwewqt"), 7))
        assertFalse(userRepository.userList.contains(User(3, "Vasia", mutableListOf("tqwewqt"), 7)))
    }

    @Test
    fun getAllUsers() {
        val allUsers = userRepository.getAllUsers()
        assertEquals(userRepository.userList, allUsers)
    }

}