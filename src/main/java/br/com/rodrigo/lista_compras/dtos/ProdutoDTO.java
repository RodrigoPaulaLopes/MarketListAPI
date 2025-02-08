package br.com.rodrigo.lista_compras.dtos;

import br.com.rodrigo.lista_compras.model.Produto;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record ProdutoDTO(@NotBlank(message = "Nome é obrigatorio!") String nome, @Min(0) Double preco, @Min(1) Integer quantidade, @Min(0) Double precoTotal) {

    public ProdutoDTO(Produto p){
        this(p.getNome(), p.getPreco(), p.getQuantidade(), p.precoTotal());
    }
}
