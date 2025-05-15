package com.example.confeitechmobile.cliente

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
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
import com.example.confeitechmobile.adm.card
import com.example.confeitechmobile.dto.BoloDTO
import com.example.confeitechmobile.model.CardapioViewModel
import com.example.confeitechmobile.ui.theme.ConfeitechMobileTheme

@Composable
fun Destaque(navController: NavController ,boloDestaque: BoloDTO){
    Row(
        Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier
                .height(520.dp)
                .width(350.dp)
                .background(
                    color = Color(0XFFF28181),
                    shape = RoundedCornerShape(20.dp)
                ),

            ) {
            Column {
                Spacer(Modifier.height(10.dp))
                Row(
                    Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {

                    Text(
                        "Destaque",
                        style = TextStyle(
                            fontSize = 40.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF481F1F)
                        )
                    )
                }
                Spacer(Modifier.height(10.dp))
                Row(
                    Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {

                    Image(
                        painter = painterResource(R.drawable.bolochocolate),
                        contentDescription = "imagem de alguma coisa",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .width(320.dp)
                            .height(320.dp)
                            .clip(RoundedCornerShape(10.dp))
                    )
                }

                Spacer(Modifier.height(20.dp))

                Row(
                    Modifier.padding(start = 20.dp),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        "${boloDestaque.nome}",
                        style = TextStyle(
                            fontSize = 30.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = Color(0xFF481F1F)
                        )
                    )
                }

                Row(
                    Modifier.padding(top = 20.dp, start = 20.dp),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        "R$ ${boloDestaque.preco}",
                        style = TextStyle(
                            fontSize = 30.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF481F1F)
                        )
                    )
                    Spacer(Modifier.width(30.dp))

                    Button(
                        onClick = { navController.navigate("telaEncomenda") },
                        modifier = Modifier
                            .height(40.dp)
                            .width(165.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF481F1F),
                            contentColor = Color.White
                        ),
                        shape = RoundedCornerShape(100.dp),
                    ) {
                        Text(
                            "Comprar",
                            style = TextStyle(
                                fontSize = 20.sp,
                            )
                        )
                        Spacer(Modifier.width(5.dp))
                        Icon(
                            imageVector = Icons.Default.ShoppingCart,
                            contentDescription = "Ícone do botão",
                            tint = Color.White,
                            modifier = Modifier
                        )
                    }
                }

            }
        }
    }

}

@Composable
fun cardCardapio(image: Painter, texto: String, boloDTO: BoloDTO, navController: NavController) {
    Spacer(Modifier.width(7.dp))
    Box(
        Modifier
            .height(260.dp)
            .width(190.dp)
            .background(
                color = Color(0xFFC481F1F),
                shape = RoundedCornerShape(10.dp)
            )

    ) {
        Column {
            Box(
                Modifier
                    .fillMaxWidth()
                    .height(125.dp)
            ) {
                Image(
                    painter = image,
                    contentDescription = "imagem de alguma coisa",
                    modifier = Modifier
                        .width(210.dp)
                        .height(138.dp)
                        .clip(RoundedCornerShape(topStart = 10.dp, topEnd = 10.dp)),
                    contentScale = ContentScale.Crop,
                )
            }
            Spacer(Modifier.height(5.dp))
            Text(
                "${boloDTO.nome}",
                style = TextStyle(
                    fontSize = 25.sp,
                    color = Color.White
                ),
                modifier = Modifier.padding(start = 5.dp)
            )
            Spacer(Modifier.height(5.dp))
            Text(
                "R$ ${boloDTO.preco}",
                style = TextStyle(
                    fontSize = 30.sp,
                    color = Color.White
                ),
                modifier = Modifier.padding(start = 5.dp)
            )
            Spacer(Modifier.height(5.dp))
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
                Button(
                    onClick = { navController.navigate("telaEncomenda") },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFF28181),
                        contentColor = Color.White
                    ),
                    modifier = Modifier
                        .height(40.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.ShoppingCart,
                        contentDescription = "Ícone do botão",
                        tint = Color(0xFFC481F1F),
                        modifier = Modifier
                    )
                }
                Spacer(Modifier.width(10.dp))
            }
        }
    }
    Spacer(Modifier.width(7.dp))
}

@Composable
fun nav(navController: NavController) {
    var valorA by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(top = 40.dp)) {
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            OutlinedTextField(
                value = valorA,
                onValueChange = { valorA = it },
                modifier = Modifier.height(50.dp),
                label = { Text("Pesquisar") },
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Filled.Search,
                        contentDescription = "Carrinho de compras"
                    )
                },
                shape = RoundedCornerShape(100.dp)
            )
            Spacer(modifier = Modifier.width(20.dp))
            Icon(
                imageVector = Icons.Filled.ShoppingCart,
                contentDescription = "Carrinho de compras",
                modifier = Modifier.height(55.dp)
                    .clickable{
                        navController.navigate("telaAdministrador")
                    }
            )
        }
        Spacer(modifier = Modifier.height(20.dp))

    }
}

@Composable
fun botoesEncomendaCardapio(navController: NavController) {
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
                containerColor = Color(0xFF481F1F),
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
                containerColor = Color(0xFFFF7070),
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
fun Arrumacao(bolo1: BoloDTO, bolo2: BoloDTO, navController: NavController) {
    Spacer(Modifier.height(14.dp))
    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
        cardCardapio(painterResource(R.drawable.bolobaunilha), "a", bolo1, navController)
        cardCardapio(painterResource(R.drawable.bolobaunilha), "a", bolo2, navController)
    }
}
@Composable
fun ArrumacaoUmBolo(bolo1: BoloDTO, navController: NavController) {
    Spacer(Modifier.height(14.dp))
    Row(Modifier.fillMaxWidth().padding(start = 2.dp)) {
        cardCardapio(painterResource(R.drawable.bolobaunilha), "a", bolo1, navController)
    }
}

@Composable
fun TelaCardapio(
    viewModel: CardapioViewModel,
    navController: NavController
) {
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .height(1500.dp)
            .fillMaxWidth()
            .background(
                brush = Brush.horizontalGradient(
                    colors = listOf(
                        Color(255, 180, 180),
                        Color.White
                    )
                ),
            )
    ) {

        var bolos by remember { mutableStateOf<List<BoloDTO>>(emptyList()) }


        LaunchedEffect(Unit) {
            bolos = viewModel.carregarCardapio()
        }

        val carregando = viewModel.isChamandoApi()


        nav(navController)
        botoesEncomendaCardapio(navController)
        Spacer(Modifier.height(30.dp))

        if (carregando) {
            Text("Carregando...")
        } else if (bolos.isEmpty()) {

        } else {
            Destaque(navController,bolos[0])
        }

        Spacer(Modifier.height(20.dp))

        Spacer(Modifier.height(20.dp))

        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            Text(
                "Cardápio",
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFFC481F1F)
                )
            )
        }
        Spacer(Modifier.height(20.dp))

        if (carregando) {
            Text("Carregando...")
        } else if (bolos.isEmpty()) {
            Text("Nenhuma encomenda encontrada")
        } else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
            ) {

                items(bolos.size) { index ->
                    if (index % 2 == 0 && index.equals(bolos.size - 1)){
                        ArrumacaoUmBolo(bolo1 = bolos[index], navController)
                    }else if (index % 2 == 0) {
                        Arrumacao(bolo1 = bolos[index], bolo2 = bolos[index + 1], navController)
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
fun showCardapioCliente() {
    ConfeitechMobileTheme {
        TelaCardapio(
            viewModel = CardapioViewModel(),
            navController = rememberNavController()
        )
    }
}