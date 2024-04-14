package com.mycompany.tcc.dao;

import com.mycompany.tcc.dados.Usuario;
import java.util.ArrayList;
import java.util.List;
// só pra testar os métodos que eu criei

public class UsuarioDAO {

    private List<Usuario> usuarios = new ArrayList<>();

    public Usuario buscar(String idUser) {
        for (Usuario usuario : usuarios) {
            if (usuario.getId().equals(idUser)) {
                return usuario;
            }
        }
        return null;
    }

    public void inserir(Usuario usuario) {
        String id = "" + usuarios.size() + "";
        usuario.setId(id);
        usuarios.add(usuario);
    }

    public void atualizar(Usuario usuario) {
        for (Usuario u : usuarios) {
            if (u.getId().equals(usuario.getId())) {
                u.setNome(usuario.getNome());
                u.setBio(usuario.getBio());
                u.setPontuacao(usuario.getPontuacao());
                break;
            }
        }
    }
    public List<Usuario> listar() {
        return usuarios;
    }

    public void remover(String idUser) {
        usuarios.removeIf(u -> u.getId().equals(idUser));
    }
}
