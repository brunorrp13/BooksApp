package com.example.booksapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.booksapp.databinding.FragmentFavoritesBinding
import com.example.booksapp.ui.adapter.BooksAdapter
import com.example.booksapp.ui.viewmodel.BooksViewModel

class FavoritesFragment : Fragment() {

    private var _binding: FragmentFavoritesBinding? = null
    private lateinit var viewModel: BooksViewModel
    private lateinit var booksAdapter: BooksAdapter

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFavoritesBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel = (activity as MainActivity).viewModel
        booksAdapter = BooksAdapter(BooksAdapter.FragmentType.FAVORITES)
        booksAdapter.setOnItemClickListener {
            viewModel.deleteBook(it)
        }
        initRecyclerView()
        viewModel.getSavedBooks().observe(viewLifecycleOwner) {
            booksAdapter.differ.submitList(it)
        }
        super.onViewCreated(view, savedInstanceState)

    }

    private fun initRecyclerView(){
        binding.rvSaved.apply {
            adapter = booksAdapter
            layoutManager = LinearLayoutManager(activity)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}