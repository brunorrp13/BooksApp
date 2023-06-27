package com.example.booksapp.ui.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.booksapp.R
import com.example.booksapp.data.model.Item
import com.example.booksapp.databinding.BookListItemBinding

class BooksAdapter : RecyclerView.Adapter<BooksAdapter.BooksViewHolder>() {


    private val callback = object : DiffUtil.ItemCallback<Item>() {
        override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, callback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BooksViewHolder {
        val binding = BookListItemBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return BooksViewHolder(binding)
    }


    override fun onBindViewHolder(holder: BooksViewHolder, position: Int) {
        val article = differ.currentList[position]
        holder.bind(article)
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    inner class BooksViewHolder(
        val binding: BookListItemBinding
    ) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(book: Item) {
            Log.i("MYTAG", "came here ${book.volumeInfo.title}")
            binding.bookTitle.text = book.volumeInfo.title
            binding.bookAuthor.text = book.volumeInfo.authors.toString()
            binding.bookDescription.text = book.volumeInfo.description
            binding.favoritesLayout.setOnClickListener {
                onItemClickListener?.let {
                    it(book)
                }
            }
        }
    }

    private var onItemClickListener: ((Item) -> Unit)? = null

    fun setOnItemClickListener(listener: (Item) -> Unit) {
        onItemClickListener = listener
    }

}
