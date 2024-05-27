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
import ucr.ac.cr.supermercadoacl.modelo.ArregloCaja;
import ucr.ac.cr.supermercadoacl.modelo.ArregloBodega;
import ucr.ac.cr.supermercadoacl.modelo.Empleado;
import ucr.ac.cr.supermercadoacl.modelo.Factura;
import ucr.ac.cr.supermercadoacl.modelo.Producto;
import ucr.ac.cr.supermercadoacl.vista.FRM_Caja;
import ucr.ac.cr.supermercadoacl.vista.FRM_Reporte;
import ucr.ac.cr.supermercadoacl.vista.PanelDatosCaja;
import java.util.Random;

/**
 *
 * @author Axely
 */
public class ManejadorCaja implements ActionListener, MouseListener{
    //Atributos y Referencias
    private Factura factura;
    private Producto producto, productoFact;
    private int idFactura;
    private final Random nRandom= new Random();
    private final ArregloCaja listaFactura;
    private final ArregloBodega listaProductos;
    private ArrayList productosFactura= new ArrayList();
    private final PanelDatosCaja panelFactura;
    private final FRM_Caja fRM_Caja;
    private FRM_Reporte fRM_Reporte;
    private ManejadorFactura manejadorFactura;
    //--------------------------------------------------------------------------
    
    //Contructor
    public ManejadorCaja(ArregloCaja arregloFactura, ArregloBodega arregloProducto, Empleado empleado) {
        this.fRM_Caja = new FRM_Caja();
        this.listaFactura = arregloFactura;
        this.listaProductos= arregloProducto;
        this.panelFactura = this.fRM_Caja.getPanel();
        this.panelFactura.setTurnoEmpleado(empleado);
        
        this.panelFactura.escuchador(this);
        this.fRM_Caja.setVisible(true);
    
    }
    //--------------------------------------------------------------------------
    
    //ActionEvent
    @Override
    public void actionPerformed(ActionEvent e) {
        
        switch (e.getActionCommand()){
            
            case "Generar Factura":
                
                this.factura= this.panelFactura.getFactura(this.generarID(), this.listaProductos.rellenarLista(this.productosFactura));
                
                if(this.factura!= null){
                    
                    FRM_Caja.getMensaje(listaFactura.registrarFactura(factura));
                    this.listaProductos.finalizarVenta();
                    this.panelFactura.limpiarFactura();
                    this.productosFactura.clear();
                    this.producto= null;
                    
                }else{
                    
                    FRM_Caja.getMensaje("Factura vacía");
                    
                }
                
            break;
            
            case "Agregar Producto":
                
                //El producto se actualiza en el MouseClicked
                String productoVerificado=this.panelFactura.verificarProducto(producto);
                
                
                if(this.producto!= null){
                    
                    if(productoVerificado.equalsIgnoreCase("Autorizado")){
                        
                        this.listaProductos.ventaProducto(producto, this.panelFactura.getCantidad());
                        
                        this.productoFact= this.panelFactura.getProducto(producto);
                        this.productosFactura.add(productoFact);
                        this.productosFactura=this.listaProductos.editarLista(productosFactura);
                        this.panelFactura.setTotal(this.listaProductos.getTotal(this.productosFactura));
                        this.panelFactura.limpiarCampos();
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
            
            case "Actualizar Fact":
                
                if(this.productosFactura!= null){

                    this.setListaEditada();

                }
                
            break;
            
            
            case "Limpiar Factura":
                
                this.productosFactura.clear();
                this.panelFactura.limpiarFactura();
                this.listaProductos.cierreDeCaja();
                
            break;
            
            case "Editar Factura":
                
                if (this.productosFactura!= null){
                    
                    this.manejadorFactura= new ManejadorFactura(this.productosFactura);
                } else {
                    
                    FRM_Caja.getMensaje("No hay una lista de productos para editar");
                }
                
            break;
            
            case "Cerrar":
                
                this.fRM_Caja.dispose();
                this.listaProductos.cierreDeCaja();
                
            break;
            
        }
        
    }
    //--------------------------------------------------------------------------
    //Este controlador sirve para recibir la lista de productos ya editada
    public void setListaEditada (){
        ArrayList <Producto> nuevaLista= new ArrayList<>(this.productosFactura);
        this.panelFactura.limpiarFactura();
        this.listaProductos.cierreDeCaja();
        
        
        for (Producto miProducto : nuevaLista) {
            
            this.listaProductos.ventaProducto(productoFact, miProducto.getExistencias());

        }
        
        this.panelFactura.setTotal(this.listaProductos.getTotal(productosFactura));

    }
    
    
    //Metodo para generar y verificar un numero random
    public int generarID (){
        
        do{
            
            this.idFactura=nRandom.nextInt(1000+1);
            
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
        this.producto= productoSeleccionado;
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
