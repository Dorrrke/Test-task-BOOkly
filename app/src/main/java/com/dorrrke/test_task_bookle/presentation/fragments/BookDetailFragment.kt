package com.dorrrke.test_task_bookle.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dorrrke.test_task_bookle.R
import com.dorrrke.test_task_bookle.domain.factories.BookDetailViewModelFactory
import com.dorrrke.test_task_bookle.domain.factories.BookPageViewModelFactory
import com.dorrrke.test_task_bookle.domain.viewModels.BookDetailViewModel
import com.dorrrke.test_task_bookle.domain.viewModels.BooksPageViewModel
import com.dorrrke.test_task_bookle.presentation.adapters.SimilarContentAdapter
import com.dorrrke.test_task_bookle.repository.models.BestSellersContentItem
import com.dorrrke.test_task_bookle.repository.models.SimilarContentItem
import com.google.android.material.imageview.ShapeableImageView
import com.squareup.picasso.Picasso

class BookDetailFragment : Fragment(R.layout.fragment_book_detail) {

    companion object{
        const val bookKey = "BOOK_KEY"
    }
    lateinit var viewModel: BookDetailViewModel
    private lateinit var similarRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel =
            ViewModelProvider(this, BookDetailViewModelFactory(activity?.application!!)).get(
                BookDetailViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        var toolbar = view.findViewById<Toolbar>(R.id.toolBarDetail)
        toolbar.apply {
            inflateMenu(R.menu.detail_menu)
            setNavigationIcon(R.drawable.ic_clouse)
            setNavigationOnClickListener {
                findNavController().navigate(R.id.action_bookDetailFragment_to_booksMainPageFragment)
            }
        }
        var book = arguments?.getParcelable<BestSellersContentItem>(bookKey)
        super.onViewCreated(view, savedInstanceState)
        var image = view.findViewById<ShapeableImageView>(R.id.detail_image_book)
        view.findViewById<TextView>(R.id.titleOfBook).text = book?.title
        view.findViewById<TextView>(R.id.bookAuthor).text = book?.author
        view.findViewById<TextView>(R.id.book_rate_score).text = book?.rate?.score.toString()
        view.findViewById<TextView>(R.id.book_rate_amount).text = "(" + book?.rate?.amount.toString() + ")"
        Picasso.get()
            .load(book?.image).resize(192, 262).centerInside()
            .into(image)

        similarRecyclerView = view.findViewById(R.id.similarRecyclerView)
        viewModel.getSimilarContent()
        viewModel.postSimilarContent().observe(viewLifecycleOwner, Observer { it?.let { initRecyclerView(it) } })
    }

    private fun initRecyclerView(it: List<SimilarContentItem>) {
        val similarContentAdapter = SimilarContentAdapter(it)
        similarRecyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        similarRecyclerView.adapter = similarContentAdapter
    }

}