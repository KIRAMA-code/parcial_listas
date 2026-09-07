package org.example;

import org.example.Model.LineaEvolutiva;
import org.example.Model.Pokemon;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Pokemon Charmander = new Pokemon("Charmander",39,52,43,1500);
        Pokemon Charmeleon = new Pokemon("Charmaleon",58,64,58,5000);
        Pokemon Charizard = new Pokemon("Charizard",78,84,78,-1);

        LineaEvolutiva pokemon1 = new LineaEvolutiva();
        pokemon1.add(Charizard);
        pokemon1.add(Charmeleon);
        pokemon1.add(Charmander);

        pokemon1.evolucionar();

        String imprimir = pokemon1.toString();
        System.out.println(imprimir);



    }
}