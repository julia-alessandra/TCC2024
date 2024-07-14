
package com.mycompany.dolphub.dto;

import javax.persistence.*;

/**
 *
 * @author Pedro Gabriel
 */

@Entity
public class Aula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_aula")
    private int id;
    @Column(name = "duracao_aula")
    private double duracao;
    @Column(name = "titulo_aula")
    private String titulo;
    @Column(name = "descricao_aula")
    private String descricao;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_modulo_modulo")
    private Modulo modulo;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getDuracao() {
        return duracao;
    }

    public void setDuracao(double duracao) {
        this.duracao = duracao;
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

    public Modulo getModulo() {
        return modulo;
    }

    public void setModulo(Modulo modulo) {
        this.modulo = modulo;
    }
}
