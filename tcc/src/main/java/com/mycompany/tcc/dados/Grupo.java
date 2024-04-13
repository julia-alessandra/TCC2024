package com.mycompany.tcc.dados;

import java.util.List;
import javax.persistence.*;

/**
 *
 * @author Júlia
 */
@Entity
public class Grupo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private String descricao;

    @OneToMany(mappedBy = "grupo", cascade = CascadeType.ALL)
    private List<Postagem> postagens;

    @ManyToMany(mappedBy = "grupos")
    private List<Usuario> membros;

    @ManyToOne
    @JoinColumn(name = "administrador_id")
    private Usuario administrador;

    public Grupo(String nome, String descricao, List<Postagem> postagens, List<Usuario> membros, Usuario administrador) {
        this.nome = nome;
        this.descricao = descricao;
        this.postagens = postagens;
        this.membros = membros;
        this.administrador = administrador;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Postagem> getPostagens() {
        return postagens;
    }

    public void setPostagens(List<Postagem> postagens) {
        this.postagens = postagens;
    }

    public List<Usuario> getMembros() {
        return membros;
    }

    public void setMembros(List<Usuario> membros) {
        this.membros = membros;
    }

    public Usuario getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Usuario usuario) {
        this.administrador = usuario;
    }

    //metodos
    public void addPostagem(Postagem postagem) {
        postagens.add(postagem);
        postagem.setGrupo(this);
    }

    public void removerPostagem(Postagem postagem) {
        postagens.remove(postagem);
        postagem.setGrupo(null);
    }

    public void limparPostagens() {
        postagens.clear();
        for (Postagem postagem : postagens) {
            postagem.setGrupo(null);
        }
    }

    public void adicionarMembro(Usuario usuario) {
        membros.add(usuario);
        usuario.getGrupos().add(this);
    }

    public void removerMembro(Usuario usuario) {
        membros.remove(usuario);
        usuario.getGrupos().remove(this);
    }

    public List<Usuario> TodosMembros() {
        return membros;
    }

    public boolean possuiMembros() {
        return membros.isEmpty();
    }

    public boolean contemMembro(Usuario usuario) {
        return membros.contains(usuario);
    }

    public void atualizarNomeGrupo(String novoNome) {
        this.nome = novoNome;
    }

    public int getNumeroPostagens() {
        return postagens.size();
    }
}
