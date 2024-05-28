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

/**
 *
 * @author Axely
 */
public class ManejadorFactura implements ActionListener, MouseListener{
    private final FRM_Factura frm_Factura;
    private final ArregloBodega arregloProductos;
    private ArrayList <Producto> listaProductos;
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
                
                this.producto=this.frm_Factura.getProducto();
                
                if(this.producto!= null){
                    
                    this.arregloProductos.eliminarProducto(this.listaProductos, producto);
                    this.frm_Factura.setDataTable(this.arregloProductos.getMatrizProductosTemp(listaProductos), this.producto.TITULOS_PRODUCTOS_FACTURA);
                    this.frm_Factura.limpiarCampos();
                    
                    
                } else {
                    
                    FRM_Factura.getMensaje("Seleccione un objeto de la tabla");
                    
                }
                
            break;
            //------------------------------------------------------------------
            
            case "Editar Producto":
                
                this.producto=this.frm_Factura.getProducto();
                
                if(this.producto!= null){
                    
                    this.listaProductos=this.arregloProductos.editarListaProductos(listaProductos, producto);
                    this.frm_Factura.setDataTable(this.arregloProductos.getMatrizProductosTemp(listaProductos), this.producto.TITULOS_PRODUCTOS_FACTURA);
                    this.frm_Factura.limpiarCampos();
                    
                } else {
                    
                    FRM_Factura.getMensaje("Seleccione un objeto de la tabla");
                    
                }
                
            break;
            //------------------------------------------------------------------
            
            case "Cerrar":
                
                FRM_Factura.getMensaje("Si realizó cambios en la tabla seleccione la opción de *Actualiza Fact*");
                this.frm_Factura.dispose();
                
            break;
            //------------------------------------------------------------------
        
        }//Fin de Switch
        //--------------------------------------------------------------------------
        
    }//Fin de ActionEvent
    //--------------------------------------------------------------------------

    @Override
    public void mouseClicked(MouseEvent e) {
        
        Producto productoSeleccionado= new Producto();
        
        productoSeleccionado.setIdProducto(this.frm_Factura.getRow()[0]);
        productoSeleccionado.setNombreProducto(this.frm_Factura.getRow()[1]);
        productoSeleccionado.setExistencias(Integer.parseInt(this.frm_Factura.getRow()[2]));
        productoSeleccionado.setPrecioVenta(Double.parseDouble(this.frm_Factura.getRow()[3]));
        
        this.frm_Factura.setProducto(productoSeleccionado);
        this.frm_Factura.activarBotones(true);

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
