package com.mycompany.dolphub.dao;

import com.mycompany.dolphub.dto.*;
import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;

/**
 * @author exoticlucas
 */
public class ModuloDAO {

    public static void inserirModulo(Modulo modulo) {
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

    public static void removerModulo(int idModulo) {
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

    public static void mostrarTodosModulo() {
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
    
    public static Modulo pesquisaIdModulo(int idModulo){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany_dolphub_jar_1.0-SNAPSHOTPU");
        EntityManager entityManager = emf.createEntityManager();
        Modulo modulo = null;
        try {
            entityManager.getTransaction().begin();
            modulo = entityManager.find(Modulo.class, idModulo);
            entityManager.getTransaction().commit();
            
        } catch (Exception ex) {
            System.err.println("Erro ao excluir modulo");
        } finally {
            entityManager.close();
        }
        return modulo;
    }
    
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        int opcao = 0;
        do {
            System.out.println(" DIGITE:\n"
                    + " 1 - Para criar novo modulo\n"
                    + " 2 - Excluir modulo\n"
                    + " 3 - Para Sair\n");
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
                    inserirModulo(modulo);
                    break;
                }
                case 2: {
                    System.out.println("Digite o Id do modulo: ");
                    int id = scan.nextInt();
                    scan.nextLine();
                    removerModulo(id);
                    break;
                }
            }
        } while (opcao != 3);
        scan.close();
    }
}
