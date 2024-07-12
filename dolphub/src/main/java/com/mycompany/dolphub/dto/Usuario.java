
package com.mycompany.dolphub.dto;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author Pedro Gabriel
 */
@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private int id;
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
}
