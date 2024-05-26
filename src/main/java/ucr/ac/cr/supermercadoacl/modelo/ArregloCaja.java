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
public class ArregloCaja {
    //Referencias y Atributos
    private static final String filePath="Facturas.txt";
    private final JSON complementoJSON;
    private ArrayList <Factura> listaFactura;
    //--------------------------------------------------------------------------
    
    //Contructor

    public ArregloCaja() {
        this.complementoJSON= new JSON();
        this.listaFactura= this.complementoJSON.cargarJSON(filePath);
        
        if (listaFactura==null){
            
            this.listaFactura= new ArrayList<Factura>();
            
        }
    }
    //--------------------------------------------------------------------------
    
    //Metodo para registrar un empleado
    public String registrarFactura (Factura Factura){
        Factura facturaBuscada=this.buscarFactura(Factura.getIdFactura());
        
        if (facturaBuscada==null){

            this.listaFactura.add(Factura);
            this.complementoJSON.archivoJSON(Factura, filePath);
            
            return "Factura Registrado";
        } else {
            
            return "El id de esta factura ya ha sido registrada";
            
        }
    }
    //--------------------------------------------------------------------------
    
    //Metodo para asignar datos a la tabla de reporte
    public String[][] getMatrizFactura (){
        String[][] matrizFactura= new String[this.listaFactura.size()][Factura.TITULOS_FACTURA.length];
        
        for (int f=0; f<matrizFactura.length; f++){
            for (int c=0; c<matrizFactura[0].length; c++){
                
                matrizFactura[f][c]=this.listaFactura.get(f).getDatosFactura(c);
                
            }
        }
        
        return matrizFactura;
    }
    //--------------------------------------------------------------------------
    
    
    //************************************************************************//
    //--------------------Metodos Complementarios-----------------------------//
    //************************************************************************//
    //Metodo que devuelve una Factura registrado con el id que se desea buscar
    public Factura buscarFactura(int idFactura) {
        
        for (Factura miFactura : listaFactura) {
            
            if (miFactura.getIdFactura()==(idFactura)) {
                
                return miFactura;
                
            }
        }
        return null;
    }
    
    //--------------------------------------------------------------------------
}//Fin de Clase//---------------------------------------------------------------
