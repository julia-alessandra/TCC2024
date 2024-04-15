package com.mycompany.tcc;

import com.mycompany.tcc.dao.UsuarioDAO;
import com.mycompany.tcc.dados.Usuario;
import java.util.ArrayList;
import java.util.List;

import java.util.Scanner;

public class InteracoesComOSistema {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        UsuarioDAO dao = new UsuarioDAO();

        System.out.println("Bem Vindo ao sistema de controle do Usuário:");
        while (true) {
            System.out.println("Escolha a opção:");
            System.out.println("1 - Adicionar usuário");
            System.out.println("2 - Remover usuário");
            System.out.println("3 - Alterar usuário");
            System.out.println("4 - Listar usuarios");
            System.out.println("0 - Acabar o programa");

            int teste = scan.nextInt();
            if(teste == 0)
                return;
            scan.nextLine(); // Consumir a quebra de linha pendente

            switch (teste) {
                case 1:
                    System.out.println("Digite o nome:");
                    String nome1 = scan.nextLine();
                    System.out.println("Digite a bio:");
                    String bio1 = scan.nextLine();
                    System.out.println("Digite a pontuação:");
                    int pontuacao1 = scan.nextInt();
                    Usuario user1 = new Usuario(nome1, bio1, pontuacao1);
                    dao.inserir(user1);
                    break;
                case 2:
                    System.out.println("Digite o id:");
                    String id2 = scan.nextLine();
                    dao.remover(id2);
                    break;
                case 3:
                    System.out.println("Digite o id:");
                    String id3 = scan.nextLine();
                    System.out.println("Digite o nome:");
                    String nome3 = scan.nextLine();
                    System.out.println("Digite a bio:");
                    String bio3 = scan.nextLine();
                    System.out.println("Digite a pontuação:");
                    int pontuacao3 = scan.nextInt();
                    Usuario user3 = new Usuario(id3, nome3, bio3, pontuacao3);
                    dao.inserir(user3);
                    break;
                default:
                    List<Usuario> usuarios = new ArrayList<>();
                    usuarios = dao.listar();
                    for (Usuario user : usuarios) {
                        System.out.println("Nome: " + user.getNome());
                        System.out.println("Id: " + user.getId());
                        System.out.println("Bio: " + user.getBio());
                        System.out.println("Pontuação: " + user.getPontuacao());
                        System.out.println("\n");
                    }

            }
        }
    }
}
