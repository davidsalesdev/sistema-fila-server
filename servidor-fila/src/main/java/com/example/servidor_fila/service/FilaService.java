package com.example.servidor_fila.service;

import com.example.servidor_fila.model.Fila;
import com.example.servidor_fila.repository.FilaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FilaService {

    @Autowired
    private FilaRepository filaRepository;
    // Adicionar jogador à fila
    public String adicionarJogadorNaFila(String jogador, String mapa) {
        long jogadoresNaFila = filaRepository.countByMapaAndServidorIniciadoFalse(mapa);

        // Adicionar jogador na fila
        Fila fila = new Fila(jogadoresNaFila + 1, jogador, mapa, false);
        filaRepository.save(fila);

        // Verificar se atingiu 10 jogadores
        if (jogadoresNaFila + 1 >= 10) {
            iniciarServidor(mapa);
            return "Servidor iniciado! IP: 192.168.0.100:27015";
        }

        return "Jogador adicionado à fila. Jogadores na fila: " + (jogadoresNaFila + 1);
    }

    // Iniciar o servidor (simulação)
    private void iniciarServidor(String mapa) {
        // Aqui você pode iniciar o servidor de verdade, talvez com um Shell Script ou API externa
        System.out.println("Iniciando servidor para o mapa: " + mapa);
    }

    // Verificar a quantidade de jogadores na fila
    public long verificarFila(String mapa) {
        return filaRepository.countByMapaAndServidorIniciadoFalse(mapa);
    }


    private final Map<String, List<String>> filas = new HashMap<>();

    public FilaService() {
        // Simulando alguns jogadores na fila de Dust2
        filas.put("Dust2", new ArrayList<>(List.of("Jogador1", "Jogador2", "Jogador3")));
    }
    public List<String> getJogadoresNaFila(String mapa) {
        return filas.getOrDefault(mapa, new ArrayList<>());
    }

}
