package com.example.shoppinglist

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.shoppinglist.data.ShoppingListDatabase
import com.google.android.material.floatingactionbutton.FloatingActionButton


class ProductListActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_productlist)

        val recyclerView = findViewById<RecyclerView>(R.id.productList)
        val fab = findViewById<FloatingActionButton>(R.id.Fab)
        val productAdapter = ProductListAdapter()

        recyclerView.apply {
            adapter=productAdapter
            layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL,false)
            setHasFixedSize(true)
        }

        fab.setOnClickListener {
            Intent(it.context, AddProductActivity::class.java).also { intent->
                startActivity(intent)
            }
        }

        val database = ShoppingListDatabase.getDatabase(this)
        //wyciagam z bazy danyc hwszystko co jest zapisane i obserwujemy zmiany to odczyta do nowa
        database.shoppinglistDao().readAllData().observe(this, {
            productAdapter.setData(ArrayList(it))
        })

    }


}