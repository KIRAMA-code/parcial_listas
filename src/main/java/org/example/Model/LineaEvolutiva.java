package org.example.Model;

public class LineaEvolutiva {
    private Nodo<Pokemon> head;
    private int size;
    private  int XPacumulador;

    public LineaEvolutiva () {

        head = null;
        size = 0;

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

        Nodo<Pokemon> nodo = new Nodo<>(head.getData());
        int faltante = ExperienciaRequerida - XPacumulador;
        // si la experiencia es mayor o igual a la que necesita para la siguiente evolucion
        //evoluciona y ahora el head es la conexión que tiene el actual, que se muestra con getnext()
        if (ExperienciaRequerida >= XPacumulador){

         head = nodo.getNext();


        }else {
            System.out.println("faltan: " + faltante + " puntos de experiencia para la siguiente evolucion");
        }



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
