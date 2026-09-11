package org.example.Service;

import org.example.Model.LineaEvolutiva;
import org.example.Model.Pokemon;

import java.util.LinkedList;
import java.util.Objects;

public class ReporteBatalla {
    private String nombre;
    private String nombreEnemigo;
    int cantidadBatallas;


    public ReporteBatalla(String nombre, String nombreEnemigo, int cantidadBatallas) {
        this.nombre = nombre;
        this.nombreEnemigo = nombreEnemigo;
        this.cantidadBatallas = cantidadBatallas;

    }

    public String getNombre() {
        return nombre;
    }

    public String getNombreEnemigo() {
        return nombreEnemigo;
    }

    public int getCantidadBatallas() {
        return cantidadBatallas;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ReporteBatalla that)) return false;
        return Objects.equals(nombre, that.nombre) && Objects.equals(nombreEnemigo, that.nombreEnemigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, nombreEnemigo, cantidadBatallas);
    }

    public void setCantidadBatallas(int cantidadBatallas) {
        this.cantidadBatallas += cantidadBatallas;
    }

    @Override
    public String toString() {
        return "ReporteBatalla{" +
                "nombre='" + nombre + '\'' +
                ", nombreEnemigo='" + nombreEnemigo + '\'' +
                ", cantidadBatallas=" + cantidadBatallas +
                '}';
    }
}