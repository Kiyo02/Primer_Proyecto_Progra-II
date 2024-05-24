/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.supermercadoacl.modelo;

/**
 *
 * @author Axely
 */
public class Producto {
    //Atributos
    private String idProducto, nombreProducto, tipoProducto, provedor;
    private int existencias, cantidadLimite;
    private double precioCompra, precioVenta;
    public static final String [] TITULOS_PRODUCTOS={"ID Producto", "Nombre Producto", "Tipo Producto", "Provedor", "Existencias", "Cantidad Limite", "Precio Compra", "Precio Venta"};
    //--------------------------------------------------------------------------
    
    //Contructor

    public Producto(String idProducto, String nombreProducto, String tipoProducto, String provedor, int existencias, int cantidadLimite, double precioCompra, double precioVenta) {
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.tipoProducto = tipoProducto;
        this.provedor = provedor;
        this.existencias = existencias;
        this.cantidadLimite = cantidadLimite;
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
    }
    
    //Contructor vacio
    public Producto() {
    
    }
    //--------------------------------------------------------------------------
    
    //Metodo para la constante
    public String getDatosBodega (int columna){
        
        switch (columna){
            case 0:
                return this.idProducto;
            
            case 1:
                return this.nombreProducto;
            
            case 2:
                return this.tipoProducto;
            
            case 3:
                return this.provedor;
            
            case 4:
                return String.valueOf(this.existencias);
            
            case 5:
                return String.valueOf(this.cantidadLimite);
            
            case 6:
                return String.valueOf(this.precioCompra);
            
            case 7:
                return String.valueOf(this.precioVenta);
        }
        
        return ""; 
    }
    //--------------------------------------------------------------------------
    
    //Setters
    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }
    
    public void setTipoProducto(String tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

    public void setProvedor(String provedor) {
        this.provedor = provedor;
    }
    
    public void setExistencias(int existencias) {
        this.existencias = existencias;
    }

    public void setCantidadLimite(int cantidadLimite) {
        this.cantidadLimite = cantidadLimite;
    }

    public void setPrecioCompra(double precioCompra) {
        this.precioCompra = precioCompra;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }
    //--------------------------------------------------------------------------
    
    //Getters 
    public String getIdProducto() {
        return idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public int getExistencias() {
        return existencias;
    }

    public String getTipoProducto() {
        return tipoProducto;
    }

    public String getProvedor() {
        return provedor;
    }

    public int getCantidadLimite() {
        return cantidadLimite;
    }

    public double getPrecioCompra() {
        return precioCompra;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }
    //--------------------------------------------------------------------------

    @Override
    public String toString() {
        return "idProducto=" + idProducto + ", nombreProducto=" + nombreProducto + ", tipoProducto=" + tipoProducto + ", provedor=" + provedor + ", existencias=" + existencias + ", cantidadLimite=" + cantidadLimite + ", precioCompra=" + precioCompra + ", precioVenta=" + precioVenta;
    }
    //--------------------------------------------------------------------------
}
