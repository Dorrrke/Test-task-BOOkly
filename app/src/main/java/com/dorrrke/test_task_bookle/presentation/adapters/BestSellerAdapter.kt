package com.dorrrke.test_task_bookle.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import com.dorrrke.test_task_bookle.R
import com.dorrrke.test_task_bookle.presentation.fragments.BookDetailFragment
import com.dorrrke.test_task_bookle.repository.models.BestSellersContentItem
import com.dorrrke.test_task_bookle.repository.models.CarouselContentItem
import com.squareup.picasso.Picasso

class BestSellerAdapter(
    private val bestSellersContent: List<BestSellersContentItem>,
    navController: NavController
) : RecyclerView.Adapter<BestSellerAdapter.BestSellerViewHolder>() {
    var navController = navController
    class BestSellerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var bookImage: ImageView? = null
        var bookTitle: TextView? = null
        var author: TextView? = null
        var price: TextView? = null
        var rateScore: TextView? = null
        var rateAmount: TextView? = null
        var layout: LinearLayout? = null

        init {
            bookImage = itemView.findViewById(R.id.bookLogo)
            bookTitle = itemView.findViewById(R.id.title)
            author = itemView.findViewById(R.id.author)
            price = itemView.findViewById(R.id.price)
            rateScore = itemView.findViewById(R.id.rate_score)
            rateAmount = itemView.findViewById(R.id.rate_amount)
            layout = itemView.findViewById(R.id.bestSellerLayout)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BestSellerViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.best_seller_item, parent, false)
        return BestSellerViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: BestSellerViewHolder, position: Int) {
        Picasso.get()
            .load(bestSellersContent[position].image).resize(72, 114).centerInside()
            .into(holder.bookImage)
        holder.bookTitle?.text = bestSellersContent[position].title
        holder.author?.text = bestSellersContent[position].author
        holder.price?.text = bestSellersContent[position].price.toString()
        holder.rateScore?.text = bestSellersContent[position].rate?.score.toString()
        holder.rateAmount?.text = "(" + bestSellersContent[position].rate?.amount.toString() + ")"
        holder.layout?.setOnClickListener {
            navController.navigate(R.id.action_booksMainPageFragment_to_bookDetailFragment,
            bundleOf(BookDetailFragment.bookKey to bestSellersContent[position]))
        }
    }

    override fun getItemCount(): Int = bestSellersContent.size
}
