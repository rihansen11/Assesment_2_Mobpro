package org.d3if0081.assesment2.navigation

import org.d3if0081.assesment2.ui.screen.KEY_ID_ORDER


sealed class Screen (val route: String){
    data object  Home: Screen("mainScreen")
    data object  FormBaru: Screen("detailScreen")
    data object  FormUbah: Screen("detailScreen/{$KEY_ID_ORDER}"){
        fun withId(id: Long) = "detailScreen/$id"
    }
}