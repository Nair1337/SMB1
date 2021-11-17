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
    fun readAllData(): LiveData<ArrayList<Product>>
}