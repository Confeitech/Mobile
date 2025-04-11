package com.example.confeitechmobile

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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import androidx.compose.ui.zIndex
import com.example.confeitechmobile.ui.theme.ConfeitechMobileTheme


@Composable
fun TelaNovoBolo(modifier: Modifier = Modifier) {
    var valorA by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .fillMaxHeight()
    ) {
        Image(
            painter = painterResource(R.drawable.novobolo),
            contentDescription = "imagem de alguma coisa",
            modifier = Modifier
                .height(425.dp)
                .fillMaxWidth()
                .padding(top = 30.dp)
                .zIndex(1f),
            contentScale = ContentScale.Crop,
        )
        Box(
            modifier = Modifier
                .height(500.dp)
                .fillMaxWidth()
                .absoluteOffset(y = (-19).dp)
                .zIndex(2f)
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color.White,
                            Color(255, 117, 117)
                        )
                    ),
                    shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)
                )
        ) {
            Column(modifier = Modifier.padding(top = 10.dp)) {


                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    OutlinedTextField(
                        value = valorA,
                        onValueChange = { valorA = it },
                        label = { Text("Nome do Bolo") },
                        modifier = Modifier.width(220.dp),
                        shape = RoundedCornerShape(20.dp),
                        trailingIcon = {
                            Icon(
                                imageVector = Icons.Filled.Edit,
                                contentDescription = "Carrinho de compras"
                            )
                        }
                    )

                    Spacer(modifier = Modifier.width(20.dp))

                    OutlinedTextField(
                        value = valorA,
                        onValueChange = { valorA = it },
                        label = { Text("Preço") },
                        modifier = Modifier.width(140.dp),
                        shape = RoundedCornerShape(20.dp),
                        trailingIcon = {
                            Icon(
                                imageVector = Icons.Filled.Edit,
                                contentDescription = "Carrinho de compras"
                            )
                        }
                    )
                }
                Spacer(modifier = modifier.height(20.dp))
                Spacer(
                    modifier = Modifier
                        .background(color = Color.Black)
                        .height(1.dp)
                        .fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(30.dp))
                Row(
                    modifier = modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    OutlinedTextField(
                        value = valorA,
                        onValueChange = { valorA = it },
                        label = { Text("Descrição") },
                        modifier = Modifier
                            .width(300.dp)
                            .height(100.dp),
                        shape = RoundedCornerShape(20.dp),
                        trailingIcon = {
                            Icon(
                                imageVector = Icons.Filled.Edit,
                                contentDescription = "Carrinho de compras"
                            )
                        }
                    )
                }

                Spacer(Modifier.height(20.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {


                    Button(
                        onClick = { },
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
                            "Concluir",
                            style = TextStyle(
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold
                            )
                        )
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
fun a() {
    ConfeitechMobileTheme {
        TelaNovoBolo()
    }
}
