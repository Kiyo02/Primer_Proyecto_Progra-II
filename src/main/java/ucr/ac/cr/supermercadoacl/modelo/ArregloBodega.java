/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.supermercadoacl.modelo;

import java.util.ArrayList;

/**
 *
 * @author Axely
 */
public class ArregloBodega {
    //Atributos y Referencias
    private static final String filePath="Bodega.txt";
    private ArrayList <Producto> listaProductos;
    private final JSON complementoJSON;
    //--------------------------------------------------------------------------

    //Constructor
    public ArregloBodega() {
        this.complementoJSON= new JSON();
        this.listaProductos= this.complementoJSON.cargarJSON(filePath);
        
        if (listaProductos== null){
            
            listaProductos= new ArrayList<Producto>();
        }
    }
    //--------------------------------------------------------------------------
    
    public String agregarProducto(Producto producto) {
        Producto productoBuscado= this.buscarProducto(producto.getIdProducto());
        
        if (productoBuscado== null) {
                
            listaProductos.add(producto);
            this.complementoJSON.archivoJSON(producto, filePath);
            return "Producto registrado";
                
        }
        
        return "Producto ya se encuentra registrado";
    }
    //--------------------------------------------------------------------------
    
    
    public String removerProducto(Producto producto) {
        Producto productoBuscado= this.buscarProducto(producto.getIdProducto());
        
        if (productoBuscado!= null){

            this.listaProductos.remove(productoBuscado);
            this.complementoJSON.sobrescribirJSON(listaProductos, filePath);
            return "El producto se elimino correctamente";
        }
        
        return "Error";
    }
    //--------------------------------------------------------------------------
    
    public String editarProducto(Producto producto) {
        Producto productoBuscado= this.buscarProducto(producto.getIdProducto());
            
        if (productoBuscado!= null){
            
            this.listaProductos.remove(productoBuscado);
            this.listaProductos.add(producto);
            this.complementoJSON.sobrescribirJSON(listaProductos, filePath);
            return "Producto editado correctamente";
            
        }
        
        return "Error";
    }
    //--------------------------------------------------------------------------
    
    public String agregarStock(Producto producto, int cantidad) {
        Producto productoBuscado= this.buscarProducto(producto.getIdProducto());
        
        
        if (productoBuscado!= null) {
            
            if (cantidad+productoBuscado.getExistencias() <= producto.getCantidadLimite()) {
                
                producto.setExistencias(productoBuscado.getExistencias()+cantidad);
                listaProductos.remove(productoBuscado);
                listaProductos.add(producto);
                this.complementoJSON.sobrescribirJSON(listaProductos, filePath);
                return "Transacción realizada correctamente";
                
            } else {
                
                return "Sobrepasa la cantidad límite de existencias en bodega";
            }

        }
        return "Producto no registrado";   
    }
    //--------------------------------------------------------------------------

    public String[][] getMatrizProductos() {
        String[][] matrizProductos= new String[this.listaProductos.size()][Producto.TITULOS_PRODUCTOS.length];

        for (int f= 0; f<matrizProductos.length; f++) {
            for (int c=0; c<matrizProductos[0].length; c++) {
                
                matrizProductos[f][c]= this.listaProductos.get(f).getDatosBodega(c);
                
            }
        }
        return matrizProductos;
    }
    
        //Metodo para asignar datos a la tabla de la factura
    public String[][] getMatrizProductosTemp (ArrayList<Producto> listaProductos){
        String[][] matrizFacturaTemp= new String[listaProductos.size()][Producto.TITULOS_PRODUCTOS_FACTURA.length];
        
        for (int f=0; f<matrizFacturaTemp.length; f++){
            for (int c=0; c<matrizFacturaTemp[0].length; c++){
                
                matrizFacturaTemp[f][c]=listaProductos.get(f).getDatosProductosFactura(c);

                
            }
        }
        
        return matrizFacturaTemp;
    }
    
