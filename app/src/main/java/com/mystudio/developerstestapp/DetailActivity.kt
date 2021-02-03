package com.mystudio.developerstestapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.mystudio.developerstestapp.data.response.DataDevelopers
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.view_developer.view.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        val developer = intent.extras?.get("developer") as DataDevelopers.DataDeveloper
        name.text = developer.name
        description.text = developer.name
        etat.text = developer.hired.toString()
        Glide.with(applicationContext).load(developer.picture).dontAnimate().into(imageDeveloper)
    }
}
