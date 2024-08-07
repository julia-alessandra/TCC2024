
package com.mycompany.dolphub.dao;

import com.mycompany.dolphub.dto.Curso;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import com.mycompany.dolphub.dto.Usuario; 
import javax.persistence.Query;

/**
 *
 * @author Pedro Gabriel
 */
public class UsuarioDAO {
    private EntityManagerFactory emf;
    private EntityManager em;
    
    public UsuarioDAO() {
        emf = Persistence.createEntityManagerFactory("com.mycompany_dolphub_jar_1.0-SNAPSHOTPU");
        em = emf.createEntityManager();
    }
    
    public boolean inserir(Usuario usuario) {
        try {
            
            em.getTransaction().begin();
            em.persist(usuario);
            em.getTransaction().commit();
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
    
    public boolean remover(int id) {
        try {
            
            em.getTransaction().begin();
            Usuario user = em.find(Usuario.class, id);
            
            if(user != null) {
                em.remove(user);
                em.getTransaction().commit();
            } else {
                System.out.println("Não foi possível encontrar o usuário");
                return false;
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return true;
    }
    
    public boolean atualizar(Usuario user) {
        
        try {
            
            em.getTransaction().begin();
            Usuario persist = em.find(Usuario.class, user.getId());
            
            if(persist != null) {
                persist.setNome(user.getNome());
                persist.setData(user.getData());
                persist.setEmail(user.getEmail());
                persist.setCurso(user.getCurso());
                em.getTransaction().commit();
            } else {
                System.out.println("Não foi possível encontrar o usuário");
                return false;
            }
        } catch(Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
    
    public List<Usuario> listar() {
        try {
            
            em.getTransaction().begin();
            CriteriaQuery<Usuario> criteria = em.getCriteriaBuilder().createQuery(Usuario.class);
            criteria.select(criteria.from(Usuario.class));
            List<Usuario> usuarios = em.createQuery(criteria).getResultList();
            return usuarios;
            
        } catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    public Usuario getUsuario(int id) {
        try {
            em.getTransaction().begin();
            Query query = em.createQuery("FROM Usuario AS u WHERE u.id_usuario =:id ");
            query.setParameter("id", id);
            List<Usuario> pesquisa = query.getResultList();
            if(!pesquisa.isEmpty()) {
                return pesquisa.get(0);
            } else {
                System.out.println("Usuário não encontrado");
                return null;
            }
        } catch(Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    public List<Curso> getMatriculas(int id) {
        List<Curso> lista = null;
        try {
            Usuario user = this.getUsuario(id);
            em.getTransaction().begin();
            Usuario persist = em.find(Usuario.class, user.getId());
            
            if(persist != null) {
                lista = persist.getCurso();
                return lista;
            } else {
                System.out.println("Não foi possível encontrar o usuário");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
        return lista;
    }
    
    public static void main(String[] args) {
        Usuario user = new Usuario();
        user.setNome("eu");
        user.setEmail("teste@gmail.com");
        user.setData("05/07/2006");
        
        UsuarioDAO dao = new UsuarioDAO();
        
        System.out.println(dao.inserir(user));
    }
    
}
