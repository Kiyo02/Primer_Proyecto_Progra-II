/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ucr.ac.cr.supermercadoacl.vista;

import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Axely
 */
public class FRM_Caja extends javax.swing.JFrame {

    /**
     * Creates new form FRM_Factura
     */
    public FRM_Caja() {
        initComponents();
    }
    //--------------------------------------------------------------------------
    
    public static void getMensaje (String mensaje){
        
        JOptionPane.showMessageDialog(null, mensaje);    
    }
    //--------------------------------------------------------------------------
    
    public PanelDatosCaja getPanel (){
        
        return panelDatosFactura1;    
    }
    //--------------------------------------------------------------------------
    
    //ActionListener de los botones
    public void setEscuchadores (ActionListener manejador){
        
        this.panelDatosFactura1.escuchador(manejador);    
    }
    //--------------------------------------------------------------------------
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelDatosFactura1 = new ucr.ac.cr.supermercadoacl.vista.PanelDatosCaja();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(panelDatosFactura1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private ucr.ac.cr.supermercadoacl.vista.PanelDatosCaja panelDatosFactura1;
    // End of variables declaration//GEN-END:variables
}
