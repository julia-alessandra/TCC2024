package com.mycompany.tcc.dao;

import com.mycompany.tcc.dados.Grupo;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class GrupoDAO {

    private static final EntityManagerFactory entityManagerFactory
            = Persistence.createEntityManagerFactory("persistence");

    public static void inserirGrupo(Grupo grupo) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(grupo);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            throw ex;
        } finally {
            entityManager.close();
        }
    }

    public static void removerGrupo(int id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            Grupo grupo = entityManager.find(Grupo.class, id);
            if (grupo != null) {
                entityManager.remove(grupo);
            }
            transaction.commit();
        } catch (Exception ex) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw ex;
        } finally {
            entityManager.close();
        }
    }

    public static Grupo obterGrupoPorId(int id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            return entityManager.find(Grupo.class, id);
        } finally {
            entityManager.close();
        }
    }
}
