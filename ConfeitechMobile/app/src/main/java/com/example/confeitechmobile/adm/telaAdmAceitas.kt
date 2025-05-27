package com.example.confeitechmobile.adm

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.material3.AlertDialog
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
import com.example.confeitechmobile.R
import com.example.confeitechmobile.dto.EncomendaDTO
import com.example.confeitechmobile.ui.theme.ConfeitechMobileTheme
import com.example.confeitechmobile.viewmodel.EncomendaViewModel

@Composable
fun botoesPendentesAceitaEncomendaAceita(navController: NavController) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {

        Button(
            onClick = { navController.navigate("telaAdministrador") },
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
                "Pendentes",
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            )
        }
        Button(
            onClick = { },
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
fun cardAceita(
    encomendaDTO: EncomendaDTO,
    viewModel: EncomendaViewModel,
    navController: NavController
) {
    var showDialog by remember { mutableStateOf(false) }
    var status by remember { mutableStateOf(encomendaDTO.andamento ?: "EM PREPARO") }

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
            Image(
                painter = painterResource(R.drawable.bolobolopng),
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

                Text("retirada: ${encomendaDTO.dataRetirada ?: "Data não informada"}", color = Color.White)
                Text("R$ ${encomendaDTO.preco ?: "Preço indefinido"}", color = Color.White)
                Text("Cliente: ${encomendaDTO.userDTO?.nome ?: "Nome não informado"}", color = Color.White)

                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    // ✅ Este texto abre o AlertDialog ao ser clicado
                    Text(
                        text = status,
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 25.sp,
                        modifier = Modifier.clickable { showDialog = true }
                    )
                    Icon(
                        imageVector = Icons.Default.Edit,
                        contentDescription = "Ícone do botão",
                        tint = Color.White
                    )
                }
            }
        }
    }

    if (showDialog) {
        AlertDialog(
            onDismissRequest = { showDialog = false },
            title = { Text("Alterar status") },
            text = {
                Column {
                    val options = listOf("EM PREPARO", "RECUSADO", "FINALIZADO")
                    options.forEach { option ->
                        Text(
                            text = option,
                            fontSize = 18.sp,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 8.dp)
                                .clickable {
                                    status = option
                                    showDialog = false
                                    // Aqui você pode chamar viewModel para atualizar no backend
                                    // viewModel.atualizarStatus(encomendaDTO.id, option)
                                }
                        )
                    }
                }
            },
            confirmButton = {
                Button(onClick = { showDialog = false }) {
                    Text("Cancelar")
                }
            }
        )
    }
}




@Composable
fun telaAdministradorEncomendaAceita(
    viewModel: EncomendaViewModel,
    modifier: Modifier = Modifier,
    navController: NavController = rememberNavController()
) {
    val lista = viewModel.lista
    val carregando = viewModel.isChamandoApi()
    val erros = viewModel.erros

    var valorA by remember { mutableStateOf("") }

    // 🔄 Chamada à API para buscar encomendas aceitas
    androidx.compose.runtime.LaunchedEffect(Unit) {
        viewModel.carregarEncomendasAceitas()
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(Color(0xFFFFCFCF), Color(0xFFFFFFFF))
                )
            )
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(modifier = Modifier.height(30.dp))
        Text(text = "Cakes Aricroce")

        Row {
            OutlinedTextField(
                value = valorA,
                onValueChange = { valorA = it },
                label = { Text("Pesquisar") },
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Filled.Search,
                        contentDescription = "Buscar",
                        modifier = Modifier.width(20.dp)
                    )
                },
                shape = RoundedCornerShape(40.dp),
            )
        }

        // ... demais componentes ...

        Spacer(Modifier.height(10.dp))
        botoesPendentesAceitaEncomendaAceita(navController)
        Spacer(Modifier.height(20.dp))

        if (carregando) {
            Text(text = "Carregando...")
        } else if (lista.isEmpty()) {
            Text(text = "Nenhuma encomenda encontrada")
        } else {
            LazyColumn {
                items(lista.size) { index ->
                    val encomenda = lista[index]
                    // Exibir só encomendas com status ACEITO (ajustar conforme o nome real)

                        cardAceita(encomenda, viewModel, navController)

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
fun showTelaEncomendasAceitasAdm() {
    ConfeitechMobileTheme {
        val navController = rememberNavController()
        telaAdministradorEncomendaAceita(
            viewModel = EncomendaViewModel(),
            navController = navController
        )
    }

}