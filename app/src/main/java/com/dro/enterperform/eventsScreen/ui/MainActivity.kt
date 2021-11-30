package com.dro.enterperform.eventsScreen.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.dro.enterperform.R
import com.dro.enterperform.databinding.ActivityMainBinding
import com.dro.enterperform.eventDetails.EventDetailsActivity
import com.dro.enterperform.eventsScreen.EventTitleViewModel
import com.dro.enterperform.eventsScreen.EventsModelItem
import com.dro.enterperform.eventsScreen.adapter.EventDetailsAdapter
import com.dro.enterperform.eventsScreen.adapter.EventTitleAdapter
import com.dro.enterperform.eventsScreen.model.EventDetailsModelItem
import com.dro.enterperform.utils.Constants
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), EventTitleAdapter.OnEventTitleClickListener  , EventDetailsAdapter.OnEventClickListener{

    lateinit var viewModel: EventTitleViewModel
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(EventTitleViewModel::class.java)

        initListeners()
        initObservers()

    }

    private fun initObservers() {
        events_title_rv.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        events__rv.layoutManager =
            LinearLayoutManager(this)
    }

    private fun initListeners() {

        viewModel.eventTitleList.observe(this, Observer {
            events_title_rv.adapter = EventTitleAdapter(it, this)
        })
        viewModel.getEventTitle()

        viewModel.eventDetailsList.observe(this, Observer {
            events__rv.adapter = EventDetailsAdapter(it, this)
        })

        viewModel.getEventDetails("5aa98d9fd7306cec6835667c", 1)
    }

    override fun onEventTitleClicked(eventModelItem: EventsModelItem) {
        viewModel.getEventDetails(eventModelItem.id, 1)
    }

    override fun onEventClicked(eventDetailsModelItem: EventDetailsModelItem) {
        val intent=Intent(this, EventDetailsActivity::class.java)
        intent.putExtra(Constants.EVENT_NAME,eventDetailsModelItem.name)
        intent.putExtra(Constants.EVENT_COVER,eventDetailsModelItem.cover)
        intent.putExtra(Constants.EVENT_DATE,eventDetailsModelItem.start_date)
        intent.putExtra(Constants.EVENT_DESCRIPTION,eventDetailsModelItem.description)
        intent.putExtra(Constants.EVENT_LAT,eventDetailsModelItem.latitude)
        intent.putExtra(Constants.EVENT_LANG,eventDetailsModelItem.longitude)
        startActivity(intent)
    }

}