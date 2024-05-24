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
public class ArregloEmpleado {
    //Referencias y Atributos
    private static final String filePath="Empleados.txt";
    private JSON complementoJSON;
    private ArrayList <Empleado> listaEmpleados;
    //La llave no se añade al Array, ya que es el llave xd
    private static final Empleado llave= new Empleado("admin", "nose", "Rodolfo", "Gerente", 2024, 111);
    //--------------------------------------------------------------------------
    
    //Metodo Constructor
    public ArregloEmpleado() {
        this.complementoJSON= new JSON();
        this.listaEmpleados= this.complementoJSON.cargarJSON(filePath);
        
        if (listaEmpleados==null){
            
            this.listaEmpleados= new ArrayList<Empleado>();
            
        }
        
    }
    //--------------------------------------------------------------------------
    
    //Metodo para registrar un empleado
    public String registrarEmpleado (Empleado nuevoEmpleado){
        
        Empleado empleadoBuscado= this.buscarEmpleado(nuevoEmpleado.getCedula());

        if (empleadoBuscado==null){

            this.listaEmpleados.add(nuevoEmpleado);
            this.complementoJSON.archivoJSON(nuevoEmpleado, filePath);
            return "Empleado Registrado";

        } else {

            //Este controlador especifica si hay un dato en particular ya registrado
            String mensaje=this.datosRegistrado(nuevoEmpleado);
            return mensaje + " ya ha sido registrado";
        }

    }
    //--------------------------------------------------------------------------
    
    //Metodo para remover empleado de la Array y del archivo JSON
    public String removerEmpleado (Empleado empleado){
        Empleado empleadoBuscado= this.buscarEmpleado(empleado.getCedula());
            
        if (empleadoBuscado!= null){

            this.listaEmpleados.remove(empleadoBuscado);
            this.complementoJSON.sobrescribirJSON(listaEmpleados, filePath);
            return "El Empleado ha sido removido";
        }
        
        return "Empleado no registrado";
    }
    //--------------------------------------------------------------------------
    
    //Metodo para editar los datos de un empleado
    public String modificarEmpleado (Empleado empleado){
        Empleado empleadoBuscado= this.buscarEmpleado(empleado.getCedula());
        
            if (empleadoBuscado!= null){
                
                this.listaEmpleados.remove(empleadoBuscado);
                this.listaEmpleados.add(empleado);
                this.complementoJSON.sobrescribirJSON(listaEmpleados, filePath);
                return "Los datos del empleado han sido modificados";
                
            }
        
        return "Empleado no registrado";
    }
    //--------------------------------------------------------------------------
    
    //Metodo para asignar datos a la tabla de reporte
    public String[][] getMatrizCanciones (){
        String[][] matrizEmpleados= new String[this.listaEmpleados.size()][Empleado.TITULOS_EMPLEADOS.length];
        
        for (int f=0; f<matrizEmpleados.length; f++){
            for (int c=0; c<matrizEmpleados[0].length; c++){
                
                matrizEmpleados[f][c]=this.listaEmpleados.get(f).getDatosEmpleados(c);
                
            }
        }
        
        return matrizEmpleados;
    }
    //--------------------------------------------------------------------------
    
    //************************************************************************//
    //--------------------Metodos Complementarios-----------------------------//
    //************************************************************************//
    //Metodo para verificar el puesto del empleado
    public Empleado esEmpleado (Empleado empleado){
        
        //Se verifica primero si es el admin por aparte porque este no va a estar en lista
        //Luego se verifica si es el admin, ya que solo hay un administrador
        if (llave.getUsuario().equalsIgnoreCase(empleado.getUsuario()) && 
            llave.getClave().equalsIgnoreCase(empleado.getClave())){

            return llave;
        }
        
        //Luego se verifica si es un empleado, ya que estos si suelen estar en lista
        for (int i=0; i<listaEmpleados.size(); i++){

            //Primero verifica si está registrado por medio de usuario y clave
            //Ya que no se pueden repetir dichos atributos entre objectos
            if (listaEmpleados.get(i).getUsuario().equalsIgnoreCase(empleado.getUsuario()) && 
                listaEmpleados.get(i).getClave().equalsIgnoreCase(empleado.getClave())){
                
                return listaEmpleados.get(i);
                
            }
        }
        return null;
    }
    //--------------------------------------------------------------------------
    
    //Metodo para verificar si algun dato está registrado, ya que para este objeto
    //No solo la cedula, sino que tambien el usuario debe ser unico
    public String datosRegistrado (Empleado empleado){
        
        if (empleado!=null){
            for (int i=0; i<listaEmpleados.size(); i++){
                if (listaEmpleados.get(i).getCedula()==empleado.getCedula()){ 
                    
                    return "Cedula";
                    
                } else if (listaEmpleados.get(i).getUsuario().equalsIgnoreCase(empleado.getUsuario())){
                    
                    return "Usuario";
                }
            }
        }
        
        return null;
    }
    
    //Metodo que devuelve un empleado registrado con la cedula que se desea buscar
    public Empleado buscarEmpleado(int cedula) {
        
        for (Empleado miEmpleado : listaEmpleados) {
            
            if (miEmpleado.getCedula()==(cedula)) {
                
                return miEmpleado;
                
            }
        }
        return null;
    }
    //--------------------------------------------------------------------------
}
