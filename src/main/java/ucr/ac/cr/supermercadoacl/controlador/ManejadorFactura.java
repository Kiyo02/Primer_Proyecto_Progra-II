/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.supermercadoacl.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import ucr.ac.cr.supermercadoacl.modelo.ArregloFactura;
import ucr.ac.cr.supermercadoacl.modelo.Factura;
import ucr.ac.cr.supermercadoacl.vista.FRM_Factura;
import ucr.ac.cr.supermercadoacl.vista.FRM_Reporte;
import ucr.ac.cr.supermercadoacl.vista.PanelDatosFactura;

/**
 *
 * @author Axely
 */
public class ManejadorFactura implements ActionListener, MouseListener{
    //Atributos y Referencias
    private Factura factura;
    private ArregloFactura listaFactura;
    private PanelDatosFactura panelFactura;
    private FRM_Factura fRM_Factura;
    private FRM_Reporte fRM_Reporte;
    //--------------------------------------------------------------------------
    
    //Contructor
    public ManejadorFactura(ArregloFactura arregloFactura) {
    
    
    }
    //--------------------------------------------------------------------------
    
    //ActionEvent
    @Override
    public void actionPerformed(ActionEvent e) {
        
        switch (e.getActionCommand()){
            
            case "":
                
            break;
            
        }
        
    }
    //--------------------------------------------------------------------------
    
    //ListenMouse para la tabla de reporte
    @Override
    public void mouseClicked(MouseEvent e) {
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mouseExited(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    //--------------------------------------------------------------------------
    
}
