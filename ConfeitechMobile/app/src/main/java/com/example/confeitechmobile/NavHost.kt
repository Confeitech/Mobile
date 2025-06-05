
package com.example.confeitechmobile

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
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
    NavHost(navController = navController,
//    INICIO PADRÃO
        startDestination = "telaLogin"

//    INICIO CLIENTE
//                startDestination = "telaCardapio"

//    INICIO ARI
//                startDestination = "telaAdministrador"
    ) {
        composable("telaLogin") {
            telaLogin(navController = navController, viewModel = loginViewModel())
        }
        composable("telaCadastro") {
            telaCadastro(navController = navController, viewModel = loginViewModel())
        }

        // CLIENTE
        composable("telaCardapio") {
            TelaCardapio(
                viewModel = CardapioViewModel(),
                navController = navController
            )
        }
        composable("telaEncomenda/{id}") { backStackEntry ->
            val id = backStackEntry.arguments?.getString("id")?.toIntOrNull()
            if (id != null) {
                TelaEncomenda(navController = navController, identificadorBolo = id, viewModel = CardapioViewModel(), encomendaViewModel = EncomendaViewModel())
            } else {
                // Tratamento caso o ID seja inválido (ex: redirecionar ou mostrar erro)
                LaunchedEffect(Unit) {
                    navController.popBackStack()
                }
            }
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
