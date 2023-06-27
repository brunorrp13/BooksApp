package com.example.booksapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ui.AppBarConfiguration
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.booksapp.R
import com.example.booksapp.databinding.ActivityMainBinding
import com.example.booksapp.ui.adapter.BooksAdapter
import com.example.booksapp.ui.viewmodel.BooksViewModel
import com.example.booksapp.ui.viewmodel.BooksViewModelFactory
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding
    @Inject
    lateinit var factory: BooksViewModelFactory
    @Inject
    lateinit var booksAdapter: BooksAdapter
    lateinit var viewModel: BooksViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.fragment) as NavHostFragment
        val navController = navHostFragment.navController
        viewModel = ViewModelProvider(this, factory)[BooksViewModel::class.java]
        binding.bnvBooks.setupWithNavController(
            navController
        )
    }
}