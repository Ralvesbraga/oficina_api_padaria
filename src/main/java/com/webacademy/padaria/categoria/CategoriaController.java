package com.webacademy.padaria.categoria;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.webacademy.padaria.interfaces.crudControllerInterfaces.IDeleteController;
import com.webacademy.padaria.interfaces.crudControllerInterfaces.IGetController;
import com.webacademy.padaria.interfaces.crudControllerInterfaces.ISaveController;

@RestController
@RequestMapping("/categorias")
public class CategoriaController implements IGetController<Categoria>, ISaveController<Categoria>, IDeleteController {
    
    private final CategoriaService service;

    public CategoriaController(CategoriaService service) {
        this.service = service;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok(null);
    }

    @PostMapping
    public ResponseEntity<Categoria> insert(@RequestBody Categoria objeto) {
        var categoria = service.save(objeto);
        return ResponseEntity.status(HttpStatus.CREATED).body(categoria);
    }

    @PutMapping
    public ResponseEntity<Categoria> update(@RequestBody Categoria objeto) {
        var categoria = service.save(objeto);
        return ResponseEntity.ok(categoria);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> get(@PathVariable Long id) {
        var categoria = service.get(id);
        return ResponseEntity.ok(categoria);
    }

    @GetMapping
    public ResponseEntity<List<Categoria>> get(@RequestParam(required = false) String termoBusca) {
        var categorias = service.get(termoBusca);
        return ResponseEntity.ok(categorias);
    }

    

}
