package com.mycompany.tcc.dao;

import com.mycompany.tcc.dados.*;
import java.util.ArrayList;
import javax.persistence.*;
import javax.persistence.criteria.*;
import java.util.List;

/**
 *
 * @author Master
 */
public class GrupoDAO {

    private EntityManagerFactory emf;
    private EntityManager em;

    public GrupoDAO() {
        emf = Persistence.createEntityManagerFactory("com.mycompany_tcc_jar_1.0-SNAPSHOTPU");
        em = emf.createEntityManager();
    }

    public void inserir(Grupo grupo) {
        try {
            em.getTransaction().begin();
            em.persist(grupo);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            System.out.println(e.getMessage());
        } finally {
            em.close();
        }
    }

    public void atualizar(Grupo grupo) {
        em.getTransaction().begin();
        Grupo g = em.find(Grupo.class, grupo.getId());

        g.setId(grupo.getId());
        g.setNome(grupo.getNome());
        g.setDescricao(grupo.getDescricao());
        em.merge(grupo);
        em.getTransaction().commit();
        em.close();
    }

    public void deletar(int id) {
        em.getTransaction().begin();
        Grupo i = em.find(Grupo.class, id);
        em.remove(i);

        em.getTransaction().commit();
        em.close();
    }

    public Grupo selecionar(int id) {
        em.getTransaction().begin();
        Grupo i = em.find(Grupo.class, id);
        em.getTransaction().commit();
        em.close();

        return i;

    }
}