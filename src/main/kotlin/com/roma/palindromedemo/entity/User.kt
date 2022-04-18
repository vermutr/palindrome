package com.roma.palindromedemo.entity

data class User(

    val id: Int,

    val name: String,

    val phrase: MutableList<String>,

    var point: Int

)