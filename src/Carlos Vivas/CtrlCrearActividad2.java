
package agendainteligente;

import java.util.Date;

/**
 * descripcion: controladora para crear las diferentes actividades
 * author carlos Vivas Abilahoud
 */




public class CtrlCrearActividad2  {

    CtrlDominio3 CD3 = new CtrlDominio3();

    private int idAct;




    public int crearActividad(String titulo, String descripcion, String tipo){

        setIdAct(CD3.crearActividad(titulo, descripcion, tipo));


        /* HAY QUE INSERTAR UNA OPERACION PARA CREAR UN AVISO
         *
         * codigo:
         * (insertar un booleano en la cabecera: "aviso"
         *
         * if(aviso){
         *
         *  CtrlCrearAviso CdUAviso =  new CtrlCrearAviso();
         *  CdUAviso.crearAviso(fecha,idAct);
         * }
         *
         * habria que hacer lo mismo para los temas no?
         *
         * otra cosa: os habeis mirado algo de las vistas?
         *
         *
         *




         */
        return getIdAct();

    }


    public void completarCita(boolean esRep, boolean esLab){

//        boolean esrep = Boolean.parseBoolean(esRep);
//        boolean eslab = Boolean.parseBoolean(esLab);
        CD3.completarCita(getIdAct(),esRep,esLab);

    }

    public void completarEnMente(int prioridad, int nHoras, boolean esLab,int horasMin,
            int horasMax, Date fechaInicio){

//        int prio = Integer.parseInt(prioridad);
//        int iNHores = Integer.parseInt(nhoras);
//        boolean eslab = Boolean.parseBoolean(es_laboral);
        CD3.completarEnMente(getIdAct(),prioridad,nHoras,esLab,horasMin,horasMax,fechaInicio);


    }
    
    public void completarDeadline(Date fechafin, int numH, int prioridad, boolean esLab,int horasMin, int horasMax, Date fechaInicio){

//        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
//        Date fechaf;
//        int numHores=Integer.parseInt(numH);
//        int prio = Integer.parseInt(prioridad);
//        boolean eslab = Boolean.parseBoolean(esLab);
//        try {
//            fechaf = formato.parse(fechafin);
//        } catch (ParseException ex) {
//            ex.printStackTrace();
//            throw new RuntimeException(ex);
//        }

        CD3.completarDeadline(getIdAct(),fechafin,numH, prioridad, esLab,horasMin, horasMax,fechaInicio);

    }

    public void completarAniversario(Date fecha){
//        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
//        Date fechaN;
//        try {
//            fechaN = formato.parse(fecha);
//        } catch (ParseException ex) {
//            ex.printStackTrace();
//            throw new RuntimeException(ex);
//        }
        CD3.completarAniversario(getIdAct(),fecha);
    }
    
    public void completarMemorandum(String texto, Date fecha){

        CD3.completarMemorandum(getIdAct(),texto, fecha);
    
    }

    public void completarCitaRepetitiva(boolean esLab, int periodicidad, Date iniP, Date finP){
        
//        boolean eslab = Boolean.parseBoolean(esLab);
//        int per = Integer.parseInt(periodicidad);
//        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
//        Date fechaP;
//                try {
//            fechaP = formato.parse(finP);
//        } catch (ParseException ex) {
//            ex.printStackTrace();
//            throw new RuntimeException(ex);
//        }

        CD3.completarCitaRepetitiva(getIdAct(),esLab,periodicidad,iniP, finP);

    }

    /**
     * @return the idAct
     */
    public int getIdAct() {
        return idAct;
    }

    /**
     * @param idAct the idAct to set
     */
    public void setIdAct(int idAct) {
        this.idAct = idAct;
    }
    
}
