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
@Table(name = "meta_tempo")
public class MetaTempo extends Meta {

    private int id;
    private int objetivoDiario;
    private ArrayList<MetaTempoHistorico> historicos;

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
    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name = "meta_tempo",
            joinColumns={@JoinColumn(name="id_meta_tempo")},
            inverseJoinColumns={@JoinColumn(name="id_registro")})
    public ArrayList<MetaTempoHistorico> getHistoricos() {
        return historicos;
    }

    public void setHistoricos(ArrayList<MetaTempoHistorico> historico) {
        this.historicos = historico;
    }
    
    public void addHistorico(MetaTempoHistorico historico) {
        if(historico != null)
            this.historicos.add(historico);
    }
    
    public void removeHistorico(MetaTempoHistorico historico) {
        this.historicos.remove(historico);
    }
}
