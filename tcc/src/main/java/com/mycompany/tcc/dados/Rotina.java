
package com.mycompany.tcc.dados;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author Pedro Gabriel
 */
@Entity
@Table(name = "rotina")
public class Rotina {
    private int id;
    private String nome;
    private String descricao;
    private String cor;
    private int quantTarefas;
    private Usuario usuario;
    private ArrayList<Categoria> categorias;

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rotina")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "nm_rotina")
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Column(name = "desc_rotina")
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Column(name = "cor")
    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    @Column(name = "quantidade_tarefa")
    public int getQuantTarefas() {
        return quantTarefas;
    }

    public void setQuantTarefas(int quantTarefas) {
        this.quantTarefas = quantTarefas;
    }

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="id_user_usuario", nullable = false)
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name = "categoria_rotina",
            joinColumns={@JoinColumn(name="id_rotina_rotina")},
            inverseJoinColumns={@JoinColumn(name="id_categoria_categoria")})
    public ArrayList<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(ArrayList<Categoria> categorias) {
        this.categorias = categorias;
    }
    
    public void addCategoria(Categoria categoria) {
        if(categoria != null)
            this.categorias.add(categoria);
    }
    
    public void removeCategoria(Categoria categoria) {
        this.categorias.remove(categoria);
    }
    
}
