package com.dro.enterperform.eventsScreen.model

class EventDetailsModel : ArrayList<EventDetailsModelItem>()

data class EventDetailsModelItem(
    val cover: String,
    val description: String,
    val end_date: String,
    val id: String,
    val latitude: String,
    val longitude: String,
    val name: String,
    val start_date: String
)