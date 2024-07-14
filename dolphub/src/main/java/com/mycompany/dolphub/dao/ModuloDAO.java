package com.mycompany.dolphub.dao;

import com.mycompany.dolphub.dto.*;
import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

/**
 * @author exoticlucas
 */
public class ModuloDAO {

    public void inserirModulo(Modulo modulo) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany_dolphub_jar_1.0-SNAPSHOTPU");
        EntityManager entityManager = emf.createEntityManager();

        try {
            entityManager.getTransaction().begin();
            entityManager.persist(modulo);
            entityManager.getTransaction().commit();
            System.out.println("Sucesso em criar modulo");
        } catch (Exception ex) {
            System.err.println("Erro ao criar modulo");
        } finally {
            entityManager.close();
        }
    }

    public void removerModulo(int idModulo) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany_dolphub_jar_1.0-SNAPSHOTPU");
        EntityManager entityManager = emf.createEntityManager();

        try {
            entityManager.getTransaction().begin();
            Modulo modulo = entityManager.find(Modulo.class, idModulo);
            if (modulo != null) {
                entityManager.remove(modulo);
                System.out.println("Sucesso em excluir modulo");
            } else {
                System.out.println("Erro ao excluir modulo");
            }
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            System.err.println("Erro ao excluir modulo");
        } finally {
            entityManager.close();
        }
    }

    public void mostrarTodosModulo() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("com.mycompany_dolphub_jar_1.0-SNAPSHOTPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        CriteriaQuery<Modulo> criteria = entityManager.getCriteriaBuilder().createQuery(Modulo.class);
        criteria.select(criteria.from(Modulo.class));
        List<Modulo> modulos = entityManager.createQuery(criteria).getResultList();
        for (Modulo modulo : modulos) {
            System.out.println("Id: " + modulo.getId() + "\nNome: " + modulo.getNome() + "\nDificuldade: " + modulo.getDificuldade() + "\nDescricao: " + modulo.getDescricao());
            entityManager.close();
        }
    }
    
    public Modulo pesquisaIdModulo(int idModulo){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("com.mycompany_dolphub_jar_1.0-SNAPSHOTPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            Query query = entityManager.createQuery("FROM Modulo AS u WHERE u.id_modulo =:id ");
            query.setParameter("id", entityManager);
            List<Modulo> pesquisa = query.getResultList();
            if(!pesquisa.isEmpty()) {
                return pesquisa.get(0);
            } else {
                System.out.println("Modulo não encontrado");
                return null;
            }
        } catch(Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    public boolean atualizarModulo(Modulo mod) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("com.mycompany_dolphub_jar_1.0-SNAPSHOTPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            
            entityManager.getTransaction().begin();
            Modulo persist = entityManager.find(Modulo.class, mod.getId());
            
            if(persist != null) {
                persist.setNome(mod.getNome());
                persist.setDescricao(mod.getDescricao());
                persist.setDificuldade(mod.getDificuldade());
                persist.setAtividades(mod.getAtividades());
                persist.setAulas(mod.getAulas());
                entityManager.getTransaction().commit();
                System.out.println("Sucesso em atualizar modulo");
            } else {
                System.out.println("Não foi possível encontrar o modulo");
                return false;
            }
        } catch(Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
    
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        ModuloDAO m = new ModuloDAO();
        int opcao = 0;
        do {
            System.out.println(" DIGITE:\n"
                    + " 1 - Para criar novo modulo\n"
                    + " 2 - Excluir modulo\n"
                    + " 3 - Atualizar modulo\n"
                    + " 4 - Para Sair\n");
            opcao = scan.nextInt();
            scan.nextLine();
            switch (opcao) {
                case 1: {
                    Modulo modulo = new Modulo();
                    System.out.println("Digite o nome do modulo");
                    modulo.setNome(scan.nextLine());
                    System.out.println("Digite a dificuldade do modulo");
                    modulo.setDificuldade(scan.nextInt());
                    scan.nextLine();
                    System.out.println("Digite a descricao do modulo");
                    modulo.setDescricao(scan.nextLine());
                    m.inserirModulo(modulo);
                    break;
                }
                case 2: {
                    System.out.println("Digite o Id do modulo: ");
                    int id = scan.nextInt();
                    scan.nextLine();
                    m.removerModulo(id);
                    break;
                }
                case 3:{
                    System.out.println("Digite o Id do modulo: ");
                    Modulo modulo = new Modulo();
                    modulo.setId(scan.nextInt());
                    scan.nextLine();
                    System.out.println("Digite o nome do modulo");
                    modulo.setNome(scan.nextLine());
                    System.out.println("Digite a dificuldade do modulo");
                    modulo.setDificuldade(scan.nextInt());
                    scan.nextLine();
                    System.out.println("Digite a descricao do modulo");
                    modulo.setDescricao(scan.nextLine());
                    
                    m.atualizarModulo(modulo);
                }
            }
        } while (opcao != 4);
        scan.close();
    }
}
