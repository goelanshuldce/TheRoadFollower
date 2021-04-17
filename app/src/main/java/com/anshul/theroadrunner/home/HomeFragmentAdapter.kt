package com.anshul.theroadrunner.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.anshul.theroadrunner.databinding.ViewHolderAttractionBinding
import com.anshul.theroadrunner.entities.Attraction

interface IAttractionViewHolder {
    fun bind(attraction: Attraction)
}

class HomeFragmentAdapter(val onClickListener: OnClickListener) :
    ListAdapter<Attraction, RecyclerView.ViewHolder>(DiffCallback) {

    enum class ViewType {
        ATTRACTION
    }

    /**
     * The [RecyclerView.ViewHolder] constructor takes the binding variable from the associated
     * GridViewItem, which nicely gives it access to the full [Attraction] information.
     */
    class AttractionViewHolder(private var binding: ViewHolderAttractionBinding) :
        RecyclerView.ViewHolder(binding.root), IAttractionViewHolder {
        override fun bind(attraction: Attraction) {
            binding.attraction = attraction
            binding.executePendingBindings()
        }
    }

    /**
     * Create new [RecyclerView] item views (invoked by the layout manager)
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            ViewType.ATTRACTION.ordinal -> AttractionViewHolder(
                ViewHolderAttractionBinding.inflate(
                    LayoutInflater.from(parent.context)
                )
            )
            else -> AttractionViewHolder(
                ViewHolderAttractionBinding.inflate(
                    LayoutInflater.from(
                        parent.context
                    )
                )
            )
        }
    }

    override fun getItemViewType(position: Int): Int {
        return ViewType.ATTRACTION.ordinal
    }

    /**
     * Replaces the contents of a view (invoked by the layout manager)
     * We can expose them using a generic binder interface
     */
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val attraction = getItem(position)
        holder.itemView.setOnClickListener {
            onClickListener.onClick(attraction.id)
        }
        (holder as IAttractionViewHolder).bind(attraction)
    }

    /**
     * Custom listener that handles clicks on [RecyclerView] items.  Passes the [Attraction.id]
     * associated with the current item to the [onClick] function.
     * @param clickListener lambda that will be called with the current [Attraction]
     */
    class OnClickListener(val clickListener: (attractionId: String) -> Unit) {
        fun onClick(attractionId: String) = clickListener(attractionId)
    }

    /**
     * Allows the RecyclerView to determine which items have changed when the [List] of [Attraction]
     * has been updated.
     */
    companion object DiffCallback : DiffUtil.ItemCallback<Attraction>() {

        override fun areItemsTheSame(oldItem: Attraction, newItem: Attraction): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Attraction, newItem: Attraction): Boolean {
            return oldItem.id == newItem.id
        }

    }
}