package com.example.intent

import android.content.Intent
import android.content.Intent.ACTION_DIAL
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import com.example.intent.MoveForResultActivity.Companion.RESULT_CODE

class MainActivity : AppCompatActivity(), View.OnClickListener{
    private lateinit var tvResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnMoveActivity: Button = findViewById(R.id.btn_move_activity)
        btnMoveActivity.setOnClickListener(this)

        val btnMoveWithDataActivity : Button = findViewById(R.id.btn_move_with_data)
        btnMoveWithDataActivity.setOnClickListener(this)

        val btnDialPhone: Button = findViewById(R.id.btn_dial_number)
        btnDialPhone.setOnClickListener(this)

        val btnMoveWithObjectActivity: Button = findViewById(R.id.btn_move_with_object)
        btnMoveWithObjectActivity.setOnClickListener(this)

        val btnMoveWithResult: Button = findViewById(R.id.btn_move_with_result)
        btnMoveWithResult.setOnClickListener(this)

        tvResult = findViewById(R.id.tv_result)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btn_move_activity -> {
                val moveIntent = Intent(this@MainActivity, MoveActivity::class.java)
                startActivity(moveIntent)
            }
            R.id.btn_move_with_data -> {
                val MoveWithDataIntent = Intent(this@MainActivity, MoveActivity::class.java)
                MoveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_NAME, "sukma")
                MoveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_AGE, 16)
                startActivity(MoveWithDataIntent)

                val btnDialPhone: Button = findViewById(R.id.btn_dial_number)
                btnDialPhone.setOnClickListener(this)
            }
            R.id.btn_dial_number -> {
                val phoneNumber = "081210841382"
                val dialPhoneIntent = Intent(Intent(ACTION_DIAL, Uri.parse("tel:$phoneNumber")))
                startActivity(dialPhoneIntent)
            }
            R.id.btn_move_with_object-> {
                val Person = Person("sukma", "p.sukmaananda@gmail.com", "Malang")
                val moveWithObjectActivity = Intent(this@MainActivity,MoveWithObjectActivity::class.java)
                moveWithObjectActivity.putExtra(MoveWithObjectActivity.EXTRA_PERSON, Person)
                startActivity(moveWithObjectActivity)
            }
            R.id.btn_move_activity_with_result-> {
                val moveForResultIntent =
                    Intent(this@MainActivity,
                        MoveForResultActivity::class.java)
                getResult.launch(moveForResultIntent)
            }
        }
    }
    private val getResult =
        registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()){
            if (it.resultCode == RESULT_CODE){
                val value = it.data?.getIntExtra(
                    MoveForResultActivity.EXTRA_SELECTED_VALUE, 0
                )
                tvResult.setText("Hasil $value")
            }
        }
    }




