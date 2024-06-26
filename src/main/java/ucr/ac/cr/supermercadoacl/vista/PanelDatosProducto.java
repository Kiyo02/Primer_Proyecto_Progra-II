/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ucr.ac.cr.supermercadoacl.vista;

import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import ucr.ac.cr.supermercadoacl.modelo.Producto;

/**
 *
 * @author Axely
 */
public class PanelDatosProducto extends javax.swing.JPanel {
    
    
    public PanelDatosProducto() {
        initComponents();
    }
    //--------------------------------------------------------------------------
    
    //Metodo para extraer el crear el objeto extrayendo los datos del panel
    public Producto getProducto (){
        
        if (this.verificarCampos()!=true){
            return new Producto(this.jtIdProduc.getText(), this.jtNProduc.getText(),
                this.jcTipoProduc.getSelectedItem().toString(), this.jtProvedor.getText(),
                Integer.parseInt(this.jtExistencias.getText()),
                Integer.parseInt(this.jtCantLimite.getText()),
                Double.parseDouble(this.jtPrecioComp.getText()),
                Double.parseDouble(this.jtPrecioVent.getText()));
        }
        
        return null;
    }
    //--------------------------------------------------------------------------
    
    //Metodo para mostrar el objeto seleccionado
    public void setProducto (Producto producto){
        
        this.jtIdProduc.setText(producto.getIdProducto());
        this.jtNProduc.setText(producto.getNombreProducto());
        this.jcTipoProduc.setSelectedItem(producto.getTipoProducto());
        this.jtProvedor.setText(producto.getProvedor());
        this.jtExistencias.setText(""+producto.getExistencias());
        this.jtCantLimite.setText(""+producto.getCantidadLimite());
        this.jtPrecioComp.setText(""+producto.getPrecioCompra());
        this.jtPrecioVent.setText(""+producto.getPrecioVenta());
        
    }
    //--------------------------------------------------------------------------
    
    //Metodo para limpiar campos
    public void limpiarCampos (){
        
        this.jtIdProduc.setText("");
        this.jtNProduc.setText("");
        this.jcTipoProduc.setSelectedIndex(0);
        this.jtProvedor.setText("");
        this.jtExistencias.setText("");
        this.jtCantLimite.setText("");
        this.jtPrecioComp.setText("");
        this.jtPrecioVent.setText("");
        
    }
    //--------------------------------------------------------------------------
    
    //Metodo para solicitar la cantidad para el nuevo stock
    public int nuevoStock (){
        int cantidad;
        
        try{
            cantidad=Integer.parseInt(JOptionPane.showInputDialog(
                "Digite la cantidad del nuevo stock"));
            
        } catch (NumberFormatException e){
            
            JOptionPane.showMessageDialog(null, 
            "Error: Digite un valor numerico en los campos correspondientes");
            return 0;
            
        }
        
        return cantidad;
    }
    //--------------------------------------------------------------------------

    
    public void activarBotones (boolean estado){
        
        this.jbAExistencias.setEnabled(estado);
        this.jbEditar.setEnabled(estado);
        this.jbRemover.setEnabled(estado);
        
    }
    //--------------------------------------------------------------------------
    
    public void cargarComboBox (String[] listaTipos){
        
        this.jcTipoProduc.setModel(new DefaultComboBoxModel<>(listaTipos));  
        
    }
    //--------------------------------------------------------------------------
    
