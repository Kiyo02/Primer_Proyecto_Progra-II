/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.supermercadoacl.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import ucr.ac.cr.supermercadoacl.modelo.ArregloBodega;
import ucr.ac.cr.supermercadoacl.modelo.Producto;
import ucr.ac.cr.supermercadoacl.vista.FRM_Bodega;
import ucr.ac.cr.supermercadoacl.vista.FRM_Reporte;
import ucr.ac.cr.supermercadoacl.vista.PanelDatosProducto;

/**
 *
 * @author Axely
 */
public class ManejadorBodega implements ActionListener, MouseListener{
    //Atributos y Referencias
    private Producto producto;
    private final ArregloBodega arregloProducto;
    private FRM_Reporte fRM_Reporte;
    private final PanelDatosProducto panelProducto;
    private final FRM_Bodega frm_Productos;
    //--------------------------------------------------------------------------
    
    //Contructor
    public ManejadorBodega(ArregloBodega arregloBodega) {
        this.frm_Productos= new FRM_Bodega();
        this.arregloProducto= new ArregloBodega();
        this.panelProducto=this.frm_Productos.getPanelDatos();
        this.panelProducto.escuchador(this);
        
        this.frm_Productos.setVisible(true);
    
    }
    //--------------------------------------------------------------------------
    
    //ActionEvent
    @Override
    public void actionPerformed(ActionEvent e) {
        
        switch (e.getActionCommand()){
            
            case "Registrar":
                
                this.producto= this.panelProducto.getProducto();
                
                if (this.producto!= null){
                    
                    FRM_Bodega.getMensaje(arregloProducto.agregarProducto(producto));
                    this.panelProducto.limpiarCampos();
                    
                }
                
            break;
            //------------------------------------------------------------------
            
            case "Editar":
                
                this.producto=this.panelProducto.getProducto();
                
                if (this.producto!= null){
                    
                    FRM_Bodega.getMensaje(arregloProducto.editarProducto(producto));
                    this.panelProducto.limpiarCampos();
                    this.panelProducto.activarBotones(false);
                    
                } else {
                    
                    FRM_Bodega.getMensaje("Selecciona un producto por medio del boton de productos");
                    
                }
                
            break;
            //------------------------------------------------------------------
            
            case "Remover":
                
                this.producto=this.panelProducto.getProducto();
                
                if (this.producto!= null){
                    FRM_Bodega.getMensaje(arregloProducto.removerProducto(producto));
                    this.panelProducto.limpiarCampos();
                    this.panelProducto.activarBotones(false);
                    
                    
                } else {
                    
                    FRM_Bodega.getMensaje("Selecciona un producto por medio del boton de productos");
                    
                }
                
            break;
            //------------------------------------------------------------------
            
            case "Agregar":
                
                this.producto=this.panelProducto.getProducto();
                
                if (this.producto!= null){
                    FRM_Bodega.getMensaje(this.arregloProducto.agregarStock(producto, this.panelProducto.nuevoStock()));
                    this.panelProducto.limpiarCampos();
                    this.panelProducto.activarBotones(false);
                    
                } else {
                    
                    FRM_Bodega.getMensaje("Selecciona un producto por medio del boton de productos");
                    
                }
                
            break;
            //------------------------------------------------------------------
            
            case "Productos":
                
                this.fRM_Reporte= new FRM_Reporte();
                this.fRM_Reporte.setDataTable(this.arregloProducto.getMatrizProductos(), Producto.TITULOS_PRODUCTOS);
                this.fRM_Reporte.listenMouse(this);
                this.fRM_Reporte.setVisible(true);
                
            break;
            //------------------------------------------------------------------
            
            case "Cerrar":
                
                this.frm_Productos.dispose();
                
            break;
            //------------------------------------------------------------------
            
        }//Fin de Switch
        //----------------------------------------------------------------------
    
    }//Fin de ActionEvent
    //--------------------------------------------------------------------------
    
    //ListenMouse para la tabla de reporte
    @Override
    public void mouseClicked(MouseEvent e) {
        this.panelProducto.limpiarCampos();
        
        Producto productoSeleccionado= new Producto();

        productoSeleccionado.setIdProducto(this.fRM_Reporte.getRow()[0]);
        productoSeleccionado.setNombreProducto(this.fRM_Reporte.getRow()[1]);
        productoSeleccionado.setTipoProducto(this.fRM_Reporte.getRow()[2]);
        productoSeleccionado.setProvedor(this.fRM_Reporte.getRow()[3]);
        productoSeleccionado.setExistencias(Integer.parseInt(this.fRM_Reporte.getRow()[4]));
        productoSeleccionado.setCantidadLimite(Integer.parseInt(this.fRM_Reporte.getRow()[5]));
        productoSeleccionado.setPrecioCompra(Double.parseDouble(this.fRM_Reporte.getRow()[6]));
        productoSeleccionado.setPrecioVenta(Double.parseDouble(this.fRM_Reporte.getRow()[7]));
        
        this.panelProducto.setProducto(productoSeleccionado);
        this.panelProducto.activarBotones(true);
        this.fRM_Reporte.dispose();
    }
    //--------------------------------------------------------------------------
    
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
    //--------------------------------------------------------------------------
}//Fin de Clase//---------------------------------------------------------------
