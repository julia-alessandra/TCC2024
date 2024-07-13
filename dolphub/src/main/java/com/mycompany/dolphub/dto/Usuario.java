
package com.mycompany.dolphub.dto;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author Pedro Gabriel
 */
@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private int id;
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="many_usuario_has_many_curso",
            joinColumns={@JoinColumn(name="id_usuario_usuario")},
            inverseJoinColumns={@JoinColumn(name="id_curso_curso")})
    private ArrayList<Curso> cursos;
    
    
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
}
