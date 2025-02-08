package br.com.rodrigo.lista_compras.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.stereotype.Service;

import br.com.rodrigo.lista_compras.dtos.ProdutoByIdDTO;
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

    public ProdutoDTO update(String id, ProdutoDTO produto) {
        var updated = produtoRepository.findById(id).get();
        updated.setValues(produto);
        var p = produtoRepository.save(updated);
        return new ProdutoDTO(p);
    }


    public List<ProdutoByIdDTO> findAll(){
        var produtos = produtoRepository.findAll().stream().map(ProdutoByIdDTO::new).toList();
        return produtos;
        
    }

    public ProdutoByIdDTO findById(String id) {
        var p = produtoRepository.findProdutoById(id);
        return new ProdutoByIdDTO(p);
    }

    public void delete(String id) {
        var produto = produtoRepository.findById(id).get();

        produtoRepository.delete(produto);
    }
}
