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
import com.example.quizappjoelcoutolugo.R
import com.example.quizappjoelcoutolugo.ruta.Rutas
import com.example.quizappjoelcoutolugo.Model.Pregunta
import com.example.quizappjoelcoutolugo.ui.theme.colorPersonalizado2
import kotlin.random.Random

const val NUMERO_DE_PREGUNTAS = 5

fun isRespuestaCorrecta(pregunta: Pregunta, respuestaUsuario: Boolean): Boolean {
    return pregunta.isRespuestaCorrecta == respuestaUsuario
}

@Composable
fun PantallaModoNormal(navController: NavHostController?) {

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

    var preguntaActual by remember { mutableStateOf(0) }
    var aciertos by remember { mutableStateOf(0) }
    var numeroDePreguntas by remember { mutableStateOf(0) }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxSize()
            .background(Color(182, 206, 99, 255))
    ) {

        Text(
            text = preguntas[preguntaActual].getEnunciado(),
            modifier = Modifier
                .padding(30.dp),
            color = Color.White,
            fontFamily = FontFamily.Monospace,
            fontSize = 24.sp,
            textAlign = TextAlign.Center
        )
        Image(
            painter = preguntas[preguntaActual].getFoto(),
            contentDescription = "",
            modifier = Modifier
                .size(450.dp)
        )

        Row {
            Button(
                onClick = {
                    val respuesta = isRespuestaCorrecta(preguntas[preguntaActual], true)

                    if (respuesta) {
                        aciertos++
                    }
                    numeroDePreguntas++

                    if (numeroDePreguntas < NUMERO_DE_PREGUNTAS) {
                        preguntaActual++
                    }
                    if (numeroDePreguntas == NUMERO_DE_PREGUNTAS) {
                        navController?.navigate(Rutas.PantallaMensajeNota.ruta + "/${aciertos.toString()}")
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
                        val respuesta = isRespuestaCorrecta(preguntas[preguntaActual], false)

                        if (respuesta) {
                            aciertos++
                        }
                        numeroDePreguntas++

                        if (numeroDePreguntas < NUMERO_DE_PREGUNTAS) {
                            preguntaActual++
                        }
                        if (numeroDePreguntas == NUMERO_DE_PREGUNTAS) {
                            navController?.navigate(Rutas.PantallaMensajeNota.ruta + "/${aciertos.toString()}")
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

        Row {
            Button(
                onClick = {
                    if (preguntaActual > 0) {
                        preguntaActual--
                    } else {
                        preguntaActual = preguntas.size - 1
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
                Text(text = "PREV")
            }

            Button(
                onClick = {
                    preguntaActual = Random.nextInt(0, preguntas.size)
                },
                shape = RectangleShape,
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorPersonalizado2
                ),
                modifier = Modifier
                    .padding(8.dp)
                    .weight(1f)
            ) {
                Text(text = "RANDOM")
            }

            Button(
                onClick = {
                    if (preguntaActual < preguntas.size-1) {
                        preguntaActual++
                    } else {
                        preguntaActual = 0
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
                Text(text = "NEXT")
            }
        }
    }
}



@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewModoNormal() {
    PantallaModoNormal(navController = null)
}