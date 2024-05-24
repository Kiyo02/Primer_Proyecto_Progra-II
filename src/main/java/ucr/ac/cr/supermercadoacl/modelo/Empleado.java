/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.supermercadoacl.modelo;

/**
 *
 * @author Axely
 */
public class Empleado {
    //Atributos
    private String usuario, clave, nombreEmpleado, puesto;
    private int cedula, edad;
    public static final String [] TITULOS_EMPLEADOS={"Usuario", "Clave", "Nombre Empleado", "Puesto", "Cedula", "Edad"};
    //--------------------------------------------------------------------------
    
    //Metodo Constructor
    public Empleado(String usuario, String clave, String nombreEmpleado, String puesto, int cedula, int edad) {
        this.usuario = usuario;
        this.clave = clave;
        this.nombreEmpleado = nombreEmpleado;
        this.puesto= puesto;
        this.cedula = cedula;
        this.edad = edad;
    }
    
    public Empleado (String usuario, String clave){
        
        this.usuario= usuario;
        this.clave= clave;
        
    }
    
    public Empleado() {
    
    }
    //--------------------------------------------------------------------------
    
    //Metodo para la constante
    public String getDatosEmpleados (int columna){
        
        switch (columna){
            case 0:
                return this.usuario;
            
            case 1:
                return this.clave;
            
            case 2:
                return this.nombreEmpleado;
            
            case 3:
                return this.puesto;
            
            case 4:
                return String.valueOf(this.cedula);
            
            case 5:
                return String.valueOf(this.edad);
        }
        
        return ""; 
    }
    //--------------------------------------------------------------------------
    
    //Setters
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    //--------------------------------------------------------------------------
    
    //Getters
    public String getUsuario() {
        return usuario;
    }

    public String getClave() {
        return clave;
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    } 

    public String getPuesto() {
        return puesto;
    }

    public int getCedula() {
        return cedula;
    }

    public int getEdad() {
        return edad;
    }
    //--------------------------------------------------------------------------

    @Override
    public String toString() {
        return "usuario=" + usuario + ", clave=" + clave + ", nombreEmpleado=" +
        nombreEmpleado+ "puesto"+ puesto + "cedula=" + cedula + ", edad=" + edad;
    }
    //--------------------------------------------------------------------------
    
}