    //ActionListener de los botones
    public void escuchador(ActionListener manejador){
        
        this.jbAExistencias.addActionListener(manejador);       
        this.jbCerrar.addActionListener(manejador);       
        this.jbEditar.addActionListener(manejador);       
        this.jbRegistrar.addActionListener(manejador);       
        this.jbRemover.addActionListener(manejador);       
        this.jbReporte.addActionListener(manejador); 
        
    }
    //--------------------------------------------------------------------------
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jbRegistrar = new javax.swing.JButton();
        jbEditar = new javax.swing.JButton();
        jbCerrar = new javax.swing.JButton();
        jbRemover = new javax.swing.JButton();
        jbReporte = new javax.swing.JButton();
        jbAExistencias = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jtProvedor = new javax.swing.JTextField();
        jtIdProduc = new javax.swing.JTextField();
        jcTipoProduc = new javax.swing.JComboBox<>();
        jtPrecioVent = new javax.swing.JTextField();
        jtNProduc = new javax.swing.JTextField();
        jtExistencias = new javax.swing.JTextField();
        jtCantLimite = new javax.swing.JTextField();
        jtPrecioComp = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel2.setText("Bodega");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 10, -1, -1));

        jbRegistrar.setFont(new java.awt.Font("Segoe UI", 3, 13)); // NOI18N
        jbRegistrar.setForeground(new java.awt.Color(51, 51, 51));
        jbRegistrar.setText("Registrar");
        jbRegistrar.setActionCommand("Registrar");
        add(jbRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, 100, -1));

        jbEditar.setFont(new java.awt.Font("Segoe UI", 3, 13)); // NOI18N
        jbEditar.setForeground(new java.awt.Color(51, 51, 51));
        jbEditar.setText("Editar");
        jbEditar.setActionCommand("Editar");
        jbEditar.setEnabled(false);
        add(jbEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 310, 100, -1));

        jbCerrar.setFont(new java.awt.Font("Segoe UI", 3, 13)); // NOI18N
        jbCerrar.setForeground(new java.awt.Color(51, 51, 51));
        jbCerrar.setText("Cerrar");
        add(jbCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 10, -1, -1));

        jbRemover.setFont(new java.awt.Font("Segoe UI", 3, 13)); // NOI18N
        jbRemover.setForeground(new java.awt.Color(51, 51, 51));
        jbRemover.setText("Remover");
        jbRemover.setActionCommand("Remover");
        jbRemover.setEnabled(false);
        add(jbRemover, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 310, 100, -1));

        jbReporte.setFont(new java.awt.Font("Segoe UI", 3, 13)); // NOI18N
        jbReporte.setForeground(new java.awt.Color(51, 51, 51));
        jbReporte.setText("Productos");
        add(jbReporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 310, 100, -1));

        jbAExistencias.setFont(new java.awt.Font("Segoe UI", 3, 13)); // NOI18N
        jbAExistencias.setForeground(new java.awt.Color(51, 51, 51));
        jbAExistencias.setText("Agregar Exist.");
        jbAExistencias.setActionCommand("Agregar");
        jbAExistencias.setEnabled(false);
        add(jbAExistencias, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 310, -1, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 16)); // NOI18N
        jLabel1.setText("Precio Venta:");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 250, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 3, 16)); // NOI18N
        jLabel3.setText("ID Producto:");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 3, 16)); // NOI18N
        jLabel4.setText("Nombre Producto:");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 3, 16)); // NOI18N
        jLabel5.setText("Tipo Producto:");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 3, 16)); // NOI18N
        jLabel6.setText("Provedor:");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 70, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 3, 16)); // NOI18N
        jLabel7.setText("Existencias:");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 130, -1, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 3, 16)); // NOI18N
        jLabel8.setText("Cantidad Limite:");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 190, -1, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 3, 16)); // NOI18N
        jLabel9.setText("Precio Compra:");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, -1, -1));

        jtProvedor.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jtProvedor.setForeground(new java.awt.Color(51, 51, 51));
        jtProvedor.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        add(jtProvedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 70, 180, -1));

        jtIdProduc.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jtIdProduc.setForeground(new java.awt.Color(51, 51, 51));
        jtIdProduc.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        add(jtIdProduc, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, 200, -1));

        jcTipoProduc.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jcTipoProduc.setForeground(new java.awt.Color(51, 51, 51));
        jcTipoProduc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Granos", "Abarrotes", "Bebidas", "Lacteos", "Congelados", "Snacks", "Higiene", "Frutas y Verduras", "Reposteria", "Limpieza", "Otro" }));
        jcTipoProduc.setActionCommand("jcTipo");
        add(jcTipoProduc, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 190, 190, -1));

        jtPrecioVent.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jtPrecioVent.setForeground(new java.awt.Color(51, 51, 51));
        jtPrecioVent.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        add(jtPrecioVent, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 250, 150, -1));

        jtNProduc.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jtNProduc.setForeground(new java.awt.Color(51, 51, 51));
        jtNProduc.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        add(jtNProduc, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 130, 160, -1));

        jtExistencias.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jtExistencias.setForeground(new java.awt.Color(51, 51, 51));
        jtExistencias.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        add(jtExistencias, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 130, 160, -1));

        jtCantLimite.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jtCantLimite.setForeground(new java.awt.Color(51, 51, 51));
        jtCantLimite.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        add(jtCantLimite, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 190, 130, -1));

        jtPrecioComp.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jtPrecioComp.setForeground(new java.awt.Color(51, 51, 51));
        jtPrecioComp.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        add(jtPrecioComp, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 250, 180, -1));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/supermarket0.1.png"))); // NOI18N
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 350));
    }// </editor-fold>//GEN-END:initComponents
    //Verifica los campos para la extracción del objeto
    public boolean verificarCampos (){
        
        try {

            // Obtener los textos y valores necesarios
            if (this.jtCantLimite.getText().isEmpty() || this.jtExistencias.getText().isEmpty() ||
                this.jtIdProduc.getText().isEmpty() || this.jtNProduc.getText().isEmpty() ||
                this.jtPrecioComp.getText().isEmpty() || this.jtPrecioVent.getText().isEmpty() ||
                this.jtProvedor.getText().isEmpty()){
                
                throw new NullPointerException("Hay espacios por rellenar");
                
            }
            
            //Try-Catch para verificar si hay caracteres no validos
            try {
                
                Integer.parseInt(this.jtExistencias.getText()); 
                Integer.parseInt(this.jtCantLimite.getText());
                Double.parseDouble(this.jtPrecioVent.getText()); 
                Double.parseDouble(this.jtPrecioComp.getText());
                
                
                
            } catch (NumberFormatException e) {
            
                JOptionPane.showMessageDialog(null, 
                    "Error: Digite un valor numerico en los campos correspondientes");
                return true;
            }
                
        } catch (NullPointerException e) {
            
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            
            return true;
        }
        
        return false;
    }
    //--------------------------------------------------------------------------
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JButton jbAExistencias;
    private javax.swing.JButton jbCerrar;
    private javax.swing.JButton jbEditar;
    private javax.swing.JButton jbRegistrar;
    private javax.swing.JButton jbRemover;
    private javax.swing.JButton jbReporte;
    private javax.swing.JComboBox<String> jcTipoProduc;
    private javax.swing.JTextField jtCantLimite;
    private javax.swing.JTextField jtExistencias;
    private javax.swing.JTextField jtIdProduc;
    private javax.swing.JTextField jtNProduc;
    private javax.swing.JTextField jtPrecioComp;
    private javax.swing.JTextField jtPrecioVent;
    private javax.swing.JTextField jtProvedor;
    // End of variables declaration//GEN-END:variables
}
