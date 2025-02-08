package br.com.rodrigo.lista_compras.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.rodrigo.lista_compras.dtos.ProdutoDTO;
import br.com.rodrigo.lista_compras.services.ProdutoService;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/v1/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    public ProdutoDTO create(@Valid @RequestBody ProdutoDTO produto) {
        var p = produtoService.create(produto);
        return p;
    }

}
