package com.example.quizappjoelcoutolugo.pantallas

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.quizappjoelcoutolugo.ruta.Rutas
import com.example.quizappjoelcoutolugo.MainActivity
import com.example.quizappjoelcoutolugo.R
import com.example.quizappjoelcoutolugo.ui.theme.colorPersonalizado2

@Composable
fun PantallaPrincipal(navController : NavHostController?) {

    val contexto = LocalContext.current
    var elDialogoEstaAbierto by remember { mutableStateOf(false) }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(Color(182, 206, 99, 255))
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "",
            modifier = Modifier
                .size(200.dp)
        )
        Button(
            onClick = { navController?.navigate(Rutas.PantallaModoNormal.ruta) },
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
                .clip(CircleShape),  // Aquí se aplica la forma de círculo
            colors = ButtonDefaults.buttonColors(
                containerColor = colorPersonalizado2
            )
        ) {
            Text(text = "MODO NORMAL")
        }

        Button(
            onClick = { navController?.navigate(Rutas.PantallaModoExamen.ruta) },
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
                .clip(CircleShape),  // Forma de círculo
            colors = ButtonDefaults.buttonColors(
                containerColor = colorPersonalizado2
            )
        ) {
            Text(text = "MODO EXAMEN")
        }

        Button(
            onClick = { navController?.navigate(Rutas.PantallaEstadisticas.ruta) },
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
                .clip(CircleShape),  // Forma de círculo
            colors = ButtonDefaults.buttonColors(containerColor = colorPersonalizado2)
        ) {
            Text(text = "ESTADÍSTICAS")
        }

        Button(
            onClick = { elDialogoEstaAbierto = true },
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
                .clip(CircleShape),  // Forma de círculo
            colors = ButtonDefaults.buttonColors(containerColor = colorPersonalizado2)
        ) {
            Text(text = "SALIR")
        }
    }
    if (elDialogoEstaAbierto) {
        AlertDialog (
            onDismissRequest = { elDialogoEstaAbierto = false },
            title = { Text("Confirmación") },
            text = { Text("¿Estás seguro que deseas salir de la aplicación?") },
            confirmButton = {
                Button(
                    onClick = {

                        elDialogoEstaAbierto = false
                        (contexto as? MainActivity)?.finish()


                    }
                ) {
                    Text("Sí")
                }
            },
            dismissButton = {
                Button(
                    onClick = {

                        elDialogoEstaAbierto = false
                    }
                ) {
                    Text("No")
                }
            }
        )
    }
}
@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewHome(){
    PantallaPrincipal(navController = null)
}