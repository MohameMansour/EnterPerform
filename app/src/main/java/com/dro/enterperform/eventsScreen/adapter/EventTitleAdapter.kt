package com.dro.enterperform.eventsScreen.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dro.enterperform.databinding.ItemEventTitleBinding
import com.dro.enterperform.eventsScreen.EventsModelItem

class EventTitleAdapter(
    val eventTitleList: List<EventsModelItem>,
    val onEventTitleClickListener: OnEventTitleClickListener
) :
    RecyclerView.Adapter<EventTitleAdapter.ViewHolder>() {

    class ViewHolder(val binding: ItemEventTitleBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): EventTitleAdapter.ViewHolder {
        val binding =
            ItemEventTitleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(
            binding
        )
    }

    override fun onBindViewHolder(holder: EventTitleAdapter.ViewHolder, position: Int) {
        holder.binding.eventTitle = eventTitleList[position]

        holder.binding.root.setOnClickListener {
            onEventTitleClickListener.onEventTitleClicked(eventTitleList[position])
        }

    }

    override fun getItemCount(): Int {
        return eventTitleList.size
    }

    interface OnEventTitleClickListener{
        fun onEventTitleClicked(eventModelItem: EventsModelItem)
    }
}