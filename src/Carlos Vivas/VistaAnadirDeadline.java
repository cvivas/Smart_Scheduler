
/*
 * VistaAnadirDeadline.java
 * Anade Deadline, interacciona con CtrlDominio2
 * Autor Carlos Vivas
 * Ultima modificacion 26/05/2009
 */

package agendainteligente;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;



public class VistaAnadirDeadline extends javax.swing.JDialog {

      CtrlDominio2 CD2=new CtrlDominio2(); 
      Constantes constantes = new Constantes();
      CtrlAgenda CDA= new CtrlAgenda();
      Date inicio;
      Date fin;

    public VistaAnadirDeadline(java.awt.Frame parent, boolean modal) {

        super(parent, modal);
        initComponents();
        cargarTemas();
        this.setLocationRelativeTo(parent);
        iniciaEtiquetas();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtHoras = new javax.swing.JTextField();
        txtTitulo = new javax.swing.JTextField();
        comboTema = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        buttonGuardar = new javax.swing.JButton();
        buttonCancelar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();
        comboFecha = new datechooser.beans.DateChooserCombo();
        comboPrioridad = new javax.swing.JComboBox();
        LabelError = new javax.swing.JLabel();
        checkLaboral = new javax.swing.JCheckBox();
        botonTema = new javax.swing.JButton();
        LabelError1 = new javax.swing.JLabel();
        LabelError2 = new javax.swing.JLabel();
        LabelError3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        comboFechaI = new datechooser.beans.DateChooserCombo();
        jLabel11 = new javax.swing.JLabel();
        horasMin = new javax.swing.JComboBox();
        horasMax = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Anadir Deadline");
        setModal(true);
        setResizable(false);
        addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                formPropertyChange(evt);
            }
        });

        jLabel2.setText("Titulo");

        jLabel5.setText("Tema");

        jLabel6.setText("Num. Horas");

        jLabel4.setText("Prioridad");

        txtHoras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHorasActionPerformed(evt);
            }
        });

        comboTema.setModel(new javax.swing.DefaultComboBoxModel(new String[] {}));

        jLabel3.setText("Descripcion");

        txtDescripcion.setColumns(20);
        txtDescripcion.setRows(5);
        jScrollPane1.setViewportView(txtDescripcion);

        jLabel7.setText("Fecha fin");

        buttonGuardar.setText("Guardar");
        buttonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonGuardarActionPerformed(evt);
            }
        });

        buttonCancelar.setText("Cancelar");
        buttonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCancelarActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel9.setText("Añadir Deadline");

        comboPrioridad.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Alta", "Media", "Baja",}));

        LabelError.setForeground(new java.awt.Color(255, 0, 0));
        LabelError.setText("jLabel1");

        checkLaboral.setText("Laboral");

        botonTema.setText("Nuevo Tema");
        botonTema.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonTemaMouseClicked(evt);
            }
        });

        LabelError1.setForeground(new java.awt.Color(255, 0, 0));
        LabelError1.setText("jLabel1");

        LabelError2.setForeground(new java.awt.Color(255, 0, 0));
        LabelError2.setText("jLabel1");

        LabelError3.setForeground(new java.awt.Color(255, 0, 0));
        LabelError3.setText("jLabel1");

        jLabel8.setText("Numero de horas como maximo");

        jLabel10.setText("Numero de horas como minimo");

        jLabel11.setText("Fecha inicio");

        horasMin.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "00", "01", "02", "03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24" }));

        horasMax.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "00", "01", "02", "03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24" }));

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .addContainerGap()
                        .add(jSeparator1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE))
                    .add(layout.createSequentialGroup()
                        .add(213, 213, 213)
                        .add(jLabel9))
                    .add(layout.createSequentialGroup()
                        .add(24, 24, 24)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(LabelError2)
                            .add(LabelError3)
                            .add(layout.createSequentialGroup()
                                .add(LabelError)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 336, Short.MAX_VALUE)
                                .add(buttonCancelar)
                                .add(31, 31, 31)
                                .add(buttonGuardar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 86, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(124, 124, 124))
                            .add(LabelError1)))
                    .add(layout.createSequentialGroup()
                        .addContainerGap()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(checkLaboral)
                            .add(layout.createSequentialGroup()
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(layout.createSequentialGroup()
                                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                            .add(jLabel2)
                                            .add(jLabel5)
                                            .add(jLabel6)
                                            .add(jLabel4))
                                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                                            .add(comboPrioridad, 0, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .add(txtHoras)
                                            .add(comboTema, 0, 85, Short.MAX_VALUE)
                                            .add(txtTitulo)))
                                    .add(layout.createSequentialGroup()
                                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                            .add(jLabel7)
                                            .add(jLabel11))
                                        .add(33, 33, 33)
                                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                            .add(comboFechaI, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                            .add(comboFecha, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
                                .add(42, 42, 42)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(layout.createSequentialGroup()
                                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                            .add(layout.createSequentialGroup()
                                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 10, Short.MAX_VALUE)
                                                .add(jLabel3)
                                                .add(35, 35, 35))
                                            .add(layout.createSequentialGroup()
                                                .add(botonTema)
                                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)))
                                        .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                                            .add(layout.createSequentialGroup()
                                                .add(jLabel8)
                                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .add(horasMax, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                            .add(layout.createSequentialGroup()
                                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                                .add(jLabel10)
                                                .add(18, 18, 18)
                                                .add(horasMin, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)))
                                .add(150, 150, 150)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                        .add(jLabel9)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jSeparator1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 10, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(layout.createSequentialGroup()
                                .add(18, 18, 18)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                    .add(jLabel2)
                                    .add(txtTitulo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                .add(26, 26, 26)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                    .add(jLabel5)
                                    .add(comboTema, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 20, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                    .add(jLabel4)
                                    .add(comboPrioridad, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                    .add(jLabel6)
                                    .add(txtHoras, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                .add(56, 56, 56)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                                    .add(jLabel7)
                                    .add(comboFecha, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(jLabel11)
                                    .add(comboFechaI, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                            .add(layout.createSequentialGroup()
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(layout.createSequentialGroup()
                                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 47, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .add(jLabel3)
                                        .add(26, 26, 26)
                                        .add(botonTema))
                                    .add(layout.createSequentialGroup()
                                        .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .add(75, 75, 75)
                                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                                            .add(jLabel10)
                                            .add(horasMin, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                            .add(horasMax, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                            .add(jLabel8))))))
                        .add(36, 36, 36)
                        .add(checkLaboral)
                        .add(196, 196, 196))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(LabelError)
                            .add(buttonGuardar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 23, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(buttonCancelar))
                        .add(2, 2, 2)
                        .add(LabelError1)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(LabelError2)
                        .add(3, 3, 3)
                        .add(LabelError3)
                        .add(30, 30, 30))))
        );

        getAccessibleContext().setAccessibleParent(this);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-687)/2, (screenSize.height-567)/2, 687, 567);
    }// </editor-fold>//GEN-END:initComponents

    private void txtHorasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHorasActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_txtHorasActionPerformed

    @SuppressWarnings("static-access")
    private void buttonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonGuardarActionPerformed

        iniciaEtiquetas();
        boolean apte=true;

        Calendar hoy=Calendar.getInstance();

        Calendar cI=comboFechaI.getSelectedDate();
        inicio=cI.getTime();
        Calendar cF=comboFecha.getSelectedDate();
        fin=cF.getTime();

        CtrlCrearActividad2 ctr2=new CtrlCrearActividad2();

        int horas=0;
        int slotMin=0;
        int slotMax=0;

       if(txtTitulo.getText().isEmpty()){
           LabelError.setText("El título no puede ser vacío");
           apte=false;
       }
       if(txtHoras.getText().isEmpty()){
          LabelError1.setText("El numero estimado de horas es obligatorio");
          apte=false;
       }

        if(cI.after(cF)){
           LabelError2.setText("La fecha fin tiene que ser posterior a la de inicio");
          apte=false;
       }
       if(hoy.after(cF)){
           LabelError2.setText("La fecha fin tiene que ser posterior a la actual");
           apte=false;
       }
         
      try{
           horas=Integer.parseInt(txtHoras.getText());
           slotMin = Integer.parseInt((String)horasMin.getSelectedItem());
           slotMax = Integer.parseInt((String)horasMax.getSelectedItem());
           }catch(Exception e){
               LabelError3.setText("Numero de horas erroneo");
               apte=false;
           }  

        if(slotMax<slotMin || slotMax==0 || horas<1){
            LabelError3.setText("Numero de horas erroneo");
            apte=false;
        }

       if(apte){
           int prio;
           String prioridad = (String) comboPrioridad.getSelectedItem();
           boolean laboral = checkLaboral.isSelected();
           
           if(prioridad.equals("Alta")) prio=Constantes.Alta;
           else if(prioridad.equals("Media")) prio = Constantes.Media;
           else prio = Constantes.Baja;
           
           int id=ctr2.crearActividad(txtTitulo.getText(), txtDescripcion.getText(), "Deadline");
           ctr2.completarDeadline(fin,horas,prio,laboral,slotMin,slotMax,inicio);

           String tem=(String)comboTema.getSelectedItem();
           if(!tem.isEmpty()){
               Tema t=new Tema();
               t.crearTema(tem);
               CD2.CA2.asignarTemaActividad(t, id);
           }
         System.out.println("Deadline guardado con \n Titulo: "+txtTitulo.getText());              

         CtrlCrearAviso CCA =  new CtrlCrearAviso();
         CCA.crearAvisoDeadline(fin, id);
         CDA.asignacionAutomatica(id, prio, horas, laboral, inicio, fin, slotMin, slotMax);
         this.setVisible(false);

       }

 
      
}//GEN-LAST:event_buttonGuardarActionPerformed

    private void buttonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCancelarActionPerformed
         this.dispose();
}//GEN-LAST:event_buttonCancelarActionPerformed

    private void formPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_formPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_formPropertyChange

    private void botonTemaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonTemaMouseClicked
        // TODO add your handling code here:
        VistaCrearTema nuevoTema = new VistaCrearTema(new javax.swing.JFrame(), true);
        nuevoTema.setVisible(true);
        comboTema.removeAllItems();
        cargarTemas();
}//GEN-LAST:event_botonTemaMouseClicked

    //Carga los temas ya existentes en el combobox
    private  void cargarTemas(){

      
        ArrayList<String>lista=CD2.listartemas();
        int indiceI=0;
        int tamanyo=lista.size();
        comboTema.addItem(Constantes.NINGUNO);
        while(indiceI<tamanyo){
               comboTema.addItem(lista.get(indiceI));
             indiceI++;
        }

    }

    //Borra el contenido de las etiquetas
    private void iniciaEtiquetas(){
        LabelError.setText("");
        LabelError1.setText("");
        LabelError2.setText("");
        LabelError3.setText("");

    }
    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                VistaAnadirDeadline dialog = new VistaAnadirDeadline(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel LabelError;
    private javax.swing.JLabel LabelError1;
    private javax.swing.JLabel LabelError2;
    private javax.swing.JLabel LabelError3;
    private javax.swing.JButton botonTema;
    private javax.swing.JButton buttonCancelar;
    private javax.swing.JButton buttonGuardar;
    private javax.swing.JCheckBox checkLaboral;
    private datechooser.beans.DateChooserCombo comboFecha;
    private datechooser.beans.DateChooserCombo comboFechaI;
    private javax.swing.JComboBox comboPrioridad;
    private static javax.swing.JComboBox comboTema;
    private javax.swing.JComboBox horasMax;
    private javax.swing.JComboBox horasMin;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private static javax.swing.JTextArea txtDescripcion;
    private javax.swing.JTextField txtHoras;
    private static javax.swing.JTextField txtTitulo;
    // End of variables declaration//GEN-END:variables

}
