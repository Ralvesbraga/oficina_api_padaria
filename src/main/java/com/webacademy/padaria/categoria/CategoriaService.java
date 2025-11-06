package com.webacademy.padaria.categoria;

import java.util.List;

import org.springframework.stereotype.Service;

import com.webacademy.padaria.infra.EntidadeNotFound;
import com.webacademy.padaria.interfaces.crudServiceInterfaces.IDeleteService;
import com.webacademy.padaria.interfaces.crudServiceInterfaces.IGetService;
import com.webacademy.padaria.interfaces.crudServiceInterfaces.ISaveService;

@Service
public class CategoriaService implements IGetService<Categoria>, ISaveService<Categoria>, IDeleteService {
    private final CategoriaRepository repository;

    public CategoriaService(CategoriaRepository repository) {
        this.repository = repository;
    }

    public void delete(Long id) {
        var categoria = get(id);
        repository.delete(categoria);
    }

    public Categoria save(Categoria objeto) {
        return repository.save(objeto);
    }

    public Categoria get(Long id) {
        var categoria = repository.findById(id).orElseThrow(() -> new EntidadeNotFound("Categoria não encontrada!"));
        return categoria;
    }

    public List<Categoria> get(String termoBusca) {
        if (termoBusca != null && !termoBusca.isBlank()) {
            var categorias = repository.busca(termoBusca);
            return categorias;
        }
        return repository.findAll();
    }
    
}
