package com.roma.palindromedemo.service.impl


import com.roma.palindromedemo.service.ScoreService
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class ScoreServiceImplTest {

    val scoreServiceImpl: ScoreService = ScoreServiceImpl()

    @Test
    fun countPoints() {
        val helloMyFriends = scoreServiceImpl.countPoints("hello my friends")
        assertEquals(14, helloMyFriends)
    }

    @Test
    fun countEmptyPhrasePoints() {
        val emptyPhrase = scoreServiceImpl.countPoints("")
        assertEquals(0, emptyPhrase)
    }

    @Test
    fun countPhraseWithPunctuationPoints() {
        val helloMyFriends = scoreServiceImpl.countPoints("hello, my: Friends!!!!")
        assertEquals(14, helloMyFriends)
    }

    @Test
    fun countPhraseWithBadOrthographyPoints() {
        val helloMyFriends = scoreServiceImpl.countPoints("helo, my: Frends!!!!")
        assertEquals(12, helloMyFriends)
    }

}