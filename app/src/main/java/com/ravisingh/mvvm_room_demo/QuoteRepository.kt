package com.ravisingh.mvvm_room_demo

import androidx.lifecycle.LiveData

class QuoteRepository(private val quoteDao: QuoteDao) {

    fun getQuotes() : LiveData<List<Quote>>{
        return quoteDao.getQuotes()
    }

    suspend fun insertQuotes(quote: Quote){
        quoteDao.insertQuote(quote)
    }
}