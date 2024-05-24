/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.supermercadoacl.modelo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author Axely
 */
public class JSON {
    //Atributos y Referencias
    private ArrayList lista;
    //--------------------------------------------------------------------------
    
    //Constructor
    public JSON() {
        
        lista= new ArrayList<>();
        
    }
    
    //Añadir al respectivo archivo JSON un objeto
    public void archivoJSON (Object Objeto, String ruta){
        JSONObject objetoJSON= new JSONObject(); 
        
        if (ruta.equalsIgnoreCase("Bodega.txt")){
            Producto bodega= (Producto) Objeto;
            
            objetoJSON.put("ID Producto", bodega.getIdProducto());
            objetoJSON.put("Nombre Producto", bodega.getNombreProducto());
            objetoJSON.put("Tipo Producto", bodega.getTipoProducto());
            objetoJSON.put("Provedor", bodega.getProvedor());
            objetoJSON.put("Existencias", bodega.getExistencias());
            objetoJSON.put("Cantidad Limite", bodega.getCantidadLimite());
            objetoJSON.put("Precio Compra", bodega.getPrecioCompra());
            objetoJSON.put("Precio Venta", bodega.getPrecioVenta());
            
        } else if (ruta.equalsIgnoreCase("Empleados.txt")){
            Empleado empleado= (Empleado) Objeto;
            
            objetoJSON.put("Usuario", empleado.getUsuario());
            objetoJSON.put("Clave", empleado.getClave());
            objetoJSON.put("Nombre Empleado", empleado.getNombreEmpleado());
            objetoJSON.put("Puesto", empleado.getPuesto());
            objetoJSON.put("Cedula", empleado.getCedula());
            objetoJSON.put("Edad", empleado.getEdad());
            
        } else if (ruta.equalsIgnoreCase("Facturas.txt")){
            Factura factura= (Factura) Objeto;
            
            objetoJSON.put("ID Factura", factura.getIdFactura());
            objetoJSON.put("Nombre Empleado", factura.getNombreEmpleado());
            objetoJSON.put("Nombre Producto", factura.getNombreProducto());
            objetoJSON.put("Cantidad", factura.getCantidad());
            objetoJSON.put("Total", factura.getTotal());
            
        }
        
        JSONArray jsonArray= new JSONArray();
        
        JSONParser jsonParser= new JSONParser();
        
        try (FileReader reader= new FileReader(ruta)){
            
            Object object= jsonParser.parse(reader);
            jsonArray=(JSONArray)object;
            
        } catch (IOException | org.json.simple.parser.ParseException e){
            System.out.println("Archivo no existente");   
        }
        
        jsonArray.add(objetoJSON);
        
        try (FileWriter file= new FileWriter(ruta)){
            
            file.write(jsonArray.toJSONString());
            file.flush();
            
        } catch (IOException io){
            io.printStackTrace();
        }
    }
    //--------------------------------------------------------------------------
    
