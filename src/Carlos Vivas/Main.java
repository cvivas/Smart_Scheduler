/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package agendainteligente;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * Descripcion: Main para la 2 entrega. Interactua con la clas driver y con las controladoras
 * de dominio actividad y horario.
 * @author Carlos Vivas
 */

public class Main {

       


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)throws Exception {
        
        CtrlDominio3 control =  new CtrlDominio3();
        CtrlActividad3 controlAct =  new CtrlActividad3();
        CtrlHorario2 controlHor =  new CtrlHorario2();
        CtrlVistaPrincipal CVP = new CtrlVistaPrincipal();

        control.asignarCtrlActividadPropio(controlAct);
        control.asignarCtrlHorarioPropio(controlHor);
        control.setJornadaLaboralDefecto(8, 16, 17, 21);


        File f = null;

        //String actual = f.getCanonicalPath().concat("\\");
        f = new File (".");
        String actual = f.getCanonicalPath();
        actual = actual.concat("\\objects");
        System.out.println(actual);
        File f2 = new File(actual);
        boolean b =f2.exists();
        if (!b){
            f2.mkdir();

                    try {
            control.guardar();
        } catch (IOException ex) {
            Logger.getLogger(vistaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }

        }

        

         try {
            control.cargar();
        } catch (IOException ex) {
            Logger.getLogger(vistaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(vistaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        vistaPrincipal vp = new vistaPrincipal();
        vp.setVisible(true);




//         inout in=new inout();
//         int eleccion=0;
//         Driver d=new Driver();
//
//         String titul;
//         String desc;
//         String fecha;
//         String num,prio,texto;
//
//         while(eleccion!=9){
//             System.out.println("*****************************************");
//             System.out.println("*************Escoge una opcion***********");
//             System.out.println("");
//             System.out.println("1-   Anadir Actividad");
//             System.out.println("2-   Anadir Tema");
//             System.out.println("3-   Listar Eventos");
//             System.out.println("4-   Eliminar actividad");
//             System.out.println("5-   Listar Temas");
//             System.out.println("6-   Guardar eventos");
//             System.out.println("7-   Cargar eventos");
//             System.out.println("8 -  eliminar tema");
//             System.out.println("9-   Salir");
//             eleccion=Integer.parseInt(in.readline());
//             switch(eleccion){
//                 case 1: System.out.println("1-   Cita");
//                         System.out.println("2-   DeadLine");
//                         System.out.println("3-   En Mente");
//                         System.out.println("4-   Cumpleaños");
//                         System.out.println("5-   Memorandum");
//                         System.out.println("6-   Volver");
//                         int eleccion2=Integer.parseInt(in.readline());
//                         switch(eleccion2){
//                             case 1:
//                                 System.out.println("Anadimos Cita");
//                                 System.out.println("Inserte el titulo de la cita");
//
//                                 titul=in.readline();
//                                 System.out.println("titulo insertado"+titul);
//                                 System.out.println("Inserte la descripcion de la cita");
//                                 desc=in.readline();
//                                 d.anadirCita(titul,desc);
//                                 System.out.println("inserte la fecha del horario de esta actividad dd/mm/aaaa");
//                                 fecha = in.readline();
//                                 d.asignarHorario(fecha);
//                                 break;
//
//                             case 2:
//
//                                 System.out.println("Inserte el titulo del deadline");
//                                 titul=in.readline();
//                                 System.out.println("Inserte la descripcion del deadline");
//                                 desc=in.readline();
//                                 System.out.println("Inserte el numero de horas estimado");
//                                 num=in.readline();
//                                 System.out.println("Inserte la prioridad del 1 al 5");
//                                 prio=in.readline();
//                                 System.out.println("Inserte la fecha del deadline DD/MM/AAAA");
//                                 fecha=in.readline();
//                                 d.anadirDeadLine(titul,desc,num,prio,fecha);
////                                 System.out.println("inserte la fecha del horario de esta actividad dd/mm/aaaa");
////                                 fecha = in.readline();
////                                 d.asignarHorario(fecha);
//                                 break;
//
//                             case 3:
//                                System.out.println("Inserte el titulo de En Mente");
//                                titul=in.readline();
//                                System.out.println("Inserte la descripcion de En Mente");
//                                desc=in.readline();
//                                System.out.println("Inserte la prioridad de En Mente");
//                                prio=in.readline();
//                                System.out.println("Inserte el numero estimado de horas");
//                                num=in.readline();
//
//                                 d.anadirEnMente(titul,desc,prio,num);
////                                 System.out.println("inserte la fecha del horario de esta actividad dd/mm/aaaa");
////                                 fecha = in.readline();
////                                 d.asignarHorario(fecha);
//                                 break;
//
//                             case 4:
//
//                                 System.out.println("El nombre de la persona que cumple anyos");
//                                 titul=in.readline();
//                                 System.out.println("Alguna anotacion suplementaria?");
//                                 desc=in.readline();
//                                 System.out.println("Inserte l a fecha del aniversario DD/MM/AAAA");
//                                 fecha=in.readline();
//                                 d.anadirCumpleanyos(titul,desc,fecha);
//                                 d.asignarHorario(fecha);
//                                 break;
//
//                             case 5:
//                                 System.out.println("titulo del memorandum");
//                                 titul=in.readline();
//                                 System.out.println("descripcion");
//                                 desc=in.readline();
//                                 System.out.println("texto del memorandum");
//                                 texto=in.readline();
//
//                                 d.anadirMemorandum(titul, desc, texto);
//                                 System.out.println("inserte la fecha del horario de esta actividad dd/mm/aaaa");
//                                 fecha = in.readline();
//                                 d.asignarHorario(fecha);
//                                 break;
//
//                             case 6: break;
//                         }
////                        System.out.println("inserte la fecha del horario de esta actividad dd/mm/aaaa");
////                        fecha = in.readline();
////                         d.asignarHorario(fecha);
//                         break;
//
//
//                 case 2:
//                     System.out.println("nombre del tema");
//                     titul=in.readline();
//                     d.crearTema(titul);break;
//
//                 case 3: d.listarAnadidos();break;
//                 case 4:
//
//                    System.out.println("Listado de actividades");
//                    d.listarAnadidos();
//                    System.out.println("inserta el id de la actividad a eliminar");
//                    int id=Integer.parseInt(in.readline());
//                     d.eliminarActividad(id);break;
//                 case 5: d.listarTemas();break;
//                 case 6: d.guardarEventos();break;
//                 case 7: d.cargarEventos();break;
//                 case 8:
//
//                     System.out.println("Listado de temas");
//                     d.listarTemas();
//                     System.out.println("inserta el nombre del tema a eliminar");
//                     titul=in.readline();
//                     d.eliminarTema(titul);
//
//                     break;
//
//             }
//         }
    }

}
