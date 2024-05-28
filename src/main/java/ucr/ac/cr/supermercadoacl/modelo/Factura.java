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
    private String nombreEmpleado, nombreProducto;
    private int idFactura;
    private double total;
    public static final String [] TITULOS_FACTURA={"ID Factura", "Nombre Empleado", "Nombre Producto", "Total"};
    //--------------------------------------------------------------------------
    
    //Metodo Construtor
    public Factura(int idFactura, String nombreEmpleado, String nombreProducto, double total) {
        this.idFactura = idFactura;
        this.nombreEmpleado = nombreEmpleado;
        this.nombreProducto = nombreProducto;
        this.total = total;
    }
    
    //Constructor vacio
    public Factura() {
    
    }
    //--------------------------------------------------------------------------
    
    //Metodo para la constante
    public String getDatosFactura (int columna){
        
        switch (columna){
            case 0:
                return String.valueOf(this.idFactura);
            
            case 1:
                return this.nombreEmpleado;
            
            case 2:
                return this.nombreProducto;
            
            case 3:
                return String.valueOf(this.total);
        }
        
        return ""; 
    }
    //--------------------------------------------------------------------------
    
    //Setters
    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    //--------------------------------------------------------------------------

    public int getIdFactura() {
        return idFactura;
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public double getTotal() {
        return total;
    }
    //--------------------------------------------------------------------------

    @Override
    public String toString() {
        return "idFactura=" + idFactura + ", nombreEmpleado=" + nombreEmpleado + ", nombreProducto=" + nombreProducto + ", total=" + total;
    }
    //--------------------------------------------------------------------------
}//Fin de Clase//---------------------------------------------------------------
