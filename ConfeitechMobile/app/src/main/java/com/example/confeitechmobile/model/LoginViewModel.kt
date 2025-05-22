package com.example.confeitechmobile.model

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.confeitechmobile.ConfeitechApiSla
import com.example.confeitechmobile.dto.UsuarioDTO
import kotlinx.coroutines.launch

class loginViewModel : ViewModel() {

    var isAdmin = mutableStateOf(false)
        private set

    private val api = ConfeitechApiSla.api

    var loginUiState = mutableStateOf(LoginUiState())
        private set

    fun onEmailChanged(newEmail: String) {
        loginUiState.value = loginUiState.value.copy(email = newEmail)
    }

    fun onPasswordChanged(newPassword: String) {
        loginUiState.value = loginUiState.value.copy(password = newPassword)
    }

    fun login(email: String, password: String) {
        loginUiState.value = loginUiState.value.copy(estaCarregando = true, erro = null)

        viewModelScope.launch {
            try {
                api.getUsers()
                val usuario = api.login(email, password)
                if (usuario.email == "ari@gmail.com") {
                    isAdmin.value = true
                }
                // login bem-sucedido
                loginUiState.value = loginUiState.value.copy(
                    estaCarregando = false,
                    sucessoLogin = usuario
                )
            } catch (e: Exception) {
                loginUiState.value = loginUiState.value.copy(
                    estaCarregando = false,
                    erro = "Erro ao fazer login: ${e.message}"
                )
            }
        }
    }

    fun cadastrarUsuario(usuarioDTO: UsuarioDTO) {
        loginUiState.value = loginUiState.value.copy(estaCarregando = true, erro = null)

        viewModelScope.launch {
            try {
                val usuarioCadastrado = api.cadastrarUsuario(usuarioDTO)

                // Cadastro bem-sucedido (você pode tratar isso de acordo com sua lógica)
                loginUiState.value = loginUiState.value.copy(
                    estaCarregando = false,
                    sucessoLogin = usuarioCadastrado
                )
            } catch (e: Exception) {
                loginUiState.value = loginUiState.value.copy(
                    estaCarregando = false,
                    erro = "Erro ao cadastrar usuário: ${e.message}"
                )
            }
        }
    }


    fun limparEstado() {
        loginUiState.value = LoginUiState()
    }
}

data class LoginUiState(
    val email: String = "",
    val password: String = "",
    val estaCarregando: Boolean = false,
    val erro: String? = null,
    val sucessoLogin: UsuarioDTO? = null
)