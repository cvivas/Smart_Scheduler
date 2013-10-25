
/* Descripcion: LLama a todas las funcione posibles de actividad dependiendo de si
 * estan creadas previamente o no. Interactua con CtrlDominio3.
 * VistaGestionActividad.java
 * Autor: Carlos Vivas
 * Created on 09-may-2009, 13:09:25
 */

package agendainteligente;

import java.util.Date;



public class VistaGestionActividad extends javax.swing.JDialog {
    int id;
    CtrlDominio3 control=new CtrlDominio3();
    Date fecha;
    /** Creates new form VistaGestionActividad */
    public VistaGestionActividad(java.awt.Frame parent, boolean modal, int id,Date fecha) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(parent);
        RadioAnadir.setSelected(true);
        this.id=id;
        this.fecha=fecha;
        carga();

    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        ComboActividad = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        RadioAnadir = new javax.swing.JRadioButton();
        RadioModificar = new javax.swing.JRadioButton();
        RadioEliminar = new javax.swing.JRadioButton();
        ButtonCancelar = new javax.swing.JButton();
        ButtonSiguiente = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        RadioMostrar = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gestion Actividad");
        setModal(true);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel1.setText("Gestion Actividad");

        ComboActividad.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Cita", "Deadline", "EnMente", "Aniversario","Memorandum" }));

        jLabel2.setText("Selecciona actividad");

