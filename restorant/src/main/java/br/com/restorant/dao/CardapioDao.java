package br.com.restorant.dao;

import br.com.restorant.entity.Cardapio;

import javax.persistence.EntityManager;
import java.util.List;

public class CardapioDao {

    private EntityManager em;

    public CardapioDao() {}

    public CardapioDao(EntityManager em) {
        this.em = em;
    }

    public void cadastrar(final Cardapio cardapio) {
        em.persist(cardapio);
        System.out.println("Prato cadastrado com sucesso! " + cardapio);
    }

    public Cardapio findById(final int id) {
        return em.find(Cardapio.class, id);
    }

    public List<Cardapio> consultarTodos() {
        String jpql = "SELECT c FROM Cardapio c";
        return this.em.createQuery(jpql, Cardapio.class).getResultList();
    }

    public void atualizar(final Cardapio cardapio) {
        em.merge(cardapio);
        System.out.println("Prato atualizado com sucesso! " + cardapio);
    }

    public void deletar(final Cardapio cardapio) {
        em.remove(cardapio);
    }

}
