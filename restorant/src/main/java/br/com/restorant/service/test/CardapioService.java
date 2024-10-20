package br.com.restorant.service.test;

import br.com.restorant.dao.CardapioDao;
import br.com.restorant.dao.CategoriaDao;
import br.com.restorant.entity.Cardapio;
import br.com.restorant.entity.Categoria;
import br.com.restorant.util.CargaDeDadosUtil;
import br.com.restorant.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class CardapioService {

    public static void main(String[] args) {
        EntityManager em = JPAUtil.getEntityManagerRestorant();
        CargaDeDadosUtil.cadastraProdutoCardapio(em);
        CargaDeDadosUtil.cadastrarCategoria(em);
        CargaDeDadosUtil.cadastraProdutoCardapio(em);
        CardapioDao dao = new CardapioDao(em);
        List<Cardapio> listCar = dao.consultarPorValor(BigDecimal.valueOf(10.3), BigDecimal.valueOf(40.2));
        listCar.forEach(elem -> System.out.println("\n\nOs pratos nesse preco: " + elem));
        em.close();
    }





}
