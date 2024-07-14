package com.mycompany.dolphub.dao;

import com.mycompany.dolphub.dto.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.persistence.*;

/**
 * @author exoticlucas
 */
public class CursoDAO {

    public static void inserirCurso(Curso curso) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany_dolphub_jar_1.0-SNAPSHOTPU");
        EntityManager entityManager = emf.createEntityManager();

        try {
            entityManager.getTransaction().begin();
            entityManager.persist(curso);
            entityManager.getTransaction().commit();
            System.out.println("Sucesso em criar curso");
        } catch (Exception ex) {
            System.err.println("Erro ao criar curso");
        } finally {
            entityManager.close();
        }
    }

    public static void removerCurso(int idCurso) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany_dolphub_jar_1.0-SNAPSHOTPU");
        EntityManager entityManager = emf.createEntityManager();

        try {
            entityManager.getTransaction().begin();
            Curso curso = entityManager.find(Curso.class, idCurso);
            if (curso != null) {
                entityManager.remove(curso);
                System.out.println("Sucesso em remover curso");
            } else {
                System.out.println("Erro ao remover curso");
            }
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            System.err.println("Erro ao remover curso");
        } finally {
            entityManager.close();
        }
    }

    public static void Main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int opcao = 0;
        do {
            System.out.println(" DIGITE:\n"
                    + " 1 - Para criar novo curso\n"
                    + " 2 - Excluir curso\n"
                    + " 3 - Para Sair\n");
            opcao = scan.nextInt();
            scan.nextLine();
            switch (opcao) {
                case 1: {
                    Curso curso = new Curso();
                    System.out.println("Digite o nome do curso");
                    curso.setNomeCurso(scan.nextLine());
                    System.out.println("Digite a descricao do curso");
                    curso.setDescricao(scan.nextLine());
                    System.out.println("Digite as tags do curso");
                    curso.setTags(scan.nextLine());
                    inserirCurso(curso);
                    break;
                }
                case 2: {
                    System.out.println("Digite o Id do curso: ");
                    int id = scan.nextInt();
                    scan.nextLine();
                    removerCurso(id);
                    break;
                }
            }
        } while (opcao != 3);
        scan.close();
    }
}
