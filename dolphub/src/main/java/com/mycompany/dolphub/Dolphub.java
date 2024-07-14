
package com.mycompany.dolphub;

import com.mycompany.dolphub.dao.ModuloDAO;
import com.mycompany.dolphub.dto.Modulo;
import com.mycompany.dolphub.dto.Questao;
import java.util.Scanner;

/**
 *
 * @author Pedro Gabriel
 */
public class Dolphub {

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
