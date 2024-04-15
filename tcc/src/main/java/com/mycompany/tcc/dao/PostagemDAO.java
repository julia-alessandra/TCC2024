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
public class PostagemDAO {

    private EntityManagerFactory emf;
    private EntityManager em;

    public PostagemDAO() {
        emf = Persistence.createEntityManagerFactory("com.mycompany_tcc_jar_1.0-SNAPSHOTPU");
        em = emf.createEntityManager();
    }

    public void inserir(Postagem postagem) {
        try {
            em.getTransaction().begin();
            em.persist(postagem);
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

    public void atualizar(Postagem postagem) {
        em.getTransaction().begin();
        Postagem g = em.find(Postagem.class, postagem.getId());

        g.setId(postagem.getId());
        g.setConteudo(postagem.getConteudo());
        em.merge(postagem);
        em.getTransaction().commit();
        em.close();
    }

    public void deletar(int id) {
        em.getTransaction().begin();
        Postagem i = em.find(Postagem.class, id);
        em.remove(i);

        em.getTransaction().commit();
        em.close();
    }

    public Postagem selecionar(int id) {
        em.getTransaction().begin();
        Postagem i = em.find(Postagem.class, id);
        em.getTransaction().commit();
        em.close();

        return i;

    }
}