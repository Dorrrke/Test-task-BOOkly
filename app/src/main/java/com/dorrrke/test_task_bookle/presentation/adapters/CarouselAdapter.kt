package com.dorrrke.test_task_bookle.presentation.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.dorrrke.test_task_bookle.R
import com.dorrrke.test_task_bookle.repository.models.CarouselContent
import com.dorrrke.test_task_bookle.repository.models.CarouselContentItem
import com.squareup.picasso.Picasso

class CarouselAdapter(private val carouselContent: List<CarouselContentItem>) : RecyclerView.Adapter<CarouselAdapter.CarouselViewHolder>(){
    class CarouselViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var bookImage: ImageView? = null
        init {
            bookImage = itemView.findViewById(R.id.image_book)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarouselViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.carusel_item, parent, false)
        return CarouselViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CarouselViewHolder, position: Int) {
        Picasso.get()
            .load(carouselContent.get(position)?.image).resize(241, 295).centerInside()
            .into(holder.bookImage)
    }

    override fun getItemCount(): Int = carouselContent.size
}