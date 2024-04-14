
package com.mycompany.tcc.dados;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;


@Entity
@Table(name = "tarefa")
public class Tarefa {
    
    private int id;
    private String nome;
    private String descricao;
    private String data;
    private String horario;
    private String periodicidade;
    private Rotina rotina;
    private Usuario usuario;
    private ArrayList<Categoria> categorias;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tarefa")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    @Column(name = "nm_tarefa")
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    @Column(name = "desc_tarefa")
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Column(name = "data_tarefa")
    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Column(name = "horario_tarefa")
    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="id_user_usuario", nullable = false)
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="id_rotina_rotina", nullable = false)
    public Rotina getRotina() {
        return rotina;
    }

    public void setRotina(Rotina rotina) {
        this.rotina = rotina;
    }

    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name = "categoria_tarefa",
            joinColumns={@JoinColumn(name="id_tarefa_tarefa")},
            inverseJoinColumns={@JoinColumn(name="id_categoria_categoria")})
    public ArrayList<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(ArrayList<Categoria> categorias) {
        this.categorias = categorias;
    }

    @Column(name = "periodicidade")
    public String getPeriodicidade() {
        return periodicidade;
    }

    public void setPeriodicidade(String periodicidade) {
        this.periodicidade = periodicidade;
    }
    
    
}
