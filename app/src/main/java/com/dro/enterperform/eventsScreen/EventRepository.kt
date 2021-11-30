package com.dro.enterperform.eventsScreen

import com.dro.enterperform.network.RetrofitBuilder

class EventRepository {

    private val client = RetrofitBuilder().instant

    suspend fun getEventTitle() = client.getMyEventsTitle()

    suspend fun getEventDetails(event_type: String, page: Int) =
        client.eventDetails(event_type, page)

}