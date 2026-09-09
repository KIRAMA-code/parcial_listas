package org.example.Model;

public class LineaEvolutiva {
    private Nodo<Pokemon> head;
    private int size;
    private  int XPacumulador;

    public LineaEvolutiva () {

        head = null;
        size = 0;
        XPacumulador = 0;

    }

    public void add (Pokemon dato) {

        Nodo<Pokemon> nodo = new Nodo<>(dato);

        if ( head == null ){

            head = nodo;

        }
        else{

            nodo.setNext(head);
            head = nodo;

        }

        size++;

    }

    public void evolucionar (){
        //extraigo el atributo xp del pokemon actual
        int ExperienciaRequerida = head.getData().getXP_requerida();



        // si la experiencia es mayor o igual a la que necesita para la siguiente evolucion
        //evoluciona y ahora el head es la conexión que tiene el actual, que se muestra con getnext()
        if (ExperienciaRequerida != -1 && this.XPacumulador >= ExperienciaRequerida){

         head = head.getNext();


        }

    }

    public int getAtaque (){
        int ataque = head.getData().getAtaque();
        return ataque;
    }

    public int getDefensa(){
        int defensa = head.getData().getDefensa();
        return defensa;
    }

    public  boolean vida ()
    {
        int hp = head.getData().getHp();
        boolean vida = true;
        if (hp == 0){
            vida = false;
        }
        return vida;
    }
    public int getHp (){
        int hp = head.getData().getHp();
        return hp;
    }

    public  int getHpMaximo(){
        int hpMaximo = head.getData().getHpMaximo();
        return hpMaximo;
    }


    public void setHp(int hp){
        head.getData().setHp(hp);
    }

    public void ganarExperiencia(int xpGanada) {
        this.XPacumulador += xpGanada;
        evolucionar();
    }


    @Override
    public String toString(){

        String mensaje = "";

        if ( head == null ) mensaje = "Lista Vacia";
        else{

            Nodo<Pokemon> aux = head;

            while ( aux != null ){

                mensaje += "[" + aux.getData() + "] -> ";

                aux = aux.getNext();

            }

        }

        return mensaje;

    }
}
