package com.roma.palindromedemo.service.impl

import com.roma.palindromedemo.config.exception.UserSaveException
import com.roma.palindromedemo.entity.User
import com.roma.palindromedemo.service.impl.UserServiceImpl
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.assertFailsWith

internal class UserServiceImplTest {

    val userService: UserServiceImpl = UserServiceImpl()

    @BeforeEach
    fun init() {
        userService.userRepository.userList.clear()
        userService.userRepository.userList.add(User(1, "Roma", mutableListOf("topot"), 5))
        userService.userRepository.userList.add(User(2, "Kolia", mutableListOf("ili"), 3))
        userService.userRepository.userList.add(User(3, "Vasia", mutableListOf("tqwewqt"), 7))
        userService.userRepository.userList.add(User(4, "Ira", mutableListOf("mommom"), 6))
        userService.userRepository.userList.add(User(5, "Olia", mutableListOf("travavart"), 9))
        userService.userRepository.userList.add(User(6, "Katia", mutableListOf("salassalas"), 10))
    }

    @Test
    fun getUserById() {
        val userById = userService.getUserById(4)
        assertEquals(User(4, "Ira", mutableListOf("mommom"), 6), userById)
    }

    @Test
    fun getUserNotExistentById() {
        assertFailsWith<NoSuchElementException> {
            userService.getUserById(10)
        }
    }
    
    @Test
    fun saveUser() {
        userService.saveUser(User(7, "Roma1", mutableListOf("qqqtopotqqq"), 11))
        assertTrue(userService.userRepository.userList.contains(User(7, "Roma1", mutableListOf("qqqtopotqqq"), 11)))
        assertTrue(userService.userRepository.userList.size == 7)
    }

    @Test
    fun saveUserAlreadyExisting() {
        assertFailsWith<UserSaveException> {
            userService.saveUser(User(4, "Ira", mutableListOf("mommom"), 6))
        }
    }

    @Test
    fun deleteUser() {
        assertTrue(userService.userRepository.userList.contains(User(3, "Vasia", mutableListOf("tqwewqt"), 7)))
        userService.deleteUser(3)
        assertFalse(userService.userRepository.userList.contains(User(3, "Vasia", mutableListOf("tqwewqt"), 7)))
    }

    @Test
    fun getAllUsers() {
        val allUsers = userService.getAllUsers()
        assertEquals(userService.userRepository.userList, allUsers)
    }

    @Test
    fun getUsersTopRating() {
        val usersTopRating = userService.getUsersTopRating(5)
        val listOfTopUsers = listOf(
            User(6, "Katia", mutableListOf("salassalas"), 10),
            User(5, "Olia", mutableListOf("travavart"), 9),
            User(3, "Vasia", mutableListOf("tqwewqt"), 7),
            User(4, "Ira", mutableListOf("mommom"), 6),
            User(1, "Roma", mutableListOf("topot"), 5)
        )
        assertTrue(usersTopRating.size == 5)
        assertTrue(userService.userRepository.userList.containsAll(listOfTopUsers))
    }

    @Test
    fun savePhrase() {
        val userById = userService.getUserById(6)
        userService.savePhrase(userById, "qwertytrewq")
        val phrase = userService.getUserById(6).phrase

        assertEquals(listOf("salassalas", "qwertytrewq"), phrase)

    }

    @Test
    fun savePoints() {
        val userById = userService.getUserById(6)
        userService.savePoints(userById, 13)
        assertEquals(23, userById.point)
    }

}