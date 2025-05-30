package com.example.confeitechmobile.loginCadastro

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.confeitechmobile.dto.UsuarioDTO
import com.example.confeitechmobile.model.loginViewModel
import com.example.confeitechmobile.ui.theme.ConfeitechMobileTheme

@Composable
fun telaCadastro(navController: NavController, viewModel: loginViewModel) {
    var valorNome by remember { mutableStateOf("") }
    var valorEmail by remember { mutableStateOf("") }
    var valorSenha by remember { mutableStateOf("") }
    var valorTelefone by remember { mutableStateOf("") }

    Box(
        Modifier
            .background(
                brush = Brush.horizontalGradient(
                    colors = listOf(
                        Color(255, 180, 180),
                        Color.White
                    )
                ),
            )
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier.padding(top = 40.dp, start = 15.dp),
        ) {
            Box(
                modifier = Modifier.fillMaxWidth(),
            ) {
                Text("Cakes Aricroce")
            }
            Spacer(Modifier.height(120.dp))

            Row {
                Spacer(Modifier.width(20.dp))

                Column(
                    Modifier
                        .background(Color.White)
                        .width(300.dp)
                        .padding(start = 30.dp)
                ) {
                    Spacer(Modifier.height(40.dp))
                    Text("Nome")
                    Spacer(Modifier.height(5.dp))
                    OutlinedTextField(
                        value = valorNome,
                        onValueChange = { valorNome = it },
                        shape = RoundedCornerShape(20.dp),
                        modifier = Modifier
                            .height(60.dp)
                            .width(250.dp),
                    )

                    Spacer(Modifier.height(40.dp))
                    Text("E-mail")
                    Spacer(Modifier.height(5.dp))
                    OutlinedTextField(
                        value = valorEmail,
                        onValueChange = { valorEmail = it },
                        shape = RoundedCornerShape(20.dp),
                        modifier = Modifier
                            .height(60.dp)
                            .width(250.dp),
                    )

                    Spacer(Modifier.height(20.dp))
                    Text("Senha")
                    Spacer(Modifier.height(5.dp))
                    OutlinedTextField(
                        value = valorSenha,
                        onValueChange = { valorSenha = it },
                        shape = RoundedCornerShape(20.dp),
                        modifier = Modifier
                            .height(60.dp)
                            .width(250.dp),
                    )

                    Spacer(Modifier.height(20.dp))
                    Text("Telefone")
                    Spacer(Modifier.height(5.dp))
                    OutlinedTextField(
                        value = valorTelefone,
                        onValueChange = { valorTelefone = it },
                        shape = RoundedCornerShape(20.dp),
                        modifier = Modifier
                            .height(60.dp)
                            .width(250.dp),
                    )

                    Spacer(Modifier.height(65.dp))

                    Row () {
                        Spacer(Modifier.width(20.dp))

                        Button(
                            onClick = {
                                if (valorNome.isNotBlank() && valorEmail.isNotBlank() && valorSenha.isNotBlank() && valorTelefone.isNotBlank()) {
                                    val usuario = UsuarioDTO(
                                        nome = valorNome,
                                        email = valorEmail,
                                        senha = valorSenha,
                                        telefone = valorTelefone,
                                        dtNasc = "2000-01-01",
                                        ativo = true,
                                        cep = "05051020",
                                    )
                                    viewModel.cadastrarUsuario(usuario)
                                    navController.navigate("telaLogin")
                                }
                            },
                            modifier = Modifier
                                .height(60.dp)
                                .width(200.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(0xFFE76060),
                                contentColor = Color.White
                            ),
                            shape = RoundedCornerShape(30.dp)
                        ) {
                            Text(
                                "Cadastrar",
                                style = TextStyle(
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Bold
                                ),
                            )
                        }
                    }
                    Spacer(Modifier.height(10.dp))
                    Text(
                        text = "Realizar Login",
                        modifier = Modifier
                            .clickable {
                                navController.navigate("telaLogin")
                            }
                            .padding(start = 60.dp)
                    )
                    Spacer(Modifier.height(40.dp))
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
fun showTelaCadastro() {
    ConfeitechMobileTheme {
        telaCadastro(
            navController = rememberNavController(),
            viewModel = loginViewModel()
        )
    }
}