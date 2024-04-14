
package com.mycompany.tcc.dao;

import com.mycompany.tcc.dados.*;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import javax.persistence.criteria.*;

/**
 *
 * @author Pedro Gabriel
 */
public class RotinaDAO {
    private EntityManagerFactory emf;
    private EntityManager em;
    
    public RotinaDAO() {
        emf = Persistence.createEntityManagerFactory("com.mycompany_tcc_jar_1.0-SNAPSHOTPU");
        em = emf.createEntityManager();
    }
    
    public void inserir(Rotina rotina) {
        try {
            em.getTransaction().begin();
            em.persist(rotina);
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
    
    public void atualizar(Rotina rotina) {
        em.getTransaction().begin();
        Rotina r = em.find(Rotina.class, rotina.getId());
        
        r.setNome(rotina.getNome());
        r.setDescricao(rotina.getDescricao());
        r.setCor(rotina.getCor());
        r.setQuantTarefas(rotina.getQuantTarefas());
        r.setCategorias(rotina.getCategorias());
        
        em.merge(rotina);
        em.getTransaction().commit();
        em.close();
    }
    
    public void apagar(int id) {
        em.getTransaction().begin();
        Rotina r = em.find(Rotina.class, id);
        em.remove(r);
        
        em.getTransaction().commit();
        em.close();
    }
    
    public Rotina selecionar(int id) {
        em.getTransaction().begin();
        Rotina r = em.find(Rotina.class, id);
        em.getTransaction().commit();
        em.close();
        
        return r;
    }
    
    public List<Rotina> pesquisarNome(String txt) {
        var cBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Rotina> c = cBuilder.createQuery(Rotina.class);
        var root = c.from(Rotina.class);
        c.select(root).where(cBuilder.like(root.get("nome"), "%" + txt + "%"));

        List<Rotina> rotinas = em.createQuery(c).getResultList();
        em.close();
        return rotinas;
    }
    
    public List<Rotina> pesquisarUsuario(Usuario usuario) {
        var cBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Rotina> c = cBuilder.createQuery(Rotina.class);
        var root = c.from(Rotina.class);
        c.select(root).where(cBuilder.equal(root.get("usuario"), usuario));

        List<Rotina> rotinas = em.createQuery(c).getResultList();
        em.close();
        return rotinas;
    }
    
    public List<Rotina> pesquisarCor(String cor) {
        var cBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Rotina> c = cBuilder.createQuery(Rotina.class);
        var root = c.from(Rotina.class);
        c.select(root).where(cBuilder.like(root.get("cor"), "%" + cor + "%"));

        List<Rotina> rotinas = em.createQuery(c).getResultList();
        em.close();
        return rotinas;
    }
    
    public List<Rotina> listar() {
        TypedQuery<Rotina> q = em.createQuery("SELECT r FROM Rotina r", Rotina.class);
        List<Rotina> lista = q.getResultList();
        return lista;
    }
    
    public List<Rotina> listar(Categoria categoria) {
        CriteriaBuilder cBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Rotina> cq = cBuilder.createQuery(Rotina.class);
        Root<Rotina> root = cq.from(Rotina.class);
        Join<Rotina, Categoria> join = root.join("categorias");
        cq.where(cBuilder.equal(join.get("id"), categoria.getId()));
        return em.createQuery(cq).getResultList();
    }
}
