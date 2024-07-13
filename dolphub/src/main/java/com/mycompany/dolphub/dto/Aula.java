
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
    private int id;
    
        @ManyToOne
    @JoinColumn(name = "modulo_id")
    private Modulo modulo;

}