    public ArrayList <Producto> eliminarProducto (ArrayList listaProductos, Producto producto){
        ArrayList<Producto> listaEditar=listaProductos;
        
        for (Producto miProducto : listaEditar) {
            
            if (miProducto.getIdProducto().equalsIgnoreCase(producto.getIdProducto())){
                
                listaEditar.remove(miProducto);
                return listaEditar;
                
            }
            
        }
        
        return listaEditar;
    }
    public ArrayList <Producto> editarListaProductos (ArrayList listaProductos, Producto producto){
        ArrayList<Producto> listaEditar=listaProductos;
        
        for (Producto miProducto : listaEditar) {
            if (miProducto.getIdProducto().equalsIgnoreCase(producto.getIdProducto())){
                
                listaEditar.remove(miProducto);
                listaEditar.add(producto);
                return listaEditar;
            }
        }
        
        return null;
    }
    //--------------------------------------------------------------------------
    
    //************************************************************************//
    //--------------------Metodos Complementarios-----------------------------//
    //************************************************************************//
    public Producto buscarProducto(String id) {
        
        for (Producto miProducto : listaProductos) {
            
            if (miProducto.getIdProducto().equalsIgnoreCase(id)) {
                
                return miProducto;
                
            }
        }
        return null;
    }
    //--------------------------------------------------------------------------
    
    //************************************************************************//
    //----------------Metodos Complementarios Para Factura--------------------//
    //************************************************************************//
    //Estos metodos son especificos para el modulo de Factura
    //Consiste en controlar el hecho de que una compra no se finalice
    //Entonces se basa en dividir el metodo principal (ventaProducto) en 3
    //Para que uno actualice el Array, otro el JSON y el otro en una factura cancelada
    public String ventaProducto(Producto producto, int cantidad) {
        Producto productoBuscado= this.buscarProducto(producto.getIdProducto());
        
        if (productoBuscado!= null){
            
            producto=productoBuscado;
            producto.setExistencias(productoBuscado.getExistencias()-cantidad);
            this.listaProductos.remove(productoBuscado);
            this.listaProductos.add(producto);
            return "Venta realizada correctamente";

        }
            
        return "Se ha generado un error inprevisto";
    }
    //--------------------------------------------------------------------------
    
    //Metodo que se utiliza cada vez que se agrega un producto a la factura
    //Verifica si hay poductos iguales y suma las cantidades y unifica el producto
    public ArrayList <Producto> editarLista (ArrayList <Producto> listaProductos){
        ArrayList<Producto> listaEditada = new ArrayList<>(listaProductos);
        int nuevasExistencias;
        Producto productoLista;
        int tamanio=listaEditada.size();
        
        if(tamanio>1){
            for (int i=0; i<listaProductos.size(); i++) {
                productoLista=listaEditada.get(i);

                for (int c=1; c<listaProductos.size(); c++){

                    if (listaEditada.get(i)!= null && listaEditada.get(c)!= null){
                        if (i!=c && listaEditada.get(c).getIdProducto().equalsIgnoreCase(productoLista.getIdProducto())){

                            nuevasExistencias=listaEditada.get(c).getExistencias()+productoLista.getExistencias();
                            productoLista.setExistencias(nuevasExistencias);
                            listaEditada.remove(listaEditada.get(i));
                            listaEditada.remove(listaEditada.get(c-1));
                            listaEditada.add(productoLista);
                            return listaEditada;

                        }
                    }
                }
            }
        }
            
        return listaEditada;
    }
    
    public String rellenarLista (ArrayList <Producto> listaProductos){
        String lista= "Producto ";
        
        if (this.listaProductos!= null){
            
            for (Producto producto : listaProductos) {
                
                lista+=producto.getNombreProducto()+
                    ", Cantidad "+producto.getExistencias()+
                    ", Total "+ producto.getPrecioVenta()*producto.getExistencias();
                
            }
            
            return lista;
        }
        
        return null;
    }
    
    public double getTotal (ArrayList <Producto> listaProducto){
        double total=0;
        
        for (Producto miProducto : listaProducto) {
            
            total+=miProducto.getExistencias()*miProducto.getPrecioVenta();
            
        }
        
        return total;
    }
    //Metodo para cada vez que se finaliza una factura
    public void finalizarVenta (){
        
        this.complementoJSON.sobrescribirJSON(listaProductos, filePath);
    }
    //--------------------------------------------------------------------------
    
    //Metodo para cada vez que se cancela una factura o se cierra la caja
    public void cierreDeCaja (){
        
        this.listaProductos.clear();
        this.listaProductos=this.complementoJSON.cargarJSON(filePath);
        
    }
    
    //--------------------------------------------------------------------------
}//Fin de Clase//---------------------------------------------------------------
