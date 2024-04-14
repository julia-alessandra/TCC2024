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
@Table(name = "meta_item")
public class MetaItem extends Meta {

    private int id;
    private int qnt;
    private int qntCompleta;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_meta_item")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "quantidade_itens")
    public int getQnt() {
        return qnt;
    }

    public void setQnt(int qnt) {
        this.qnt = qnt;
    }

    @Column(name = "quantidade_completa")
    public int getQntCompleta() {
        return qntCompleta;
    }

    public void setQntCompleta(int qntCompleta) {
        this.qntCompleta = qntCompleta;
    }

}
