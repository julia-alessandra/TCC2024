
package com.mycompany.dolphub.dto;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author Pedro Gabriel
 */
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="tipo_usuario", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_usuario")
    private int id;
    
    @Column(name = "nome_usuario")
    private String nome;
    @Column(name = "nascimento_usuario")
    private String data;
    @Column(name = "email_usuario")
    private String email;
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="matriculas",
            joinColumns={@JoinColumn(name="id_usuario_usuario")},
            inverseJoinColumns={@JoinColumn(name="id_curso_curso")})
    private ArrayList<Curso> cursos;
    
    @ManyToMany(mappedBy = "usuarios")
    public List<Atividade> atividades;
    
    @ManyToMany(mappedBy = "usuarios")
    public List<Questao> questoes;
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Curso> getCurso() {
        return cursos;
    }

    public void setCurso(ArrayList<Curso> curso) {
        this.cursos = curso;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