    //Metodo complementario para editar u eliminar objetos y rescribir el respectivo JSON
    public void sobrescribirJSON (ArrayList lista, String ruta){
        Empleado empleado; Factura factura; Producto bodega;
        JSONArray jsonArray= new JSONArray();
        
        for (int i=0; i<lista.size(); i++){
            JSONObject objetoJSON= new JSONObject();
            
            if (ruta.equalsIgnoreCase("Bodega.txt")){
                bodega= (Producto) lista.get(i);

                objetoJSON.put("ID Producto", bodega.getIdProducto());
                objetoJSON.put("Nombre Producto", bodega.getNombreProducto());
                objetoJSON.put("Tipo Producto", bodega.getTipoProducto());
                objetoJSON.put("Provedor", bodega.getProvedor());
                objetoJSON.put("Existencias", bodega.getExistencias());
                objetoJSON.put("Cantidad Limite", bodega.getCantidadLimite());
                objetoJSON.put("Precio Compra", bodega.getPrecioCompra());
                objetoJSON.put("Precio Venta", bodega.getPrecioVenta());

            } else if (ruta.equalsIgnoreCase("Empleados.txt")){
                empleado= (Empleado) lista.get(i);

                objetoJSON.put("Usuario", empleado.getUsuario());
                objetoJSON.put("Clave", empleado.getClave());
                objetoJSON.put("Nombre Empleado", empleado.getNombreEmpleado());
                objetoJSON.put("Puesto", empleado.getPuesto());
                objetoJSON.put("Cedula", empleado.getCedula());
                objetoJSON.put("Edad", empleado.getEdad());

            } else if (ruta.equalsIgnoreCase("Facturas.txt")){
                factura= (Factura) lista.get(i);

                objetoJSON.put("ID Factura", factura.getIdFactura());
                objetoJSON.put("Nombre Empleado", factura.getNombreEmpleado());
                objetoJSON.put("Nombre Producto", factura.getNombreProducto());
                objetoJSON.put("Cantidad", factura.getCantidad());
                objetoJSON.put("Total", factura.getTotal());
            }

            jsonArray.add(objetoJSON);
            
        }

        try (FileWriter file= new FileWriter(ruta)){

            file.write(jsonArray.toJSONString());
            file.flush();

        } catch (IOException io){

            io.printStackTrace();

        }
        
    }
    //--------------------------------------------------------------------------
    
    //Metodo para cargar los datos del JSON que se seleccione 
    public ArrayList cargarJSON (String ruta){
        JSONParser parser= new JSONParser();
        
        try (FileReader reader= new FileReader(ruta)){
            
            Object objeto=parser.parse(reader);
            JSONArray jsonArray=(JSONArray) objeto;
            
            for (Object object : jsonArray) {
                
                JSONObject jsonObject=(JSONObject) object;
                
                if (ruta.equalsIgnoreCase("Bodega.txt")){
                    
                    String idProducto=(String) jsonObject.get("ID Producto");
                    String nombreProducto=(String) jsonObject.get("Nombre Producto");
                    String tipoProducto=(String) jsonObject.get("Tipo Producto");
                    String provedor=(String) jsonObject.get("Provedor");
                    int existencias=((Long)jsonObject.get("Existencias")).intValue();
                    int cantidadLimite=((Long)jsonObject.get("Cantidad Limite")).intValue();
                    double precioCompra=(Double)jsonObject.get("Precio Venta");
                    double precioVenta=(Double)jsonObject.get("Precio Compra");
                    
                    Producto bodega= new Producto(idProducto, nombreProducto, tipoProducto, provedor, existencias, cantidadLimite, precioCompra, precioVenta);
                    lista.add(bodega);
                    
                } else if (ruta.equalsIgnoreCase("Empleados.txt")){
                    
                    String usuario=(String) jsonObject.get("Usuario");
                    String clave=(String) jsonObject.get("Clave");
                    String nombreEmpleado=(String) jsonObject.get("Nombre Empleado");
                    String puesto=(String) jsonObject.get("Puesto");
                    int cedula=((Long)jsonObject.get("Cedula")).intValue();
                    int edad=((Long)jsonObject.get("Edad")).intValue();
                    
                    Empleado empleado= new Empleado(usuario, clave, nombreEmpleado, puesto, cedula, edad);
                    lista.add(empleado);
                    
                } else if (ruta.equalsIgnoreCase("Facturas.txt")){
                    
                    String idFactura=(String) jsonObject.get("ID Factura");
                    String nombreEmpleado=(String) jsonObject.get("Nombre Empleado");
                    String nombreProducto=(String) jsonObject.get("Nombre Producto");
                    int cantidad=((Long)jsonObject.get("Cantidad")).intValue();
                    double total=(Double)jsonObject.get("Total");
                    
                    Factura factura= new Factura(idFactura, nombreEmpleado, nombreProducto, cantidad, total);
                    lista.add(factura);
                    
                }
            }
            
        } catch (FileNotFoundException e) {
            System.out.println("El archivo "+ ruta +" no existe");
            return null;
        }catch (IOException | org.json.simple.parser.ParseException e){
            e.printStackTrace();   
        }
        return lista;
    }
    
}//Fin de clase
