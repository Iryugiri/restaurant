package br.com.restorant.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "ordens")
public class Ordem {

    @Id
    private Integer id;
    @Column(name = "valor_total")
    private BigDecimal valorTotal;
    @Column(name = "data_de_criacao")
    private LocalDateTime dataCriacao = LocalDateTime.now();

    @ManyToOne
    private Cliente cliente;

    @ManyToMany
    @JoinTable(
            name = "ordens_cardapio",
            joinColumns = @JoinColumn(name = "ordens_id"),
            inverseJoinColumns = @JoinColumn(name = "cardapio_id")
    )
    private List<Cardapio> cardapioList;

    public Ordem() {
    }

    public Ordem(Cliente cliente) {
        this.cliente = cliente;
    }

    public Integer getId() {
        return id;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public Cliente getCliente() {
        return cliente;
    }

    @Override
    public String toString() {
        return " Ordem {" +
                "id=" + id +
                ", valorTotal=" + valorTotal +
                ", dataCriacao=" + dataCriacao +
                ", cliente=" + cliente +
                '}';
    }
}
