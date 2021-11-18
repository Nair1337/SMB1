package com.example.shoppinglist.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ShoppingListDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addProduct(shoppinglist: Product)

    @Query("SELECT * FROM ShoppingList_table ORDER BY id_of_product ASC")
    fun readAllData(): LiveData<List<Product>>

    @Query("DELETE FROM ShoppingList_table WHERE id_of_product LIKE :id")
    fun deleteById(id: Int)

    @Query("UPDATE ShoppingList_table SET name_of_product = :name, price_of_product = :price, how_many_products = :kant WHERE id_of_product LIKE :id")
    fun updateById(name: String, price: Float, kant: Int, id: Int)
}

