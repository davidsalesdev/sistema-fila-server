package com.example.servidor_fila.controller;

import com.example.servidor_fila.service.FilaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fila")
public class FilaController {

    @Autowired
    private FilaService filaService;

    // Endpoint para adicionar jogador à fila
    @PostMapping("/entrar")
    public String entrarNaFila(@RequestBody JogadorRequest jogadorRequest) {
        return filaService.adicionarJogadorNaFila(jogadorRequest.getJogador(), jogadorRequest.getMapa());
    }

    // Endpoint para verificar o status da fila
    @GetMapping("/status/{mapa}")
    public long statusDaFila(@PathVariable String mapa) {
        return filaService.verificarFila(mapa);
    }

    @GetMapping("/ranking/{mapa}")
    public List<String> getRanking(@PathVariable String mapa) {
        return filaService.getJogadoresNaFila(mapa);
    }
}
