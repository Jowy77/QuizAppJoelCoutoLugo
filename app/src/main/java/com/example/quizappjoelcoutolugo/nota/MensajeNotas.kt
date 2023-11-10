package com.example.quizappjoelcoutolugo.nota

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quizappjoelcoutolugo.R
import androidx.navigation.NavHostController
import com.example.quizappjoelcoutolugo.ruta.Rutas
import com.example.quizappjoelcoutolugo.ui.theme.colorPersonalizado1
import com.example.quizappjoelcoutolugo.ui.theme.colorPersonalizado2

@Composable
fun PantallaMensajeNota(aciertos: Int, navController: NavHostController?) {

    val aprobado: Painter = painterResource(id = R.drawable.goku)
    val suspendido: Painter = painterResource(id = R.drawable.suspendido)

    var imagenNota by remember { mutableStateOf<Painter>(aprobado) }
    var textoMensaje by remember { mutableStateOf("¡ENHORABUENA!,\nHas aprobado con la máxima nota.\nFELICIDADES") }

    when {

        aciertos >= 3 -> {
            imagenNota = aprobado
            textoMensaje = "¡Has superado el desafío!.\n¡FELICIDADES por tu éxito merecido!"
        }
        else -> {
            imagenNota = suspendido
            textoMensaje = "........DECEPCIONANTE\nUwU."
        }
    }

    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxSize()
            .background(Color(182, 206, 99, 255))
    ) {
        Text(
            modifier = Modifier.padding(30.dp),
            color = Color.White,
            fontFamily = FontFamily.Monospace,
            fontSize = 24.sp,
            textAlign = TextAlign.Center,
            text = textoMensaje
        )
        Image(
            modifier = Modifier.size(450.dp),
            painter = imagenNota,
            contentDescription = ""
        )
        Button(
            onClick = {
                navController?.navigate(Rutas.PantallaPrincipal.ruta)
            },
            shape = CircleShape,
            colors = ButtonDefaults.buttonColors(
                containerColor = colorPersonalizado2
            ),
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
        ) {
            Text(text = "VOLVER AL MENÚ")
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewMensajeNotas() {
    PantallaMensajeNota(1, navController = null)
}