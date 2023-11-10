package com.example.quizappjoelcoutolugo.pantallas

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.quizappjoelcoutolugo.ruta.Rutas
import com.example.quizappjoelcoutolugo.R
import com.example.quizappjoelcoutolugo.Model.Pregunta
import com.example.quizappjoelcoutolugo.ui.theme.colorPersonalizado2

@Composable
fun PantallaModoExamen(navController: NavHostController?) {

    val preguntas = listOf<Pregunta>(
        Pregunta(
            "¿Luffy sera el futuro rey de los piratas?",
            true,
            painterResource(id = R.drawable.onepiece)
        ),
        Pregunta(
            "¿Ichigo actualmente usa una espada?",
            false,
            painterResource(id = R.drawable.bleach)
        ),
        Pregunta(
            "¿Killua ha matado gente inocente?",
            true,
            painterResource(id = R.drawable.hunter)
        ),
        Pregunta(
            "¿Todo en uno y uno es todo?",
            true,
            painterResource(id = R.drawable.fullmetal)
        ),
        Pregunta(
            "¿Eren era el malo(pregunta con trampa)?",
            false,
            painterResource(id = R.drawable.shingeki)
        )
    )

    // Estado de la pantalla
    var preguntaActual by remember { mutableStateOf(0) }
    var aciertos by remember { mutableStateOf(0) }
    var cantidadPreguntas by remember { mutableStateOf(0) }

    // Funciones de la pantalla
    fun respuestaCorrecta(pregunta: Pregunta, respuestaUsuario: Boolean): Boolean {
        return pregunta.isRespuestaCorrecta.equals(respuestaUsuario)
    }

    fun navegarAPantallaMensajeNota(aciertos: Int) {
        navController?.navigate(Rutas.PantallaMensajeNota.ruta + "/${aciertos.toString()}")
    }

    // Pantalla
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxSize()
            .background(Color(182, 206, 99, 255))
    ) {

        // Enunciado de la pregunta actual
        Text(
            text = preguntas[preguntaActual].getEnunciado(),
            modifier = Modifier
                .padding(30.dp),
            color = Color.White,
            fontFamily = FontFamily.Monospace,
            fontSize = 24.sp,
            textAlign = TextAlign.Center
        )

        // Imagen de la pregunta actual
        Image(
            painter = preguntas[preguntaActual].getFoto(),
            contentDescription = "",
            modifier = Modifier
                .size(450.dp)
        )

        // Botones de respuesta
        Row {
            Button(
                onClick = {
                    val respuesta = respuestaCorrecta(preguntas[preguntaActual], true)

                    aciertos += if (respuesta) 1 else 0
                    cantidadPreguntas++

                    if (cantidadPreguntas < preguntas.size) {
                        preguntaActual++
                    } else {
                        navegarAPantallaMensajeNota(aciertos)
                    }
                },
                shape = RectangleShape,
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorPersonalizado2
                ),
                modifier = Modifier
                    .padding(8.dp)
                    .weight(1f)
            ) {
                Text(text = "VERDADERO")
            }

            Button(
                onClick = {
                    val respuesta = respuestaCorrecta(preguntas[preguntaActual], false)

                    aciertos += if (respuesta) 1 else 0
                    cantidadPreguntas++

                    if (cantidadPreguntas < preguntas.size) {
                        preguntaActual++
                    } else {
                        navegarAPantallaMensajeNota(aciertos)
                    }
                },
                shape = RectangleShape,
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorPersonalizado2
                ),
                modifier = Modifier
                    .padding(8.dp)
                    .weight(1f)
            ) {
                Text(text = "FALSO")
            }
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewModoExamen() {
    PantallaModoExamen(navController = null)
}