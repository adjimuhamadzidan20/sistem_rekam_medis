package medis;
import static java.lang.Integer.parseInt;
import koneksidb.koneksi_db;
import java.sql.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;

public class Data_Obat extends javax.swing.JFrame {
    
    String namaobat, jenisobat, stokobat, kodeobat, hargaobat;
    
    public Data_Obat() {
        initComponents();
        showData();
        kodeObat();
        inputKodeObat.setEditable(false);
    }
    
    private void resetInput() {
        inputHarga.setText("");
        inputNamaObat.setText("");
        inputJenisObat.setSelectedItem("");
        inputStok.setText("");
    }
    
    // menampilkan isi data dari db
    private void showData() {
        DefaultTableModel tabel = new DefaultTableModel(); 
        tabel.addColumn("ID_Obat");
        tabel.addColumn("Nama_Obat");
        tabel.addColumn("Jenis_Obat");
        tabel.addColumn("Harga");
        tabel.addColumn("Stok");
        
        try {
           String query = "SELECT * FROM tb_data_obat";
           java.sql.Connection conn = (Connection)koneksi_db.sambung_db();
           java.sql.Statement stat = conn.createStatement();
           java.sql.ResultSet hasil = stat.executeQuery(query);
           
           while(hasil.next()) {
               tabel.addRow(new Object[] {
                   hasil.getString(1),hasil.getString(2),hasil.getString(3),
                   hasil.getString(4),hasil.getString(5)
               });
           }
           
           // set data ke tabel dataObat 
           dataObat.setModel(tabel);
        }
        
        catch(Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    // update data
    private void editData() {
        kodeobat = inputKodeObat.getText();
        hargaobat = inputHarga.getText();
        namaobat = inputNamaObat.getText();
        jenisobat = (String) inputJenisObat.getSelectedItem();
        stokobat = inputStok.getText();
        
        if(namaobat.equals("") || jenisobat.equals("") || hargaobat.equals("") || stokobat.equals("")) {
            JOptionPane.showMessageDialog(null, "Klik data dan pilih pada tabel dahulu", "Info", JOptionPane.WARNING_MESSAGE);
        }
        
        else {
            int konfirm = JOptionPane.showConfirmDialog(null, "Update data?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
            
            if(konfirm == 0) {
                try {
                    String query = "UPDATE tb_data_obat SET "
                    + "Nama_Obat = '"+namaobat+"', Jenis_Obat = '"+jenisobat+"',"
                    + "Harga = '"+hargaobat+"', Stok = '"+stokobat+"'"
                    + "WHERE ID_Obat = '"+kodeobat+"'";
                    java.sql.Connection conn = (Connection)koneksi_db.sambung_db();
                    java.sql.PreparedStatement stat = conn.prepareStatement(query);
                    stat.execute();
                    showData();
                    resetInput();
                    kodeObat();
                    btnSave.setEnabled(true);

                    JOptionPane.showMessageDialog(null, "Data berhasil diupdate", "Info", JOptionPane.INFORMATION_MESSAGE);   
                }

                catch(Exception e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
            }
        }    
    }
    
    // delete data
    private void hapusData() {
        kodeobat = inputKodeObat.getText();
        hargaobat = inputHarga.getText();
        namaobat = inputNamaObat.getText();
        jenisobat = (String) inputJenisObat.getSelectedItem();
        stokobat = inputStok.getText();
        
        if(namaobat.equals("") || jenisobat.equals("") || hargaobat.equals("") || stokobat.equals("")) {
            JOptionPane.showMessageDialog(null, "Klik data dan pilih pada tabel dahulu", "Info", JOptionPane.WARNING_MESSAGE);
        }
        
        else {
            int konfirm = JOptionPane.showConfirmDialog(null, "Delete data?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
            
            if(konfirm == 0) {
                try {
                    String query = "DELETE FROM tb_data_obat WHERE ID_Obat = '"+kodeobat+"'";
                    java.sql.Connection conn = (Connection)koneksi_db.sambung_db();
                    java.sql.PreparedStatement stat = conn.prepareStatement(query);
                    stat.execute();
                    showData();
                    resetInput();
                    kodeObat();
                    btnSave.setEnabled(true);

                    JOptionPane.showMessageDialog(null, "Data berhasil dihapus", "Info", JOptionPane.INFORMATION_MESSAGE);
                }

                catch(Exception e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
            }            
        }     
    }
    
    private void kodeObat() {
        String kode = "33000000";
        int i = 0;
        try {
            String sql = "SELECT ID_Obat FROM tb_data_obat";
            Connection connect = (Connection)koneksi_db.sambung_db();
            Statement stat = connect.createStatement();
            ResultSet res = stat.executeQuery(sql);
            
            while(res.next()) {
                kode = res.getString("ID_Obat");
            }
            
            kode = kode.substring(6);
            i = Integer.parseInt(kode) + 01;
            kode = "0000"+ i;
            kode = "330" + kode.substring(kode.length()-5);
            inputKodeObat.setText(kode);        
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        kolomCari = new javax.swing.JTextField();
        cariData = new javax.swing.JButton();
        jenisData = new javax.swing.JComboBox<>();
        kembali = new javax.swing.JToggleButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        dataObat = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        kodeObat = new javax.swing.JLabel();
        inputKodeObat = new javax.swing.JTextField();
        namaObat = new javax.swing.JLabel();
        inputNamaObat = new javax.swing.JTextField();
        jenisObat = new javax.swing.JLabel();
        inputJenisObat = new javax.swing.JComboBox<>();
        harga = new javax.swing.JLabel();
        inputHarga = new javax.swing.JTextField();
        stok = new javax.swing.JLabel();
        inputStok = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SI Rekam Medis | Data Obat");
        setBackground(new java.awt.Color(204, 204, 204));
        setForeground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        cariData.setText("Search");
        cariData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cariDataActionPerformed(evt);
            }
        });

        jenisData.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID_Obat", "Nama_Obat", "Jenis_Obat", "Harga", "Stok" }));
        jenisData.setFocusable(false);

        kembali.setText("Kembali");
        kembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kembaliActionPerformed(evt);
            }
        });

        dataObat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Kode Obat", "Nama Obat", "Jenis Obat", "Satuan", "Harga", "Stok"
            }
        ));
        dataObat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dataObatMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(dataObat);
        if (dataObat.getColumnModel().getColumnCount() > 0) {
            dataObat.getColumnModel().getColumn(0).setResizable(false);
            dataObat.getColumnModel().getColumn(1).setResizable(false);
            dataObat.getColumnModel().getColumn(2).setResizable(false);
            dataObat.getColumnModel().getColumn(3).setResizable(false);
            dataObat.getColumnModel().getColumn(5).setResizable(false);
        }

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 153, 153));
        jLabel3.setText("PENDATAAN OBAT");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153)));

        kodeObat.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        kodeObat.setForeground(new java.awt.Color(0, 153, 153));
        kodeObat.setText("ID Obat");

        namaObat.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        namaObat.setForeground(new java.awt.Color(0, 153, 153));
        namaObat.setText("Nama Obat");

        jenisObat.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        jenisObat.setForeground(new java.awt.Color(0, 153, 153));
        jenisObat.setText("Jenis Obat");

        inputJenisObat.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cair", "Tablet", "Serbuk", "Lainnya" }));

        harga.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        harga.setForeground(new java.awt.Color(0, 153, 153));
        harga.setText("Harga Obat");

        stok.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        stok.setForeground(new java.awt.Color(0, 153, 153));
        stok.setText("Stok Obat");

        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ikon/save_as.png"))); // NOI18N
        btnSave.setText("Save Data");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ikon/pencil_edit.png"))); // NOI18N
        btnEdit.setText("Update Data");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ikon/trash_box.png"))); // NOI18N
        btnDelete.setText("Delete Data");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ikon/refresh.png"))); // NOI18N
        btnReset.setText("Reset Data");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(inputKodeObat)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(stok, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(harga, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jenisObat, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(namaObat, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(kodeObat, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(btnReset, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(inputNamaObat)
                    .addComponent(inputJenisObat, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(inputHarga)
                    .addComponent(inputStok)
                    .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEdit, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(kodeObat)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputKodeObat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(namaObat)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputNamaObat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jenisObat)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputJenisObat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(harga)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(stok)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputStok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(btnReset)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSave)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEdit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDelete)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jenisData, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(kolomCari, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(cariData, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 657, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(kembali, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(kolomCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cariData)
                    .addComponent(jenisData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(kembali)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // mengklik data yang dipilih didalam tabel dengan kursor
    private void dataObatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dataObatMouseClicked
        int nomer = dataObat.rowAtPoint(evt.getPoint());

        String kode = dataObat.getValueAt(nomer, 0).toString();
        inputKodeObat.setText(kode);
        inputKodeObat.setEditable(false);
        btnSave.setEnabled(false);

        String namaobat = dataObat.getValueAt(nomer, 1).toString();
        inputNamaObat.setText(namaobat);

        String jenisobat = dataObat.getValueAt(nomer, 2).toString();
        inputJenisObat.setSelectedItem(jenisobat);


        String harga = dataObat.getValueAt(nomer, 3).toString();
        inputHarga.setText(harga);

        String stok = dataObat.getValueAt(nomer, 4).toString();
        inputStok.setText(stok);

    }//GEN-LAST:event_dataObatMouseClicked

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        hapusData();
        showData();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        editData();
        showData();
    }//GEN-LAST:event_btnEditActionPerformed

    // save data
    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        kodeobat = inputKodeObat.getText();
        hargaobat = inputHarga.getText();
        namaobat = inputNamaObat.getText();
        jenisobat = (String) inputJenisObat.getSelectedItem();
        stokobat = inputStok.getText(); 
        
        if(kodeobat.equals("") || hargaobat.equals("") || namaobat.equals("") || jenisobat.equals("") || stokobat.equals("")) {
            JOptionPane.showMessageDialog(null, "Mohon input terlebih dahulu", "Informasi", JOptionPane.WARNING_MESSAGE);
        }
        
        else {
            int konfirm = JOptionPane.showConfirmDialog(null, "Simpan data?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        
            if(konfirm == 0) {
                try {
                    String query = "INSERT INTO tb_data_obat VALUES "
                    + "('"+kodeobat+"','"+namaobat+"','"+jenisobat+"',"
                    + "'"+hargaobat+"','"+stokobat+"')";
                    java.sql.Connection conn = (Connection)koneksi_db.sambung_db();
                    java.sql.PreparedStatement stat = conn.prepareStatement(query);
                    stat.execute();
                    showData();
                    kodeObat();
                    resetInput();

                    JOptionPane.showMessageDialog(null, "Data berhasil disimpan", "Info", JOptionPane.INFORMATION_MESSAGE);
                }

                catch(Exception e) {
                   JOptionPane.showMessageDialog(null, e.getMessage());
                }
            }
        }        
    }//GEN-LAST:event_btnSaveActionPerformed

    // cari data
    private void cariDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cariDataActionPerformed
        DefaultTableModel tabeldata = new DefaultTableModel();
        
        tabeldata.addColumn("ID_Obat");
        tabeldata.addColumn("Nama_Obat");
        tabeldata.addColumn("Jenis_Obat");
        tabeldata.addColumn("Harga");
        tabeldata.addColumn("Stok");
        
        try {
            String sql = "SELECT * FROM tb_data_obat WHERE "+jenisData.getSelectedItem()+" LIKE '%"+kolomCari.getText()+"%'";
            
            java.sql.Connection conn = (Connection)koneksi_db.sambung_db();
            java.sql.Statement stat = conn.createStatement();
            java.sql.ResultSet res = stat.executeQuery(sql);
            
            while(res.next()) {
                tabeldata.addRow(
                    new Object[] {
                        res.getString(1),
                        res.getString(2),
                        res.getString(3),
                        res.getString(4),
                        res.getString(5)
                    }
                );
            }
            
            dataObat.setModel(tabeldata);
        }
        
        catch(Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Info",JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_cariDataActionPerformed

    private void kembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kembaliActionPerformed
        new Menu_Utama().setVisible(true);
        dispose();
    }//GEN-LAST:event_kembaliActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        resetInput();
        kodeObat();
        btnSave.setEnabled(true);
    }//GEN-LAST:event_btnResetActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Data_Obat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Data_Obat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Data_Obat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Data_Obat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Data_Obat().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton cariData;
    private javax.swing.JTable dataObat;
    private javax.swing.JLabel harga;
    private javax.swing.JTextField inputHarga;
    private javax.swing.JComboBox<String> inputJenisObat;
    private javax.swing.JTextField inputKodeObat;
    private javax.swing.JTextField inputNamaObat;
    private javax.swing.JTextField inputStok;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> jenisData;
    private javax.swing.JLabel jenisObat;
    private javax.swing.JToggleButton kembali;
    private javax.swing.JLabel kodeObat;
    private javax.swing.JTextField kolomCari;
    private javax.swing.JLabel namaObat;
    private javax.swing.JLabel stok;
    // End of variables declaration//GEN-END:variables
}
