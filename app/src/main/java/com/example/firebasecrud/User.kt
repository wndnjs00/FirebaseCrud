package com.example.firebasecrud

data class User(
    var userKey : String,   //사용자키값(구분값)
    var userName : String,  //사용자이름
    var userAge : String    //사용자나이
){
    constructor() : this("","","")
}

