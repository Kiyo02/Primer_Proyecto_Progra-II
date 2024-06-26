/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ucr.ac.cr.supermercadoacl.vista;

import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import ucr.ac.cr.supermercadoacl.modelo.Producto;


/**
 *
 * @author Axely
 */
public class FRM_Factura extends javax.swing.JFrame{
    private TableRowSorter <TableModel> sorter;
    /**
     * Creates new form FRM_Factura
     */
    public FRM_Factura() {
        initComponents();
    }
    //--------------------------------------------------------------------------
    
    public static void getMensaje (String mensaje){
        
        JOptionPane.showMessageDialog(null, mensaje);    
    }
    //--------------------------------------------------------------------------
    
    public Producto getProducto (){
        
        if (this.verificarCampos()!=true){
            return new Producto (this.jtID.getText(), this.jtNombre.getText(),
                Integer.parseInt(this.jtCantidad.getText()),
                Double.parseDouble(this.jtPrecio.getText()));
        }
        
        return null;
    }
    //--------------------------------------------------------------------------
    
    public void setProducto (Producto producto){
        
        this.jtID.setText(producto.getIdProducto());
        this.jtNombre.setText(producto.getNombreProducto());
        this.jtCantidad.setText(String.valueOf(producto.getExistencias()));
        this.jtPrecio.setText(String.valueOf(producto.getPrecioVenta()));
        this.jtTotal.setText(String.valueOf(producto.getPrecioVenta()*producto.getExistencias()));
        
    }
    //--------------------------------------------------------------------------
    
    public void activarBotones (boolean estado){
        
        this.jbRemoverProducto.setEnabled(estado);
        this.jbEditar.setEnabled(estado);
    }
    //--------------------------------------------------------------------------
    
    public void limpiarCampos (){
        
        this.jtNombre.setText("");
        this.jtCantidad.setText("");
        this.jtID.setText("");
        this.jtPrecio.setText("");
        this.jtTotal.setText("");
    }
    //--------------------------------------------------------------------------
    
    //Metodo para rellenar la tabla
    public void setDataTable(String[][] data, String []encabezado){
        
        DefaultTableModel model= new DefaultTableModel(data, encabezado);
        this.tblFactura.setModel(model);
        this.tblFactura.setAutoCreateRowSorter(true);
        this.sorter= new TableRowSorter<>(model);
        this.tblFactura.setRowSorter(sorter);
        this.jScrollPane1.setViewportView(this.tblFactura);
    }
    //--------------------------------------------------------------------------
    
    //Metodo que retorna el item seleccionado de la tabla
    public String [] getRow (){
        String [] itemSelect=new String[this.tblFactura.getColumnCount()];
        int selectRow=this.tblFactura.getSelectedRow();
        
        for (int i=0; i<itemSelect.length; i++) {
            
            itemSelect[i]=this.tblFactura.getValueAt(selectRow, i).toString();
            
        }
        
        return itemSelect;
    }
    //--------------------------------------------------------------------------
    
    //MouseListener de los botones
    public void listenMouse (MouseListener controller){
        
        this.tblFactura.addMouseListener(controller);
    }
    //--------------------------------------------------------------------------
    
    //ActionListener de los botones
    public void escuchadores (ActionListener manejador){
    
        this.jbCerrar.addActionListener(manejador);
        this.jbEditar.addActionListener(manejador);
        this.jbRemoverProducto.addActionListener(manejador);
    }
    //--------------------------------------------------------------------------
    
    //Verifica los campos para la extracción del objeto
    public boolean verificarCampos (){
        
        try {

            // Obtener los textos y valores necesarios
            if (this.jtID.getText().isEmpty() || this.jtCantidad.getText().isEmpty() ||
                this.jtPrecio.getText().isEmpty() || this.jtTotal.getText().isEmpty()){
                
                throw new NullPointerException("Hay espacios por rellenar");   
            }
            
            try {
                
                Double.parseDouble(this.jtCantidad.getText()); 
                
            } catch (NumberFormatException e) {
            
                JOptionPane.showMessageDialog(null, 
                    "Error: Digite un valor numerico en los campos correspondientes");
                return true;
            }
                
        } catch (NullPointerException e) {

            // Manejar la excepción de campos nulos
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            // Aquí podrías manejar el error de otra forma, como mostrar un mensaje al usuario
            return true;

        }
        
        return false;
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

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblFactura = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jbCerrar = new javax.swing.JButton();
        jbRemoverProducto = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jtTotal = new javax.swing.JTextField();
        jtID = new javax.swing.JTextField();
        jtCantidad = new javax.swing.JTextField();
        jtPrecio = new javax.swing.JTextField();
        jbEditar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jtNombre = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblFactura.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblFactura);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 540, 239));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Factura");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 10, -1, -1));

        jbCerrar.setText("Cerrar");
        jPanel1.add(jbCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 10, -1, -1));

        jbRemoverProducto.setText("Remover Producto");
        jbRemoverProducto.setEnabled(false);
        jPanel1.add(jbRemoverProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 330, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Total:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 410, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("ID:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Cantidad:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 370, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Precio Unidad:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 410, -1, -1));

        jtTotal.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jtTotal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtTotal.setEnabled(false);
        jPanel1.add(jtTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 410, 130, -1));

        jtID.setEditable(false);
        jtID.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jtID.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel1.add(jtID, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 370, 100, -1));

        jtCantidad.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jtCantidad.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel1.add(jtCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 370, 40, -1));

        jtPrecio.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jtPrecio.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtPrecio.setEnabled(false);
        jPanel1.add(jtPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 410, 180, -1));

        jbEditar.setText("Editar Producto");
        jbEditar.setEnabled(false);
        jPanel1.add(jbEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 370, 130, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Producto:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, -1, -1));

        jtNombre.setEditable(false);
        jtNombre.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jtNombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel1.add(jtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 330, 240, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 570, 460));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbCerrar;
    private javax.swing.JButton jbEditar;
    private javax.swing.JButton jbRemoverProducto;
    private javax.swing.JTextField jtCantidad;
    private javax.swing.JTextField jtID;
    private javax.swing.JTextField jtNombre;
    private javax.swing.JTextField jtPrecio;
    private javax.swing.JTextField jtTotal;
    private javax.swing.JTable tblFactura;
    // End of variables declaration//GEN-END:variables

    
}
