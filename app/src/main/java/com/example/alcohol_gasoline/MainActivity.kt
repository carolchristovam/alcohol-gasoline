package com.example.alcohol_gasoline

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import com.example.alcohol_gasoline.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        setupClick()
    }

    fun priceCalculate() {
        val alcoholPrice = binding.alcoholPrice.text.toString()
        val gasolinePrice = binding.gasolinePrice.text.toString()

        val validate = validate(alcoholPrice, gasolinePrice)

        if (validate) {
            calculatePrice(alcoholPrice, gasolinePrice)
        } else {
            binding.textResult.text = "Please fill the prices first"
        }
    }

    private fun setupClick() {
        binding.button.setOnClickListener{
            priceCalculate()
        }

    }

    private fun calculatePrice(alcoholPrice: String, gasolinePrice: String) {
        val alcoholValue = alcoholPrice.toDouble()
        val gasolineValue = gasolinePrice.toDouble()
        val priceResult = alcoholValue/gasolineValue

        if(priceResult>=0.7){
            binding.textResult.text = "Gasoline is the best option!"
        }else{
            binding.textResult.text = "Alcohol is the best option!"
        }

    }

    fun validate(alcoholPrice: String, gasolinePrice: String):Boolean {
        var validatedFields: Boolean = true

        if (alcoholPrice == null || alcoholPrice.equals("")) {
            validatedFields=false
        }else if(gasolinePrice == null || gasolinePrice.equals("")){
            validatedFields=false
        }
        return validatedFields

    }
}