package com.example.shoppinglist

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.shoppinglist.data.Product
import com.example.shoppinglist.data.ShoppingListDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class UpdateProductActivity : AppCompatActivity() {

    companion object {
        const val KEY = "byleco"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_product)

        val product = intent.getSerializableExtra(KEY) as? Product

        if (product  == null){
            finish()
        }

        val name = findViewById<EditText>(R.id.Name)
        val ilosc = findViewById<EditText>(R.id.Ilosc)
        val cena = findViewById<EditText>(R.id.Cena)
        val dodaj = findViewById<Button>(R.id.bt_add)

        name.setText(product!!.name_of_product)
        ilosc.setText(product!!.how_many_products)
        cena.setText(product!!.price_of_product.toString())

        val database = ShoppingListDatabase.getDatabase(this)

        dodaj.setOnClickListener {
            GlobalScope.launch(Dispatchers.Default) {
                database.shoppinglistDao().updateById(
                    name.text.toString(),
                    cena.text.toString().toFloat(),
                    ilosc.text.toString().toInt(),
                    product.id_of_product
                )
            }
            onBackPressed()
        }

    }
}