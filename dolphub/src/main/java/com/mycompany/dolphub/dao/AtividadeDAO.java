package com.mycompany.dolphub.dao;

import com.mycompany.dolphub.dto.Atividade;
import java.util.*;
import javax.persistence.*;
import javax.persistence.criteria.CriteriaQuery;

public class AtividadeDAO {

    public static void inserir(Atividade atividade) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("com.mycompany_dolphub_jar_1.0-SNAPSHOTPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(atividade);
            entityManager.getTransaction().commit();
            System.out.println("Atividade criada com sucesso!");
        } catch (Exception ex) {
            System.err.println("Erro ao criar atividade");
        } finally {
            entityManager.close();
        }
    }

    public static void remover(int idAtividade) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("com.mycompany_dolphub_jar_1.0-SNAPSHOTPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            Atividade atividade = entityManager.find(Atividade.class, idAtividade);
            if (atividade != null) {
                entityManager.remove(atividade);
                System.out.println("Atividade excluída com sucesso!");
            } else {
                System.out.println("Não foi possível encontrar a atividade");
            }
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            System.err.println("Erro ao excluir a atividade");
        } finally {
            entityManager.close();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;
        do {
            System.out.println(" DIGITE:\n"
                    + " 1 - Para criar nova atividade\n"
                    + " 2 - Excluir atividade\n"
                    + " 3 - Para Sair\n");
            opcao = scanner.nextInt();
            scanner.nextLine();
            switch (opcao) {
                case 1: {
                    Atividade atividade = new Atividade();
                    System.out.println("Digite o titulo da atividade: ");
                    atividade.setTitulo(scanner.nextLine());
                    System.out.println("Digite a descrição da atividade: ");
                    atividade.setDescricao(scanner.nextLine());
                    System.out.println("Digite a dificuldade da atividade");
                    atividade.setDificuldade(scanner.nextLine());
                    inserir(atividade);
                    break;
                }
                case 2: {
                    System.out.println("Digite o Id da atividade: ");
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
