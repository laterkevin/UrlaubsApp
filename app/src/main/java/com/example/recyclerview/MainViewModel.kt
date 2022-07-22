
package com.example.recyclerview

import androidx.lifecycle.ViewModel
import com.example.recyclerview.data.Repository

class MainViewModel : ViewModel() {

    private val repo = Repository()

    val vacations = repo.vacations

    val categories = repo.categories

    // wird immer ausgeführt wenn ein neues Viewmodel erstellt wird
    init {
        // TODO rufe loadVacations() des Repositories auf
        repo.loadVacations()
    }
}