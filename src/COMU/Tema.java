package Agenda;

import java.io.Serializable;

/**
* Descripcion: Clase Tema que implementa tema con su atributo y sus operaciones, compartido por grupo 1 y 2
* Autor: Cesar Nogales
* Ultima fecha: 22 d'abril 2009
* Relacionada con las clases:
        -
*/

public class Tema implements Serializable{

    private String nom;

    public Tema () {
        
        nom=new String();

    }// fin operacion

    public String getNom(){

        return nom;

    }// fin operacion

    public void setNom(String nom){

        this.nom=nom;

    }// fin operacion

    public Tema crearTema (String nomT) {
     /* Creadora: devuelve  un tema */

        this.nom=nomT;
        return this;

    }// fin operacion

    void mostrarNombre() {

        System.out.println(nom);

    }// fin operacion

       
}// fin clase






