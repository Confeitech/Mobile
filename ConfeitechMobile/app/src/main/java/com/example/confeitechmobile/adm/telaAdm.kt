package com.example.confeitechmobile.adm

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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import com.example.confeitechmobile.dto.AndamentoEncomenda
import com.example.confeitechmobile.dto.EncomendaDTO
import com.example.confeitechmobile.ui.theme.ConfeitechMobileTheme
import com.example.confeitechmobile.viewmodel.EncomendaViewModel

@Composable
fun botoesPendentesAceita(navController: NavController) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {

        Button(
            onClick = {  },
            modifier = Modifier
                .height(40.dp)
                .width(165.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF481F1F),
                contentColor = Color.White
            ),
            shape = RoundedCornerShape(topStart = 100.dp, bottomStart = 100.dp)
        ) {
            Text(
                "Pendentes",
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            )
        }
        Button(
            onClick = { navController.navigate("telaAdministradorEncomendaAceita") },
            modifier = Modifier
                .height(40.dp)
                .width(165.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFFF7070),
                contentColor = Color.White
            ),
            shape = RoundedCornerShape(topEnd = 100.dp, bottomEnd = 100.dp)
        ) {
            Text(
                "Aceitas",
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            )
        }
    }
}

@Composable
fun card(encomendaDTO: EncomendaDTO, viewModel: EncomendaViewModel, navController: NavController) {
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
                model = encomendaDTO?.bolo?.image, // A URL da imagem
                contentDescription = "Imagem do Red Velvet",
                modifier = Modifier.size(120.dp),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.width(10.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    encomendaDTO.bolo?.nome ?: "Bolo Desconhecido",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    color = Color(android.graphics.Color.parseColor("#FFD9D9"))
                )

                Text(
                    "retirada: ${encomendaDTO.dataRetirada ?: "Data não informada"}",
                    color = Color.White,
                    fontSize = 14.sp
                )
                Text(
                    "R$ ${encomendaDTO.preco ?: "Preço indefinido"}",
                    color = Color.White,
                    fontSize = 14.sp
                )
                Text(
                    "Cliente: ${encomendaDTO?.userDTO?.nome ?: "Preço indefinido"}",
                    color = Color.White,
                    fontSize = 14.sp
                )
                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(), // Preenche a largura total
                    horizontalArrangement = Arrangement.End  // Alinhamento à direita
                ) {

                    Button(
                        onClick = {
                            viewModel.atualizarAndamentoEncomenda(
                                encomendaDTO.id!!,
                                AndamentoEncomenda.EM_PREPARO,
                            )
                            viewModel.atualizarLista()
                            navController.navigate("telaAdministradorEncomendaAceita")
                        },
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF6BCF6B)),
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Text("✔", color = Color.Black, fontSize = 18.sp)
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    Button(
                        onClick = {
                            viewModel.atualizarAndamentoEncomenda(
                                encomendaDTO.id!!,
                                AndamentoEncomenda.CANCELADA
                            )
                        },
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFEE6C6C)),
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Text("✖", color = Color.Black, fontSize = 18.sp)
                    }
                }
            }


        }


    }
}

@Composable
fun telaAdministrador(
    viewModel: EncomendaViewModel,
    modifier: Modifier = Modifier,
    navController: NavController = rememberNavController() // valor padrão
) {
    // Chama a função atualizarLista() Aqui
    LaunchedEffect(Unit) {
        viewModel.atualizarLista()
    }
    var lista = viewModel.lista
    var carregando = viewModel.isChamandoApi()
    var erros = viewModel.erros

    var valorA by remember { mutableStateOf("") }



    Column(
        modifier = modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(Color(0xFFFFCFCF), Color(0xFFFFFFFF))
                )
            )
            .fillMaxSize()  // Preenche toda a tela
            .padding(16.dp),  // Adiciona padding ao redor
        horizontalAlignment = Alignment.CenterHorizontally,  // Centraliza horizontalmente
    )
    {
        Spacer(modifier = Modifier.height(30.dp))
        Text(text = "Cakes Aricroce")

        Row {

            OutlinedTextField(


                value = valorA,
                onValueChange = { valorA = it },
                label = { Text("Pesquisar") },
                trailingIcon = {
                    // Adiciona o ícone da lupa dentro da caixa de texto
                    Icon(
                        imageVector = Icons.Filled.Search,
                        contentDescription = "Carrinho de compras",
                        modifier = Modifier.width(20.dp)
                    )
                },
                shape = RoundedCornerShape(40.dp),


                )


        }

        Spacer(Modifier.height(10.dp))

        botoesPendentesAceita(navController)

        Spacer(Modifier.height(20.dp))

        if (carregando) {
            Text(text = "Carregando...")
        } else if (lista.isEmpty()) {
            Text(text = "Nenhuma encomenda encontrada")
        } else {
            LazyColumn {
                items(lista.size) { index ->
                    val encomenda = lista[index]
                    if (encomenda.andamento == "AGUARDANDO"){
                        card(encomenda, viewModel, navController)
                    }
                }
            }
        }
    }

}

@Preview(
    showBackground = true,
    showSystemUi = true,
    device = Devices.PIXEL_2
)
@Composable
fun showTelaEncomendasPendenteAdm() {
    ConfeitechMobileTheme {
        val navController = rememberNavController()
        telaAdministrador(
            viewModel = EncomendaViewModel(),
            navController = navController
        )
    }

}