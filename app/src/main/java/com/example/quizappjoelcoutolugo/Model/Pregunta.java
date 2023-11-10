package com.example.quizappjoelcoutolugo.Model;

import androidx.compose.ui.graphics.painter.Painter;

public class Pregunta {

    public String enunciado;
    public boolean respuestaCorrecta;
    public Painter foto;

    public Pregunta() {

    }

    public Pregunta(String pregunta, boolean respuesta, Painter foto) {
        this.enunciado = pregunta;
        this.respuestaCorrecta = respuesta;
        this.foto = foto;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public boolean isRespuestaCorrecta() {
        return respuestaCorrecta;
    }

    public void setRespuestaCorrecta(boolean respuestaCorrecta) {
        this.respuestaCorrecta = respuestaCorrecta;
    }

    public Painter getFoto() {
        return foto;
    }

    public void setFoto(Painter foto) {
        this.foto = foto;
    }
}
