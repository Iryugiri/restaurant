package br.com.restorant.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

    private static final EntityManagerFactory RESTORANT = Persistence.createEntityManagerFactory("restaurant");


    public static EntityManager getEntityManagerRestorant() {
        return RESTORANT.createEntityManager();
    }

}
