package com.example.shoppinglist

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.shoppinglist.data.Product
import com.example.shoppinglist.data.ShoppingListDatabase

class AddProductActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_product)

        val name = findViewById<EditText>(R.id.Name)
        val ilosc = findViewById<EditText>(R.id.Ilosc)
        val cena = findViewById<EditText>(R.id.Cena)
        val dodaj = findViewById<Button>(R.id.bt_add)

        val database = ShoppingListDatabase.getDatabase(this)

        dodaj.setOnClickListener {
            val product = Product(
                name.text.toString(),
                cena.text.toString().toFloat(),
                ilosc.text.toString().toInt()
            )
            database.shoppinglistDao().addProduct(product)
            onBackPressed()
        }

    }
}