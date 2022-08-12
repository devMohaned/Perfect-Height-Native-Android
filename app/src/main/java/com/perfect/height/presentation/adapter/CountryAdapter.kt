package com.perfect.height.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.perfect.height.R
import com.perfect.height.databinding.ItemCountryBinding
import com.perfect.height.models.Country
import kotlinx.coroutines.NonDisposableHandle.parent

class CountryAdapter(private val dataSet: List<Country>) :
    RecyclerView.Adapter<CountryAdapter.ViewHolder>() {

    class ViewHolder(private val binding: ItemCountryBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(country: Country){
            binding.country = country
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemCountryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val country = dataSet[position]
        viewHolder.bind(country)
    }

    override fun getItemCount() = dataSet.size

}
