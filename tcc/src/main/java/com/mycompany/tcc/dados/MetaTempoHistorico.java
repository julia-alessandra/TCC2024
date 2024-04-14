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
@Table(name = "historico_meta_tempo")
public class MetaTempoHistorico {

    private int id;
    private String dataRegistro;
    private String horarioRegistro;
    private int tempoRegistrado;
    private MetaTempo metaTempo;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_registro")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "data_registro")
    public String getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(String dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

    @Column(name = "horario_registro")
    public String getHorarioRegistro() {
        return horarioRegistro;
    }

    public void setHorarioRegistro(String horarioRegistro) {
        this.horarioRegistro = horarioRegistro;
    }

    @Column(name = "tempo_registrado")
    public int getTempoRegistrado() {
        return tempoRegistrado;
    }

    public void setTempoRegistrado(int tempoRegistrado) {
        this.tempoRegistrado = tempoRegistrado;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_meta_tempo", nullable = false)
    public MetaTempo getMetaTempo() {
        return metaTempo;
    }

    public void setMetaTempo(MetaTempo metaTempo) {
        this.metaTempo = metaTempo;
    }

}
