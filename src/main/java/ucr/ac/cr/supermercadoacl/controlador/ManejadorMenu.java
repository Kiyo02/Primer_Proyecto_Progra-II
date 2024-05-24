/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.supermercadoacl.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import ucr.ac.cr.supermercadoacl.modelo.ArregloProducto;
import ucr.ac.cr.supermercadoacl.modelo.ArregloEmpleado;
import ucr.ac.cr.supermercadoacl.modelo.ArregloFactura;
import ucr.ac.cr.supermercadoacl.modelo.Empleado;
import ucr.ac.cr.supermercadoacl.vista.FRM_Menu;

/**
 *
 * @author Axely
 */
public class ManejadorMenu implements ActionListener{
    //Atributos y Referencias
    private FRM_Menu fRM_Menu;
    private ArregloEmpleado arregloEmpleado;
    private ArregloProducto arregloProductos;
    private ArregloFactura arregloFactura;
    private ManejadorEmpleado manejadorEmpleado;
    private ManejadorProductos manejadorProductos;
    private ManejadorFactura manejadorFactura;
    private Empleado empleado;
    //--------------------------------------------------------------------------
    public ManejadorMenu() {
        
        this.fRM_Menu= new FRM_Menu();
        this.arregloEmpleado= new ArregloEmpleado();
        this.arregloProductos= new ArregloProducto();
        this.arregloFactura= new ArregloFactura();
        
        this.fRM_Menu.setEscuchadores(this);
        this.fRM_Menu.setVisible(true);
    }
    //--------------------------------------------------------------------------
    
    //ActionEvent
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            
            case "IniciarSesion":
                
                this.empleado=this.fRM_Menu.inicioSesion();
                if (this.verificarLogin(empleado)!= false){
                    Empleado acceso=this.arregloEmpleado.esEmpleado(empleado);
                    
                    if (acceso.getPuesto().equalsIgnoreCase("Gerente")){
                        
                        this.fRM_Menu.loginGerente(true);
                        
                    } else if (acceso.getPuesto().equalsIgnoreCase("SubGerente")){
                        
                        this.fRM_Menu.loginSubGerente(true);
                        
                    } else if (acceso.getPuesto().equalsIgnoreCase("Cajero")){
                        
                        this.fRM_Menu.loginCajero(true);
                        
                    }
                    FRM_Menu.getMensaje("Sesion Iniciada");
                }
                
            break;
            //------------------------------------------------------------------
            
            case "CerrarSesion":
                
                this.fRM_Menu.cerrarSesion(true);
                FRM_Menu.getMensaje("Sesion Cerrada");
                
            break;
            //------------------------------------------------------------------
            
            case "Empleados":
                
                this.manejadorEmpleado= new ManejadorEmpleado(this.arregloEmpleado);
                
            break;
            //------------------------------------------------------------------
            
            case "Bodega":
                
                this.manejadorProductos= new ManejadorProductos(this.arregloProductos);
                
            break;
            //------------------------------------------------------------------
            
            case "Caja":
                this.empleado=this.arregloEmpleado.esEmpleado(empleado);
                
                this.manejadorFactura= new ManejadorFactura(this.arregloFactura,
                    this.arregloProductos, this.empleado);
                
            break;
            //------------------------------------------------------------------
            
            case "Creditos":
                
                JOptionPane.showMessageDialog(null,
                "----------------Proyecto Elaborado Por:----------------------"
                + "\nAxel Obando Bermudez, Carnet C25595"
                + "\nCaled Bustos Torres, Carnet C31382"
                + "\nLaura Morales Hermann, Carnet C25271"
                +"\n------------------------------------------------------------"
                + "-----------");
                
            break;
            //------------------------------------------------------------------
            
            case "Salir":
                
                System.exit(0);
                
            break;
            //------------------------------------------------------------------ 
            
        }//Fin Switch
        //----------------------------------------------------------------------
        
    }//Fin ActionEvent
    //--------------------------------------------------------------------------
    
    //Verifica que no haya ningun espacio en blanco y que el usurio este registrado
    private boolean verificarLogin (Empleado empleado){
        
        if (empleado.getUsuario().isEmpty()){
            
            FRM_Menu.getMensaje("Digite el usuario");
            return false;
            
        } else if(empleado.getClave().isEmpty()){
            
            FRM_Menu.getMensaje("Digite la clave");
            return false;
            
        }
        
        
        if (this.arregloEmpleado.esEmpleado(empleado)==null){
            
            FRM_Menu.getMensaje("Usuario o clave incorrecta");
            return false;
            
        }
        
        return true;
    }//Fin verificar
    //--------------------------------------------------------------------------
    
}//Fin de clase