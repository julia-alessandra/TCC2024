package com.mycompany.dolphub.dto;

import java.util.Collection;
import javax.persistence.*;

@Entity
public class Questao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_questao")
    private int id;

    @Column(name = "comando_questao")
    private String comando;

    @Column(name = "tags_questao")
    private String tags;


    // Getters e setters
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
