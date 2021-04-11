package com.anshul.theroadrunner.home

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.anshul.theroadrunner.entities.Attraction
import com.squareup.picasso.Picasso


/**
 * When there is no [Attraction] data (data is null), hide the [RecyclerView], otherwise show it.
 */
@BindingAdapter("listData")
fun listData(recyclerView: RecyclerView, data: List<Attraction>?) {
    val adapter = recyclerView.adapter as HomeFragmentAdapter
    adapter.submitList(data)
}

@BindingAdapter("loadUrl")
fun loadUrl(imageView: ImageView, urls: List<String>) {
    if (urls.isNotEmpty()) {
        Picasso.get().load(urls[0]).into(imageView)
    }
}