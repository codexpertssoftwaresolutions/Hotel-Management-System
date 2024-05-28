package gui.carpark;

import javaswingdev.drawer.DrawerController;
import model.TableActionCellEditor;
import model.TableActionCellRender;
import model.TableActionEvent;

public class Parking extends javax.swing.JPanel {

    private DrawerController drawer;

    public Parking(DrawerController drawer) {
        initComponents();
        setTableAction();
        this.drawer = drawer;
    }

    private void setTableAction() {
        TableActionEvent event = new TableActionEvent() {

            @Override
            public void onEdit(int row) { // row -> clicked row index
                System.out.println(row);
            }

            @Override
            public void onView(int row) {
                System.out.println(row);
            }
        };
        parkingDetailsTable.getColumnModel().getColumn(3).setCellRenderer(new TableActionCellRender());
        parkingDetailsTable.getColumnModel().getColumn(3).setCellEditor(new TableActionCellEditor(event));
        
        // parkingDetailsTable - > table variable name
        // 3 -> action button column index
        // onEdit -> when click pencil icon
        // onView -> when click eye icon
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        parkingDetailsTable = new javax.swing.JTable();

        setLayout(new java.awt.BorderLayout());

        parkingDetailsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "#"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        parkingDetailsTable.setRowHeight(40);
        jScrollPane1.setViewportView(parkingDetailsTable);

        add(jScrollPane1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable parkingDetailsTable;
    // End of variables declaration//GEN-END:variables
}
