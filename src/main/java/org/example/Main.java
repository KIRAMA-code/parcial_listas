package org.example;

import org.example.Model.LineaEvolutiva;
import org.example.Model.Pokemon;

import static java.util.Collections.max;
public class Main {
    public static void main(String[] args) {

        //creo cada fase de charmander
        Pokemon Charmander = new Pokemon("Charmander",39,39,52,43,1500);
        Pokemon Charmeleon = new Pokemon("Charmaleon",58,58,64,58,5000);
        Pokemon Charizard = new Pokemon("Charizard",78,78,84,78,-1);
        //las añado a la lineaevolutiva de forma estrategica, pues añado desde el ultimo hasta el primero para que el head
        //quede con charmander
        LineaEvolutiva pokemon1 = new LineaEvolutiva();
        pokemon1.add(Charizard);
        pokemon1.add(Charmeleon);
        pokemon1.add(Charmander);

        Pokemon [] hordaEnemigos = new Pokemon[100000];


        for (int i = 0; i < hordaEnemigos.length; i++) {
            //relleno cada atributo con numeros aleatorio bajos para que charmander pueda ganar y evolucionar
            int hp = (int)(Math.random() * (30 - 10 + 1)) + 10;
            int hpMaximo = hp;
            int ataque = (int)(Math.random() * (30 - 10 + 1)) + 10;
            int defensa = (int)(Math.random() * (30 - 10 + 1)) + 10;
            int XP_requerida = (int)(Math.random() * (30 - 10 + 1)) + 10;

            //luego le inyecto los resultados enemigo a enemigo, el numero de enemigos es definido en hordaEnemigos.length
            Pokemon enemigo = new Pokemon("enemigo",hp,hpMaximo,ataque,defensa,XP_requerida);
            hordaEnemigos[i] = enemigo;

        }

        iniciarEntrenamientoMasivo(pokemon1,hordaEnemigos);






    }

    static public void iniciarEntrenamientoMasivo (LineaEvolutiva mipokemon, Pokemon[] hordaEnemigos){

        for (int i = 0; i < hordaEnemigos.length; i++) {
            mipokemon.setHp(mipokemon.getHpMaximo());//le subimos la vida al maximo despues de cada pelea
            //escoge al primer enemigo
            Pokemon enemigo = hordaEnemigos[i];
            //calculo los daños con la formula del documento pdf
            int dañoaEnemigo = Math.max(1,mipokemon.getAtaque() - enemigo.getDefensa());
            int dañoAsumido = Math.max(1,enemigo.getAtaque() - mipokemon.getDefensa());
            //implemento la logica de vida que esta en lineaEvolutiva
            boolean vidaEnemigo = enemigo.vida();
            boolean vidamipokemon = mipokemon.vida();

           while (vidamipokemon && vidaEnemigo){
                //peleo con el primer enemigo por turnos
               int rest1 = enemigo.getHp() - dañoaEnemigo;
               enemigo.setHp(rest1);
                //si la vida del enemigo es 0 o menos mi pokemon gana xp y utiliza el metodo evolucionar que esta contenido dentro del metodo
               //ganar experiencia
              if ( enemigo.getHp()<= 0 ){
                  //le añado 50 de experiencia al acumulador
                  mipokemon.ganarExperiencia(50);
                  //la vida cambia a false y se sale del while
                  vidaEnemigo = false;
              }
               int rest2 = mipokemon.getHp() - dañoAsumido;
               mipokemon.setHp(rest2);
                // si mi pokemon muere se acaba y ya
              if (mipokemon.getHp() <= 0){
                  //la vida se convierte en false y se sale
                  vidamipokemon = false;

              }


           }



        }
    }
}