        RadioAnadir.setText("Añadir");
        RadioAnadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RadioAnadirActionPerformed(evt);
            }
        });

        RadioModificar.setText("Modificar");
        RadioModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RadioModificarActionPerformed(evt);
            }
        });

        RadioEliminar.setText("Eliminar");
        RadioEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RadioEliminarActionPerformed(evt);
            }
        });

        ButtonCancelar.setText("Cancelar");
        ButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonCancelarActionPerformed(evt);
            }
        });

        ButtonSiguiente.setText("Siguiente");
        ButtonSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonSiguienteActionPerformed(evt);
            }
        });

        jLabel3.setText("Opciones de actividad");

        RadioMostrar.setText("Mostrar");
        RadioMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RadioMostrarActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(42, 42, 42)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabel2)
                    .add(ComboActividad, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 155, Short.MAX_VALUE)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jLabel3)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(RadioEliminar)
                            .add(RadioModificar)
                            .add(RadioMostrar)
                            .add(RadioAnadir))
                        .add(6, 6, 6)))
                .add(50, 50, 50))
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap(241, Short.MAX_VALUE)
                .add(ButtonCancelar)
                .add(12, 12, 12)
                .add(ButtonSiguiente)
                .add(43, 43, 43))
            .add(jSeparator1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 448, Short.MAX_VALUE)
            .add(layout.createSequentialGroup()
                .add(157, 157, 157)
                .add(jLabel1)
                .addContainerGap(172, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(jLabel1)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jSeparator1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 14, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabel2)
                    .add(layout.createSequentialGroup()
                        .add(jLabel3)
                        .add(26, 26, 26)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(RadioAnadir)
                            .add(ComboActividad, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(RadioMostrar)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(RadioModificar)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(RadioEliminar)))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 58, Short.MAX_VALUE)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(ButtonSiguiente)
                    .add(ButtonCancelar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    //Funcion que dependiendo del id muestra unas opciones u otras
    private void carga(){
        if(id >0){
           RadioAnadir.setVisible(false);
           RadioAnadir.setSelected(false);
           RadioMostrar.setVisible(true);
           RadioMostrar.setSelected(true);
           Actividad act=control.CA3.buscarActividad(id);
   
           if(act!=null){
               ComboActividad.setSelectedItem(act.getClass().getSimpleName());
               ComboActividad.setEnabled(false);

               }

        }else{
            RadioMostrar.setVisible(false);
            RadioModificar.setVisible(false);
            RadioEliminar.setVisible(false);
        }

     

    }
    private void ButtonSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonSiguienteActionPerformed
        
        if(ComboActividad.getSelectedItem().equals("Deadline")){
            if(RadioAnadir.isSelected()){
                 VistaAnadirDeadline dialog = new VistaAnadirDeadline(new javax.swing.JFrame(), true);
                 dialog.setVisible(true);
            }
            else if(RadioModificar.isSelected()){
                 VistaModificarDeadline dialog = new VistaModificarDeadline(new javax.swing.JFrame(), true,id);
                 dialog.setVisible(true);
            }
            else if(RadioEliminar.isSelected()){
                VistaEliminarDeadline dialog = new VistaEliminarDeadline(new javax.swing.JFrame(), true,id,fecha);
                dialog.setVisible(true);
            }
            else{
                 VistaVerDeadline dialog = new VistaVerDeadline(new javax.swing.JFrame(), true,id);
                 dialog.setVisible(true);
            }

        }
        else if(ComboActividad.getSelectedItem().equals("Cita")){
             if(RadioAnadir.isSelected()){
                 VistaAnadirCita dialog = new VistaAnadirCita(new javax.swing.JFrame(), true);
                 dialog.setVisible(true);
            }
            else if(RadioModificar.isSelected()){
                 VistaModificarCita dialog = new VistaModificarCita(new javax.swing.JFrame(), true, id,fecha);
                 dialog.setVisible(true);
            }
            else if(RadioEliminar.isSelected()){
                VistaEliminarCita dialog = new VistaEliminarCita(new javax.swing.JFrame(), true, id,fecha);
                dialog.setVisible(true);

            }else{
                VistaVerCita dialog = new VistaVerCita(new javax.swing.JFrame(), true, id,fecha);
                dialog.setVisible(true);
            }
        }
        else if(ComboActividad.getSelectedItem().equals("EnMente")){
             if(RadioAnadir.isSelected()){
                 VistaAnadirEnMente dialog = new VistaAnadirEnMente(new javax.swing.JFrame(), true);
                 dialog.setVisible(true);
            }
            else if(RadioModificar.isSelected()){
                 VistaModificarEnMente dialog = new VistaModificarEnMente(new javax.swing.JFrame(), true,id);
                 dialog.setVisible(true);
            }
            else if(RadioEliminar.isSelected()){
                VistaEliminarEnMente dialog = new VistaEliminarEnMente(new javax.swing.JFrame(), true,id);
                dialog.setVisible(true);
            }
            else{
                 VistaVerEnMente dialog = new VistaVerEnMente(new javax.swing.JFrame(), true,id,fecha);
                dialog.setVisible(true);
            }
        }
        else if(ComboActividad.getSelectedItem().equals("Memorandum")){
              if(RadioAnadir.isSelected()){
                 VistaAnadirMemorandum dialog = new VistaAnadirMemorandum(new javax.swing.JFrame(), true);
                 dialog.setVisible(true);
            }
            else if(RadioModificar.isSelected()){
                 VistaModificarMemorandum dialog = new VistaModificarMemorandum(new javax.swing.JFrame(), true,id,fecha);
                 dialog.setVisible(true);
            }
            else if(RadioEliminar.isSelected()){
                VistaEliminarMemorandum dialog = new VistaEliminarMemorandum(new javax.swing.JFrame(), true,id);
                dialog.setVisible(true);
            }
            else{
                VistaVerMemorandum dialog = new VistaVerMemorandum(new javax.swing.JFrame(), true,id,fecha);
                dialog.setVisible(true);
            }
        }
         else if(ComboActividad.getSelectedItem().equals("Aniversario")){
              if(RadioAnadir.isSelected()){
                 VistaAnadirAniversario dialog = new VistaAnadirAniversario(new javax.swing.JFrame(), true);
                 dialog.setVisible(true);
            }
            else if(RadioModificar.isSelected()){
                 VistaModificarAniversario dialog = new VistaModificarAniversario(new javax.swing.JFrame(), true,id);
                 dialog.setVisible(true);
            }
            else if(RadioEliminar.isSelected()){
                VistaEliminarAniversario dialog = new VistaEliminarAniversario(new javax.swing.JFrame(), true,id);
                dialog.setVisible(true);
            }
            else{
                VistaVerAniversario dialog = new VistaVerAniversario(new javax.swing.JFrame(), true,id);
                dialog.setVisible(true);
            }
        }
        this.dispose();
       
    }//GEN-LAST:event_ButtonSiguienteActionPerformed

    private void RadioAnadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RadioAnadirActionPerformed
        if(RadioModificar.isSelected()) RadioModificar.setSelected(false);
        if(RadioEliminar.isSelected())  RadioEliminar.setSelected(false);
        if(RadioMostrar.isSelected())   RadioMostrar.setSelected(false);
    }//GEN-LAST:event_RadioAnadirActionPerformed

    private void RadioModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RadioModificarActionPerformed
        if(RadioAnadir.isSelected())  RadioAnadir.setSelected(false);
        if(RadioEliminar.isSelected())RadioEliminar.setSelected(false);
        if(RadioMostrar.isSelected()) RadioMostrar.setSelected(false);
    }//GEN-LAST:event_RadioModificarActionPerformed

    private void RadioEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RadioEliminarActionPerformed
         if(RadioModificar.isSelected()) RadioModificar.setSelected(false);
         if(RadioAnadir.isSelected())    RadioAnadir.setSelected(false);
         if(RadioMostrar.isSelected())   RadioMostrar.setSelected(false);
    }//GEN-LAST:event_RadioEliminarActionPerformed

    private void ButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonCancelarActionPerformed
       this.dispose();
    }//GEN-LAST:event_ButtonCancelarActionPerformed

    private void RadioMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RadioMostrarActionPerformed
         if(RadioModificar.isSelected()) RadioModificar.setSelected(false);
         if(RadioAnadir.isSelected())    RadioAnadir.setSelected(false);
         if(RadioEliminar.isSelected())  RadioEliminar.setSelected(false);
}//GEN-LAST:event_RadioMostrarActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            private int idAct;
            private Date fecha;
            public void run() {
                
                VistaGestionActividad dialog = new VistaGestionActividad(new javax.swing.JFrame(), true,idAct,fecha);
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
    private javax.swing.JButton ButtonCancelar;
    private javax.swing.JButton ButtonSiguiente;
    protected javax.swing.JComboBox ComboActividad;
    private static javax.swing.JRadioButton RadioAnadir;
    private javax.swing.JRadioButton RadioEliminar;
    private javax.swing.JRadioButton RadioModificar;
    private static javax.swing.JRadioButton RadioMostrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables

}
