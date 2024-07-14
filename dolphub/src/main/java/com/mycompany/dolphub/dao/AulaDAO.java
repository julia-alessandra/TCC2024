
package com.mycompany.dolphub.dao;
import com.mycompany.dolphub.dto.Aula;
import java.util.*;
import javax.persistence.*;
import javax.persistence.criteria.CriteriaQuery;

public class AulaDAO {
    public static void inserir(Aula aula) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("com.mycompany_dolphub_jar_1.0-SNAPSHOTPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(aula);
            entityManager.getTransaction().commit();
            System.out.println("Aula criada com sucesso!");
        } catch (Exception ex) {
            System.err.println("Erro ao criar aula");
        } finally {
            entityManager.close();
        }
    }
    public static void remover(int idAula) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("com.mycompany_dolphub_jar_1.0-SNAPSHOTPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            Aula aula = entityManager.find(Aula.class, idAula);
            if (aula != null) {
                entityManager.remove(aula);
                System.out.println("Aula excluída com sucesso!");
            } else {
                System.out.println("Não foi possível encontrar a aula");
            }
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            System.err.println("Erro ao excluir a aula");
        } finally {
            entityManager.close();
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;
        do {
            System.out.println(" DIGITE:\n"
                    + " 1 - Para criar nova aula\n"
                    + " 2 - Excluir aula\n"
                    + " 3 - Para Sair\n");
            opcao = scanner.nextInt();
            scanner.nextLine();
            switch (opcao) {
                case 1: {
                    Aula aula = new Aula();
                    System.out.println("Digite o titulo da aula: ");
                    aula.setTitulo(scanner.nextLine());
                    System.out.println("Digite a descrição da aula: ");
                    aula.setDescricao(scanner.nextLine());
                    System.out.println("Digite a duracao da aula: ");
                    aula.setDuracao(scanner.nextDouble());                    
                    System.out.println("Digite a duracao da aula: ");
                    aula.setDuracao(scanner.nextDouble());
                    inserir(aula);
                    break;
                }
                case 2: {
                    System.out.println("Digite o Id da aula: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    remover(id);
                    break;
                }
            }
        } while (opcao != 3);
        scanner.close();
    }



}
