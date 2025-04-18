// AppNavigation.kt
package com.example.confeitechmobile

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.confeitechmobile.adm.telaAdministrador
import com.example.confeitechmobile.cliente.TelaEncomenda
import com.example.confeitechmobile.cliente.telaEncomendasCliente
import com.example.confeitechmobile.viewmodel.EncomendaViewModel

@Composable
fun AppNavigation(viewModel: EncomendaViewModel) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "telaEncomenda") {
        composable("telaEncomenda") {
            TelaEncomenda(navController = navController)
        }
        composable("telaEncomendasCliente") {
            telaEncomendasCliente()
        }
        composable("telaAdministrador") {
            telaAdministrador(viewModel = viewModel)
        }
        // Adicione mais telas conforme necessário
    }
}
