package com.mycompany.tcc.dados;

import java.util.List;
import javax.persistence.*;

//Só criei isso pq precisou em grupos! :)
@Entity
public class Usuario {
    private String id;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
  
}