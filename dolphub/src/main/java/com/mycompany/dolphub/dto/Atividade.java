package com.mycompany.dolphub.dto;

import javax.persistence.*;

/**
 *
 * @author Pedro Gabriel
 */
@Entity
public class Atividade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_atividade")
    private int id;

    @ManyToOne
    @JoinColumn(name = "modulo_id")
    private Modulo modulo;
}
