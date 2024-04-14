/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tcc.dados;

import java.util.ArrayList;
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
    private ArrayList<Item> itens;

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
    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name = "meta_item",
            joinColumns={@JoinColumn(name="id_meta_item")},
            inverseJoinColumns={@JoinColumn(name="id_item")})
    public ArrayList<Item> getItens() {
        return itens;
    }

    public void setItens(ArrayList<Item> item) {
        this.itens = item;
    }
    
    public void addItem(Item item) {
        if(item != null)
            this.itens.add(item);
    }
    
    public void removeItem(Item item) {
        this.itens.remove(item);
    }
}
