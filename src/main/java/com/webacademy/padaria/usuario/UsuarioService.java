package com.webacademy.padaria.usuario;

import java.util.List;

import org.springframework.stereotype.Service;

import com.webacademy.padaria.crudServiceInterfaces.IDeleteService;
import com.webacademy.padaria.crudServiceInterfaces.IGetService;
import com.webacademy.padaria.crudServiceInterfaces.ISaveService;

@Service
public class UsuarioService implements IGetService<Usuario>, ISaveService<Usuario>, IDeleteService {

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public Usuario save(Usuario objeto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public Usuario get(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'get'");
    }

    @Override
    public List<Usuario> get(String termoBusca) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'get'");
    }
    
}
