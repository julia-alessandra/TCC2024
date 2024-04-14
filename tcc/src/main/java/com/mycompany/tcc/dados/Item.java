/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tcc.dados;

import javax.persistence.*;

/**
 *
 * @author Master
 */
@Entity
@Table(name = "item")
public class Item {

    private int id;
    private String estado;
    private String conteudo;
    private MetaItem metaItem;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_meta_tempo")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    @Column(name = "estado")
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    @Column(name = "conteudo_item")
    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_meta_item", nullable = false)
    public MetaItem getMetaItem() {
        return metaItem;
    }

    public void setMetaItem(MetaItem metaItem) {
        this.metaItem = metaItem;
    }

}
