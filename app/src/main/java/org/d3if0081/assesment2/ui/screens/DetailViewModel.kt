package org.d3if0081.assesment2.ui.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.d3if0081.assesment2.database.OrderDao
import org.d3if0081.assesment2.model.Order

class DetailViewModel (private val dao: OrderDao): ViewModel() {

    fun insert(nama:String, kiloan:String, jenisLaundry: String){
        val order = Order (
            nama = nama,
            kiloan = kiloan,
            jenisLaundry = jenisLaundry
        )
        viewModelScope.launch (Dispatchers.IO){
            dao.insert(order)
        }
    }

    suspend fun getOrder(id:Long): Order?{
        return dao.getOrderById(id)
    }

    fun  update(id: Long, nama: String,kiloan: String,jenisLaundry: String){
        val order = Order(
            id = id,
            nama = nama,
            kiloan = kiloan,
            jenisLaundry = jenisLaundry
        )
        viewModelScope.launch (Dispatchers.IO){
            dao.update(order)
        }

    }

    fun delete(id: Long){
        viewModelScope.launch(Dispatchers.IO){
            dao.deleteById(id)
        }
    }

}