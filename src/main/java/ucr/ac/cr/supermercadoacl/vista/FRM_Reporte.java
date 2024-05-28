/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ucr.ac.cr.supermercadoacl.vista;

import java.awt.event.MouseListener;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Axely
 */
public class FRM_Reporte extends javax.swing.JFrame {
    private TableRowSorter <TableModel> sorter;
    /**
     * Creates new form FRM_Reporte
     */
    public FRM_Reporte() {
        initComponents();
    }
    //--------------------------------------------------------------------------
    
    //Metodo para rellenar la tabla
    public void setDataTable(String[][] data, String []encabezado){
        
        DefaultTableModel model= new DefaultTableModel(data, encabezado);
        this.tblReporte.setModel(model);
        this.tblReporte.setAutoCreateRowSorter(true);
        this.sorter= new TableRowSorter<>(model);
        this.tblReporte.setRowSorter(sorter);
        this.jScrollPane1.setViewportView(this.tblReporte);
        
    }
    //--------------------------------------------------------------------------
    
    //Metodo que retorna el item seleccionado de la tabla
    public String [] getRow (){
        String [] itemSelect=new String[this.tblReporte.getColumnCount()];
        int selectRow=this.tblReporte.getSelectedRow();
        
        for (int i=0; i<itemSelect.length; i++) {
            
            itemSelect[i]=this.tblReporte.getValueAt(selectRow, i).toString();
            
        }
        
        return itemSelect;
    }
    
    //MouseListener de los botones
    public void listenMouse (MouseListener controller){
        
        this.tblReporte.addMouseListener(controller);
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jtFiltro = new javax.swing.JTextField();
        jbCerrar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblReporte = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Tabla de Reporte");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 3, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Buscar:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, -1, -1));

        jtFiltro.setBackground(new java.awt.Color(204, 204, 204));
        jtFiltro.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jtFiltro.setForeground(new java.awt.Color(51, 51, 51));
        jtFiltro.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtFiltro.setPreferredSize(new java.awt.Dimension(71, 26));
        jtFiltro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtFiltroKeyReleased(evt);
            }
        });
        jPanel1.add(jtFiltro, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 350, 330, -1));

        jbCerrar.setBackground(new java.awt.Color(204, 204, 204));
        jbCerrar.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jbCerrar.setForeground(new java.awt.Color(51, 51, 51));
        jbCerrar.setText("Cerrar");
        jbCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCerrarActionPerformed(evt);
            }
        });
        jPanel1.add(jbCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 350, 90, -1));

        tblReporte.setBackground(new java.awt.Color(204, 204, 204));
        tblReporte.setModel(new javax.swing.table.DefaultTableModel(
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
        tblReporte.setGridColor(new java.awt.Color(153, 153, 153));
        tblReporte.setSelectionBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(tblReporte);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 520, 280));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 540, 390));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCerrarActionPerformed
        this.dispose();
    }//GEN-LAST:event_jbCerrarActionPerformed

    private void jtFiltroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtFiltroKeyReleased
        this.sorter.setRowFilter(RowFilter.regexFilter("(?i)"+this.jtFiltro.getText()));
    }//GEN-LAST:event_jtFiltroKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbCerrar;
    private javax.swing.JTextField jtFiltro;
    private javax.swing.JTable tblReporte;
    // End of variables declaration//GEN-END:variables
}
