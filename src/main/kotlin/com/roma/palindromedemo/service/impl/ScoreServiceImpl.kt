package com.roma.palindromedemo.service.impl

import com.roma.palindromedemo.service.ScoreService

class ScoreServiceImpl : ScoreService {

    override fun countPoints(phrase: String): Int {
        return phrase.replace("\\W".toRegex(), "").length
    }

}