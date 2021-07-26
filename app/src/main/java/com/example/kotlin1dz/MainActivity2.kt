package com.example.kotlin1dz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.kotlin1dz.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {

    private lateinit var ui: ActivityMain2Binding

    companion object{

        const val TEXT_KEY = "_KEY_"

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ui = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(ui.root)

        checkIntent()
        checking()

    }

    private fun checking(){
        ui.editTextActv2.setOnClickListener {
            if (!ui.editTextActv2.text.isNullOrEmpty())  send()
            else Toast.makeText(this,"Поле не может быть пустым", Toast.LENGTH_SHORT).show()

        }

    }

    private fun send() {
        val intent  = Intent(this, MainActivity::class.java)
        intent.putExtra(TEXT_KEY,ui.editTextActv2.text.toString())
        setResult(RESULT_OK,intent)
        finish()

    }

    private fun checkIntent(){
        ui.editTextActv2.setText(intent.getStringExtra(TEXT_KEY))

    }

}