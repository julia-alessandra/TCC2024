package com.mycompany.dolphub.dao;

import com.mycompany.dolphub.dto.Questao;
import java.util.List;

import javax.persistence.*;
import java.util.Scanner;
import javax.persistence.criteria.*;

public class QuestaoDAO {

    public static void inserir(Questao questao) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("com.mycompany_dolphub_jar_1.0-SNAPSHOTPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(questao);
            entityManager.getTransaction().commit();
            System.out.println("Questão criada com sucesso!");
        } catch (Exception ex) {
            System.err.println("Erro ao criar a questão");
        } finally {
            entityManager.close();
        }
    }

    public static void remover(int idQuestao) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("com.mycompany_dolphub_jar_1.0-SNAPSHOTPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            Questao questao = entityManager.find(Questao.class, idQuestao);
            if (questao != null) {
                entityManager.remove(questao);
                System.out.println("Questão excluída com sucesso!");
            } else {
                System.out.println("Não foi possível encontrar a questão");
            }
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            System.err.println("Erro ao excluir a questão");
        } finally {
            entityManager.close();
        }
    }

    public static void exibirQuestoes() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("com.mycompany_dolphub_jar_1.0-SNAPSHOTPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        CriteriaQuery<Questao> criteria = entityManager.getCriteriaBuilder().createQuery(Questao.class);
        criteria.select(criteria.from(Questao.class));
        List<Questao> questoes = entityManager.createQuery(criteria).getResultList();
        for (Questao questao : questoes) {
            System.out.println("Id: " + questao.getId() + "\nComando: " + questao.getComando() + "\nTags: " + questao.getTags());
            entityManager.close();
        }
    }

    public Questao getQuestao(int id) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("com.mycompany_dolphub_jar_1.0-SNAPSHOTPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            Query query = entityManager.createQuery("FROM Questao AS u WHERE u.id_questao =:id ");
            query.setParameter("id", id);
            List<Questao> pesquisa = query.getResultList();
            if (!pesquisa.isEmpty()) {
                return pesquisa.get(0);
            } else {
                System.out.println("Usuário não encontrado");
                return null;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static boolean atualizarQuestao(Questao questao) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("com.mycompany_dolphub_jar_1.0-SNAPSHOTPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {

            entityManager.getTransaction().begin();
            Questao persist = entityManager.find(Questao.class, questao.getId());

            if (persist != null) {
                persist.setComando(questao.getComando());
                persist.setTags(questao.getTags());
                entityManager.getTransaction().commit();
            } else {
                System.out.println("Não foi possível encontrar a questao");
                return false;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;
        do {
            System.out.println(" DIGITE:\n"
                    + " 1 - Para criar novas questões\n"
                    + " 2 - Excluir Questão\n"
                    + " 3 - Exibir questões\n"
                    + " 4 - Atualizar questão\n"
                    + " 5 - Sair\n");
            opcao = scanner.nextInt();
            scanner.nextLine();
            switch (opcao) {
                case 1: {
                    Questao questao = new Questao();
                    System.out.println("Digite o comando da questão: ");
                    questao.setComando(scanner.nextLine());
                    System.out.println("Digite a(s) tag(s) da questão: (separadas por virgula)");
                    questao.setTags(scanner.nextLine());
                    inserir(questao);
                    break;
                }
                case 2: {
                    System.out.println("Digite o Id da Questão: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    remover(id);
                    break;
                }
                case 3: {
                    QuestaoDAO.exibirQuestoes();
                    break;
                }
                case 4: {
                    int id;
                    System.out.println("Digite o id da questao: ");
                    id = scanner.nextInt();
                    scanner.nextLine();
                    Questao questao = new Questao();
                    QuestaoDAO q = new QuestaoDAO();
                    questao = q.getQuestao(id);

                    System.out.println("Digite o novo comando da questão: ");
                    questao.setComando(scanner.nextLine());

                    System.out.println("Digite as novas tags da questão: ");
                    questao.setTags(scanner.nextLine());
                    
                    atualizarQuestao(questao);
                    System.out.println("Questão atualizada");
                }
            }
        } while (opcao != 5);
        scanner.close();
    }
}
