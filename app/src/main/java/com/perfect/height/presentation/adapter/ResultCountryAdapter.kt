package com.perfect.height.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.perfect.height.databinding.ItemResultBinding
import com.perfect.height.models.Country
import com.perfect.height.models.CountryHeight

class ResultCountryAdapter(
    private val dataSet: List<CountryHeight>) :
    RecyclerView.Adapter<ResultCountryAdapter.ViewHolder>() {


    class ViewHolder(private val binding: ItemResultBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(countryHeight: CountryHeight){
            binding.countryHeight = countryHeight
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemResultBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val countryHeight = dataSet[position]
        viewHolder.bind(countryHeight)
    }

    override fun getItemCount() = dataSet.size

}
