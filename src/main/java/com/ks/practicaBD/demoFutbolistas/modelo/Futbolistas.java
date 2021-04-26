package com.ks.practicaBD.demoFutbolistas.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.juli.logging.Log;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Futbolistas")
public class Futbolistas {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private int Id;
    private String nombre;
    private String posicion;
    private int numcamisa;

    public Futbolistas(String nombre, String posicion, int numcamisa) {
        this.nombre = nombre;
        this.posicion = posicion;
        this.numcamisa = numcamisa;
    }

}
