package br.com.rodrigo.lista_compras.services;

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
        return new ProdutoDTO(p.getNome(), p.getPreco(), p.getQuantidade(), p.precoTotal());
    }
}
