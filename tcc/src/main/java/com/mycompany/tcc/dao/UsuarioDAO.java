package com.mycompany.tcc.dao;

import com.mycompany.tcc.dados.*;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import javax.persistence.criteria.*;

public class UsuarioDAO {
    
    private EntityManagerFactory emf;
    private EntityManager em;
    
    public UsuarioDAO() {
        emf = Persistence.createEntityManagerFactory("com.mycompany_tcc_jar_1.0-SNAPSHOTPU");
        em = emf.createEntityManager();
    }
    
    public void inserir(Usuario usuario) {
        try {
            em.getTransaction().begin();
            em.persist(usuario);
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
    
    public void atualizar(Usuario usuario) {
        em.getTransaction().begin();
        Usuario u = em.find(Usuario.class, usuario.getId());
        
        u.setNome(usuario.getNome());
        u.setBio(usuario.getBio());
        u.setPontuacao(usuario.getPontuacao());
        em.merge(usuario);
        em.getTransaction().commit();
        em.close();
    }
    
    public void apagar(int id) {
        em.getTransaction().begin();
        Usuario u = em.find(Usuario.class, id);
        em.remove(u);
        
        em.getTransaction().commit();
        em.close();
    }
    
    public Usuario selecionar(int id) {
        
        em.getTransaction().begin();
        Usuario u = em.find(Usuario.class, id);
        em.getTransaction().commit();
        em.close();
        
        return u;
        
    }
    
    public List<Usuario> pesquisarNome(String txt) {
        var cBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Usuario> c = cBuilder.createQuery(Usuario.class);
        var root = c.from(Usuario.class);
        c.select(root).where(cBuilder.like(root.get("nome"), "%" + txt + "%"));

        List<Usuario> usuarios = em.createQuery(c).getResultList();
        em.close();
        return usuarios;
    }
    
    
    public List<Usuario> listar() {
        TypedQuery<Usuario> q = em.createQuery("SELECT t FROM Usuario t", Usuario.class);
        List<Usuario> lista = q.getResultList();
        return lista;
    }
    
    
    public static void main(String[] args) {
        // testes
        
    }
}
