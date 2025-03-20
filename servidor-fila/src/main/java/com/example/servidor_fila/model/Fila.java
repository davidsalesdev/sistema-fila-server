package com.example.servidor_fila.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;



@Entity
public class Fila {

    @Id
    private Long id;
    private String jogador;
    private String mapa;
    private boolean servidorIniciado;

    // Getters e setters

    public Fila() {}

    public Fila(Long id, String jogador, String mapa, boolean servidorIniciado) {
        this.id = id;
        this.jogador = jogador;
        this.mapa = mapa;
        this.servidorIniciado = servidorIniciado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJogador() {
        return jogador;
    }

    public void setJogador(String jogador) {
        this.jogador = jogador;
    }

    public String getMapa() {
        return mapa;
    }

    public void setMapa(String mapa) {
        this.mapa = mapa;
    }

    public boolean isServidorIniciado() {
        return servidorIniciado;
    }

    public void setServidorIniciado(boolean servidorIniciado) {
        this.servidorIniciado = servidorIniciado;
    }
}
