package com.webacademy.padaria.categoria;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    
    @Query("""
        SELECT c FROM Categoria c
        WHERE c.nome LIKE %:termoBusca%
    """)
    List<Categoria> busca(String termoBusca);
}
