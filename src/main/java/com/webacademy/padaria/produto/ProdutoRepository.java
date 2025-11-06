package com.webacademy.padaria.produto;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    
    @Query("""
        SELECT p FROM Produto p
        JOIN p.categoria c
        WHERE p.nome LIKE %:termoBusca%
        OR c.nome LIKE %:termoBusca%    
    """)
    List<Produto> busca(String termoBusca);
}
