package com.ravisingh.mvvm_room_demo

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface QuoteDao {

    @Query("Select * from quote")
    fun getQuotes(): LiveData<List<Quote>>

    @Insert
    suspend fun insertQuote(quote: Quote)
}