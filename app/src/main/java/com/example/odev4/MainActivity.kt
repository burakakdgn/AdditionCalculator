package com.example.odev4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.odev4.databinding.ActivityMainBinding
import android.widget.Button

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding
    private var currentNumber = 0
    private var result = 0
    private var isAdding = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Sayı butonlarına tıklama işlemleri
        for (i in 0..9) {
            val buttonId = resources.getIdentifier("button$i", "id", packageName)
            val buttonText = i.toString()
            val button = findViewById<Button>(buttonId)
            button.setOnClickListener {
                if (isAdding) {
                    currentNumber = currentNumber * 10 + i
                } else {
                    currentNumber = i
                    isAdding = true
                }
                binding.editTextSonuc.setText(currentNumber.toString())
            }
        }

        // Toplama işareti butonu
        binding.buttonToplama.setOnClickListener {
            result += currentNumber
            currentNumber = 0
            isAdding = false
            binding.editTextSonuc.setText(result.toString())
        }

        // Sonuç butonu
        binding.buttonSonuc.setOnClickListener {
            result += currentNumber
            currentNumber = 0
            isAdding = false
            binding.editTextSonuc.setText(result.toString())
        }
        // Sıfırlama
        val buttonAC = binding.buttonAC
        buttonAC.setOnClickListener {
            result = 0
            currentNumber = 0
            isAdding = false
            binding.editTextSonuc.setText("0")
        }
    }
}
