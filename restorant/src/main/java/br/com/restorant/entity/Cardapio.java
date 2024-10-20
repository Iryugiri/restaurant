package br.com.restorant.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Table(name = "cardapio")
@Entity
public class Cardapio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String descricao;
    private BigDecimal preco;
    private Boolean disponivel;

    @ManyToOne
    private Categoria categoria;

    @Column(name = "data_de_registro")
    private LocalDateTime dataDeRegistro;

    public Cardapio() {
    }

    public Cardapio(String nome, String descricao, BigDecimal preco, Boolean disponivel, Categoria categoria) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.disponivel = disponivel;
        this.dataDeRegistro = LocalDateTime.now();
        this.categoria = categoria;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public LocalDateTime getDataDeRegistro() {
        return dataDeRegistro;
    }

    @Override
    public String toString() {
        return "Prato{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", preco=" + preco +
                ", dataDeRegistro=" + dataDeRegistro +
                ", categoria=" + categoria +
                '}';
    }
}
