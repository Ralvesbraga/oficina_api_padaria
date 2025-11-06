package com.webacademy.padaria.usuario;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.webacademy.padaria.interfaces.crudServiceInterfaces.IDeleteService;
import com.webacademy.padaria.interfaces.crudServiceInterfaces.IGetService;
import com.webacademy.padaria.interfaces.crudServiceInterfaces.ISaveService;

@Service
public class UsuarioService implements IGetService<Usuario>, ISaveService<Usuario>, IDeleteService {

    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public void delete(Long id) {
        Optional<Usuario> usuarioOptional = repository.findById(id);
        if(usuarioOptional.isPresent()) {
            var usuario = usuarioOptional.get();
            repository.delete(usuario);
            return;
        }
        return;
    }

    public Usuario save(Usuario objeto) {
        var usuario = repository.save(objeto);
        return usuario;
    }

    public Usuario get(Long id) {
        var usuarioOptional = repository.findById(id);
        if (usuarioOptional.isPresent()) {
            return usuarioOptional.get();
        }
        return null;
    }

    public List<Usuario> get(String termoBusca) {
        if (termoBusca != null && !termoBusca.isBlank()) {
            var registros = repository.busca(termoBusca);
            return registros;
        }
        var registros = repository.findAll();
        return registros;
    }
    
}
