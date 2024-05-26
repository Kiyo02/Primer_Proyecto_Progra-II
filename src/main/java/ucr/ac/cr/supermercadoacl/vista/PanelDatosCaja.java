/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ucr.ac.cr.supermercadoacl.vista;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import ucr.ac.cr.supermercadoacl.modelo.Empleado;
import ucr.ac.cr.supermercadoacl.modelo.Factura;
import ucr.ac.cr.supermercadoacl.modelo.Producto;

/**
 *
 * @author Axely
 */
public class PanelDatosCaja extends javax.swing.JPanel {
    private double total;
    private String listaProductos="Producto ";
    private Producto productoFact;
    private ArrayList <Producto> listaProd= new ArrayList<>();
    //--------------------------------------------------------------------------
    
    /**
     * Creates new form PanelDatosFactura
     */
    public PanelDatosCaja() {
        initComponents();
    }
    //--------------------------------------------------------------------------
    
    public void setTurnoEmpleado (Empleado turnoEmpleado){
        
        this.jtEmpleado.setText(turnoEmpleado.getNombreEmpleado());
        
        if(turnoEmpleado.getPuesto().equalsIgnoreCase("Gerente")){
            
            this.jbFacturas.setEnabled(true);
            
        }
        
    }
    //--------------------------------------------------------------------------
    
    public Factura getFactura (int idFactura){
        this.jtTotal.setText("0");
        
        this.listaProductos=this.rellenarLista();
        
        if (this.verificarLista()!=true){
            return new Factura (idFactura, jtEmpleado.getText(), 
                this.listaProductos, this.total);
        }
        
        return null;
    }
    //--------------------------------------------------------------------------

    //Metodo para extraer la cantidad
    public int getCantidad (){
        
        return Integer.parseInt(this.jtCantidad.getText());
    }
    //--------------------------------------------------------------------------
    
    //
    public void setProduto (Producto producto){
        
        
       this.jtProducto.setText(producto.getNombreProducto());
       this.jbAgregarProd.setEnabled(true);
       
        
    }
    //--------------------------------------------------------------------------
    public void setTotal(Producto producto){
        
        this.total+=(producto.getPrecioVenta()*Integer.parseInt(jtCantidad.getText()));
        this.jtTotal.setText(String.valueOf(total));
        
        //Se modifica la cantidad usando las existencias ya que es un producto temporal
        this.listaProd.add(new Producto(producto.getIdProducto(), this.jtProducto.getText(),
            Integer.parseInt(this.jtCantidad.getText()),
                producto.getPrecioVenta()));

        
        this.jbGenerarFact.setEnabled(true);
        this.jbLimpiar.setEnabled(true);
        this.jbEditar.setEnabled(true);
        this.jbAgregarProd.setEnabled(false);
        this.limpiarCampos();
        
    }
    //--------------------------------------------------------------------------

    public void limpiarFactura (){
        
        this.total= 0;
        this.listaProductos="Producto";
        this.listaProd.clear();
        this.jtTotal.setText("");
        
        this.limpiarCampos();
        
    }
    
    public void limpiarCampos (){
        
        this.jtCantidad.setText("");
        this.jtProducto.setText("");
        
    }
    
    public void activarBotones (boolean estado){
        
        this.jbAgregarProd.setEnabled(estado);
        this.jbLimpiar.setEnabled(estado);
        
    }
    //--------------------------------------------------------------------------
    
    public ArrayList<Producto> getFacturaTemp (){
        
        return listaProd;
    }
    
    public void setFacturaTemp (ArrayList listaProductos){
        
        this.listaProd= listaProductos;
        
    }
    
    public String rellenarLista (){
        String lista= "Producto ";
        if (this.listaProd!= null){
            
            for (Producto producto : listaProd) {
                
                lista+=producto.getNombreProducto()+
                    ", Cantidad "+producto.getExistencias()+
                    ", Total "+ producto.getPrecioVenta()*producto.getExistencias();
                
            }
            
            return lista;
        }
        
        return "";
    }
    //--------------------------------------------------------------------------
    
