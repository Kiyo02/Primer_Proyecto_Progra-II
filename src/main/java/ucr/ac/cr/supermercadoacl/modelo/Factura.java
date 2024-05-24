/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.supermercadoacl.modelo;

/**
 *
 * @author Axely
 */
public class Factura {
    //Atributos
    private String idFactura, nombreEmpleado, nombreProducto;
    private int cantidad;
    private double total;
    public static final String [] TITULOS_FACTURA={"ID Factura", "Nombre Empleado", "Nombre Producto", "Cantidad", "Total"};
    //--------------------------------------------------------------------------
    
    //Metodo Construtor
    public Factura(String idFactura, String nombreEmpleado, String nombreProducto, int cantidad, double total) {
        this.idFactura = idFactura;
        this.nombreEmpleado = nombreEmpleado;
        this.nombreProducto = nombreProducto;
        this.cantidad = cantidad;
        this.total = total;
    }
    
    //Constructor vacio
    public Factura() {
    
    }
    //--------------------------------------------------------------------------
    
    //Metodo para la constante
    public String getDatosEmpleados (int columna){
        
        switch (columna){
            case 0:
                return this.idFactura;
            
            case 1:
                return this.nombreEmpleado;
            
            case 2:
                return this.nombreProducto;
            
            case 3:
                return String.valueOf(this.cantidad);
            
            case 4:
                return String.valueOf(this.total);
        }
        
        return ""; 
    }
    //--------------------------------------------------------------------------
    
    //Setters
    public void setIdFactura(String idFactura) {
        this.idFactura = idFactura;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    //--------------------------------------------------------------------------

    public String getIdFactura() {
        return idFactura;
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getTotal() {
        return total;
    }
    //--------------------------------------------------------------------------

    @Override
    public String toString() {
        return "idFactura=" + idFactura + ", nombreEmpleado=" + nombreEmpleado + ", nombreProducto=" + nombreProducto + ", cantidad=" + cantidad + ", total=" + total;
    }
    //--------------------------------------------------------------------------
    
}
