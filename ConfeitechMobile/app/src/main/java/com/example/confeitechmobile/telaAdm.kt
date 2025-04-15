package com.example.confeitechmobile

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
import com.example.confeitechmobile.ui.theme.ConfeitechMobileTheme

@Composable
fun botoesPendentesAceita() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {

        Button(
            onClick = { },
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
            onClick = { },
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
fun telaAdministrador(modifier: Modifier = Modifier) {


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


        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            horizontalArrangement = Arrangement.SpaceEvenly, // Espaçamento uniforme
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Ícone 1 - Bolo
            Box(
                modifier = Modifier
                    .size(60.dp)
                    .background(Color(0xFFFF4A4A), shape = CircleShape), // Cor vermelha arredondada
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(R.drawable.imagebolo), // Substitua pelo seu recurso
                    contentDescription = "Ícone Bolo",
                    modifier = Modifier.size(30.dp)
                )
            }

            // Ícone 2 - Sacola de compras
            Box(
                modifier = Modifier
                    .size(60.dp)
                    .background(Color(0xFF4A1A1A), shape = CircleShape), // Cor marrom arredondada
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(R.drawable.bolsadecompras), // Substitua pelo seu recurso
                    contentDescription = "Ícone Sacola",
                    modifier = Modifier.size(30.dp)
                )
            }

            // Ícone 3 - Cupcake
            Box(
                modifier = Modifier
                    .size(60.dp)
                    .background(Color(0xFFFF4A4A), shape = CircleShape), // Cor vermelha arredondada
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(R.drawable.bolinho), // Substitua pelo seu recurso
                    contentDescription = "Ícone Cupcake",
                    modifier = Modifier.size(35.dp)
                )
            }
        }

        Spacer(Modifier.height(10.dp))

        botoesPendentesAceita()

        Spacer(Modifier.height(20.dp))

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
                        "Red velvet x3",
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        color = Color(android.graphics.Color.parseColor("#FFD9D9"))
                    )

                    Text("retirada: 02-03-2025", color = Color.White, fontSize = 14.sp)
                    Text("R$17,97", color = Color.White, fontSize = 14.sp)
                    Spacer(modifier = Modifier.height(8.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(), // Preenche a largura total
                        horizontalArrangement = Arrangement.End  // Alinhamento à direita
                    ) {

                        Button(
                            onClick = { /* Aceitar pedido */ },
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF6BCF6B)),
                            shape = RoundedCornerShape(12.dp)
                        ) {
                            Text("✔", color = Color.Black, fontSize = 18.sp)
                        }
                        Spacer(modifier = Modifier.height(8.dp))
                        Button(
                            onClick = { /* Cancelar pedido */ },
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFEE6C6C)),
                            shape = RoundedCornerShape(12.dp)
                        ) {
                            Text("✖", color = Color.Black, fontSize = 18.sp)
                        }
                    }
                }


            }


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
                Image(
                    painter = painterResource(R.drawable.bololimao),
                    contentDescription = "Imagem do Red Velvet",
                    modifier = Modifier.size(120.dp),
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.width(10.dp))
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        "Bolo De Limão",
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        color = Color(android.graphics.Color.parseColor("#FFD9D9"))
                    )
                    Text("retirada: 02-03-2025", color = Color.White, fontSize = 14.sp)
                    Text("R$17,97", color = Color.White, fontSize = 14.sp)
                    Spacer(modifier = Modifier.height(8.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(), // Preenche a largura total
                        horizontalArrangement = Arrangement.End  // Alinhamento à direita
                    ) {

                        Button(
                            onClick = { /* Aceitar pedido */ },
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF6BCF6B)),
                            shape = RoundedCornerShape(12.dp)
                        ) {
                            Text("✔", color = Color.Black, fontSize = 18.sp)
                        }
                        Spacer(modifier = Modifier.height(8.dp))
                        Button(
                            onClick = { /* Cancelar pedido */ },
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFEE6C6C)),
                            shape = RoundedCornerShape(12.dp)
                        ) {
                            Text("✖", color = Color.Black, fontSize = 18.sp)
                        }
                    }
                }


            }

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
                Image(
                    painter = painterResource(R.drawable.bololimao),
                    contentDescription = "Imagem do Red Velvet",
                    modifier = Modifier.size(120.dp),
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.width(10.dp))
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        "Bolo De Limão",
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        color = Color(android.graphics.Color.parseColor("#FFD9D9"))
                    )
                    Text("retirada: 02-03-2025", color = Color.White, fontSize = 14.sp)
                    Text("R$17,97", color = Color.White, fontSize = 14.sp)
                    Spacer(modifier = Modifier.height(8.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(), // Preenche a largura total
                        horizontalArrangement = Arrangement.End  // Alinhamento à direita
                    ) {

                        Button(
                            onClick = { /* Aceitar pedido */ },
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF6BCF6B)),
                            shape = RoundedCornerShape(12.dp)
                        ) {
                            Text("✔", color = Color.Black, fontSize = 18.sp)
                        }
                        Spacer(modifier = Modifier.height(8.dp))
                        Button(
                            onClick = { /* Cancelar pedido */ },
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

}

@Preview(
    showBackground = true,
    showSystemUi = true,
    device = Devices.PIXEL_2
)
@Composable
fun c() {
    ConfeitechMobileTheme {
        telaAdministrador()
    }
}