    //ActionListener de los botones
    public void escuchador (ActionListener manejador){
        
        this.jbAgregarProd.addActionListener(manejador);
        this.jbCerrar.addActionListener(manejador);
        this.jbFacturas.addActionListener(manejador);
        this.jbGenerarFact.addActionListener(manejador);
        this.jbProductos.addActionListener(manejador);
        this.jbLimpiar.addActionListener(manejador);
        this.jbEditar.addActionListener(manejador);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jbGenerarFact = new javax.swing.JButton();
        jbAgregarProd = new javax.swing.JButton();
        jbProductos = new javax.swing.JButton();
        jbFacturas = new javax.swing.JButton();
        jbCerrar = new javax.swing.JButton();
        jtTotal = new javax.swing.JTextField();
        jtCantidad = new javax.swing.JTextField();
        jtProducto = new javax.swing.JTextField();
        jtEmpleado = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jbLimpiar = new javax.swing.JButton();
        jbEditar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel2.setText("Caja Registradora");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 3, 16)); // NOI18N
        jLabel3.setText("Total:");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 3, 16)); // NOI18N
        jLabel4.setText("Empleado:");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 3, 16)); // NOI18N
        jLabel5.setText("Producto:");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 3, 16)); // NOI18N
        jLabel6.setText("Cantidad:");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, -1, -1));

        jbGenerarFact.setText("Generar Factura");
        jbGenerarFact.setEnabled(false);
        add(jbGenerarFact, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 210, 130, -1));

        jbAgregarProd.setText("Agregar Producto");
        jbAgregarProd.setEnabled(false);
        add(jbAgregarProd, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 160, 130, -1));

        jbProductos.setText("Productos");
        jbProductos.setMaximumSize(new java.awt.Dimension(124, 23));
        jbProductos.setMinimumSize(new java.awt.Dimension(124, 23));
        jbProductos.setPreferredSize(new java.awt.Dimension(124, 23));
        add(jbProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 110, 130, -1));

        jbFacturas.setText("Facturas");
        add(jbFacturas, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 260, 90, -1));

        jbCerrar.setText("Cerrar");
        add(jbCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 80, -1));

        jtTotal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtTotal.setText("0");
        jtTotal.setEnabled(false);
        add(jtTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 210, 270, -1));

        jtCantidad.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        add(jtCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 160, 270, -1));

        jtProducto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtProducto.setEnabled(false);
        add(jtProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, 270, -1));

        jtEmpleado.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtEmpleado.setEnabled(false);
        add(jtEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 60, 270, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("Nota: Una vez agregado un producto en la factura  ya no se puede remover de la lista de productos.");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, -1, -1));

        jbLimpiar.setText("Limpiar Factura");
        jbLimpiar.setEnabled(false);
        add(jbLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 260, 130, -1));

        jbEditar.setText("Editar Factura");
        jbEditar.setEnabled(false);
        add(jbEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 60, 130, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cajero1.png"))); // NOI18N
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 530, 290));
    }// </editor-fold>//GEN-END:initComponents
    public boolean verificarLista (){
        
        try {

            if (this.listaProductos.isEmpty() || this.jtEmpleado.getText().isEmpty() ||
                this.total==0){
                
                throw new NullPointerException("No hay productos registrados een la factura");
                
            }
                
        } catch (NullPointerException e) {

            // Manejar la excepción de campos nulos
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            return true;

        }
        
        return false;
    }
    
    public String verificarProducto(Producto producto) {
        
        try {
            if (Integer.parseInt(this.jtCantidad.getText()) >= 0) {
                if (producto.getExistencias() >= Integer.parseInt(this.jtCantidad.getText())) {
                    return "Autorizado";
                } else {
                    return "La cantidad deseada supera las existencias del producto";
                }
            } else {
                return "La cantidad debe ser un número positivo";
            }
        } catch (NumberFormatException e) {
            return "Digite una numeración correcta";
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JButton jbAgregarProd;
    private javax.swing.JButton jbCerrar;
    private javax.swing.JButton jbEditar;
    private javax.swing.JButton jbFacturas;
    private javax.swing.JButton jbGenerarFact;
    private javax.swing.JButton jbLimpiar;
    private javax.swing.JButton jbProductos;
    private javax.swing.JTextField jtCantidad;
    private javax.swing.JTextField jtEmpleado;
    private javax.swing.JTextField jtProducto;
    private javax.swing.JTextField jtTotal;
    // End of variables declaration//GEN-END:variables
}
