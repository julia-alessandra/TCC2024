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
public class MetaDAO {

    private EntityManagerFactory emf;
    private EntityManager em;

    public MetaDAO() {
        emf = Persistence.createEntityManagerFactory("com.mycompany_tcc_jar_1.0-SNAPSHOTPU");
        em = emf.createEntityManager();
    }

    public void inserir(Meta meta) {
        try {
            em.getTransaction().begin();
            em.persist(meta);
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

    public void atualizar(Meta meta) {
        em.getTransaction().begin();
        if (meta instanceof MetaAcumulativa) {
            MetaAcumulativa metaA = (MetaAcumulativa) meta;
            MetaAcumulativa m = em.find(MetaAcumulativa.class, metaA.getId());
            m.setId(metaA.getId());
            m.setNome(metaA.getNome());
            m.setTipo(metaA.getTipo());
            m.setNome(metaA.getNome());
            m.setDataInicio(metaA.getDataInicio());
            m.setDataFinal(metaA.getDataFinal());
            m.setEstado(metaA.getEstado());
            m.setDescricao(metaA.getDescricao());

            m.setProgresso(metaA.getProgresso());
            m.setObjetivo(metaA.getObjetivo());
            m.setUnidade(metaA.getUnidade());
            em.merge(metaA);
            em.getTransaction().commit();
            em.close();
        } else if (meta instanceof MetaItem) {
            MetaItem metaI = (MetaItem) meta;
            MetaItem m = em.find(MetaItem.class, metaI.getId());
            m.setId(metaI.getId());
            m.setNome(metaI.getNome());
            m.setTipo(metaI.getTipo());
            m.setNome(metaI.getNome());
            m.setDataInicio(metaI.getDataInicio());
            m.setDataFinal(metaI.getDataFinal());
            m.setEstado(metaI.getEstado());
            m.setDescricao(metaI.getDescricao());
            m.setItens(metaI.getItens());

            m.setQnt(metaI.getQnt());
            m.setQntCompleta(metaI.getQntCompleta());
            em.merge(metaI);
            em.getTransaction().commit();
            em.close();
        } else if (meta instanceof MetaTempo) {
            MetaTempo metaT = (MetaTempo) meta;
            MetaTempo m = em.find(MetaTempo.class, metaT.getId());
            m.setId(metaT.getId());
            m.setNome(metaT.getNome());
            m.setTipo(metaT.getTipo());
            m.setNome(metaT.getNome());
            m.setDataInicio(metaT.getDataInicio());
            m.setDataFinal(metaT.getDataFinal());
            m.setEstado(metaT.getEstado());
            m.setDescricao(metaT.getDescricao());
            m.setHistoricos(metaT.getHistoricos());

            m.setObjetivoDiario(metaT.getObjetivoDiario());
            
            em.merge(metaT);
            em.getTransaction().commit();
            em.close();
        }
    }

    public void deletar(int id) {
        em.getTransaction().begin();
        Meta m = em.find(Meta.class, id);
        em.remove(m);

        em.getTransaction().commit();
        em.close();
    }

    public Meta selecionar(int id) {
        em.getTransaction().begin();
        Meta m = em.find(Meta.class, id);
        em.getTransaction().commit();
        em.close();

        return m;
    }

    public List<Meta> pesquisarUsuario(Usuario usuario) {
        var cBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Meta> m = cBuilder.createQuery(Meta.class);
        var root = m.from(Meta.class);
        m.select(root).where(cBuilder.equal(root.get("usuario"), usuario));

        List<Meta> metas = em.createQuery(m).getResultList();
        em.close();
        return metas;
    }

    public List<Meta> listar() {
        TypedQuery<Meta> q = em.createQuery("SELECT m FROM Meta m", Meta.class);
        List<Meta> lista = q.getResultList();
        return lista;
    }

    public List<MetaAcumulativa> listarMetaAcumulativa() {
        TypedQuery<MetaAcumulativa> q = em.createQuery("SELECT m FROM MetaAcumulativa m", MetaAcumulativa.class);
        List<MetaAcumulativa> lista = q.getResultList();
        return lista;
    }
    public List<MetaItem> listarMetaItem() {
        TypedQuery<MetaItem> q = em.createQuery("SELECT m FROM MetaItem m", MetaItem.class);
        List<MetaItem> lista = q.getResultList();
        return lista;
    }
    public List<MetaTempo> listarMetaTempo() {
        TypedQuery<MetaTempo> q = em.createQuery("SELECT m FROM MetaTempo m", MetaTempo.class);
        List<MetaTempo> lista = q.getResultList();
        return lista;
    }
    public List<MetaItem> listar(Item item) {
        CriteriaBuilder cBuilder = em.getCriteriaBuilder();
        CriteriaQuery<MetaItem> cq = cBuilder.createQuery(MetaItem.class);
        Root<MetaItem> root = cq.from(MetaItem.class);
        Join<MetaItem, Item> join = root.join("itens");
        cq.where(cBuilder.equal(join.get("id"), item.getId()));
        return em.createQuery(cq).getResultList();
    }
    public List<MetaTempoHistorico> listar(MetaTempoHistorico historico) {
        CriteriaBuilder cBuilder = em.getCriteriaBuilder();
        CriteriaQuery<MetaTempoHistorico> cq = cBuilder.createQuery(MetaTempoHistorico.class);
        Root<MetaTempoHistorico> root = cq.from(MetaTempoHistorico.class);
        Join<MetaTempoHistorico, Item> join = root.join("historicos");
        cq.where(cBuilder.equal(join.get("id"), historico.getId()));
        return em.createQuery(cq).getResultList();
    }
}
