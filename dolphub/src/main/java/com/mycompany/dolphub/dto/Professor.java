
package com.mycompany.dolphub.dto;

import java.util.List;
import javax.persistence.*;

/**
 *
 * @author Pedro Gabriel
 */
@Entity
@DiscriminatorValue("professor")
public class Professor extends Usuario {
    @Id
    @Column(name = "id_professor")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    @Column(name = "formacao_professor")
    private String formacao;
    
    @Column(name = "titulo_professor")
    private String titulo;
    
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST, mappedBy = "professor")
    private List<Curso> cursosAutorais;

    public String getFormacao() {
        return formacao;
    }

    public void setFormacao(String formacao) {
        this.formacao = formacao;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<Curso> getCursosAutorais() {
        return cursosAutorais;
    }

    public void setCursosAutorais(List<Curso> cursosAutorais) {
        this.cursosAutorais = cursosAutorais;
    }

    
}
