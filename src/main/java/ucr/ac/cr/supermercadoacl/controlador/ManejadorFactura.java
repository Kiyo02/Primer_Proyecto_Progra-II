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
import ucr.ac.cr.supermercadoacl.modelo.ArregloProducto;
import ucr.ac.cr.supermercadoacl.modelo.Empleado;
import ucr.ac.cr.supermercadoacl.modelo.Factura;
import ucr.ac.cr.supermercadoacl.modelo.Producto;
import ucr.ac.cr.supermercadoacl.vista.FRM_Factura;
import ucr.ac.cr.supermercadoacl.vista.FRM_Reporte;
import ucr.ac.cr.supermercadoacl.vista.PanelDatosFactura;
import java.util.Random;

/**
 *
 * @author Axely
 */
public class ManejadorFactura implements ActionListener, MouseListener{
    //Atributos y Referencias
    private Factura factura;
    private Producto producto;
    private int idFactura;
    private String tablaSeleccionada;
    private Random nRandom= new Random(1000+1);
    private ArregloFactura listaFactura;
    private ArregloProducto listaProductos;
    private PanelDatosFactura panelFactura;
    private FRM_Factura fRM_Factura;
    private FRM_Reporte fRM_Reporte;
    //--------------------------------------------------------------------------
    
    //Contructor
    public ManejadorFactura(ArregloFactura arregloFactura, ArregloProducto arregloProducto, Empleado empleado) {
        this.fRM_Factura = new FRM_Factura();
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
                
                //Se usa este medio ya que para poder generar una factura hay 
                //que registrar como minimo un producto  
                if(this.producto!= null){
                    
                    FRM_Factura.getMensaje(listaFactura.registrarFactura(panelFactura.getFactura(this.generarID())));
                    this.panelFactura.limpiarFactura();
                    this.producto= null;
                    
                }else{
                    
                    FRM_Factura.getMensaje("Llene todos los espacios para continuar");
                    
                }
                
            break;
            
            case "Agregar Producto":
                
                /*if(this.producto!= null){
                    if(bodega.getExistencias() > panelFactura.getCantidad()){
                        producto = new Bodega(bodega.getIdProducto(),bodega.getNombreProducto(),
                        panelFactura.getCantidad(),bodega.getPrecio());
                        listaFactura.agregarProducto(producto);
                        this.producto= null;
                        
                        FRM_Factura.getMensaje("Producto Agregado...");
                        
                        
                    }else{
                        FRM_Factura.getMensaje("La cantidad sobrepasa a la que se tiene en Bodega");
                    }
                }else{
                    FRM_Factura.getMensaje("Llene todos los espacios para continuar");
                }*/
                
            break;
            
            case "Productos":
                
                this.tablaSeleccionada="tblProductos";
                this.fRM_Reporte= new FRM_Reporte();
                this.fRM_Reporte.setDataTable(this.listaProductos.getMatrizProductos(), Producto.TITULOS_PRODUCTOS);
                this.fRM_Reporte.listenMouse(this);
                this.fRM_Reporte.setVisible(true);
                
            break;
            
            case "Facturas":
                
                this.tablaSeleccionada="tblFacturas";
                this.fRM_Reporte= new FRM_Reporte();
                this.fRM_Reporte.setDataTable(this.listaFactura.getMatrizFactura(), Factura.TITULOS_FACTURA);
                this.fRM_Reporte.listenMouse(this);
                this.fRM_Reporte.setVisible(true);
                
            break;
            
            
            case "Cerrar":
                
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
        
        if (this.tablaSeleccionada.equalsIgnoreCase("tblProductos")){
            
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
            
        } else if (this.tablaSeleccionada.equalsIgnoreCase("tblFacturas")){
            
            Factura facturaSeleccionada= new Factura();
            
            facturaSeleccionada.setIdFactura(Integer.parseInt(this.fRM_Reporte.getRow()[0]));
            facturaSeleccionada.setNombreEmpleado(this.fRM_Reporte.getRow()[1]);
            facturaSeleccionada.setNombreProducto(this.fRM_Reporte.getRow()[2]);
            facturaSeleccionada.setTotal(Double.parseDouble(this.fRM_Reporte.getRow()[3]));
            
        }
        
        
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
