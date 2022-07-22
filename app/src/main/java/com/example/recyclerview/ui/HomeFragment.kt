
package com.example.recyclerview.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.recyclerview.MainViewModel
import com.example.recyclerview.R
import com.example.recyclerview.adapter.CategoryAdapter
import com.example.recyclerview.databinding.FragmentHomeBinding
import java.util.*

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    // TODO lade mit Hilfe von activityViewModels() das MainViewModel
    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        // TODO stelle in der recyclerViewHome die categories des ViewModels dar
        //  benutze hierfür den CategoryAdapter

        binding.recyclerViewHome.adapter = CategoryAdapter(viewModel.categories)
    }
}