package com.dro.enterperform.network


import com.dro.enterperform.eventsScreen.EventsModel
import com.dro.enterperform.eventsScreen.model.EventDetailsModel
import retrofit2.http.*

interface Apis {

    @GET(Urls.EVENTS_TITLE)
    suspend fun getMyEventsTitle(
    ): NetworkResponse<EventsModel, ErrorModel>

    @GET(Urls.EVENT_DETAILS)
    suspend fun eventDetails(
        @Query("event_type") event_type: String,
        @Query("page") page: Int,
    ): NetworkResponse<EventDetailsModel, ErrorModel>


}