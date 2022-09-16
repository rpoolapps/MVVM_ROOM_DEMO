package com.ravisingh.mvvm_room_demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.ravisingh.mvvm_room_demo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val dao = QuoteDatabase.getQuoteDatabase(applicationContext).quoteDao()
        val repository = QuoteRepository(dao)
        viewModel = ViewModelProvider(this, MainViewModelFactory(repository)).get(MainViewModel::class.java)

        viewModel.getQuotes().observe(this) {
            binding.quotes = it.toString()
        }

        binding.addQuote.setOnClickListener {
           val quote  = Quote(0,"This is Testing","Testing")
            viewModel.insertQuote(quote)
        }
    }
}