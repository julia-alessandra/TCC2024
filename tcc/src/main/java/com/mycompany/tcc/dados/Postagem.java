package com.mycompany.tcc.dados;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author Júlia
 */
@Entity
public class Postagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String conteudo;
    private List<Usuario> likes;

    @ManyToOne
    @JoinColumn(name = "grupo_id")
    private Grupo grupo;

    public Postagem(String conteudo, Grupo grupo) {
        this.conteudo = conteudo;
        this.likes = new ArrayList<>();
        this.grupo = grupo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public List<Usuario> getLikes() {
        return likes;
    }

    public void setLikes(List<Usuario> likes) {
        this.likes = likes;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    public void adicionarLike(Usuario usuario) {
        likes.add(usuario);
    }

    public int numLikes() {
        return likes.size();
    }

    public void removerLike(Usuario usuario) {
        likes.remove(usuario);
    }

}
