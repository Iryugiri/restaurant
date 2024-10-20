package br.com.restorant.util;

import br.com.restorant.dao.CardapioDao;
import br.com.restorant.dao.CategoriaDao;
import br.com.restorant.entity.Cardapio;
import br.com.restorant.entity.Categoria;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class CargaDeDadosUtil {

    private static Boolean cadAtivo = false;

    public static void cadastrarCategoria(EntityManager em) {
        CategoriaDao dao = new CategoriaDao(em);
        Categoria categoria = new Categoria("Comida");
        Categoria categoria1 = new Categoria("Bebida");
        Categoria categoria2 = new Categoria("Sobremesa");

        em.getTransaction().begin();
        dao.cadastrar(categoria);
        dao.cadastrar(categoria1);
        dao.cadastrar(categoria2);
        em.getTransaction().commit();
        em.clear();

        cadAtivo = true;
    }

    public static void cadastraProdutoCardapio(EntityManager em) {
        if (cadAtivo) {
            CategoriaDao categoriaDao = new CategoriaDao(em);
            CardapioDao dao = new CardapioDao(em);

            List<Categoria> catList = categoriaDao.consultarTodos();

            Cardapio risoto = new Cardapio("risoto", "risoto acompanhado de uma carne de sua escolha", BigDecimal.valueOf(70.5), true, catList.get(0));
            Cardapio macarao = new Cardapio("macarrao", "macarrao acompanhado de uma carne de sua escolha", BigDecimal.valueOf(30.5), true, catList.get(0));
            Cardapio sorvete = new Cardapio("Sorvete", "Acompanha cobertura e chocolate", BigDecimal.valueOf(20.5), true, catList.get(1));
            Cardapio Coca = new Cardapio("Coca", "Coca Cola acompanhada por gelo", BigDecimal.valueOf(40.5), true, catList.get(2));

            em.getTransaction().begin();
            dao.cadastrar(risoto);
            dao.cadastrar(Coca);
            dao.cadastrar(macarao);
            dao.cadastrar(sorvete);
            em.getTransaction().commit();
            em.clear();

            dao.consultarTodos().forEach(produt -> System.out.println("\nO cardapio tem o prato: " + produt));
        }
        else {
            System.out.println("Cadastre a categoria primeiro");
        }
    }

}
