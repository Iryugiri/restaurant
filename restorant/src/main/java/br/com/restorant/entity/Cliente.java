package br.com.restorant.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "clientes")
public class Cliente {

    @Id
    private Integer id;
    private String nome;
    private String cpf;
    private String cep;

    public Cliente() {
    }

    public Cliente(String nome, String cpf, String cep) {
        this.nome = nome;
        this.cpf = cpf;
        this.cep = cep;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getCep() {
        return cep;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", cep='" + cep + '\'' +
                '}';
    }
}
