


package Agenda;

/**
 ** Descripcio: CtrlCrearTema gestiona el caso de uso de crear un tema y
 *  contiene todas las operaciones necesarias para realizarlo
 *  Autor: Raul Serna
 *  Ultima actualizacion:30 de abril 2009
 *  Relacionada con las clases: Tema,CtrlDominio
 */
public class CtrlCrearTema {
CtrlDominio2 controladorDeDominio =  new CtrlDominio2();

public void crearTemaGenerico (String nombre) {
    /*Operacion crearTemaGenerico llama a la capa de dominio para aplicar el caso de uso de
     *crear tema*/

    controladorDeDominio.crearTema(nombre);
    System.out.println("Se ha creado el tema: "+nombre);
    }//fin operacion

public void crearTema (String nomT, String nomA, int idA ) {
    /*Operacion crearTema llama a la capa de dominio para aplicar el caso de uso de
     crear tema asignando el tema a la Actividad identificada por idA*/
   
    controladorDeDominio.crearTema(nomT, nomA, idA);

    }//fin operacion


}
