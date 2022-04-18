package com.roma.palindromedemo.service.impl


import com.roma.palindromedemo.service.impl.ScoreServiceImpl
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.assertEquals

internal class ScoreServiceImplTest {

    @Test
    fun countPoints() {
        val ssi = ScoreServiceImpl()
        val helloMyFriends = ssi.countPoints("hello my friends")
        assertEquals(14, helloMyFriends)
    }

    @Test
    fun countEmptyPhrasePoints() {
        val ssi = ScoreServiceImpl()
        val emptyPhrase = ssi.countPoints("")
        assertEquals(0, emptyPhrase)
    }

    @Test
    fun countPhraseWithPunctuationPoints() {
        val ssi = ScoreServiceImpl()
        val helloMyFriends = ssi.countPoints("hello, my: Friends!!!!")
        assertEquals(14, helloMyFriends)
    }

    @Test
    fun countPhraseWithBadOrthographyPoints() {
        val ssi = ScoreServiceImpl()
        val helloMyFriends = ssi.countPoints("helo, my: Frends!!!!")
        assertEquals(12, helloMyFriends)
    }

}