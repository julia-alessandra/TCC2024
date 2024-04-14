
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
public class TarefaDAO {
    
    private EntityManagerFactory emf;
    private EntityManager em;
    
    public TarefaDAO() {
        emf = Persistence.createEntityManagerFactory("com.mycompany_tcc_jar_1.0-SNAPSHOTPU");
        em = emf.createEntityManager();
    }
    
    public void inserir(Tarefa tarefa) {
        try {
            em.getTransaction().begin();
            em.persist(tarefa);
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
    
    public void atualizar(Tarefa tarefa) {
        em.getTransaction().begin();
        Tarefa t = em.find(Tarefa.class, tarefa.getId());
        
        t.setNome(tarefa.getNome());
        t.setDescricao(tarefa.getDescricao());
        t.setPeriodicidade(tarefa.getPeriodicidade());
        t.setData(tarefa.getData());
        t.setHorario(tarefa.getHorario());
        t.setCategorias(tarefa.getCategorias());
        em.merge(tarefa);
        em.getTransaction().commit();
        em.close();
    }
    
    public void apagar(int id) {
        em.getTransaction().begin();
        Tarefa t = em.find(Tarefa.class, id);
        em.remove(t);
        
        em.getTransaction().commit();
        em.close();
    }
    
    public Tarefa selecionar(int id) {
        
        em.getTransaction().begin();
        Tarefa t = em.find(Tarefa.class, id);
        em.getTransaction().commit();
        em.close();
        
        return t;
        
    }
    
    public List<Tarefa> pesquisarNome(String txt) {
        var cBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Tarefa> c = cBuilder.createQuery(Tarefa.class);
        var root = c.from(Tarefa.class);
        c.select(root).where(cBuilder.like(root.get("nome"), "%" + txt + "%"));

        List<Tarefa> tarefas = em.createQuery(c).getResultList();
        em.close();
        return tarefas;
    }
    
    public List<Tarefa> pesquisarUsuario(Usuario usuario) {
        var cBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Tarefa> c = cBuilder.createQuery(Tarefa.class);
        var root = c.from(Tarefa.class);
        c.select(root).where(cBuilder.equal(root.get("id_user_usuario"), usuario.getId()));

        List<Tarefa> tarefas = em.createQuery(c).getResultList();
        em.close();
        return tarefas;
    }
    
    public List<Tarefa> pesquisarRotina(Rotina rotina) {
        var cBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Tarefa> c = cBuilder.createQuery(Tarefa.class);
        var root = c.from(Tarefa.class);
        c.select(root).where(cBuilder.equal(root.get("id_rotina_rotina"), rotina.getId()));

        List<Tarefa> tarefas = em.createQuery(c).getResultList();
        em.close();
        return tarefas;
    }
    
    public List<Tarefa> pesquisarData(String data) {
        var cBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Tarefa> c = cBuilder.createQuery(Tarefa.class);
        var root = c.from(Tarefa.class);
        c.select(root).where(cBuilder.like(root.get("data_tarefa"), "%" + data + "%"));

        List<Tarefa> tarefas = em.createQuery(c).getResultList();
        em.close();
        return tarefas;
    }
    
    public List<Tarefa> listar() {
        TypedQuery<Tarefa> q = em.createQuery("SELECT t FROM Tarefa t", Tarefa.class);
        List<Tarefa> lista = q.getResultList();
        return lista;
    }
    
    public List<Tarefa> listar(Categoria categoria) {
        CriteriaBuilder cBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Tarefa> cq = cBuilder.createQuery(Tarefa.class);
        Root<Tarefa> root = cq.from(Tarefa.class);
        Join<Tarefa, Categoria> join = root.join("categorias");
        cq.where(cBuilder.equal(join.get("id_categoria_categoria"), categoria.getId()));
        return em.createQuery(cq).getResultList();
    }
    
    public static void main(String[] args) {
        EntityManagerFactory emft = Persistence.createEntityManagerFactory("com.mycompany_tcc_jar_1.0-SNAPSHOTPU");
        EntityManager emt = emft.createEntityManager();
        TarefaDAO dao = new TarefaDAO();
        
        emt.getTransaction().begin();
        Usuario u = emt.find(Usuario.class, "userfake");
        emt.getTransaction().commit();
        
        emt.getTransaction().begin();
        Categoria c = emt.find(Categoria.class, 1);
        emt.getTransaction().commit();
        
        emt.getTransaction().begin();
        Rotina r = emt.find(Rotina.class, 1);
        emt.getTransaction().commit();
        
        Tarefa t = new Tarefa();
        t.setUsuario(u);
        t.setRotina(r);
        t.setId(1);
        t.setDescricao("teste desc");
        t.setNome("nome tarefa");
        
        System.out.println("Até aqui tudo certo 1111");
        dao.inserir(t);
        System.out.println("Funcionou");
    }
}
