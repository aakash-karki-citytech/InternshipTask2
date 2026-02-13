package com.example.internshiptask2.ui.guides

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.example.internshiptask2.data.api.RetrofitClient
import com.example.internshiptask2.data.model.User
import com.example.internshiptask2.databinding.FragmentGuidesBinding
import kotlinx.coroutines.launch

class GuidesFragment : Fragment() {

    private var _binding: FragmentGuidesBinding? = null
    private val binding get() = _binding!!

    private val users = mutableListOf<User>()
    private lateinit var adapter: GuidesAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGuidesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = GuidesAdapter(users, object : GuidesClickListener{
            override fun onEdit() {
                TODO("Not yet implemented")
            }

            override fun onDelete() {
                TODO("Not yet implemented")
            }
        })
        binding.recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.recyclerView.adapter = adapter


        fetchUsers()
    }

    private fun fetchUsers() {
        lifecycleScope.launch {
            try {
                val response = RetrofitClient.api.User()
                users.addAll(response)
                adapter.notifyDataSetChanged()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
