package com.mycompany.dolphub.dto;

import java.util.*;
import javax.persistence.*;

@Entity
public class Atividade {

    @Id
    @Column(name = "id_atividade")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "titulo_atividade")
    private String titulo;

    @Column(name = "descricao_atividade")
    private String descricao;

    @Column(name = "dificuldade_atividade")
    private String dificuldade;
     
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "questao_atividade",
            joinColumns = {@JoinColumn(name = "id_atividade")},
            inverseJoinColumns = {@JoinColumn(name = "id_questao")})
    private List<Questao> questoes; 
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "modulo_id")
    private Modulo modulo;
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "historico_atividade",
            joinColumns = {@JoinColumn(name = "id_atividade")},
            inverseJoinColumns = {@JoinColumn(name = "id_usuario")})
   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDificuldade() {
        return dificuldade;
    }

    public void setDificuldade(String dificuldade) {
        this.dificuldade = dificuldade;
    }

    public Modulo getModulo() {
        return modulo;
    }

    public void setModulo(Modulo modulo) {
        this.modulo = modulo;
    }

    public Collection<Questao> getQuestoes() {
        return questoes;
    }

    public void setQuestoes(List<Questao> questoes) {
        this.questoes = questoes;
    }    
}
