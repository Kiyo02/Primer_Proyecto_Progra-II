/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.supermercadoacl.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import ucr.ac.cr.supermercadoacl.modelo.Producto;
import ucr.ac.cr.supermercadoacl.vista.FRM_Factura;

/**
 *
 * @author Axely
 */
public class ManejadorFactura implements ActionListener, MouseListener{
    private FRM_Factura frm_Factura;

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
        Producto productoSeleccionado= new Producto();
        
        productoSeleccionado.setIdProducto(this.frm_Factura.getRow()[0]);
        productoSeleccionado.setNombreProducto(this.frm_Factura.getRow()[1]);
        productoSeleccionado.setTipoProducto(this.frm_Factura.getRow()[2]);
        
        

    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }
    
}
