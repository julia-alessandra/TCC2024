/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tcc.dao;
import com.mycompany.tcc.dados.*;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import javax.persistence.criteria.*;
/**
 *
 * @author Master
 */

public class MetaTempoHistoricoDAO {
    private EntityManagerFactory emf;
    private EntityManager em;

    public MetaTempoHistoricoDAO() {
        emf = Persistence.createEntityManagerFactory("com.mycompany_tcc_jar_1.0-SNAPSHOTPU");
        em = emf.createEntityManager();
    }
    public void inserir(MetaTempoHistorico mth){
        try {
            em.getTransaction().begin();
            em.persist(mth);
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
    public void atualizar(MetaTempoHistorico mth) {
        em.getTransaction().begin();
        MetaTempoHistorico m = em.find(MetaTempoHistorico.class, mth.getId());

        m.setId(mth.getId());
        m.setDataRegistro(mth.getDataRegistro());
        m.setHorarioRegistro(mth.getHorarioRegistro());
        m.setTempoRegistrado(mth.getTempoRegistrado());
        em.merge(mth);
        em.getTransaction().commit();
        em.close();
    }

    public void deletar(int id) {
        em.getTransaction().begin();
        MetaTempoHistorico m = em.find(MetaTempoHistorico.class, id);
        em.remove(m);

        em.getTransaction().commit();
        em.close();
    }

    public MetaTempoHistorico selecionar(int id) {
        em.getTransaction().begin();
        MetaTempoHistorico m = em.find(MetaTempoHistorico.class, id);
        em.getTransaction().commit();
        em.close();

        return m;
    }

    public List<MetaTempoHistorico> pesquisarMetaTempo(MetaTempo metaTempo) {
        var cBuilder = em.getCriteriaBuilder();
        CriteriaQuery<MetaTempoHistorico> c = cBuilder.createQuery(MetaTempoHistorico.class);
        var root = c.from(MetaTempoHistorico.class);
        c.select(root).where(cBuilder.equal(root.get("metaTempo"), metaTempo));

        List<MetaTempoHistorico> mth = em.createQuery(c).getResultList();
        em.close();
        return mth;
    }

    public List<MetaTempoHistorico> pesquisarData(String data) {
        var cBuilder = em.getCriteriaBuilder();
        CriteriaQuery<MetaTempoHistorico> c = cBuilder.createQuery(MetaTempoHistorico.class);
        var root = c.from(MetaTempoHistorico.class);
        c.select(root).where(cBuilder.like(root.get("data"), "%" + data + "%"));

        List<MetaTempoHistorico> mth = em.createQuery(c).getResultList();
        em.close();
        return mth;
    }
    
    public List<MetaTempoHistorico> listar() {
        TypedQuery<MetaTempoHistorico> q = em.createQuery("SELECT mth FROM MetaTempoHistorico mth", MetaTempoHistorico.class);
        List<MetaTempoHistorico> lista = q.getResultList();
        return lista;
    }
    public List<MetaTempoHistorico> listar(MetaTempoHistorico historico) {
        CriteriaBuilder cBuilder = em.getCriteriaBuilder();
        CriteriaQuery<MetaTempoHistorico> cq = cBuilder.createQuery(MetaTempoHistorico.class);
        Root<MetaTempoHistorico> root = cq.from(MetaTempoHistorico.class);
        Join<MetaTempoHistorico, MetaTempo> join = root.join("historicos");
        cq.where(cBuilder.equal(join.get("id"), historico.getId()));
        return em.createQuery(cq).getResultList();
    }
}
