
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
public class CategoriaDAO {
    private EntityManagerFactory emf;
    private EntityManager em;
    
    public CategoriaDAO() {
        emf = Persistence.createEntityManagerFactory("com.mycompany_tcc_jar_1.0-SNAPSHOTPU");
        em = emf.createEntityManager();
    }
    
    public void inserir(Categoria categoria) {
        try {
            em.getTransaction().begin();
            em.persist(categoria);
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
    
    public void atualizar(Categoria categoria) {
        em.getTransaction().begin();
        Categoria c = em.find(Categoria.class, categoria.getId());
        
        c.setNome(categoria.getNome());
        c.setDescricao(categoria.getDescricao());
        
        em.merge(categoria);
        em.getTransaction().commit();
        em.close();
    }
    
    public void apagar(int id) {
        em.getTransaction().begin();
        Categoria c = em.find(Categoria.class, id);
        em.remove(c);
        
        em.getTransaction().commit();
        em.close();
    }
    
    public Categoria selecionar(int id) {
        em.getTransaction().begin();
        Categoria c = em.find(Categoria.class, id);
        em.getTransaction().commit();
        em.close();
        
        return c;
    }
    
    public List<Categoria> pesquisarNome(String txt) {
        var cBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Categoria> c = cBuilder.createQuery(Categoria.class);
        var root = c.from(Categoria.class);
        c.select(root).where(cBuilder.like(root.get("nome"), "%" + txt + "%"));

        List<Categoria> categorias = em.createQuery(c).getResultList();
        em.close();
        return categorias;
    }
    
    public List<Categoria> pesquisarUsuario(Usuario usuario) {
        var cBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Categoria> c = cBuilder.createQuery(Categoria.class);
        var root = c.from(Categoria.class);
        c.select(root).where(cBuilder.equal(root.get("usuario"), usuario));

        List<Categoria> lista = em.createQuery(c).getResultList();
        em.close();
        return lista;
    }
    
    public List<Categoria> listar() {
        TypedQuery<Categoria> q = em.createQuery("SELECT c FROM Categoria c", Categoria.class);
        List<Categoria> lista = q.getResultList();
        return lista;
    }
    
    public List<Categoria> listar(Rotina rotina) {
        CriteriaBuilder cBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Categoria> cq = cBuilder.createQuery(Categoria.class);
        Root<Categoria> root = cq.from(Categoria.class);
        Join<Categoria, Rotina> join = root.join("rotinas");
        cq.where(cBuilder.equal(join.get("id"), rotina.getId()));
        return em.createQuery(cq).getResultList();
    }
    
    public List<Categoria> listar(Tarefa tarefa) {
        CriteriaBuilder cBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Categoria> cq = cBuilder.createQuery(Categoria.class);
        Root<Categoria> root = cq.from(Categoria.class);
        Join<Categoria, Tarefa> join = root.join("tarefas");
        cq.where(cBuilder.equal(join.get("id"), tarefa.getId()));
        return em.createQuery(cq).getResultList();
    }
}
