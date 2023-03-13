package com.fquiz.worldcupquiz

data class question(
    val id:Int,
    val quetion:String,
    val image:Int,
    val optionOne:String,
    val image2:Int,
    val optionTwo:String,
    val image3:Int,
    val optionThree:String,
    val image4:Int,
    val optionFour:String,
    val correctAnswer:Int
)
