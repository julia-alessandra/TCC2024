package com.mycompany.dolphub.dto;

import java.util.*;
import javax.persistence.*;

@Entity
public class Questao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_questao")
    private int id;

    @Column(name = "comando_questao")
    private String comando;

    @Column(name = "tags_questao")
    private String tags;

    @ManyToMany(mappedBy = "questoes")
    private List<Atividade> atividades;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "historico_questao",
            joinColumns = {@JoinColumn(name = "id_questao")},
            inverseJoinColumns = {@JoinColumn(name = "id_usuario")})
    private List<Usuario> usuarios;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComando() {
        return comando;
    }

    public void setComando(String comando) {
        this.comando = comando;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public List<Atividade> getAtividades() {
        return atividades;
    }

    public void setAtividades(List<Atividade> atividades) {
        this.atividades = atividades;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

}
