package com.example.booksapp.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.booksapp.data.util.Resource
import com.example.booksapp.databinding.FragmentBooksBinding
import com.example.booksapp.ui.adapter.BooksAdapter
import com.example.booksapp.ui.viewmodel.BooksViewModel

class BooksFragment : Fragment() {
    private lateinit var viewModel: BooksViewModel
    private lateinit var booksAdapter: BooksAdapter
    private var isLoading = false
    private var _binding: FragmentBooksBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBooksBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as MainActivity).viewModel
        booksAdapter = (activity as MainActivity).booksAdapter
        booksAdapter.setOnItemClickListener {
            viewModel.saveBook(it)
        }
        initRecyclerView()
        viewNewsList()
    }

    private fun initRecyclerView() {
        // newsAdapter = NewsAdapter()
        binding.rvBooks.apply {
            adapter = booksAdapter
            layoutManager = LinearLayoutManager(activity)
        }
    }

    private fun viewNewsList() {

        viewModel.getBooks("mobiledevelopment")
        viewModel.books.observe(viewLifecycleOwner) { response ->
            when (response) {
                is Resource.Success -> {
                    hideProgressBar()
                    response.data?.let {
                        Log.i("MYTAG", "came here ${it.items.toList().size}")
                        booksAdapter.differ.submitList(it.items.toList())
                    }
                }
                is Resource.Error -> {
                    hideProgressBar()
                    response.message?.let {
                        Toast.makeText(activity, "An error occurred : $it", Toast.LENGTH_LONG)
                            .show()
                    }
                }

                is Resource.Loading -> {
                    showProgressBar()
                }

                else -> {}
            }
        }
    }

    private fun showProgressBar() {
        isLoading = true
        binding.progressBar.visibility = View.VISIBLE
    }

    private fun hideProgressBar() {
        isLoading = false
        binding.progressBar.visibility = View.INVISIBLE
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}