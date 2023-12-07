package com.example.module

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.module.HomeFragment

class HomeFragment : Fragment() {

    private lateinit var viewModel: ExampleViewModel
    private lateinit var adapter: ExampleAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        viewModel = ViewModelProvider(this).get(ExampleViewModel::class.java)

        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerView)
        adapter = ExampleAdapter()

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        viewModel.dataList.observe(viewLifecycleOwner, Observer {
            adapter.submitList(it)
        })

        return view
    }
}
