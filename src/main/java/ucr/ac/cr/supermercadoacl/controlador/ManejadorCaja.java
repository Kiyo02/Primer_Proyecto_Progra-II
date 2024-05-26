/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.supermercadoacl.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import ucr.ac.cr.supermercadoacl.modelo.ArregloCaja;
import ucr.ac.cr.supermercadoacl.modelo.ArregloBodega;
import ucr.ac.cr.supermercadoacl.modelo.Empleado;
import ucr.ac.cr.supermercadoacl.modelo.Factura;
import ucr.ac.cr.supermercadoacl.modelo.Producto;
import ucr.ac.cr.supermercadoacl.vista.FRM_Caja;
import ucr.ac.cr.supermercadoacl.vista.FRM_Reporte;
import ucr.ac.cr.supermercadoacl.vista.PanelDatosFactura;
import java.util.Random;

/**
 *
 * @author Axely
 */
public class ManejadorCaja implements ActionListener, MouseListener{
    //Atributos y Referencias
    private Factura factura;
    private Producto producto;
    private int idFactura;
    private final Random nRandom= new Random(1000+1);
    private final ArregloCaja listaFactura;
    private final ArregloBodega listaProductos;
    private final PanelDatosFactura panelFactura;
    private final FRM_Caja fRM_Factura;
    private FRM_Reporte fRM_Reporte;
    //--------------------------------------------------------------------------
    
    //Contructor
    public ManejadorCaja(ArregloCaja arregloFactura, ArregloBodega arregloProducto, Empleado empleado) {
        this.fRM_Factura = new FRM_Caja();
        this.listaFactura = arregloFactura;
        this.listaProductos= arregloProducto;
        this.panelFactura = this.fRM_Factura.getPanel();
        this.panelFactura.setTurnoEmpleado(empleado);
        
        this.panelFactura.escuchador(this);
        this.fRM_Factura.setVisible(true);
    
    }
    //--------------------------------------------------------------------------
    
    //ActionEvent
    @Override
    public void actionPerformed(ActionEvent e) {
        
        switch (e.getActionCommand()){
            
            case "Generar Factura":
                
                this.factura= this.panelFactura.getFactura(this.generarID());
                
                if(this.factura!= null){
                    
                    FRM_Caja.getMensaje(listaFactura.registrarFactura(factura));
                    this.listaProductos.finalizarVenta();
                    this.panelFactura.limpiarFactura();
                    this.producto= null;
                    
                }else{
                    
                    FRM_Caja.getMensaje("Llene todos los espacios para continuar");
                    
                }
                
            break;
            
            case "Agregar Producto":
                
                //El producto se actualiza en el MouseClicked
                String productoVerificado=this.panelFactura.verificarProducto(producto);
                if(this.producto!= null){
                    
                    if(productoVerificado.equalsIgnoreCase("Autorizado")){
                        
                        this.listaProductos.ventaProducto(producto, this.panelFactura.getCantidad());
                        this.panelFactura.setTotal(producto);
                        this.producto= null;
                        
                    }else{
                        
                        FRM_Caja.getMensaje(productoVerificado);
                        
                    }
                }
                
            break;
            
            case "Productos":
                
                this.fRM_Reporte= new FRM_Reporte();
                this.fRM_Reporte.setDataTable(this.listaProductos.getMatrizProductos(), Producto.TITULOS_PRODUCTOS);
                this.fRM_Reporte.listenMouse(this);
                this.fRM_Reporte.setVisible(true);
                
            break;
            
            case "Facturas":
                
                this.fRM_Reporte= new FRM_Reporte();
                this.fRM_Reporte.setDataTable(this.listaFactura.getMatrizFactura(), Factura.TITULOS_FACTURA);
                this.fRM_Reporte.setVisible(true);
                
            break;
            
            
            case "Limpiar Factura":
                
                this.panelFactura.limpiarCampos();
                this.panelFactura.limpiarFactura();
                this.listaProductos.cierreDeCaja();
                
            break;
            
            case "Cerrar":
                
                this.listaProductos.cierreDeCaja();
                this.fRM_Factura.dispose();
                
            break;
            
        }
        
    }
    //--------------------------------------------------------------------------
    
    //Metodo para generar y verificar un numero random
    public int generarID (){
        
        do{
            
            this.idFactura=nRandom.nextInt();
            
        } while (this.listaFactura.buscarFactura(idFactura)!= null);
        
        return idFactura;
    }
    //--------------------------------------------------------------------------
    
    //ListenMouse para la tabla de reporte
    @Override
    public void mouseClicked(MouseEvent e) {
        
        this.panelFactura.limpiarCampos();
            
        Producto productoSeleccionado= new Producto();

        productoSeleccionado.setIdProducto(this.fRM_Reporte.getRow()[0]);
        productoSeleccionado.setNombreProducto(this.fRM_Reporte.getRow()[1]);
        productoSeleccionado.setTipoProducto(this.fRM_Reporte.getRow()[2]);
        productoSeleccionado.setProvedor(this.fRM_Reporte.getRow()[3]);
        productoSeleccionado.setExistencias(Integer.parseInt(this.fRM_Reporte.getRow()[4]));
        productoSeleccionado.setCantidadLimite(Integer.parseInt(this.fRM_Reporte.getRow()[5]));
        productoSeleccionado.setPrecioCompra(Double.parseDouble(this.fRM_Reporte.getRow()[6]));
        productoSeleccionado.setPrecioVenta(Double.parseDouble(this.fRM_Reporte.getRow()[7]));

        this.panelFactura.setProduto(productoSeleccionado);
        this.producto = productoSeleccionado;
        this.fRM_Reporte.dispose();
        
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
    //--------------------------------------------------------------------------
    
}
