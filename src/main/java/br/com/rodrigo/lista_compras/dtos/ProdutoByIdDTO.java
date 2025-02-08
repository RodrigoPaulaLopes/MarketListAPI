package br.com.rodrigo.lista_compras.dtos;

import br.com.rodrigo.lista_compras.model.Produto;

public record ProdutoByIdDTO(String id, String nome, Double preco, Integer quantidade, Double precoTotal) {

    public ProdutoByIdDTO(Produto p){
        this(p.getId(), p.getNome(), p.getPreco(), p.getQuantidade(), p.precoTotal());
    }
}
