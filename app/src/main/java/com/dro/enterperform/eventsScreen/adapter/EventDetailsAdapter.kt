package com.dro.enterperform.eventsScreen.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dro.enterperform.databinding.ItemEventBinding
import com.dro.enterperform.eventsScreen.EventsModelItem
import com.dro.enterperform.eventsScreen.model.EventDetailsModelItem

class EventDetailsAdapter(
    val eventDetailsList: List<EventDetailsModelItem> ,
    val onEventClickListener: EventDetailsAdapter.OnEventClickListener
) :
    RecyclerView.Adapter<EventDetailsAdapter.ViewHolder>() {

    class ViewHolder(val binding: ItemEventBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): EventDetailsAdapter.ViewHolder {
        val binding =
            ItemEventBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return EventDetailsAdapter.ViewHolder(
            binding
        )

    }

    override fun onBindViewHolder(holder: EventDetailsAdapter.ViewHolder, position: Int) {
        holder.binding.eventDetails = eventDetailsList[position]

        holder.binding.root.setOnClickListener {
            onEventClickListener.onEventClicked(eventDetailsList[position])
        }

    }

    override fun getItemCount(): Int {
        return eventDetailsList.size
    }

    interface OnEventClickListener{
        fun onEventClicked(eventDetailsModelItem: EventDetailsModelItem)
    }


}