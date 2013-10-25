/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * VistaModificarEnMente.java
 *
 * Created on 29-abr-2009, 20:20:23
 */

package agendainteligente;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Marc Sitges
 */
public class VistaModificarEnMente extends javax.swing.JDialog {

    CtrlAgenda CA = new CtrlAgenda();
    CtrlTema CT = new CtrlTema();
    CtrlModificarActivitat CMA = new CtrlModificarActivitat();
    CtrlEliminarActividad CEA = new CtrlEliminarActividad();
    CtrlCrearActividad2 CCA = new CtrlCrearActividad2();
    CtrlCrearAviso CAV = new CtrlCrearAviso();
    CtrlCrearTema CCT = new CtrlCrearTema();

    int idActividadSeleccionada;
    boolean existe = false;
    boolean laboral = false;
    int Nhoras;
    int slotMax;
    int slotMin;
    int prioridad;
    Date fechaInicio;
    /** Creates new form VistaModificarEnMente
     * @param parent
     * @param modal
     * @param idAct
     */
    public VistaModificarEnMente(java.awt.Frame parent, boolean modal, int idAct) {
        super(parent, modal);
        initComponents();
        cargarTemas();
        textoError.setText("");
        idActividadSeleccionada = idAct;
        existe = cargarEnMente(idActividadSeleccionada);
        if(!existe)textoError.setText("No hay ninguna actividad en mente en el sistema");
    }

