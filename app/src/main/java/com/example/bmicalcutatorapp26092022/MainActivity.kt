package com.example.bmicalcutatorapp26092022

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var isMale: Boolean = true
    var isFemale: Boolean = false
    var height: Double = 0.0
    var weight: Double = 0.0
    var age: Int = 1
    var BMI: Double = 0.0
    var result:String = ""
    var result_type:String = ""
    var comment:String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_male.setOnClickListener{
            isFemale = false
            isMale = true
            btn_male.setBackgroundColor(Color.GRAY)
            btn_female.setBackgroundColor(getResources().getColor(R.color.purple_500))
        }
        btn_female.setOnClickListener{
            isFemale = true
            isMale = false
            btn_female.setBackgroundColor(Color.GRAY)
            btn_male.setBackgroundColor(getResources().getColor(R.color.purple_500))
        }



        btn_calculate.setOnClickListener{
            if (et_height.text?.isEmpty() == true){
                Toast.makeText(this,"Vui lòng nhập chiều cao!",Toast.LENGTH_LONG).show()
            }else if (et_weight.text?.isEmpty() == true){
                Toast.makeText(this,"Vui lòng nhập cân nặng!",Toast.LENGTH_LONG).show()
            }else if (et_age.text?.isEmpty() == true){
                Toast.makeText(this,"Vui lòng nhập độ tuổi!",Toast.LENGTH_LONG).show()
            }else{
                height = et_height.text!!.toString().toDouble() / 100
                weight = et_weight.text!!.toString().toDouble()
                age = et_age.text!!.toString().toInt()
                BMI = weight/(height * height )
                result = String.format("%.2f",BMI)
                Toast.makeText(this, result,Toast.LENGTH_LONG).show()

                if(BMI<18.5){
                    result_type = "Nhẹ cân"
                    comment = "Bạn bị nhẹ cân"
                }else if(BMI<23){
                    result_type = "Tình trạng dinh dưỡng bình thường"
                    comment = "Cân nặng của bạn rất tốt"
                }else if(BMI<25){
                    result_type = "Tiền béo phì"
                    comment = "Bạn đang bị béo phì"
                }else if(BMI<30){
                    result_type = "Béo phì độ 1"
                    comment = "Bạn đang bị béo phì độ 1"
                }else if(BMI>=30){
                    result_type = "Béo phì độ 2"
                    comment = "Bạn đang bị béo phì độ 2"
                }

                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra("result", result)
                intent.putExtra("result_type",result_type)
                intent.putExtra("comment",comment)
                startActivity(intent)
            }

        }
    }
}