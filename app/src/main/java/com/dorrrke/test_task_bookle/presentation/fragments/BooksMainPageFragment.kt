package com.dorrrke.test_task_bookle.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dorrrke.test_task_bookle.R
import com.dorrrke.test_task_bookle.domain.factories.BookPageViewModelFactory
import com.dorrrke.test_task_bookle.domain.viewModels.BooksPageViewModel
import com.dorrrke.test_task_bookle.presentation.adapters.BestSellerAdapter
import com.dorrrke.test_task_bookle.presentation.adapters.CarouselAdapter
import com.dorrrke.test_task_bookle.repository.models.BestSellersContentItem
import com.dorrrke.test_task_bookle.repository.models.CarouselContentItem

class BooksMainPageFragment : Fragment(R.layout.fragment_books_main_page) {

    lateinit var viewModel: BooksPageViewModel
    private lateinit var carouselRecyclerView: RecyclerView
    private lateinit var bestSellerRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel =
            ViewModelProvider(this, BookPageViewModelFactory(activity?.application!!)).get(BooksPageViewModel::class.java)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var toolbar = view.findViewById<Toolbar>(R.id.toolBar)
        var navController = findNavController()
        toolbar.apply {
            inflateMenu(R.menu.menu)
            setLogo(R.drawable.ic_logo__fix)
        }
        carouselRecyclerView = view.findViewById<RecyclerView>(R.id.recyclerViewCarousel)
        bestSellerRecyclerView = view.findViewById<RecyclerView>(R.id.bestSellerRecyclerView)
        viewModel.getCarouselContent()
        viewModel.postCarouselContent().observe(viewLifecycleOwner, Observer { it?.let { initCarouselRecyclerView(it) } })
        viewModel.getBestSellerContent()
        viewModel.postBestSellerContent().observe(viewLifecycleOwner, Observer { it?.let { initBestSellerRecyclerView(it, navController) } })
    }

    private fun initBestSellerRecyclerView(
        it: List<BestSellersContentItem>,
        navController: NavController
    ) {
        val bestSellersAdapter = BestSellerAdapter(it, navController)
        bestSellerRecyclerView.layoutManager = LinearLayoutManager(context)
        bestSellerRecyclerView.adapter = bestSellersAdapter
    }

    private fun initCarouselRecyclerView(books: List<CarouselContentItem>) {
        val carouselAdapter = CarouselAdapter(books)
        carouselRecyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        carouselRecyclerView.adapter = carouselAdapter
    }
}