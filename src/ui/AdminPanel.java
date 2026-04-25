package ui;

import controllers.AssignCourierController;
import controllers.ManageInventoryController;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Medicine;

public class AdminPanel extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(AdminPanel.class.getName());

    public AdminPanel() {
        initComponents();
        name_rb.setSelected(true);
        loadAllMedicines();
        loadOrders();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        search_type = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        ManageInvtory = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        search_input = new javax.swing.JTextField();
        search_text = new javax.swing.JLabel();
        add_btn = new javax.swing.JButton();
        search_btn = new javax.swing.JButton();
        edit_btn = new javax.swing.JButton();
        name_rb = new javax.swing.JRadioButton();
        id_rb = new javax.swing.JRadioButton();
        AssignCurier = new javax.swing.JPanel();
        titleLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        ordersTable = new javax.swing.JTable();
        couriersScrollPane = new javax.swing.JScrollPane();
        couriersTable = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Name", "Price", "Stock"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        search_input.addActionListener(this::search_inputActionPerformed);

        search_text.setText("Search:");

        add_btn.setText("Add");
        add_btn.addActionListener(this::add_btnActionPerformed);

        search_btn.setText("Search");
        search_btn.addActionListener(this::search_btnActionPerformed);

        edit_btn.setText("Edit");
        edit_btn.addActionListener(this::edit_btnActionPerformed);

        search_type.add(name_rb);
        name_rb.setText("Name");

        search_type.add(id_rb);
        id_rb.setText("ID");

        javax.swing.GroupLayout ManageInvtoryLayout = new javax.swing.GroupLayout(ManageInvtory);
        ManageInvtory.setLayout(ManageInvtoryLayout);
        ManageInvtoryLayout.setHorizontalGroup(
            ManageInvtoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ManageInvtoryLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(ManageInvtoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ManageInvtoryLayout.createSequentialGroup()
                        .addGroup(ManageInvtoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(search_input, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(add_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(ManageInvtoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(search_btn, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                            .addComponent(edit_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(ManageInvtoryLayout.createSequentialGroup()
                        .addGroup(ManageInvtoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ManageInvtoryLayout.createSequentialGroup()
                                .addComponent(search_text)
                                .addGap(18, 18, 18)
                                .addComponent(name_rb)
                                .addGap(16, 16, 16)
                                .addComponent(id_rb))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 569, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 1, Short.MAX_VALUE)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        ManageInvtoryLayout.setVerticalGroup(
            ManageInvtoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ManageInvtoryLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 509, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ManageInvtoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(search_text)
                    .addComponent(name_rb)
                    .addComponent(id_rb))
                .addGap(8, 8, 8)
                .addGroup(ManageInvtoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(search_input, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(search_btn))
                .addGap(18, 18, 18)
                .addGroup(ManageInvtoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(add_btn)
                    .addComponent(edit_btn))
                .addContainerGap(131, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Manage Inventory", ManageInvtory);

        titleLabel.setFont(new java.awt.Font("IBM Plex Mono", 1, 16)); // NOI18N
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLabel.setText("Assign Courier");

        jLabel1.setText("Couriers");

        jLabel2.setText("Orders");

        jButton1.setText("X");
        jButton1.addActionListener(this::jButton1ActionPerformed);

        ordersTable.setBackground(new java.awt.Color(30, 30, 30));
        ordersTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Order ID", "Customer ID", "Date", "Status", "Priority"
            }
        ));
        jScrollPane1.setViewportView(ordersTable);

        couriersTable.setBackground(new java.awt.Color(30, 30, 30));
        couriersTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Courier ID", "Name", "Phone"
            }
        ));
        couriersScrollPane.setViewportView(couriersTable);

        jButton2.setText("Assign");
        jButton2.addActionListener(this::jButton2ActionPerformed);

        javax.swing.GroupLayout AssignCurierLayout = new javax.swing.GroupLayout(AssignCurier);
        AssignCurier.setLayout(AssignCurierLayout);
        AssignCurierLayout.setHorizontalGroup(
            AssignCurierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AssignCurierLayout.createSequentialGroup()
                .addContainerGap(52, Short.MAX_VALUE)
                .addGroup(AssignCurierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(AssignCurierLayout.createSequentialGroup()
                        .addGap(141, 141, 141)
                        .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(AssignCurierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(couriersScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(86, Short.MAX_VALUE))
            .addGroup(AssignCurierLayout.createSequentialGroup()
                .addGap(242, 242, 242)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        AssignCurierLayout.setVerticalGroup(
            AssignCurierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AssignCurierLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(AssignCurierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titleLabel)
                    .addComponent(jButton1))
                .addGap(8, 8, 8)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(couriersScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addContainerGap(67, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Assign Courier", AssignCurier);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (selectedOrderId == null || selectedCourierId == null) {
            JOptionPane.showMessageDialog(this, "Select order and courier first");
            return;
        }

        try {
            assignCtrl.assignCourier(selectedOrderId, selectedCourierId);

            JOptionPane.showMessageDialog(this, "Assigned successfully");

            loadOrders();
            couriersTable.setModel(new javax.swing.table.DefaultTableModel());

            selectedOrderId = null;
            selectedCourierId = null;

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void assignButtonActionPerformed(java.awt.event.ActionEvent evt) {
        if (selectedOrderId == null || selectedCourierId == null) {
            JOptionPane.showMessageDialog(this, "Select an order and a courier first");
            return;
        }
        try {
            assignCtrl.assignCourier(selectedOrderId, selectedCourierId);
            JOptionPane.showMessageDialog(this, "Assigned successfully");
            loadOrders();
            selectedOrderId = null;
            selectedCourierId = null;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Assignment failed: " + ex.getMessage());
        }
    }

    private void search_btnActionPerformed(java.awt.event.ActionEvent evt) {
        String q = search_input.getText().trim();
        ManageInventoryController ctrl = new ManageInventoryController();
        List<Medicine> results;
        if (id_rb.isSelected()) {
            try {
                results = ctrl.searchById(Integer.parseInt(q));
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Invalid ID");
                return;
            }
        } else {
            results = ctrl.searchByName(q);
        }
        populateMedicineTable(results);
    }

    private void add_btnActionPerformed(java.awt.event.ActionEvent evt) {
        MedicineDialog d = new MedicineDialog(this, "Add Medicine", null, "", 0.0, 0);
        d.setVisible(true);
        if (d.isSaved()) loadAllMedicines();
    }

    private void edit_btnActionPerformed(java.awt.event.ActionEvent evt) {
        int row = jTable1.getSelectedRow();
        if (row < 0) { JOptionPane.showMessageDialog(this, "Select a medicine first"); return; }
        int id = (int) jTable1.getValueAt(row, 0);
        MedicineDialog d = new MedicineDialog(this, "Edit Medicine", id,
            (String) jTable1.getValueAt(row, 1),
            (double) jTable1.getValueAt(row, 2),
            (int) jTable1.getValueAt(row, 3));
        d.setVisible(true);
        if (d.isSaved()) loadAllMedicines();
    }

    private void search_inputActionPerformed(java.awt.event.ActionEvent evt) {
        search_btnActionPerformed(evt);
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(() -> new AdminPanel().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AssignCurier;
    private javax.swing.JPanel ManageInvtory;
    private javax.swing.JButton add_btn;
    private javax.swing.JScrollPane couriersScrollPane;
    private javax.swing.JTable couriersTable;
    private javax.swing.JButton edit_btn;
    private javax.swing.JRadioButton id_rb;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JRadioButton name_rb;
    private javax.swing.JTable ordersTable;
    private javax.swing.JButton search_btn;
    private javax.swing.JTextField search_input;
    private javax.swing.JLabel search_text;
    private javax.swing.ButtonGroup search_type;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables

    private final ManageInventoryController invController = new ManageInventoryController();
    private final AssignCourierController assignCtrl = new AssignCourierController();
    private String selectedOrderId;
    private String selectedCourierId;

    private void loadAllMedicines() {
        populateMedicineTable(invController.getAllMedicines());
    }

    private void populateMedicineTable(List<Medicine> list) {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        for (Medicine m : list) {
            model.addRow(new Object[]{m.getMedicineId(), m.getName(), m.getPrice(), m.getStockQuantity()});
        }
    }

    private void loadOrders() {
        List<model.Order> orders = assignCtrl.getPendingOrders();
        DefaultTableModel model = (DefaultTableModel) ordersTable.getModel();
        model.setRowCount(0);
        for (model.Order o : orders) {
            model.addRow(new Object[]{o.getOrderId(), o.getCustomerId(), o.getOrderDate(), o.getStatus()});
        }

        ordersTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent e) {
                int row = ordersTable.getSelectedRow();
                if (row >= 0) {
                    selectedOrderId = (String) ordersTable.getValueAt(row, 0);
                    loadCouriers();
                }
            }
        });
    }

    private void loadCouriers() {
        List<model.Courier> couriers = assignCtrl.getAvailableCouriers();
        DefaultTableModel model = (DefaultTableModel) couriersTable.getModel();
        model.setRowCount(0);
        for (model.Courier c : couriers) {
            model.addRow(new Object[]{c.getStaffId(), c.getName(), c.getPhonenum()});
        }

        couriersTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent e) {
                int row = couriersTable.getSelectedRow();
                if (row >= 0) {
                    selectedCourierId = (String) couriersTable.getValueAt(row, 0);
                }
            }
        });
    }

    private static class MedicineDialog extends javax.swing.JDialog {
        private boolean saved = false;
        private final Integer editId;
        private final javax.swing.JTextField nameField = new javax.swing.JTextField(15);
        private final javax.swing.JTextField priceField = new javax.swing.JTextField(10);
        private final javax.swing.JTextField stockField = new javax.swing.JTextField(10);

        MedicineDialog(java.awt.Frame parent, String title, Integer editId,
                       String name, double price, int stock) {
            super(parent, title, true);
            this.editId = editId;
            setSize(300, 200);
            setLocationRelativeTo(parent);
            setLayout(new java.awt.GridBagLayout());
            java.awt.GridBagConstraints g = new java.awt.GridBagConstraints();
            g.insets = new java.awt.Insets(5, 5, 5, 5);
            g.fill = java.awt.GridBagConstraints.HORIZONTAL;

            nameField.setText(name);
            priceField.setText(String.valueOf(price));
            stockField.setText(String.valueOf(stock));

            g.gridx = 0; g.gridy = 0; add(new javax.swing.JLabel("Name:"), g);
            g.gridx = 1; add(nameField, g);
            g.gridx = 0; g.gridy = 1; add(new javax.swing.JLabel("Price:"), g);
            g.gridx = 1; add(priceField, g);
            g.gridx = 0; g.gridy = 2; add(new javax.swing.JLabel("Stock:"), g);
            g.gridx = 1; add(stockField, g);

            javax.swing.JPanel bp = new javax.swing.JPanel(new java.awt.FlowLayout());
            javax.swing.JButton saveBtn = new javax.swing.JButton("Save");
            saveBtn.addActionListener(e -> save());
            javax.swing.JButton cancelBtn = new javax.swing.JButton("Cancel");
            cancelBtn.addActionListener(e -> dispose());
            bp.add(saveBtn); bp.add(cancelBtn);
            g.gridx = 0; g.gridy = 3; g.gridwidth = 2;
            add(bp, g);
        }

        private void save() {
            try {
                String name = nameField.getText().trim();
                double price = Double.parseDouble(priceField.getText().trim());
                int stock = Integer.parseInt(stockField.getText().trim());
                if (name.isEmpty()) { javax.swing.JOptionPane.showMessageDialog(this, "Name required"); return; }
                if (price < 0) { javax.swing.JOptionPane.showMessageDialog(this, "Price must be >= 0"); return; }
                if (stock < 0) { javax.swing.JOptionPane.showMessageDialog(this, "Stock must be >= 0"); return; }
                ManageInventoryController c = new ManageInventoryController();
                boolean ok;
                if (editId == null) {
                    ok = c.addMedicine(name, "", price, stock, "");
                } else {
                    ok = c.updateMedicine(editId, name, price, stock, "");
                }
                if (ok) { saved = true; dispose(); }
                else { javax.swing.JOptionPane.showMessageDialog(this, "Save failed"); }
            } catch (java.lang.NumberFormatException e) {
                javax.swing.JOptionPane.showMessageDialog(this, "Invalid number");
            }
        }

        boolean isSaved() { return saved; }
    }
}
