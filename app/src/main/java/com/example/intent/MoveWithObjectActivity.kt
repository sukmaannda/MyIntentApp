package com.example.intent

import android.app.Person
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MoveWithObjectActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_with_object)

        if (intent != null) {
            val tvObject: TextView = findViewById(R.id.tv_object)
            val manusia: Person? = intent.getParcelableExtra(EXTRA_PERSON)
            val name : String? = manusia?.name.toString()
//           val email: String? = manusia?.email
//            val city: String? = manusia?.city
            val text = "Name : $name"
            tvObject.setText(text)
        }
    }

    companion object {
        const val EXTRA_PERSON = "extra_person"
    }
}