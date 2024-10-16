package br.com.restorant.service.test;

import br.com.restorant.dao.CardapioDao;
import br.com.restorant.entity.Cardapio;
import br.com.restorant.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class CardapioService {

    public static void main(String[] args) {

        Cardapio risoto = new Cardapio("Risoto", "Risoto acompanhado de uma carne de sua escolha", BigDecimal.valueOf(230.5), true);
        Cardapio macarao = new Cardapio("macarao", "macarao acompanhado de uma carne de sua escolha", BigDecimal.valueOf(30.5), true);
        Cardapio arroz = new Cardapio("arroz", "arroz acompanhado de uma carne de sua escolha", BigDecimal.valueOf(230.5), true);
        Cardapio feijoada = new Cardapio("feijoada", "Feijoada acompanhado de uma carne de sua escolha", BigDecimal.valueOf(230.5), true);
        EntityManager em = JPAUtil.getEntityManagerRestorant();
        CardapioDao dao = new CardapioDao(em);

        /*
        Em uma operacao de modificacao no banco de dados e necessario criar isso
        em.getTransaction().begin();
        em.getTransaction().commit();
        */
        em.getTransaction().begin();
        dao.cadastrar(risoto);
        dao.cadastrar(macarao);
        dao.cadastrar(arroz);
        em.getTransaction().commit();
//        em.close();
// ----------------------------------------------------------------------
//
        /*
         * Mas e possivel criar coisas usando o flush()
         */

        System.out.println("------------------------");
        System.out.println("Outro jeito de inserir inf no DB");
        System.out.println("------------------------");
        em.getTransaction().begin();
        dao.cadastrar(risoto);
        dao.cadastrar(macarao);
        dao.cadastrar(arroz);
        em.flush();

        em.close();


    }

}
