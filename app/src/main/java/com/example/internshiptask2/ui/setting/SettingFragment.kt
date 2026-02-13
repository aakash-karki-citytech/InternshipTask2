package com.example.internshiptask2.ui.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.internshiptask2.MyApp
import com.example.internshiptask2.data.local.entity.SettingEntity
import com.example.internshiptask2.databinding.FragmentSettingBinding
import kotlinx.coroutines.launch

class SettingFragment : Fragment() {

    private var _binding: FragmentSettingBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: SettingAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentSettingBinding.inflate(inflater, container, false)

        adapter = SettingAdapter(emptyList())
        binding.rvSettings.layoutManager = LinearLayoutManager(requireContext())
        binding.rvSettings.adapter = adapter

        loadSettings()

        binding.btnSave.setOnClickListener {

            val title = binding.etTitle.text.toString()
            val value = binding.etValue.text.toString()

            if (title.isNotEmpty() && value.isNotEmpty()) {

                lifecycleScope.launch {

                    MyApp.database.settingDao()
                        .insertSetting(SettingEntity(title = title, value = value))

                    loadSettings()
                }

                binding.etTitle.text?.clear()
                binding.etValue.text?.clear()
            }
        }

        return binding.root
    }

    private fun loadSettings() {
        lifecycleScope.launch {
            MyApp.database.settingDao().getAllSettings().collect { list ->
                adapter.updateData(list)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
