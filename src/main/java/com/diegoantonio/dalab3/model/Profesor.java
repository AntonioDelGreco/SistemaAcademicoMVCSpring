package com.diegoantonio.dalab3.model;

import java.util.ArrayList;

public class Profesor {
    private Integer id;
    private String nombre;
    private String apellido;
    private static Integer contador = 0;

    public Profesor(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
        setId();
    }

    public Integer getId() {
        return id;
    }

    public void setId() {
        this.id = ++contador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
}
