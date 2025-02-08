package br.com.rodrigo.lista_compras.model;

import java.beans.Transient;

import br.com.rodrigo.lista_compras.dtos.ProdutoDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "produtos")
public class Produto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private Double preco;

    @Column(nullable =  false)
    private Integer quantidade;
    
    public Produto() {
    }

    public Produto(String id, String nome, Double preco, Integer quantidade) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }
    public Produto(ProdutoDTO p) {
        this.nome = p.nome();
        this.preco = p.preco();
        this.quantidade = p.quantidade();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }


    @Transient
    public Double precoTotal(){
        return preco * quantidade;
    }

    public void setValues(ProdutoDTO p){
       this.setNome(p.nome());
       this.setPreco(p.preco());
       this.setQuantidade(p.quantidade());
    }

    
}
