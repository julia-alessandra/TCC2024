
package com.mycompany.tcc.dados;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author Pedro Gabriel
 */
@Entity
@Table(name = "categoria")
public class Categoria {
    private int id;
    private String nome;
    private String descricao;
    private Usuario usuario;
    private ArrayList<Rotina> rotinas;
    private ArrayList<Tarefa> tarefas;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "nm_categoria")
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    @Column(name = "desc_categoria")
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="id_user_usuario", nullable = false)
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @ManyToMany(mappedBy = "categorias")
    public ArrayList<Rotina> getRotinas() {
        return rotinas;
    }

    public void setRotinas(ArrayList<Rotina> rotinas) {
        this.rotinas = rotinas;
    }

    @ManyToMany(mappedBy = "categorias")
    public ArrayList<Tarefa> getTarefas() {
        return tarefas;
    }

    public void setTarefas(ArrayList<Tarefa> tarefas) {
        this.tarefas = tarefas;
    }
    
    
}
