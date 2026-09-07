package org.example.Model;

public class Pokemon {
    private String nombre;
    private int hp;
    private int ataque;
    private int defensa;
    private int XP_requerida;

    //se genera el constructor
    public Pokemon(String nombre, int hp, int ataque, int defensa, int XP_requerida) {
        this.nombre = nombre;
        this.hp = hp;
        this.ataque = ataque;
        this.defensa = defensa;
        this.XP_requerida = XP_requerida;
    }

    //genero los getters
    public String getNombre() {
        return nombre;
    }

    public int getHp() {
        return hp;
    }

    public int getAtaque() {
        return ataque;
    }

    public int getDefensa() {
        return defensa;
    }

    public int getXP_requerida() {
        return XP_requerida;
    }

    //genero el toString


    @Override
    public String toString() {
        return "Pokemon{" +
                "nombre='" + nombre + '\'' +
                ", hp=" + hp +
                ", ataque=" + ataque +
                ", defensa=" + defensa +
                ", XP_requerida=" + XP_requerida +
                '}';
    }
}
