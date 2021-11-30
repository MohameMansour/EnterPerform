package com.dro.enterperform.eventsScreen

class EventsModel : ArrayList<EventsModelItem>()

data class EventsModelItem(
    val id: String,
    val name: String
)