package br.com.rodrigo.lista_compras.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rodrigo.lista_compras.dtos.ProdutoDTO;
import br.com.rodrigo.lista_compras.model.Produto;
import br.com.rodrigo.lista_compras.repositories.ProdutoRepository;

@Service
public class ProdutoService {
    
    @Autowired
    private ProdutoRepository produtoRepository;



    public ProdutoDTO create(ProdutoDTO produto) {
        var model = new Produto(produto);
        var p = produtoRepository.save(model);
        return new ProdutoDTO(p);
    }


    public List<ProdutoDTO> findAll(){
        var produtos = produtoRepository.findAll().stream().map(ProdutoDTO::new).toList();
        return produtos;
        
    }
}
