package com.example.quizappjoelcoutolugo.pantallas


import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.quizappjoelcoutolugo.MainActivity
import com.example.quizappjoelcoutolugo.ruta.Rutas
import com.example.quizappjoelcoutolugo.R
import com.example.quizappjoelcoutolugo.ui.theme.colorPersonalizado2

@Composable
fun HomeView(navController: NavHostController?) {
    var isDialogoAbierto by remember { mutableStateOf(false) }
    val contexto = LocalContext.current
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(Color(182, 206, 99, 255))
    ) {
        Logo()
        Spacer(modifier = Modifier.height(50.dp))
        BotonNavegacion(text = "MODO FACIL", ruta = Rutas.EasyModeView.ruta, navController = navController)
        BotonNavegacion(text = "EXAMEN", ruta = Rutas.ExamenView.ruta, navController = navController)
        BotonNavegacion(text = "ESTADÍSTICAS(En mantenimiento)", ruta = "", navController = null)
        BotonSalir(isDialogoAbierto = isDialogoAbierto) { isOpen ->
            isDialogoAbierto = isOpen
        }
    }

    MostrarDialogo(isDialogoAbierto = isDialogoAbierto, contexto = contexto) { isOpen ->
        isDialogoAbierto = isOpen
    }
}

@Composable
fun Logo() {
    Image(
        painter = painterResource(id = R.drawable.logo),
        contentDescription = "",
        modifier = Modifier.size(200.dp)
    )
}

@Composable
fun BotonNavegacion(text: String, ruta: String, navController: NavHostController?) {
    Button(
        onClick = { if (ruta.isNotEmpty()) navController?.navigate(ruta) },
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .clip(CircleShape),
        colors = ButtonDefaults.buttonColors(containerColor = colorPersonalizado2)
    ) {
        Text(text = text)
    }
}

@Composable
fun BotonSalir(isDialogoAbierto: Boolean, onDialogOpen: (Boolean) -> Unit) {
    Button(
        onClick = { onDialogOpen(true) },
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .clip(CircleShape),
        colors = ButtonDefaults.buttonColors(containerColor = colorPersonalizado2)
    ) {
        Text(text = "EXIT")
    }
}

@Composable
fun MostrarDialogo(isDialogoAbierto: Boolean, contexto: Context, onDialogClose: (Boolean) -> Unit) {
    if (isDialogoAbierto) {
        AlertDialog(
            onDismissRequest = { onDialogClose(false) },
            title = { Text("ATENCION AMIGO PEATON") },
            text = { Text("¿Quieres salir de la app?") },
            confirmButton = {
                Button(
                    onClick = {
                        onDialogClose(false)
                        (contexto as? MainActivity)?.finish()
                    }
                ) {
                    Text("Sí")
                }
            },
            dismissButton = {
                Button(
                    onClick = { onDialogClose(false) }
                ) {
                    Text("No")
                }
            }
        )
    }
}
/*@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewHome(){
    HomeView(navController = null)
}*/