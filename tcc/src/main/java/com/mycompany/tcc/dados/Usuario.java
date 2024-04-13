package com.mycompany.tcc.dados;

import java.util.List;

//Só criei isso pq precisou em grupos! :)
public class Usuario {
        private List<Grupo> grupos;

    public List<Grupo> getGrupos() {
        return grupos;
    }

    public void setGrupos(List<Grupo> grupos) {
        this.grupos = grupos;
    }    
}
