package br.com.rodrigo.lista_compras.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.rodrigo.lista_compras.dtos.ProdutoByIdDTO;
import br.com.rodrigo.lista_compras.dtos.ProdutoDTO;
import br.com.rodrigo.lista_compras.services.ProdutoService;
import jakarta.validation.Valid;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/api/v1/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public List<ProdutoByIdDTO> findAll() {
       return produtoService.findAll();
    }
    
    @PostMapping
    public ProdutoDTO create(@Valid @RequestBody ProdutoDTO produto) {
        var p = produtoService.create(produto);
        return p;
    }

    @GetMapping("/{id}")
    public ProdutoByIdDTO findById(@PathVariable String id) {
       return produtoService.findById(id);
    }
    @GetMapping("/nome/{name}")
    public List<ProdutoByIdDTO> findByName(@PathVariable String name) {
       return produtoService.findByName(name);
    }

    @PutMapping("/{id}")
    public ProdutoDTO update(@PathVariable String id, @Valid @RequestBody ProdutoDTO produtoDTO) {
       return produtoService.update(id, produtoDTO);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
       produtoService.delete(id);
    }
    

}
