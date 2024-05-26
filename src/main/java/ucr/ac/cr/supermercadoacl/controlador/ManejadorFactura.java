/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.supermercadoacl.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import ucr.ac.cr.supermercadoacl.modelo.ArregloBodega;
import ucr.ac.cr.supermercadoacl.modelo.Producto;
import ucr.ac.cr.supermercadoacl.vista.FRM_Factura;
import ucr.ac.cr.supermercadoacl.vista.PanelDatosCaja;

/**
 *
 * @author Axely
 */
public class ManejadorFactura implements ActionListener, MouseListener{
    private final FRM_Factura frm_Factura;
    private ArregloBodega arregloProductos;
    private ArrayList <Producto> listaProductos;
    private PanelDatosCaja panelDatosCaja;
    private Producto producto;

    public ManejadorFactura(ArrayList<Producto> productosFactura) {
        this.frm_Factura= new FRM_Factura();
        this.arregloProductos= new ArregloBodega();
        this.listaProductos= productosFactura;
        this.frm_Factura.setDataTable(arregloProductos.getMatrizProductosTemp(listaProductos), Producto.TITULOS_PRODUCTOS_FACTURA);
        
        this.frm_Factura.listenMouse(this);
        this.frm_Factura.escuchadores(this);
        this.frm_Factura.setVisible(true);
        
    }
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        
        switch (e.getActionCommand()){
            
            case "Remover Producto":
                
                if(this.producto!= null){
                    
                    this.listaProductos.remove(producto);
                    this.frm_Factura.setDataTable(this.arregloProductos.getMatrizProductosTemp(listaProductos), this.producto.TITULOS_PRODUCTOS_FACTURA);
                    this.frm_Factura.limpiarCampos();
                    
                    
                } else {
                    
                    FRM_Factura.getMensaje("Seleccione un objeto de la tabla");
                    
                }
                
            break;

            case "Editar Producto":
                
                if(this.producto!= null){
                    
                    this.listaProductos=this.arregloProductos.editarListaProductos(listaProductos, producto);
                    this.frm_Factura.setDataTable(this.arregloProductos.getMatrizProductosTemp(listaProductos), this.producto.TITULOS_PRODUCTOS_FACTURA);
                    this.frm_Factura.limpiarCampos();
                    
                } else {
                    
                    FRM_Factura.getMensaje("Seleccione un objeto de la tabla");
                    
                }
                
            break;
            
            case "Cerrar":
                
                this.panelDatosCaja.setFacturaTemp(this.listaProductos);
                this.frm_Factura.dispose();
                
            break;
            
            
        }
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
        Producto productoSeleccionado= new Producto();
        
        productoSeleccionado.setIdProducto(this.frm_Factura.getRow()[0]);
        productoSeleccionado.setNombreProducto(this.frm_Factura.getRow()[1]);
        productoSeleccionado.setTipoProducto(this.frm_Factura.getRow()[2]);
        
        this.frm_Factura.setProducto(productoSeleccionado);
        this.frm_Factura.activarBotones(true);

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
