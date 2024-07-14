
package com.mycompany.dolphub.dto;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
/**
 *
 * @author exoticlucas
 */
@Entity
public class Modulo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_modulo")
    private int id;
    
    @Column(name = "nome_modulo")
    private String nome;
    
    @Column(name = "dificuldade_modulo")
    private int dificuldade;
    
    @Column(name = "descricao_modulo")
    private String descricao;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_curso_curso")
    public Curso curso;
    
    @OneToMany(fetch = FetchType.EAGER, cascade =
            CascadeType.PERSIST, mappedBy = "modulo")
    private List<Atividade> atividades;
    
    @OneToMany(fetch = FetchType.EAGER, cascade =
            CascadeType.PERSIST, mappedBy = "modulo")
    private List<Aula> aulas;
    
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

    public int getDificuldade() {
        return dificuldade;
    }

    public void setDificuldade(int dificuldade) {
        this.dificuldade = dificuldade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Atividade> getAtividades() {
        return atividades;
    }

    public void setAtividades(ArrayList<Atividade> atividades) {
        this.atividades = atividades;
    }

    public List<Aula> getAulas() {
        return aulas;
    }

    public void setAulas(List<Aula> aulas) {
        this.aulas = aulas;
    }
    
}
