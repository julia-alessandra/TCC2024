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
@Table(name = "meta_tempo")
public class MetaTempo extends Meta {

    private int id;
    private int objetivoDiario;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_meta_tempo")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "objetivo_diario")
    public int getObjetivoDiario() {
        return objetivoDiario;
    }

    public void setObjetivoDiario(int objetivoDiario) {
        this.objetivoDiario = objetivoDiario;
    }

}
