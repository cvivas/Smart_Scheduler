/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * vistaListaOtros.java
 *
 * Created on 29-may-2009, 1:26:47
 */

package agendainteligente;

import java.util.ArrayList;

/**
 *
 * @author carlos
 */
public class vistaListaOtros extends javax.swing.JPanel {

    CtrlDominio3 CD3 = new CtrlDominio3();

    /** Creates new form vistaListaOtros */
    public vistaListaOtros() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        list1 = new java.awt.List();

        list1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                list1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(list1, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(list1, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void list1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_list1MouseClicked
                   int indiceClick=Constantes.INCORRECTO;
           indiceClick = this.list1.getSelectedIndex();
           ArrayList<TCtrlListar> al = CD3.obtenerListadoDeOtros();
           TCtrlListar elem=null;
           if (al!=null && !al.isEmpty()){

               elem = al.get(indiceClick);


        VistaGestionActividad d = new VistaGestionActividad(new javax.swing.JFrame(),true,elem.getIdAct(),elem.getFechaAviso());
           d.setVisible(true);



           }
    }//GEN-LAST:event_list1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public java.awt.List list1;
    // End of variables declaration//GEN-END:variables

}