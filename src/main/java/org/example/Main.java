package org.example;

import lombok.extern.log4j.Log4j2;
import org.example.Model.LineaEvolutiva;
import org.example.Model.Pokemon;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.Util.PerformanceReporter;

import java.util.LinkedList;

@Log4j2
public class Main {

    private static final Logger loggerTiempos = LogManager.getLogger("tiempos");

    public static void main(String[] args) {




        //creo cada fase de charmander
        Pokemon Charmander = new Pokemon("Charmander",39,39,52,43,25);
        Pokemon Charmeleon = new Pokemon("Charmaleon",58,58,64,58,50);
        Pokemon Charizard = new Pokemon("Charizard",78,78,84,78,-1);
        //las añado a la lineaevolutiva de forma estrategica, pues añado desde el ultimo hasta el primero para que el head
        //quede con charmander
        LineaEvolutiva pokemon1 = new LineaEvolutiva();
        pokemon1.add(Charizard);
        pokemon1.add(Charmeleon);
        pokemon1.add(Charmander);

        Pokemon rattata = new Pokemon("Rattata",30,30,56,35,0);
        boolean vidaEnemigo = rattata.vida();
        boolean vidamipokemon = pokemon1.vida();
        //----------------------PRUEBA MOCK DATA----------------------------------------
        while (vidaEnemigo && vidamipokemon){
            int dañoaEnemigo = Math.max(1,pokemon1.getAtaque() - rattata.getDefensa());
            int dañoAsumido = Math.max(1,rattata.getAtaque() - pokemon1.getDefensa());

            int rest1 = rattata.getHp() - dañoaEnemigo;
            rattata.setHp(rest1);
            log.info("vida del rattata: " + rattata.getHp());
            //si la vida del enemigo es 0 o menos mi pokemon gana xp y utiliza el metodo evolucionar que esta contenido dentro del metodo
            //ganar experiencia
            if ( rattata.getHp()<= 0 ){
                //le añado 50 de experiencia al acumulador
                pokemon1.ganarExperiencia(50);
                pokemon1.getXP();
                //la vida cambia a false y se sale del while
                vidaEnemigo = false;
                break;
            }
            int rest2 = pokemon1.getHp() - dañoAsumido;
            pokemon1.setHp(rest2);
            log.info("vida del pokemon " + pokemon1.getHp());
            // si mi pokemon muere se acaba y ya
            if (pokemon1.getHp() <= 0){
                //la vida se convierte en false y se sale
                vidamipokemon = false;

            }

        }
        //------------------------------------------------------------------------------------------


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

        //iniciarEntrenamientoMasivo(pokemon1,hordaEnemigos,50);


        Pokemon [] hordaCartepie = new Pokemon[25000];

        for (int i = 0; i < hordaCartepie.length; i++) {
            Pokemon cartepie = new Pokemon("Cartepie",45,45,30,35,0);
            hordaCartepie[i] = cartepie;
        }
        //gananciaXP es la que se gana cuando se derrota
     //   iniciarEntrenamientoMasivo(pokemon1,hordaCartepie,50);


        Pokemon pikachu = new Pokemon("Pikachu",20000,20000,2000,2000,50);
        Pokemon pikachu2 = new Pokemon("Pikachu2",3000,3000,3000,3000,-1);

        LineaEvolutiva pokemon2 = new LineaEvolutiva();
        pokemon2.add(pikachu2);
        pokemon2.add(pikachu);

        LinkedList <LineaEvolutiva> equipoRocket = new LinkedList<>();
        equipoRocket.add(pokemon1);
        equipoRocket.add(pokemon2);

         Pokemon [] hordaenemigoK = new Pokemon[50];
        for (int i = 0; i < hordaenemigoK.length; i++) {

        }

        enfrentamientoEquipo(equipoRocket,hordaCartepie,50);

    }

    static public void iniciarEntrenamientoMasivo (LineaEvolutiva mipokemon, Pokemon[] hordaEnemigos,int gananciaXP){
        log.info("Iniciando entrenamiento masivo");

        log.info("Estado de memoria antes de la lógica del método");
        PerformanceReporter.reportarMemoriaSistema();
        PerformanceReporter.medirPesoObjeto(mipokemon,"Linea de evolucion");
        PerformanceReporter.medirPesoObjeto(hordaEnemigos[0],"nodo enemigo()");
        long tiempoInicio = System.nanoTime();
        for (int i = 0; i < hordaEnemigos.length; i++) {
            mipokemon.setHp(mipokemon.getHpMaximo());//le subimos la vida al máximo después de cada pelea
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
                  mipokemon.ganarExperiencia(gananciaXP);
                  //la vida cambia a false y se sale del while
                  vidaEnemigo = false;
                  break;
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
        long tiempoFin = System.nanoTime();
        loggerTiempos.info("timepo total de ejecución: " + (tiempoFin - tiempoInicio + " ns"));
        log.info("estado de la memoria despues de la lógica del método");
        PerformanceReporter.reportarMemoriaSistema();

    }

    public static void enfrentamientoEquipo (LinkedList <LineaEvolutiva> equipoRocket, Pokemon[] hordacaterpie,int gananciaXP){



        for (int j = 0; j < 4; j++) {
            Pokemon pokemonenBatalla =  equipoRocket.getFirst().getFaseActual();
            LineaEvolutiva lineapokemon = equipoRocket.getFirst();

            System.out.print("pokemon en lucha: " + pokemonenBatalla );

            for (int i = 0; i < hordacaterpie.length; i++) {
                pokemonenBatalla.setHp(pokemonenBatalla.getHpMaximo());//le subimos la vida al máximo después de cada pelea
                //escoge al primer enemigo
                Pokemon enemigo = hordacaterpie[i];
                //calculo los daños con la formula del documento pdf
                int dañoaEnemigo = Math.max(1, pokemonenBatalla.getAtaque() - enemigo.getDefensa());
                int dañoAsumido = Math.max(1, enemigo.getAtaque() - pokemonenBatalla.getDefensa());
                //implemento la logica de vida que esta en lineaEvolutiva
                boolean vidaEnemigo = enemigo.vida();
                boolean vidamipokemon = pokemonenBatalla.vida();


                while (vidamipokemon && vidaEnemigo) {
                    //peleo con el primer enemigo por turnos
                    int rest1 = enemigo.getHp() - dañoaEnemigo;
                    enemigo.setHp(rest1);
                    //si la vida del enemigo es 0 o menos mi pokemon gana xp y utiliza el metodo evolucionar que esta contenido dentro del metodo
                    //ganar experiencia
                    if (enemigo.getHp() <= 0) {
                        //le añado 50 de experiencia al acumulador
                        lineapokemon.ganarExperiencia(gananciaXP);
                        //la vida cambia a false y se sale del while
                        vidaEnemigo = false;
                        break;
                    }
                    int rest2 = lineapokemon.getHp() - dañoAsumido;
                    lineapokemon.setHp(rest2);
                    // si mi pokemon muere se acaba y ya
                    if (lineapokemon.getHp() <= 0) {
                        //la vida se convierte en false y se sale
                        vidamipokemon = false;

                    }


                }


            }

            equipoRocket.remove().getFaseActual();
            equipoRocket.add(lineapokemon);
        }
    }
}