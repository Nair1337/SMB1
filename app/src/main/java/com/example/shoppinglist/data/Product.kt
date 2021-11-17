package com.example.shoppinglist.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ShoppingList_table")
data class Product(
    val name_of_product: String,
    val price_of_product: Float,
    val how_many_products: Int,
    val if_bought: Boolean = false,
    @PrimaryKey(autoGenerate = true)
    val id_of_product: Int = 0
)