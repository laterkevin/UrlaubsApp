package com.example.recyclerview.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.recyclerview.R
import com.example.recyclerview.data.model.Category
import com.example.recyclerview.data.model.Vacation

class Repository {

    private val _vacations = MutableLiveData<List<Vacation>>()
    val vacations: LiveData<List<Vacation>>
        get() = _vacations

    val categories = listOf(
        Category(
            "beach",
            R.drawable.urlaub2
        ),
        Category(
            "city",
            R.drawable.urlaub5
        ),
        Category(
            "nature",
            R.drawable.urlaub9
        )
    )

    fun loadVacations() {
        _vacations.value = listOf(
            Vacation(1, R.string.preis1, R.drawable.urlaub1, "beach"),
            Vacation(2, R.string.preis2, R.drawable.urlaub2, "beach"),
            Vacation(3, R.string.preis3, R.drawable.urlaub3, "beach"),
            Vacation(4, R.string.preis4, R.drawable.urlaub4, "city"),
            Vacation(5, R.string.preis1, R.drawable.urlaub5, "city"),
            Vacation(6, R.string.preis2, R.drawable.urlaub6, "city"),
            Vacation(7, R.string.preis3, R.drawable.urlaub7, "city"),
            Vacation(8, R.string.preis4, R.drawable.urlaub8, "nature"),
            Vacation(9, R.string.preis1, R.drawable.urlaub9, "nature"),
            Vacation(10, R.string.preis2, R.drawable.urlaub10, "nature"),
            Vacation(11, R.string.preis3, R.drawable.urlaub11, "nature"),
            Vacation(12, R.string.preis4, R.drawable.urlaub12, "nature")
        )
    }
}
