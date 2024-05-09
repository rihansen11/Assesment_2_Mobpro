package org.d3if0081.assesment2.ui.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import org.d3if0081.assesment2.database.OrderDao
import org.d3if0081.assesment2.model.Order

class MainViewModel(dao: OrderDao) : ViewModel() {

    val data : StateFlow<List<Order>> = dao.getOrder().stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000L),
        initialValue = emptyList()
    )

}