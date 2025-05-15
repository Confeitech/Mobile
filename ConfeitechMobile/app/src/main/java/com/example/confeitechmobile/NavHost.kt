
package com.example.confeitechmobile

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.confeitechmobile.adm.telaAdministrador
import com.example.confeitechmobile.adm.telaAdministradorEncomendaAceita
import com.example.confeitechmobile.cliente.TelaCardapio
import com.example.confeitechmobile.cliente.TelaEncomenda
import com.example.confeitechmobile.cliente.telaEncomendasCliente
import com.example.confeitechmobile.loginCadastro.telaCadastro
import com.example.confeitechmobile.loginCadastro.telaLogin
import com.example.confeitechmobile.model.CardapioViewModel
import com.example.confeitechmobile.model.loginViewModel
import com.example.confeitechmobile.viewmodel.EncomendaViewModel

@Composable
fun AppNavigation(viewModel: EncomendaViewModel) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "telaLogin") {
        composable("telaLogin") {
            telaLogin(navController = navController, viewModel = loginViewModel())
        }
        composable("telaCadastro") {
            telaCadastro(navController = navController)
        }

        // CLIENTE
        composable("telaCardapio") {
            TelaCardapio(
                viewModel = CardapioViewModel(),
                navController = navController
            )
        }
        composable("telaEncomenda") {
            TelaEncomenda(navController = navController)
        }
        composable("telaEncomendasCliente") {
            telaEncomendasCliente( navController = navController )
        }

//        ADM
        composable("telaAdministrador") {
            telaAdministrador(
                viewModel = viewModel,
                navController = navController,
            )
        }
        composable("telaAdministradorEncomendaAceita") {
            telaAdministradorEncomendaAceita(
                viewModel = viewModel,
                navController = navController,
            )
        }
        // Adicione mais telas conforme necessário
    }
}
