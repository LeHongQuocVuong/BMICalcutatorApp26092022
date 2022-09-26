package com.example.bmicalcutatorapp26092022

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        var result: String? = intent.getStringExtra("result")
        var result_type: String? = intent.getStringExtra("result_type")
        var comment: String? = intent.getStringExtra("comment")

        tv_result.text = result
        tv_result_type.text = result_type
        tv_comment.text = comment

        btn_re_calculate.setOnClickListener{
            val intent2 = Intent(this, MainActivity::class.java)
            startActivity(intent2)
        }
    }
}