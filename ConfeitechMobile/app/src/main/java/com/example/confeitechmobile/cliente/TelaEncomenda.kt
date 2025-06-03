package com.example.confeitechmobile.cliente

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxHeight
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
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.confeitechmobile.R
import com.example.confeitechmobile.ui.theme.ConfeitechMobileTheme
import androidx.navigation.compose.rememberNavController
import com.example.confeitechmobile.dto.BoloDTO
import com.example.confeitechmobile.model.CardapioViewModel
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.TextField
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import java.util.Calendar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TelaEncomenda(navController: NavController, modifier: Modifier = Modifier) {

    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .fillMaxHeight()
    ) {
        // IMAGEM
        Image(
            painter = painterResource(R.drawable.bolochocolate),
            contentDescription = "imagem de alguma coisa",
            modifier = Modifier
                .height(425.dp)
                .fillMaxWidth()
                .padding(top = 30.dp)
                .zIndex(1f),
            contentScale = ContentScale.Crop,
        )
        //PARTE DO FUNDO ROSA
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
                .absoluteOffset(y = (-19).dp)
                .zIndex(2f)
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color.White,
                            Color(255, 180, 180)
                        )
                    ),
                    shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)
                )
        ) {

            Column(modifier = Modifier.padding(top = 8.dp)) {
                // PARTE DO NOME DO BOLO E PREÇO
                Spacer(modifier = Modifier.height(10.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Spacer(
                        modifier = Modifier.weight(0.1f)
                    )
                    Text(
                        text = "Bolo de Chocolate",
                        modifier = Modifier.width(170.dp),
                        style = TextStyle(
                            fontSize = 30.sp,
                            fontStyle = FontStyle.Normal,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFFA41F1F)
                        ),
                    )
                    Spacer(modifier = Modifier.weight(0.1f))
                    Column(
                        modifier = Modifier
                            .weight(0.4f)
                            .height(90.dp)
                    ) {
                        Text(
                            text = "19,00",
                            modifier = Modifier.weight(0.1f),
                            style = TextStyle(
                                fontSize = 30.sp,
                                fontStyle = FontStyle.Normal,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFFA41F1F)
                            ),
                        )
                        Text(
                            text = "Tamanho: 1kg",
                            modifier = Modifier.weight(0.1f),
                            style = TextStyle(
                                fontSize = 15.sp,
                                fontStyle = FontStyle.Normal,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFFA41F1F)
                            ),
                        )
                    }
                }

                Spacer(
                    modifier = Modifier
                        .height(2.dp)
                        .fillMaxWidth()
                )

                // DESCRIÇÃO
                Row(
                    modifier = Modifier
                        .height(1.dp)
                        .background(color = Color.Black)
                        .fillMaxWidth()
                ) {}
                Spacer(
                    modifier = Modifier
                        .height(15.dp)
                        .fillMaxWidth()
                )
                Row {
                    Spacer(modifier = Modifier.width(40.dp))
                    Text(
                        text = "Descrição ∙",
                        style = TextStyle(
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFFED6565)
                        )
                    )
                }
                Spacer(modifier = Modifier.height(4.dp))
                Row {
                    Spacer(modifier = Modifier.weight(0.1f))
                    Text(
                        text = "Uma versão deliciosa do tradicional bolo de chocolate, com massa macia e vibrante.",
                        style = TextStyle(
                            fontSize = 15.sp,
                            color = Color(0xFF481F1F)
                        ),
                        modifier = Modifier.weight(0.8f)
                    )
                    Spacer(modifier = Modifier.weight(0.1f))
                }

                Spacer(modifier = Modifier.height(18.dp))

                Spacer(modifier = Modifier.height(20.dp))

                Row {
                    Spacer(modifier = Modifier.width(40.dp))

                    Text(
                        text = "Data de retirada",
                        style = TextStyle(
                            fontWeight = FontWeight.Bold
                        )
                    )
                }
                // Variáveis de estado
                val dias = (1..31).map { it.toString().padStart(2, '0') }
                val meses = (1..12).map { it.toString().padStart(2, '0') }
                val anoAtual = Calendar.getInstance().get(Calendar.YEAR)
                val anos = (anoAtual..(anoAtual + 2)).map { it.toString() }

                var diaSelecionado by remember { mutableStateOf(dias.first()) }
                var mesSelecionado by remember { mutableStateOf(meses.first()) }
                var anoSelecionado by remember { mutableStateOf(anos.first()) }

                var expandedDia by remember { mutableStateOf(false) }
                var expandedMes by remember { mutableStateOf(false) }
                var expandedAno by remember { mutableStateOf(false) }
                Row {
                    // Dia
                    ExposedDropdownMenuBox(
                        expanded = expandedDia,
                        onExpandedChange = { expandedDia = !expandedDia }
                    ) {
                        TextField(
                            value = diaSelecionado,
                            onValueChange = {},
                            readOnly = true,
                            label = { Text("Dia") },
                            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expandedDia) },
                            modifier = Modifier
                                .menuAnchor()
                                .weight(1f)
                        )
                        ExposedDropdownMenu(
                            expanded = expandedDia,
                            onDismissRequest = { expandedDia = false }
                        ) {
                            dias.forEach { dia ->
                                DropdownMenuItem(
                                    text = { Text(dia) },
                                    onClick = {
                                        diaSelecionado = dia
                                        expandedDia = false
                                    }
                                )
                            }
                        }
                    }
                    // Mês
                    ExposedDropdownMenuBox(
                        expanded = expandedMes,
                        onExpandedChange = { expandedMes = !expandedMes }
                    ) {
                        TextField(
                            value = mesSelecionado,
                            onValueChange = {},
                            readOnly = true,
                            label = { Text("Mês") },
                            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expandedMes) },
                            modifier = Modifier
                                .menuAnchor()
                                .weight(1f)
                        )
                        ExposedDropdownMenu(
                            expanded = expandedMes,
                            onDismissRequest = { expandedMes = false }
                        ) {
                            meses.forEach { mes ->
                                DropdownMenuItem(
                                    text = { Text(mes) },
                                    onClick = {
                                        mesSelecionado = mes
                                        expandedMes = false
                                    }
                                )
                            }
                        }
                    }


                }

                Spacer(modifier = Modifier.height(30.dp))

                Row(modifier = Modifier.align(Alignment.CenterHorizontally)) {
                    Button(
                        onClick = { navController.navigate("telaEncomendasCliente") },
                        modifier = Modifier
                            .height(80.dp)
                            .width(250.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFFE76060),
                            contentColor = Color.White
                        ),
                        shape = RoundedCornerShape(30.dp)
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.bolsadecompras),
                            contentDescription = "Ícone do botão",
                            modifier = Modifier.size(24.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            "Encomendar",
                            style = TextStyle(
                                fontSize = 30.sp,
                                fontWeight = FontWeight.Bold
                            )
                        )
                    }
                }
                Spacer(modifier = Modifier.height(40.dp))
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
fun showTelaDescricaoBolo() {
    ConfeitechMobileTheme {
        val navController = rememberNavController()
        TelaEncomenda(navController = navController)
    }
}
