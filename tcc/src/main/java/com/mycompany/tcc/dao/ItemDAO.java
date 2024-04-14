/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
public class ItemDAO {

    private EntityManagerFactory emf;
    private EntityManager em;

    public ItemDAO() {
        emf = Persistence.createEntityManagerFactory("com.mycompany_tcc_jar_1.0-SNAPSHOTPU");
        em = emf.createEntityManager();
    }

    public void inserir(Item item) {
        try {
            em.getTransaction().begin();
            em.persist(item);
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

    public void atualizar(Item item) {
        em.getTransaction().begin();
        Item i = em.find(Item.class, item.getId());

        i.setId(item.getId());
        i.setEstado(item.getEstado());
        i.setConteudo(item.getConteudo());
        em.merge(item);
        em.getTransaction().commit();
        em.close();
    }

    public void deletar(int id) {
        em.getTransaction().begin();
        Item i = em.find(Item.class, id);
        em.remove(i);

        em.getTransaction().commit();
        em.close();
    }

    public Item selecionar(int id) {
        em.getTransaction().begin();
        Item i = em.find(Item.class, id);
        em.getTransaction().commit();
        em.close();

        return i;

    }

    public List<Item> pesquisarMetaItem(MetaItem metaItem) {
        var cBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Item> c = cBuilder.createQuery(Item.class);
        var root = c.from(Item.class);
        c.select(root).where(cBuilder.equal(root.get("metaItem"), metaItem));

        List<Item> itens = em.createQuery(c).getResultList();
        em.close();
        return itens;
    }

    public List<Item> pesquisarEstado(String estado) {
         var cBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Item> c = cBuilder.createQuery(Item.class);
        var root = c.from(Item.class);
        c.select(root).where(cBuilder.like(root.get("estado"), "%" + estado + "%"));

        List<Item> itens = em.createQuery(c).getResultList();
        em.close();
        return itens;
    }

    public List<Item> listar() {
        TypedQuery<Item> q = em.createQuery("SELECT i FROM Item i", Item.class);
        List<Item> lista = q.getResultList();
        return lista;
    }
}
