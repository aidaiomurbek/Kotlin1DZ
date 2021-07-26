package com.example.kotlin1dz

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.example.kotlin1dz.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var ui: ActivityMainBinding

    private lateinit var resultLauncher: ActivityResultLauncher<Intent>

    companion object {
        const val TEXT_KEY = "_KEY_"

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ui = ActivityMainBinding.inflate(layoutInflater)
        setContentView(ui.root)
        registerForResult()
        checking()

    }

    private fun registerForResult() {
        resultLauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult())
            { result ->
                if (result.resultCode == Activity.RESULT_OK)
                    checkData(result.data)

            }

    }

    private fun checkData(data: Intent?) {
        ui.editTextActv1.setText(data?.getStringExtra(TEXT_KEY))

    }


    private fun checking() {
        ui.btnActv1.setOnClickListener {
            if (!ui.editTextActv1.text.isNullOrEmpty()) send()
            else Toast.makeText(this, "Поле не может быть пустым", Toast.LENGTH_SHORT).show()

        }

    }

    private fun send() {
        val intent = Intent(this, MainActivity2::class.java)
        intent.putExtra(TEXT_KEY, ui.editTextActv1.text.toString())
        resultLauncher.launch(intent)

    }

}