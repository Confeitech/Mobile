    package com.example.confeitechmobile.model

    import androidx.compose.runtime.mutableStateListOf
    import androidx.compose.runtime.mutableStateOf
    import androidx.lifecycle.ViewModel
    import androidx.lifecycle.viewModelScope
    import com.example.confeitechmobile.ConfeitechApiSla
    import com.example.confeitechmobile.dto.BoloDTO

    class CardapioViewModel : ViewModel() {

        private val api = ConfeitechApiSla.api

        var chamandoApi = mutableStateOf(false)
            private set

        var erros = mutableStateListOf<String>()
            private set

        fun isChamandoApi(): Boolean = chamandoApi.value

        suspend fun carregarCardapio(): List<BoloDTO> {
            chamandoApi.value = true
            erros.clear()

            return try {
                val resposta = api.getCardapio()
                return resposta
            } catch (e: Exception) {
                erros.add("Erro ao buscar o cardápio: ${e.message}")
                emptyList()
            } finally {
                chamandoApi.value = false
            }
        }

        suspend fun carregarBolo1(): BoloDTO{
            chamandoApi.value = true
            erros.clear()

            return try {
                val resposta = api.getBolo1()
                return resposta
            } catch (e: Exception) {
                erros.add("Erro ao buscar o cardápio: ${e.message}")
                BoloDTO()
            } finally {
                chamandoApi.value = false
            }
        }

        fun limparErros() {
            erros.clear()
        }
    }
