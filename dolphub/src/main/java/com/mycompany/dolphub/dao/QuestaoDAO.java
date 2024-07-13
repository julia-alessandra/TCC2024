package com.mycompany.dolphub.dao;

import com.mycompany.dolphub.dto.Questao;
import java.text.ParseException;
import java.util.Scanner;
import javax.persistence.*;

/**
 *
 * @author Julia
 */
public class QuestaoDAO {

    public static void inserirQuestao(Questao questao) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(questao);
            entityManager.getTransaction().commit();
            System.out.println("Questão inserida com sucesso!");
        } catch (Exception ex) {
            System.err.println("Erro ao inserir a questão: ");

        } finally {
            entityManager.close();
        }
    }

    public static void excluirQuestao(int idQuestao) {
        EntityManagerFactory entityManagerFactory
                = Persistence.createEntityManagerFactory("persistence");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            Questao questao = entityManager.find(Questao.class, idQuestao);
            if (questao != null) {
                entityManager.remove(questao);
                System.out.println("Questão excluída com sucesso!");
            } else {
                System.out.println("Não foi possível encontrar a questão indicada");
            }
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            entityManager.getTransaction().rollback();
            System.err.println("Erro ao excluir a questão: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            entityManager.close();
        }
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;
        do {
            System.out.println("***SISTEMA DE GERENCIAMENTO DE QUESTÕES***");
            System.out.println(" DIGITE:\n"
                    + " 1 - Para Cadastrar Questão\n"
                    + " 2 - Excluir Questão\n"
                    + " 3 - Para Sair\n");
            opcao = scanner.nextInt();
            scanner.nextLine();
            switch (opcao) {
                case 1: {
                    Questao d = new Questao();
                    System.out.println("Digite o comando da questão: ");
                    d.setComando(scanner.nextLine());
                    System.out.println("Uma tag: ");
                    d.setTags(scanner.nextLine());
                    QuestaoDAO.inserirQuestao(d);
                    break;
                }

                case 2: {
                    System.out.println("Digite o Id da Questão: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    QuestaoDAO.excluirQuestao(id);
                    break;
                }
            }
        } while (opcao != 3);
    }
}
