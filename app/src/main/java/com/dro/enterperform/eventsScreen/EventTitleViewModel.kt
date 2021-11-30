package com.dro.enterperform.eventsScreen

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.dro.enterperform.eventsScreen.model.EventDetailsModel
import com.dro.enterperform.network.NetworkResponse
import kotlinx.coroutines.launch

class EventTitleViewModel(app: Application) : AndroidViewModel(app)  {

    private var repo = EventRepository()
    var eventTitleList = MutableLiveData<EventsModel>()
    var eventDetailsList = MutableLiveData<EventDetailsModel>()


    fun getEventTitle() {

        viewModelScope.launch {
            val eventTitle = repo.getEventTitle()

            when (eventTitle) {
                is NetworkResponse.Success -> {
                    eventTitleList.value = eventTitle.body
                }
                is NetworkResponse.ApiError -> {
                }
                is NetworkResponse.NetworkError -> {
                }
                is NetworkResponse.UnknownError -> {
                }
            }
        }
    }

    fun getEventDetails(event_type: String, page: Int) {

        viewModelScope.launch {
            val eventDetails = repo.getEventDetails(event_type,page)

            when (eventDetails) {
                is NetworkResponse.Success -> {
                    eventDetailsList.value = eventDetails.body
                }
                is NetworkResponse.ApiError -> {
                }
                is NetworkResponse.NetworkError -> {
                }
                is NetworkResponse.UnknownError -> {
                }
            }
        }
    }


}