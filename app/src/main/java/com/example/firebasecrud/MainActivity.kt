package com.example.firebasecrud

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.firebasecrud.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // viewbinding객체 생성
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 데이터베이스 클래스 객체생성
        val dao = UserDao()


        // addBtn 눌렀을때
        binding.addBtn.setOnClickListener {

            // 입력값 변수에 담기
            val name = binding.nameEdit.text.toString()  //이름   //binding을 사용해서 nameEdit값을 가져오는데 String값으로 바꿔서 가져옴
            val age = binding.ageEdit.text.toString()    //나이   //binding을 사용해서 ageEdit값을 가져오는데 String값으로 바꿔서 가져옴

            // 입력값을 담은변수를 User클래스에 담기(데이터 세팅)
            val user = User("", name, age)  // userKey,userName,userAge

            // 위에 세팅된 값을 데이터베이스에 전송한다음 등록
            dao.add(user)?.addOnSuccessListener {
                // 데이터가 성공적으로 들어갔을때
                Toast.makeText(this, "등록 성공!", Toast.LENGTH_SHORT).show()

            }?.addOnFailureListener {
                // 데이터 등록이 실패했을때
                Toast.makeText(this, "등록 실패 : ${it.message}", Toast.LENGTH_SHORT).show()

            }

        }

    }
}