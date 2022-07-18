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
import com.dorrrke.test_task_bookle.repository.models.SimilarContentItem
import com.squareup.picasso.Picasso

class SimilarContentAdapter(
    private val similarContent: List<SimilarContentItem>
) : RecyclerView.Adapter<SimilarContentAdapter.SimilarContentViewHolder>() {
    class SimilarContentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var bookImage: ImageView? = null

        init {
            bookImage = itemView.findViewById(R.id.similarBookLogo)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SimilarContentViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.similar_item, parent, false)
        return SimilarContentViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: SimilarContentViewHolder, position: Int) {
        Picasso.get()
            .load(similarContent[position].image).resize(72, 114).centerInside()
            .into(holder.bookImage)
    }

    override fun getItemCount(): Int = similarContent.size
}