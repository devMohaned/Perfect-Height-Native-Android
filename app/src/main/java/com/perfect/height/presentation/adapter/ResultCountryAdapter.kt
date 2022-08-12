package com.perfect.height.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.perfect.height.databinding.ItemResultBinding
import com.perfect.height.models.CountryHeight

class ResultCountryAdapter(
    private val dataSet: List<CountryHeight>) :
    RecyclerView.Adapter<ResultCountryAdapter.ViewHolder>() {


    class ViewHolder(binding: ItemResultBinding) : RecyclerView.ViewHolder(binding.root) {
        val countryNameTextView: TextView
        val countryHeightTextView: TextView
        val countryFlag: ImageView

        init {
            countryFlag = binding.countryFlagImageview
            countryNameTextView = binding.countryNameTextview;
            countryHeightTextView = binding.countryHeightTextview;
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemResultBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.countryFlag.setImageResource(dataSet[position].country.flag)
        viewHolder.countryNameTextView.text = dataSet[position].country.name
        viewHolder.countryHeightTextView.text =
            "(" + dataSet[position].height.toInt().toString() + " CM)"
    }

    override fun getItemCount() = dataSet.size

}
