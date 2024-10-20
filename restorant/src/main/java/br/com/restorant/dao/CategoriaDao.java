package br.com.restorant.dao;

import br.com.restorant.entity.Cardapio;
import br.com.restorant.entity.Categoria;

import javax.persistence.EntityManager;

public class CategoriaDao {

    private EntityManager em;

    public CategoriaDao(EntityManager em) {
        this.em = em;
    }

    public void cadastrar(final Categoria categoria) {
        em.persist(categoria);
        System.out.println("Prato cadastrado com sucesso! " + categoria);
    }

    public Categoria findById(final int id) {
        return em.find(Categoria.class, id);
    }

    public void atualizar(final Categoria categoria) {
        em.merge(categoria);
    }

    public void deletar(final Categoria categoria) {
        em.remove(categoria);
    }

}