    private boolean cargarEnMente(int idActividadSeleccionada) {

        Actividad a=CA.CA3.buscarActividad(idActividadSeleccionada);
        if(a==null){
            textoTitulo.disable();
            textoDescripcion.disable();
            return false;
        }
        EnMente modificador=(EnMente)a;

        slotMax = modificador.getSlotMax();
        slotMin = modificador.getSlotMin();
        Nhoras = modificador.getNHoras();
        numHoras.setText(String.valueOf(Nhoras));
        laboral = modificador.isEs_laboral();
        es_laboral.setSelected(modificador.isEs_laboral());
        textoTitulo.setText(modificador.getTitulo());
        textoDescripcion.setText(modificador.getDescripcion());
        prioridad = modificador.getPrioridad();
        if(prioridad == Constantes.Alta)panelPrioridad.setSelectedIndex(0);
        if(prioridad == Constantes.Media)panelPrioridad.setSelectedIndex(1);
        if(prioridad == Constantes.Baja)panelPrioridad.setSelectedIndex(2);
        String tema = CA.obtenerTema(idActividadSeleccionada);
        comboTema.setSelectedItem(tema);
        fechaInicio = modificador.getFechaInicio();

        return true;

    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        textoTitulo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        textoError = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textoDescripcion = new javax.swing.JTextPane();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        comboTema = new javax.swing.JComboBox();
        jButton3 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        panelPrioridad = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        es_laboral = new javax.swing.JCheckBox();
        numHoras = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        horasMax = new javax.swing.JFormattedTextField();
        horasMin = new javax.swing.JFormattedTextField();
        FechaInicio = new javax.swing.JLabel();
        fechaCombo = new datechooser.beans.DateChooserCombo();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabel2.setText("Titulo");

        jLabel6.setText("Descripcion");

        textoError.setForeground(new java.awt.Color(255, 0, 0));
        textoError.setText("jLabel7");

        jScrollPane1.setViewportView(textoDescripcion);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel1.setText("Modificar: En Mente");

        jButton1.setText("Modificar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        comboTema.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ninguno"}));

        jButton3.setText("Nuevo tema");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel7.setText("Tema");

        jLabel8.setText("Numero de horas");

        panelPrioridad.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Alta", "Media", "Baja" }));

        jLabel4.setText("Prioridad");

        es_laboral.setText("Laboral");

        jLabel9.setText("Numero de horas como maximo");

        jLabel10.setText("Numero de horas como minimo");

        horasMax.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                horasMaxActionPerformed(evt);
            }
        });
        horasMax.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                horasMaxKeyTyped(evt);
            }
        });

        horasMin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                horasMinKeyTyped(evt);
            }
        });

        FechaInicio.setText("Fecha Inicio");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 583, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(208, 208, 208)
                        .addComponent(jLabel1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(textoError)
                                    .addComponent(es_laboral))
                                .addGap(18, 18, 18)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(42, 42, 42)
                                .addComponent(jButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel9)
                                            .addComponent(jLabel10))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(horasMax, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(horasMin, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(FechaInicio)
                                        .addGap(18, 18, 18)
                                        .addComponent(fechaCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 323, Short.MAX_VALUE)
                                        .addComponent(jLabel6))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel8)
                                            .addComponent(jLabel4))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                    .addComponent(comboTema, javax.swing.GroupLayout.Alignment.LEADING, 0, 96, Short.MAX_VALUE)
                                                    .addComponent(textoTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
                                                    .addComponent(panelPrioridad, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGap(27, 27, 27)
                                                .addComponent(jButton3))
                                            .addComponent(numHoras, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(27, 27, 27)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(13, 13, 13)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel6)
                            .addComponent(textoTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(numHoras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(comboTema, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(panelPrioridad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(es_laboral)
                                .addGap(52, 52, 52)
                                .addComponent(textoError))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton2)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fechaCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(FechaInicio))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(horasMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(horasMax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))))
                .addGap(28, 28, 28))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        boolean error1=false;
        boolean error2=false;
        boolean error3=false;
        boolean error4=false;

        boolean cambioDeHoras = false;

        if(!existe)textoError.setText("No hay ninguna actividad en mente en el sistema");
        else{

            /*capturamos primero la prioridad*/
            String prio = (String) panelPrioridad.getSelectedItem();
            int prioridadMod;
            if(prio.equals("Alta")){
                prioridadMod=Constantes.Alta;
            }
            else if(prio.equals("Media")){
                prioridadMod=Constantes.Media;
            }
            else prioridadMod=Constantes.Baja;
            /*fin de la captura de prioridades*/

            /*capturamos si es laboral o no*/
            boolean laboral2 = es_laboral.isSelected();
            /*fin de la captura de si es laboral*/

            /*capturamos el numero de horas*/
            int horas;
            String numH = numHoras.getText();
            try{
                horas = Integer.parseInt(numH);
            }catch(Exception e){
                horas=0;
            }
            if(horas!=Nhoras && horas>0)cambioDeHoras=true;
            /*fin de la captura del numero de horas*/

            String prueba = horasMin.getText();
            try{
                slotMin = Integer.parseInt(prueba);
            }catch(Exception e){
                slotMin=0;
            }
            prueba = horasMax.getText();
            try{
                slotMax = Integer.parseInt(prueba);
            }catch(Exception e){
                slotMax=0;
            }

            if(slotMax<slotMin) error1=true;

            /************************************************/
            /***Modificacion de los datos de la actividad****/
            /************************************************/

            /*capturamos la descripcion*/
            String descripcion = textoDescripcion.getText();
                if(descripcion.equals(""))error2=true;
            /*fin de la captura de la descripcion*/

            /*capturamos el titulo*/
            String titulo = textoTitulo.getText();
                if(titulo.equals(""))error1=true;
            /*fin de la captura del titulo*/

            /*capturamos el tema*/
            String tema = (String) comboTema.getSelectedItem();
                if(tema.equals(""))error4=true;
            /*fin de la captura del tema*/

            Date inicio = fechaInicio;
            Date fin = CtrlAgenda.annoSiguiente(inicio);

            if(!error1 && !error2 && !error3 && !error4){

                CA.insertarInformacionGenerica(idActividadSeleccionada, titulo, descripcion);
                CCA.setIdAct(idActividadSeleccionada);
                CCA.completarEnMente(prioridadMod, horas, laboral2,slotMin,slotMax,fechaInicio);
                CCT.crearTema(tema, titulo, idActividadSeleccionada);
                int resultat=1;

                if(cambioDeHoras || (laboral2!=laboral && horas>0) ||
                        (prioridad!=prioridadMod && horas>0)){

                    CEA.eliminarActividadTodo(idActividadSeleccionada);
                    idActividadSeleccionada = CCA.crearActividad(titulo, descripcion, "EnMente");
                    CCA.completarEnMente(prioridadMod, horas, laboral2,slotMin,slotMax,fechaInicio);
                    CCT.crearTema(tema, titulo, idActividadSeleccionada);

                    while(resultat!=0){

                        resultat=CA.asignacionAutomatica(idActividadSeleccionada,
                                prioridadMod, horas, laboral2,fechaInicio, fin, slotMin, slotMax);

                        if(resultat>0){

                            inicio= (Date) CtrlAgenda.diaSiguiente(fin).clone();
                            fin = CtrlAgenda.annoSiguiente(inicio);
                            horas=resultat;
                        }
                    }
                }
                else if(horas==0) {
                    CEA.eliminarActividadTodo(idActividadSeleccionada);
                    idActividadSeleccionada = CCA.crearActividad(titulo, descripcion, "EnMente");
                    CCA.completarEnMente(prioridadMod, horas, laboral2,slotMin,slotMax,fechaInicio);
                    CCT.crearTema(tema, titulo, idActividadSeleccionada);

                    while(inicio.before(fin)){
                       CAV.crearAviso(inicio, idActividadSeleccionada);
                       inicio = (Date) CA.semanaSiguiente(inicio).clone();
                    }
                }
                this.dispose();
            }
            else {
                if(error1) textoError.setText("Titulo incorrecto");
                else if(error2) textoError.setText("descripcion incorrecta");
                else if(error3) textoError.setText("Horas incorrectas");
                else if(error4) textoError.setText("Tema incorrecto");
            }
        }
}//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.dispose();
}//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        VistaCrearTema nuevoTema = new VistaCrearTema(new javax.swing.JFrame(), true);
        nuevoTema.setVisible(true);
        comboTema.removeAllItems();
        cargarTemas();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void horasMaxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_horasMaxActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_horasMaxActionPerformed

    private void horasMaxKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_horasMaxKeyTyped
        // TODO add your handling code here:
        textoError.setText("");
}//GEN-LAST:event_horasMaxKeyTyped

    private void horasMinKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_horasMinKeyTyped
        // TODO add your handling code here:
        textoError.setText("");
}//GEN-LAST:event_horasMinKeyTyped

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            private int idActividad;
            public void run() {
                VistaModificarEnMente dialog = new VistaModificarEnMente(new javax.swing.JFrame(), true, idActividad);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    private  void cargarTemas(){

        ArrayList<String>lista=CA.listartemas();
        int indiceI=0;
        int tamanyo=lista.size();
        while(indiceI<tamanyo){
               comboTema.addItem(lista.get(indiceI));
             indiceI++;
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel FechaInicio;
    private javax.swing.JComboBox comboTema;
    private javax.swing.JCheckBox es_laboral;
    private datechooser.beans.DateChooserCombo fechaCombo;
    private javax.swing.JFormattedTextField horasMax;
    private javax.swing.JFormattedTextField horasMin;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField numHoras;
    private javax.swing.JComboBox panelPrioridad;
    private javax.swing.JTextPane textoDescripcion;
    private javax.swing.JLabel textoError;
    private javax.swing.JTextField textoTitulo;
    // End of variables declaration//GEN-END:variables

}