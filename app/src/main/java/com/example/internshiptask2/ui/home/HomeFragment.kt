package com.example.internshiptask2.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.internshiptask2.data.model.HeritageSite
import com.example.internshiptask2.databinding.FragmentHomeBinding
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val jsonString = loadJsonFromAssets()

        val type = object : TypeToken<List<HeritageSite>>() {}.type
        val heritageList: List<HeritageSite> = Gson().fromJson(jsonString, type)

        val adapter = HeritageAdapter(heritageList)

        binding.recyclerViewHeritage.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerViewHeritage.adapter = adapter
    }

    private fun loadJsonFromAssets(): String {
        return requireContext().assets.open("heritage.json")
            .bufferedReader()
            .use { it.readText() }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
