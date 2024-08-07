
package com.mycompany.dolphub.dto;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author exoticlucas
 */

@Entity
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_curso")
    private int id;
    
    @Column(name = "nome_curso")
    private String nomeCurso;
    
    @Column(name = "descricao_curso")
    private String descricao;
    
    @Column(name = "tags_curso")
    private String tags;
    
    
    @ManyToMany(mappedBy="cursos")
    private List<Usuario> usuarios;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_professor_professor")
    public Professor professor;
    
    @OneToMany(fetch = FetchType.EAGER,
            cascade = CascadeType.PERSIST,
            mappedBy = "curso")
    public List<Modulo> modulos;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }


    public List<Modulo> getModulos() {
        return modulos;
    }

    public void setModulos(List<Modulo> modulos) {
        this.modulos = modulos;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }
    
}
