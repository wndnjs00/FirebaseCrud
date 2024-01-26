package com.example.firebasecrud

import com.google.android.gms.tasks.Task
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

// 데이터베이스와 연결해줄 클래스 생성

class UserDao {

    private var databaseReference : DatabaseReference? = null


    // init안에 있는 코드 = UserDao 객체 생성시에 바로 실행할 코드
    init {
        val db = FirebaseDatabase.getInstance()
        //FirebaseDatabase에 있는 user에 저장
        databaseReference = db.getReference("user")
    }

    // 사용자 등록함수
    fun add(user : User?) : Task<Void>{
        // databaseReference객체를 통해서 push(값을넣어줌)를 해주는데, user값을 넣어줌
         return databaseReference!!.push().setValue(user)
    }

}