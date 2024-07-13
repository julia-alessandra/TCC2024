
package com.mycompany.dolphub.dto;

import javax.persistence.*;

/**
 *
 * @author Pedro Gabriel
 */
@Entity
public class Professor extends Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
}
