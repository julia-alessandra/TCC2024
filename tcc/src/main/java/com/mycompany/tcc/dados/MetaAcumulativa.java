/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tcc.dados;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author Master
 */
@Entity
@Table(name = "meta_acumulativa")
public class MetaAcumulativa extends Meta {

    private int id;
    private double progresso;
    private double objetivo;
    private String unidade;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_meta_acumulativa")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "progresso_ac")
    public double getProgresso() {
        return progresso;
    }

    public void setProgresso(double progresso) {
        this.progresso = progresso;
    }

    @Column(name = "objetivo_ac")
    public double getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(double objetivo) {
        this.objetivo = objetivo;
    }

    @Column(name = "unidade")
    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

}
