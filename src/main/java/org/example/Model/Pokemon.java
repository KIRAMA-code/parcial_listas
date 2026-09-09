package org.example.Model;

public class Pokemon {
    private String nombre;
    private int hp;
    private int hpMaximo;
    private int ataque;
    private int defensa;
    private int XP_requerida;

    //se genera el constructor
    public Pokemon(String nombre, int hp,int hpMaximo, int ataque, int defensa, int XP_requerida) {
        this.nombre = nombre;
        this.hp = hp;
        this.hpMaximo = hpMaximo;
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

    public int getHpMaximo() {return hpMaximo;}

    //este metodo vida regula la lógica de la vida si es 0 o menos se pasa a false osea muerto
    public  boolean vida ()
    {
        boolean vida = true;
        if (hp <= 0){
            vida = false;
        }
        return vida;
    }

    public void setHp(int hp) {
        this.hp = hp;
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
