package br.com.restorant.service.test;

import br.com.restorant.dao.CardapioDao;
import br.com.restorant.dao.CategoriaDao;
import br.com.restorant.entity.Cardapio;
import br.com.restorant.entity.Categoria;
import br.com.restorant.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class CardapioService {

    public static void main(String[] args) {
        EntityManager em = JPAUtil.getEntityManagerRestorant();
        cadastraProdutoCardapio(em, cadastrarCategoria(em));
    }

    public static Categoria cadastrarCategoria(EntityManager em) {
        CategoriaDao dao = new CategoriaDao(em);
        Categoria categoria = new Categoria("Comida");

        em.getTransaction().begin();
        dao.cadastrar(categoria);
        em.getTransaction().commit();
        em.clear();
        return categoria;
    }

    public static void cadastraProdutoCardapio(EntityManager em, Categoria categoria) {
        Cardapio risoto = new Cardapio("risoto", "risoto acompanhado de uma carne de sua escolha", BigDecimal.valueOf(230.5), true, categoria);
        Cardapio macarao = new Cardapio("macarrao", "macarrao acompanhado de uma carne de sua escolha", BigDecimal.valueOf(30.5), true, categoria);
        Cardapio arroz = new Cardapio("arroz", "arroz acompanhado de uma carne de sua escolha", BigDecimal.valueOf(230.5), true, categoria);
        Cardapio feijoada = new Cardapio("feijoada", "Feijoada acompanhado de uma carne de sua escolha", BigDecimal.valueOf(230.5), true, categoria);
        CardapioDao dao = new CardapioDao(em);

        em.getTransaction().begin();
        dao.cadastrar(risoto);
        dao.cadastrar(feijoada);
        em.getTransaction().commit();

        em.getTransaction().begin();
        dao.cadastrar(macarao);
        dao.cadastrar(arroz);
        em.flush();

        dao.consultarTodos().forEach(elemt -> System.out.println("O prato: " + elemt));
        em.close();
    }

}
