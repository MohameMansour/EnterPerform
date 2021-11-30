package com.dro.enterperform.eventDetails

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.dro.enterperform.R
import com.dro.enterperform.databinding.ActivityEventDetailsBinding
import com.dro.enterperform.utils.Constants

class EventDetailsActivity : AppCompatActivity() {

    lateinit var binding: ActivityEventDetailsBinding
    var desc = ""
    var name = ""
    var long = ""
    var lat = ""
    var cover = ""
    var date = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_event_details)


        intent.extras?.let {
            name = it.getString(Constants.EVENT_NAME)!!
            desc = it.getString(Constants.EVENT_DESCRIPTION)!!
            date = it.getString(Constants.EVENT_DATE)!!
            lat = it.getString(Constants.EVENT_LAT)!!
            long = it.getString(Constants.EVENT_LANG)!!
            cover = it.getString(Constants.EVENT_COVER)!!
        }

        binding.eventDescTextview.text = desc
        binding.eventNameTextview.text = name
        binding.dateTextview.text = date


        Glide
            .with(binding.root.context)
            .load(cover)
            .into(binding.coverIv)


    }

}