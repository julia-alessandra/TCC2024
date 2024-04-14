package com.mycompany.tcc.dados;

import java.util.List;
import javax.persistence.*;

//Só criei isso pq precisou em grupos! :)
@Entity
public class Usuario {
    private String id;
    private String nome;
    private String bio;
    private String pontuacao;
    public Usuario(String nome, String bio, String pontuacao) {
        this.nome = nome;
        this.bio = bio;
        this.pontuacao = pontuacao;
    }

    public Usuario(String id, String nome, String bio, String pontuacao) {
        this.id = id;
        this.nome = nome;
        this.bio = bio;
        this.pontuacao = pontuacao;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(String pontuacao) {
        this.pontuacao = pontuacao;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
  
}