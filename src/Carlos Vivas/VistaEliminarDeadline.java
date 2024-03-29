
/* Descripcion Elimina Deadlines, interactua con CtrlDominio3 y CtrlAgenda
 * VistaEliminarDeadline.java
 * Autor: Carlos Vivas
 * Created on 29-abr-2009, 19:52:15
 */

package agendainteligente;

import java.util.Calendar;
import java.util.Date;


public class VistaEliminarDeadline extends javax.swing.JDialog {
    CtrlDominio3 control=new CtrlDominio3();
    CtrlActividad3 controlAct =  new CtrlActividad3();
    CtrlHorario2 controlHor =  new CtrlHorario2();
    CtrlAgenda CDA= new CtrlAgenda();
    Date inicio;
    Date fin;
    int id;
    /** Creates new form VistaEliminarDeadline */
    public VistaEliminarDeadline(java.awt.Frame parent, boolean modal,int id,Date fecha) {
        super(parent, modal);
        initComponents();
        this.id=id;
        this.fin=fecha;
        inicializarCampos();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        txtHoras = new javax.swing.JTextField();
        txtTitulo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        comboFechaI = new datechooser.beans.DateChooserCombo();
        txtFechaI = new javax.swing.JLabel();
        buttinEliminar = new javax.swing.JButton();
        buttonCancelar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextPane();
        radioHoy = new javax.swing.JRadioButton();
        radioFranja = new javax.swing.JRadioButton();
        radioTotal = new javax.swing.JRadioButton();
        comboPrioridad = new javax.swing.JComboBox();
        comboFechaF = new datechooser.beans.DateChooserCombo();
        txtFechaF = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Eliminar Deadline");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel1.setText("Eliminar: Deadline");

        jLabel2.setText("Titulo");

        jLabel5.setText("Tema");

        jLabel6.setText("Num. Horas");

        jLabel4.setText("Prioridad");

        jTextField2.setEditable(false);
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        txtHoras.setEditable(false);
        txtHoras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHorasActionPerformed(evt);
            }
        });

        txtTitulo.setEditable(false);

        jLabel3.setText("Descripcion");

        txtFechaI.setText("Deadline");

        buttinEliminar.setText("Eliminar");
        buttinEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttinEliminarActionPerformed(evt);
            }
        });

        buttonCancelar.setText("Cancelar");
        buttonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCancelarActionPerformed(evt);
            }
        });

        txtDescripcion.setEditable(false);
        txtDescripcion.setEnabled(false);
        jScrollPane2.setViewportView(txtDescripcion);

        radioHoy.setText("Solo hoy");
        radioHoy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioHoyActionPerformed(evt);
            }
        });

        radioFranja.setText("Franja horaria");
        radioFranja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioFranjaActionPerformed(evt);
            }
        });

        radioTotal.setText("Total");
        radioTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioTotalActionPerformed(evt);
            }
        });

        comboPrioridad.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Alta", "Media", "Baja" }));
        comboPrioridad.setEnabled(false);

        txtFechaF.setText("Deadline");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(208, 208, 208)
                        .addComponent(jLabel1))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 614, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                                .addComponent(jLabel3)
                                .addGap(29, 29, 29))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jTextField2, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(comboPrioridad, javax.swing.GroupLayout.Alignment.LEADING, 0, 70, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addComponent(txtHoras, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(radioFranja)
                            .addComponent(radioHoy)
                            .addComponent(radioTotal)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(txtFechaI)
                                .addGap(47, 47, 47))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtFechaF)
                                .addGap(47, 47, 47)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(comboFechaI, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboFechaF, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(125, 125, 125)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonCancelar)
                .addGap(42, 42, 42)
                .addComponent(buttinEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(8, 8, 8))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(comboPrioridad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtHoras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(117, 117, 117))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                        .addComponent(radioHoy)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(radioFranja)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(radioTotal)
                        .addGap(18, 18, 18)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtFechaI)
                    .addComponent(comboFechaI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtFechaF)
                    .addComponent(comboFechaF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonCancelar)
                    .addComponent(buttinEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttinEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttinEliminarActionPerformed

        Calendar cI=comboFechaI.getSelectedDate();
        inicio=cI.getTime();
        
        try{
        if(radioTotal.isSelected()){
           CDA.eliminarActividad(id);
       }
       else if(radioHoy.isSelected()){
        CDA.eliminarActividadDia(id, fin);

       }
       else{
            Calendar cF=comboFechaF.getSelectedDate();
            fin=cF.getTime();

            if(inicio.after(fin)){
            CDA.eliminarActividadFranja(id, inicio, fin);
            }else txtFechaI.setText("Fecha incorrecta");
       }
        }catch(Exception e){}
        this.dispose();
        
}//GEN-LAST:event_buttinEliminarActionPerformed

    private void radioHoyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioHoyActionPerformed
       if(radioFranja.isSelected()){
           radioFranja.setSelected(false);
       }
       if(radioTotal.isSelected()){
           radioTotal.setSelected(false);
       }
       
       if(comboFechaF.isVisible()){
           comboFechaF.setVisible(false);
       }

       if(comboFechaI.isVisible()){
           comboFechaI.setVisible(false);
       }

       txtFechaI.setText("");
       txtFechaF.setText("");
}//GEN-LAST:event_radioHoyActionPerformed

    private void txtHorasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHorasActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_txtHorasActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_jTextField2ActionPerformed

    private void radioFranjaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioFranjaActionPerformed
       if(radioHoy.isSelected()){
           radioHoy.setSelected(false);
       }
       if(radioTotal.isSelected()){
            radioTotal.setSelected(false);
       }
       if(!comboFechaI.isVisible()){
           comboFechaI.setVisible(true);
       }
       if(!comboFechaF.isVisible()){
           comboFechaF.setVisible(true);
       }


        txtFechaF.setText("Fecha Fin");
        txtFechaI.setText("Fecha inicio");

    }//GEN-LAST:event_radioFranjaActionPerformed

    private void radioTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioTotalActionPerformed
        if(radioFranja.isSelected()){
            radioFranja.setSelected(false);
        }
        if(radioHoy.isSelected()){
           radioHoy.setSelected(false);
        }
        if(comboFechaI.isVisible()){
            comboFechaI.setVisible(false);
        }

       if(comboFechaF.isVisible()){
           comboFechaF.setVisible(false);
       }

        txtFechaI.setText("");
        txtFechaF.setText("");
    }//GEN-LAST:event_radioTotalActionPerformed

    private void buttonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCancelarActionPerformed
       this.dispose();
    }//GEN-LAST:event_buttonCancelarActionPerformed

    //Carga los campos del Deadline
    private void inicializarCampos(){

            Calendar c= Calendar.getInstance();
            Actividad d=control.CA3.buscarActividad(id);
            Deadline modificador=(Deadline)d;

            txtFechaI.setText("");
            txtFechaF.setText("");
            radioHoy.setSelected(true);

           if(comboFechaF.isVisible()){
               comboFechaF.setVisible(false);
           }

           if(comboFechaI.isVisible()){
               comboFechaI.setVisible(false);
           }

           txtFechaI.setText("");
           txtFechaF.setText("");
          
            txtTitulo.setText(modificador.getTitulo());
            txtDescripcion.setText(modificador.getDescripcion());
            Integer h=modificador.getNumHoras();
            txtHoras.setText(h.toString());
            c.setTime(modificador.getFechaFinal());
            comboFechaI.setSelectedDate(c);
            int p=modificador.getPrioridad();
            if(p==1){
               comboPrioridad.setSelectedItem("Baja");
            }
            else if(p==2){
               comboPrioridad.setSelectedItem("Media");
            }
            else{
                comboPrioridad.setSelectedItem("Alta");
            }


    }


    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            private int idAct;
            private Date fecha;
            public void run() {
                VistaEliminarDeadline dialog = new VistaEliminarDeadline(new javax.swing.JFrame(), true,idAct,fecha);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttinEliminar;
    private javax.swing.JButton buttonCancelar;
    private javax.swing.ButtonGroup buttonGroup1;
    private datechooser.beans.DateChooserCombo comboFechaF;
    private datechooser.beans.DateChooserCombo comboFechaI;
    private javax.swing.JComboBox comboPrioridad;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JRadioButton radioFranja;
    private javax.swing.JRadioButton radioHoy;
    private javax.swing.JRadioButton radioTotal;
    private javax.swing.JTextPane txtDescripcion;
    private javax.swing.JLabel txtFechaF;
    private javax.swing.JLabel txtFechaI;
    private javax.swing.JTextField txtHoras;
    private javax.swing.JTextField txtTitulo;
    // End of variables declaration//GEN-END:variables



}
