package com.fquiz.worldcupquiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class result : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val tvName:TextView=findViewById(R.id.pname)
        val tvScore:TextView=findViewById(R.id.score)
        val btnFinish:Button=findViewById(R.id.finish)

        tvName.text=intent.getStringExtra(Constants.USER_NAME)

        val totalquestions=intent.getIntExtra(Constants.TOTAL_QUESTION,0)
        val correctAnswers=intent.getIntExtra(Constants.CORRECT_ANSWERS,0)

        tvScore.setText("Your Score is $correctAnswers out of $totalquestions")

        btnFinish.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
        }
    }
}