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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.confeitechmobile.ui.theme.ConfeitechMobileTheme

@Composable
fun Greeting(modifier: Modifier = Modifier) {
    var valorA by remember { mutableStateOf("") }

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
            .fillMaxSize()  // Preenche toda a tela
            .padding(16.dp),  // Adiciona padding ao redor
        horizontalAlignment = Alignment.CenterHorizontally,  // Centraliza horizontalmente
    )
    {
        nav()
        botoesEncomendaCardapio()
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
                        color = Color.White
                    )
                    Text("retirada: 02-03-2025", color = Color.White, fontSize = 14.sp)
                    Text("R$17,97", color = Color.White, fontSize = 14.sp)
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        "EM PREPARO",
                        color = Color(0xFFE8C547),
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    )
                    Row(
                        modifier = Modifier.fillMaxWidth(), // Preenche a largura total
                        horizontalArrangement = Arrangement.End  // Alinhamento à direita
                    ) {
                        Button(

                            onClick = { /* lógica de cancelamento */ },
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFEE6C6C)),
                            shape = RoundedCornerShape(16.dp)
                        ) {
                            Text("Cancelar", color = Color.Black)
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
                        color = Color.White
                    )
                    Text("retirada: 02-03-2025", color = Color.White, fontSize = 14.sp)
                    Text("R$17,97", color = Color.White, fontSize = 14.sp)
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        "CONCLUIDA",
                        color = Color(0xFFBEFFB6),
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    )
                    Row(
                        modifier = Modifier.fillMaxWidth(), // Preenche a largura total
                        horizontalArrangement = Arrangement.End  // Alinhamento à direita
                    ) {
                        Button(

                            onClick = { /* lógica de cancelamento */ },
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFEE6C6C)),
                            shape = RoundedCornerShape(16.dp)
                        ) {
                            Text("X", color = Color.Black)
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
fun k() {
    ConfeitechMobileTheme {
        Greeting(

        )
    }
}
