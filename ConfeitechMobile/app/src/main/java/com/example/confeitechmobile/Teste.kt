package com.example.confeitechmobile

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.confeitechmobile.ui.theme.ConfeitechMobileTheme
import com.example.confeitechmobile.viewmodel.EncomendaViewModel

@Composable
fun TelaEncomendass(viewModel: EncomendaViewModel) {
    val lista = viewModel.lista
    val carregando = viewModel.isChamandoApi()
    val erros = viewModel.erros

    Column (Modifier.padding(top = 50.dp)){


        if (carregando) {
            Text(text = "Carregando...")
        } else if (lista.isEmpty()) {
            Text(text = "Nenhuma encomenda encontrada")
        } else {
            LazyColumn {
                items(lista.size) { index ->
                    val encomenda = lista[index]
                    Column {
                        Text(text = "ID: ${encomenda.id ?: "N/A"}")
                        Text(text = "Preço: ${encomenda.preco}")
                        Text(text = "Peso: ${encomenda.peso ?: "N/A"}")
                        Text(text = "Andamento: ${encomenda.andamento ?: "N/A"}")
                        Text(text = "Observações: ${encomenda.observacoes ?: "N/A"}")
                        Text(text = "Data Retirada: ${encomenda.dataRetirada ?: "N/A"}")
                        Text(text = "----------------------")
                    }
                }
            }
        }

        erros.forEach {
            Text(text = "Erro: $it")
        }
    }
}


@Preview(
    showBackground = true,
    showSystemUi = true,
    device = Devices.PIXEL_2
)
@Composable
fun teste() {
    ConfeitechMobileTheme {
        TelaEncomendass(
            viewModel = EncomendaViewModel()
        )
    }
}
