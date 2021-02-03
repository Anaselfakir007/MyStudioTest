package com.mystudio.developerstestapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.mystudio.developerstestapp.adapters.developer.DeveloperAdapter
import com.mystudio.developerstestapp.adapters.developer.DeveloperViewHolder
import com.mystudio.developerstestapp.api.DevelopersHelper
import com.mystudio.developerstestapp.api.builder.ApiBuilder
import com.mystudio.developerstestapp.data.Resource
import com.mystudio.developerstestapp.data.response.DataDevelopers
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), DeveloperViewHolder.ViewListener,
    SwipeRefreshLayout.OnRefreshListener {
    private lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupViewModel()
        getDevelopers()
        swipeRefresh.setOnRefreshListener { this }
    }

    private fun setupViewModel() {
        viewModel = ViewModelProviders.of(
            this,
            ViewModelFactory(DevelopersHelper(ApiBuilder.apiService))
        ).get(MainViewModel::class.java)
    }

    private fun getDevelopers() {
        viewModel.getDevelopers().observe(this, Observer {

            it?.let { resource ->
                when (resource.status) {
                    Resource.Status.SUCCESS -> {
                        recyclerDevelopers.visibility = View.VISIBLE
                        progressBar.visibility = View.GONE
                        val adapter = DeveloperAdapter(this)
                        swipeRefresh.isRefreshing = false
                        recyclerDevelopers.layoutManager = LinearLayoutManager(applicationContext)
                        resource.data?.let { developers ->
                            recyclerDevelopers.adapter = adapter
                            adapter.setItems(developers.list)
                        }
                    }
                    Resource.Status.ERROR -> {
                        recyclerDevelopers.visibility = View.VISIBLE
                        progressBar.visibility = View.GONE
                        swipeRefresh.isRefreshing = false
                        Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                    }
                    Resource.Status.LOADING -> {
                        swipeRefresh.isRefreshing = false
                        progressBar.visibility = View.VISIBLE
                        recyclerDevelopers.visibility = View.GONE
                    }
                }
            }
        })

    }

    override fun onDeveloperClicked(item: DataDevelopers.DataDeveloper) {
        startActivity(Intent(this, DetailActivity::class.java).apply {
            putExtra(
                "developer",
                item
            )
        })
    }

    override fun onRefresh() {
        swipeRefresh.isRefreshing = false
        getDevelopers()
    }
}