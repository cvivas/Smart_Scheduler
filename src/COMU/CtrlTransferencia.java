
package Agenda;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

/**
* Descripcio: Controlador de gestion de transferencias entre grupos 1 y 3
* Autor: Rafael D. Gracia (Grup 3)
* Ultima data: 24 abril 2009
* Relacionada amb les classes: CtrlActividad.java CtrlHorario.java
*/

public class CtrlTransferencia extends CtrlDominio{


protected StringBuffer horario = new StringBuffer();
protected StringBuffer hora = new StringBuffer();

protected StringBuffer titulo = new StringBuffer();
protected StringBuffer descripcion = new StringBuffer();


    public CtrlTransferencia () {

    }

    private void guardarTFecha (TFecha fecha,BufferedWriter out) throws IOException{

      /**
       * De los dos grupos
       * Post: escribe en un fichero un TFecha
       */

      out.write(fecha.horario.getDay());
      out.write("/");
      out.write(fecha.horario.getMonth());
      out.write("/");
      out.write(fecha.horario.getYear());
      out.newLine();
      out.write(fecha.hora);
      out.newLine();

   }//fi operacio

    public void fechacompletaGuardar(Set cjtDatos) throws FileNotFoundException, IOException{

        /**
         * Grupo 1: Llamada previa a importarHorario.
         * Grupo 3: Llamada previa a exportarHorarioFecha.
         * Utilizado por ambos grupos. Común.
         * Deberia retornar un Set < TFecha >
         */

        File fstream = new File( "..\\Font\\fechas.txt" );
        BufferedWriter out = new BufferedWriter( new FileWriter (fstream) );

        try{
         Iterator<TFecha> iterador= cjtDatos.iterator();

                while (iterador.hasNext()) {

                    TFecha actual = iterador.next();
                    guardarTFecha(actual,out);
                        
                    if (iterador.hasNext()){
                        out.write("*");
                        out.newLine();
                    }//fi while

                }//fi while

         out.write("/");
        }catch (Exception e) {System.out.println("ERROR: No se ha podido crear el archivo");}

         out.close();

    }//fi operacio

    public boolean leerFecha(BufferedReader bf) throws FileNotFoundException, IOException{

        /**
         * Propio de 1 y de 3, para leer Horario y hora
         */

        int indice = 1;
        boolean pendientes = true;
        boolean salir = true;
        String linea;
        String fin = "/" ;
        String sigue = "*" ;
        
        while(salir && ((linea=bf.readLine())!=null)){
                
                if (linea.equalsIgnoreCase(sigue) || linea.equalsIgnoreCase(fin)){

                    salir=false;

                    if (linea.equalsIgnoreCase(fin)){
                        pendientes=false;
                    }//fi if

                } else {

                    // guardar string
                    switch(indice){
                            case 1: horario.append(linea); break;
                            case 2: hora.append(linea); break;

                            default: break;
                            }
                    indice++;
                    
                }//fi if

        }//fi while

        return pendientes; //devuelve si aun quedan objetos por leer
    }

    public Date transformarFecha (StringBuffer horario){

        /**
         * Pre: -
         * Post: transforma horario en un Date para crear Horario
         *
         * Común para los dos grupos
         */

        Date resultado = new Date();
        String dia,mes,anno;

        dia = horario.substring(0, 1);
        mes = horario.substring(3, 4);
        anno = horario.substring(6, 9);

        resultado.setMonth( Integer.parseInt(mes) );
        resultado.setDate( Integer.parseInt(dia) );
        resultado.setYear( (Integer.parseInt(anno)) );

        return resultado;

    }



}//fi classe

