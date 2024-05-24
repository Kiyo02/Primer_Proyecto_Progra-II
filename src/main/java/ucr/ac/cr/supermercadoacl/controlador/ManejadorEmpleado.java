/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.supermercadoacl.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import ucr.ac.cr.supermercadoacl.modelo.ArregloEmpleado;
import ucr.ac.cr.supermercadoacl.modelo.Empleado;
import ucr.ac.cr.supermercadoacl.vista.FRM_Empleado;
import ucr.ac.cr.supermercadoacl.vista.FRM_Reporte;
import ucr.ac.cr.supermercadoacl.vista.PanelDatosEmpleado;

/**
 *
 * @author Axely
 */
public class ManejadorEmpleado implements ActionListener, MouseListener{
    //Atributos y Referencias
    private Empleado empleado;
    private ArregloEmpleado listaEmpleado;
    private PanelDatosEmpleado panelEmpleado;
    private FRM_Empleado frm_Empleado;
    private FRM_Reporte frm_Reporte;
    //--------------------------------------------------------------------------

    //Constructor
    public ManejadorEmpleado(ArregloEmpleado arregloEmpleado) {
        this.frm_Empleado= new FRM_Empleado();
        this.listaEmpleado=arregloEmpleado;
        this.panelEmpleado=this.frm_Empleado.getPanel();
        this.panelEmpleado.escuchador(this);
        this.frm_Empleado.setVisible(true);
    
    }
    //--------------------------------------------------------------------------
    
    //ActionEvent
    @Override
    public void actionPerformed(ActionEvent e) {
        
        switch (e.getActionCommand()){
            
            case "Registrar":
                
                this.empleado=this.panelEmpleado.getEmpleado();
                
                if (this.empleado!= null){
                    
                    FRM_Empleado.getMensaje(this.listaEmpleado.registrarEmpleado(empleado));
                    this.panelEmpleado.limpiarCampos();
                    
                }
                
            break;
            //------------------------------------------------------------------
            
            case "Editar":
                
                this.empleado=this.panelEmpleado.getEmpleado();
                
                if (this.empleado!= null){
                    
                    FRM_Empleado.getMensaje(this.listaEmpleado.modificarEmpleado(empleado));
                    this.panelEmpleado.limpiarCampos();
                    this.panelEmpleado.activarBotones(false);
                    
                } else {
                    
                    FRM_Empleado.getMensaje("Selecciona un empleado por medio de la tabla de reporte");
                    
                }
                
            break;
            //------------------------------------------------------------------
            
            case "Eliminar":
                
                this.empleado=this.panelEmpleado.getEmpleado();
                
                if (this.empleado!= null){
                    
                    FRM_Empleado.getMensaje(this.listaEmpleado.removerEmpleado(empleado));
                    this.panelEmpleado.limpiarCampos();
                    this.panelEmpleado.activarBotones(false);
                    
                } else {
                    
                    FRM_Empleado.getMensaje("Selecciona un empleado por medio de la tabla de reporte");
                    
                }
                
            break;
            //------------------------------------------------------------------
            
            case "Reporte":
                
                this.frm_Reporte= new FRM_Reporte();
                this.frm_Reporte.setDataTable(this.listaEmpleado.getMatrizCanciones(), Empleado.TITULOS_EMPLEADOS);
                this.frm_Reporte.listenMouse(this);
                this.frm_Reporte.setVisible(true);
                
            break;
            //------------------------------------------------------------------
            
            case "Cerrar":
                
                this.frm_Empleado.dispose();
                
            break;
            //------------------------------------------------------------------
        }//Fin del Switch
        //----------------------------------------------------------------------
        
    }//Fin de actionEvent
    //--------------------------------------------------------------------------

    //ListenMouse para la tabla de reporte
    @Override
    public void mouseClicked(MouseEvent e) {
        this.panelEmpleado.limpiarCampos();
        Empleado empleadoSeleccionado= new Empleado();
        empleadoSeleccionado.setUsuario(this.frm_Reporte.getRow()[0]);
        empleadoSeleccionado.setClave(this.frm_Reporte.getRow()[1]);
        empleadoSeleccionado.setNombreEmpleado(this.frm_Reporte.getRow()[2]);
        empleadoSeleccionado.setPuesto(this.frm_Reporte.getRow()[3]);
        empleadoSeleccionado.setCedula(Integer.parseInt(this.frm_Reporte.getRow()[4]));
        empleadoSeleccionado.setEdad(Integer.parseInt(this.frm_Reporte.getRow()[5]));
        this.panelEmpleado.setEmpleado(empleadoSeleccionado);
        this.panelEmpleado.activarBotones(true);
        this.frm_Reporte.dispose();
        
    }
    //--------------------------------------------------------------------------
    
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
        
    }//Fin de listenMouse
    //--------------------------------------------------------------------------
    
}//Fin de clase
