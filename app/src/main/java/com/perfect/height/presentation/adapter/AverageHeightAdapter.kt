package com.perfect.height.presentation.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.transition.TransitionManager
import com.perfect.height.databinding.ItemAverageHeightBinding
import com.perfect.height.models.AverageCountryHeight


class AverageHeightAdapter(
    private val dataSet: List<AverageCountryHeight>
    , private var isLinearLayoutManager: Boolean
    , private var visitedPositions: MutableMap<Int, Boolean>
) :
    RecyclerView.Adapter<AverageHeightAdapter.ViewHolder>() {

    class ViewHolder(binding: ItemAverageHeightBinding) : RecyclerView.ViewHolder(binding.root) {
        val averageCountryRecyclerView: RecyclerView
        val averageHeightTextview: Button

        init {
            averageCountryRecyclerView = binding.averageHeightCountryRecyclerview
            averageHeightTextview = binding.averageHeightTextview
        }
    }

    fun updateLayoutManager() {
        isLinearLayoutManager = !isLinearLayoutManager
        notifyItemRangeChanged(0, itemCount)
    }

    private fun getLayoutManager(context: Context): RecyclerView.LayoutManager {
        return if (isLinearLayoutManager) LinearLayoutManager(context)
        else GridLayoutManager(context, 3)
    }

    fun collapaseOrCollide(isCollapsing: Boolean = true) {
        if (isCollapsing) {
            for (position in 0..itemCount) {
                visitedPositions[position] = isCollapsing
                notifyItemChanged(position)
            }
        } else {
            visitedPositions.clear()
            notifyItemRangeChanged(0, itemCount)
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemAverageHeightBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }


    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val averageCountryAdapter = CountryAdapter(dataSet[position].country)
        viewHolder.averageCountryRecyclerView.layoutManager =
            getLayoutManager(viewHolder.averageCountryRecyclerView.context)
        viewHolder.averageCountryRecyclerView.adapter = averageCountryAdapter
        viewHolder.averageHeightTextview.text =
            dataSet[position].height.height.toInt().toString() + " CM"

        val isExpanded = visitedPositions[position] != null
        viewHolder.averageCountryRecyclerView.visibility =
            if (isExpanded) View.VISIBLE else View.GONE
        viewHolder.averageHeightTextview.isActivated = isExpanded
        viewHolder.averageHeightTextview.setOnClickListener {
            if (isExpanded) visitedPositions.remove(position)
            else visitedPositions[position] = true
            TransitionManager.beginDelayedTransition(viewHolder.averageCountryRecyclerView)
            notifyItemChanged(position)
        }

        viewHolder.averageCountryRecyclerView.addItemDecoration(
            DividerItemDecoration(
                viewHolder.itemView.context,
                LinearLayoutManager.VERTICAL
            )
        )
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size



}
