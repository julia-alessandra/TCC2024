
package com.mycompany.dolphub.dao;

import com.mycompany.dolphub.dto.Curso;
import com.mycompany.dolphub.dto.Professor;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author Pedro Gabriel
 */
public class ProfessorDAO {
    private EntityManagerFactory emf;
    private EntityManager em;
    
    public ProfessorDAO() {
        emf = Persistence.createEntityManagerFactory("com.mycompany_dolphub_jar_1.0-SNAPSHOTPU");
        em = emf.createEntityManager();
    }
    
    public boolean inserir(Professor professor) {
        try {
            
            em.getTransaction().begin();
            em.persist(professor);
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
            Professor pro = em.find(Professor.class, id);
            
            if(pro != null) {
                em.remove(pro);
                em.getTransaction().commit();
            } else {
                System.out.println("Não foi possível encontrar o professor");
                return false;
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return true;
    }
    
    public boolean atualizar(Professor user) {
        
        try {
            
            em.getTransaction().begin();
            Professor persist = em.find(Professor.class, user.getId());
            
            if(persist != null) {
                persist.setNome(user.getNome());
                persist.setData(user.getData());
                persist.setEmail(user.getEmail());
                persist.setCurso(user.getCurso());
                em.getTransaction().commit();
            } else {
                System.out.println("Não foi possível encontrar o professor");
                return false;
            }
        } catch(Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
    
    public List<Professor> listar() {
        try {
            
            em.getTransaction().begin();
            CriteriaQuery<Professor> criteria = em.getCriteriaBuilder().createQuery(Professor.class);
            criteria.select(criteria.from(Professor.class));
            List<Professor> professores = em.createQuery(criteria).getResultList();
            return professores;
            
        } catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    public Professor getProfessor(int id) {
        try {
            em.getTransaction().begin();
            Query query = em.createQuery("FROM Professor AS p WHERE p.id_professor =:id ");
            query.setParameter("id", id);
            List<Professor> pesquisa = query.getResultList();
            if(!pesquisa.isEmpty()) {
                return pesquisa.get(0);
            } else {
                System.out.println("Professor não encontrado");
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
            Professor pro = this.getProfessor(id);
            em.getTransaction().begin();
            Professor persist = em.find(Professor.class, pro.getId());
            
            if(persist != null) {
                lista = persist.getCursosAutorais();
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
        ProfessorDAO dao = new ProfessorDAO();
        
        Professor p = new Professor();
        p.setData("ontem");
        p.setEmail("a");
        p.setFormacao("engenharia de pesca");
        p.setNome("rondinely");
        p.setTitulo("doutor");
        
        dao.inserir(p);
        
    }
}
