package com.example.servidor_fila.repository;


import com.example.servidor_fila.model.Fila;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilaRepository extends JpaRepository<Fila, Long> {
    long countByMapaAndServidorIniciadoFalse(String mapa); // Contar jogadores na fila
}
