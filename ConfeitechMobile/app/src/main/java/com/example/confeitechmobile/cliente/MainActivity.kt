package com.example.confeitechmobile.cliente

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.example.confeitechmobile.R
import com.example.confeitechmobile.UsuarioSessao
import com.example.confeitechmobile.dto.AndamentoEncomenda
import com.example.confeitechmobile.dto.EncomendaDTO
import com.example.confeitechmobile.ui.theme.ConfeitechMobileTheme
import com.example.confeitechmobile.viewmodel.EncomendaViewModel

@Composable
fun botoesEncomenda(navController: NavController) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {

        Button(
            onClick = { navController.navigate("telaCardapio") },
            modifier = Modifier
                .height(40.dp)
                .width(165.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFFF7070),
                contentColor = Color.White
            ),
            shape = RoundedCornerShape(topStart = 100.dp, bottomStart = 100.dp)
        ) {
            Text(
                "Cardápio",
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            )
        }
        Button(
            onClick = { navController.navigate("telaEncomendasCliente") },
            modifier = Modifier
                .height(40.dp)
                .width(165.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF481F1F),
                contentColor = Color.White
            ),
            shape = RoundedCornerShape(topEnd = 100.dp, bottomEnd = 100.dp)
        ) {
            Text(
                "Encomendas",
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            )
        }
    }
}


@Composable
fun cardTelaEncomendasCliente(encomenda: EncomendaDTO, viewModel: EncomendaViewModel) {
    var status = "Aguardando";
    if (encomenda.andamento.equals("AGUARDANDO")) {
        status = "Aguardando"
    } else if (encomenda.andamento.equals("EM_PREPARO")) {
        status = "Preparando"
    } else if (encomenda.andamento.equals("CANCELADA")) {
        status = "Cancelada"
    } else if (encomenda.andamento.equals("PRONTA") ) {
        status = "Pronta"
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .background(Color(0xFF481F1F), RoundedCornerShape(16.dp))
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                model = encomenda?.bolo?.image, // A URL da imagem
                contentDescription = "Imagem do Red Velvet",
                modifier = Modifier.size(120.dp),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.width(10.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    "${encomenda?.bolo?.nome}",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    color = Color.White
                )
                Text("retirada: ${encomenda.dataRetirada}", color = Color.White, fontSize = 14.sp)
                Text("R$${encomenda.preco}", color = Color.White, fontSize = 14.sp)
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    "${status}",
                    color = Color(0xFFE8C547),
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    Button(
                        onClick = {
                            viewModel.atualizarAndamentoEncomenda(
                                encomenda.id!!,
                                AndamentoEncomenda.CANCELADA
                            )
                        },
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFEE6C6C)),
                        shape = RoundedCornerShape(16.dp)
                    ) {
                        Text("Cancelar", color = Color.Black)
                    }
                }
            }
        }
    }
}


@Composable
fun telaEncomendasCliente(
    modifier: Modifier = Modifier,
    viewModel: EncomendaViewModel = androidx.lifecycle.viewmodel.compose.viewModel(),
    navController: NavController
) {
    val listaEncomendas = viewModel.lista
    val carregando = viewModel.isChamandoApi()
    val erros = viewModel.erros

    // Faz a requisição ao abrir a tela
    LaunchedEffect(Unit) {
        viewModel.carregarEncomendasPorUsuario(UsuarioSessao.idUsuario!!)
    }

    Column(
        modifier = modifier
            .background(
                brush = Brush.horizontalGradient(
                    colors = listOf(
                        Color(255, 180, 180),
                        Color.White
                    )
                ),
            )
            .verticalScroll(rememberScrollState())
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        nav(navController)
        botoesEncomenda(navController)
        Spacer(Modifier.height(20.dp))

        // Mostra mensagem de carregamento
        if (carregando) {
            Text("Carregando encomendas...")
        }

        // Exibe os cards dinamicamente com base na resposta da API
        listaEncomendas.forEach { encomenda ->
            cardTelaEncomendasCliente(encomenda, viewModel)
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}


@Preview(
    showBackground = true,
    showSystemUi = true,
    device = Devices.PIXEL_2
)
@Composable
fun showTelaEncomendasCliente() {
    ConfeitechMobileTheme {
        telaEncomendasCliente(
            navController = rememberNavController()
        )
    }
}
