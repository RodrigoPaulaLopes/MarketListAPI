package br.com.rodrigo.lista_compras.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.rodrigo.lista_compras.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, String>{


    public Produto findProdutoById(String id);
}
