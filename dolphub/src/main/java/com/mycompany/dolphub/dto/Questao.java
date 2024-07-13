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
    public List<Atividade> atividades;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "historico_questao",
            joinColumns = {@JoinColumn(name = "id_questao")},
            inverseJoinColumns = {@JoinColumn(name = "id_usuario")})

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

}
