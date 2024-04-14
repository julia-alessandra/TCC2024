/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.tcc.idao;

import com.mycompany.tcc.dados.Usuario;
import java.util.ArrayList;

public interface IUsuarioDAO {

    public interface UsuarioDAO {

        Usuario buscar(String idUser);

        void inserir(Usuario usuario);

        void atualizar(Usuario usuario);

        void remover(String idUser);

    }

}
