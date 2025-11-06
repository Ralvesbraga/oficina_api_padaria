package com.webacademy.padaria.produto;

import java.util.List;

import org.springframework.stereotype.Service;

import com.webacademy.padaria.infra.EntidadeNotFound;
import com.webacademy.padaria.interfaces.crudServiceInterfaces.IDeleteService;
import com.webacademy.padaria.interfaces.crudServiceInterfaces.IGetService;
import com.webacademy.padaria.interfaces.crudServiceInterfaces.ISaveService;

@Service
public class ProdutoService implements IGetService<Produto>, ISaveService<Produto>, IDeleteService {

    private final ProdutoRepository repository;

    public ProdutoService(ProdutoRepository repository) {
        this.repository = repository;
    }

    @Override
    public void delete(Long id) {
        var produto = get(id);
        repository.delete(produto);
    }

    @Override
    public Produto save(Produto objeto) {
        var produto = repository.save(objeto);
        return produto;
    }

    @Override
    public Produto get(Long id) {
        var produto = repository.findById(id)
            .orElseThrow(() -> new EntidadeNotFound("Produto não encontrado!"));
        return produto;
    }

    @Override
    public List<Produto> get(String termoBusca) {
        if (termoBusca != null && !termoBusca.isBlank()) {
            var produtos = repository.busca(termoBusca);
            return produtos;
        }
        return repository.findAll();
    }
    
}
