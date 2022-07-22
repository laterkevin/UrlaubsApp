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
import com.example.recyclerview.adapter.VacationAdapter
import com.example.recyclerview.databinding.FragmentCategoryBinding

class CategoryFragment : Fragment() {

    private lateinit var binding: FragmentCategoryBinding

    // TODO lade mit Hilfe von activityViewModels() das MainViewModel
    private val viewModel: MainViewModel by activityViewModels()

    private var category: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // TODO lade die richtige category aus den arguments
        category = viewModel.categories[0].name

//        val categories = Repository().categories
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_category,
            container,
            false
        )

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        // TODO filtere mit Hilfe der category die vacations des ViewModels
        //  danach lade in die categoryRecycler die gefilterte Liste
        //  benutze dafür den VacationAdapter
        //  (das ganze sollte innerhalb eines Observers geschehen)
        //  optional: lade in category background ein zufälliges Bild der gefilterten Liste
        viewModel.vacations.observe(viewLifecycleOwner) {
            val filteredList = it.filter { it.category == category }

            binding.categoryRecycler.adapter =
                this.context?.let { it1 -> VacationAdapter(it1, filteredList) }
        }
    }
}