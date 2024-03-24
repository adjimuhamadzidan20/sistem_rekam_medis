package medis;
import koneksidb.koneksi_db;
import java.sql.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Data_Pasien extends javax.swing.JFrame {
    
    String idPasien, namaPasien, jenKelamin, usia, alamat, keluhan;

    public Data_Pasien() {
        initComponents();
        showData();
        kodePasien();
        inputIdPasien.setEditable(false);
    }
    
    private void resetInput() {
        inputNamaPasien.setText("");
        inputJenisKelamin.setSelectedItem("");
        inputUsia.setText("");
        inputAlamat.setText("");
        inputKeluhan.setText("");
    }
    
    private void kodePasien() {
        String kode = "11000000";
        int i = 0;
        try {
            String sql = "SELECT ID_Pasien FROM tb_data_pasien";
            Connection connect = (Connection)koneksi_db.sambung_db();
            Statement stat = connect.createStatement();
            ResultSet res = stat.executeQuery(sql);
            
            while(res.next()) {
                kode = res.getString("ID_Pasien");
            }
            
            kode = kode.substring(6);
            i = Integer.parseInt(kode) + 01;
            kode = "0000"+ i;
            kode = "110" + kode.substring(kode.length()-5);
            inputIdPasien.setText(kode);        
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    private void showData() {
        DefaultTableModel tabel = new DefaultTableModel();
        tabel.addColumn("ID_Pasien");
        tabel.addColumn("Nama_Pasien");
        tabel.addColumn("Jenis_Kelamin");
        tabel.addColumn("Usia");
        tabel.addColumn("Alamat");
        tabel.addColumn("Keluahan");
        
        try {
            String sql = "SELECT * FROM tb_data_pasien";
            
            java.sql.Connection conn = (Connection)koneksi_db.sambung_db();
            java.sql.Statement stat = conn.createStatement();
            java.sql.ResultSet hasil = stat.executeQuery(sql);
            
            while(hasil.next()) {
                tabel.addRow(
                    new Object[] {
                        hasil.getString(1),
                        hasil.getString(2),
                        hasil.getString(3),
                        hasil.getString(4),
                        hasil.getString(5),
                        hasil.getString(6)
                    }
                );
            }
        
            dataPasien.setModel(tabel); 
        }   
        catch(Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        dataPasien = new javax.swing.JTable();
        jenisData = new javax.swing.JComboBox<>();
        kolomCari = new javax.swing.JTextField();
        cariData = new javax.swing.JButton();
        kembali = new javax.swing.JToggleButton();
        jPanel2 = new javax.swing.JPanel();
        inputJenisKelamin = new javax.swing.JComboBox<>();
        satuan = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        inputKeluhan = new javax.swing.JTextField();
        inputIdPasien = new javax.swing.JTextField();
        btnEdit = new javax.swing.JButton();
        harga = new javax.swing.JLabel();
        btnDelete = new javax.swing.JButton();
        namaObat = new javax.swing.JLabel();
        inputNamaPasien = new javax.swing.JTextField();
        jenisObat = new javax.swing.JLabel();
        namaObat1 = new javax.swing.JLabel();
        inputAlamat = new javax.swing.JTextField();
        stok = new javax.swing.JLabel();
        inputUsia = new javax.swing.JTextField();
        btnReset = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SI Rekam Medis | Data Pasien");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 153, 153));
        jLabel3.setText("PENDATAAN PASIEN");

        dataPasien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Pasien", "Nama Pasien", "Jenis Kelamin", "Usia", "Alamat", "Keluhan"
            }
        ));
        dataPasien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dataPasienMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(dataPasien);

        jenisData.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID_Pasien", "Nama_Pasien" }));
        jenisData.setFocusable(false);

        cariData.setText("Search");
        cariData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cariDataActionPerformed(evt);
            }
        });

        kembali.setText("Kembali");
        kembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kembaliActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153)));

        inputJenisKelamin.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Laki-laki", "Perempuan" }));

        satuan.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        satuan.setForeground(new java.awt.Color(0, 153, 153));
        satuan.setText("Usia");

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

        harga.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        harga.setForeground(new java.awt.Color(0, 153, 153));
        harga.setText("Alamat");

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ikon/trash_box.png"))); // NOI18N
        btnDelete.setText("Delete Data");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        namaObat.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        namaObat.setForeground(new java.awt.Color(0, 153, 153));
        namaObat.setText("Nama Pasien");

        jenisObat.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        jenisObat.setForeground(new java.awt.Color(0, 153, 153));
        jenisObat.setText("Jenis Kelamin");

        namaObat1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        namaObat1.setForeground(new java.awt.Color(0, 153, 153));
        namaObat1.setText("ID Pasien");

        stok.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        stok.setForeground(new java.awt.Color(0, 153, 153));
        stok.setText("Keluhan");

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
                    .addComponent(inputIdPasien)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(stok)
                            .addComponent(harga)
                            .addComponent(satuan)
                            .addComponent(jenisObat)
                            .addComponent(namaObat)
                            .addComponent(namaObat1))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(btnReset, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(inputNamaPasien)
                    .addComponent(inputJenisKelamin, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(inputUsia)
                    .addComponent(inputAlamat)
                    .addComponent(inputKeluhan)
                    .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEdit, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(namaObat1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputIdPasien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(namaObat)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputNamaPasien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jenisObat)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputJenisKelamin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(satuan)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputUsia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(harga)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(stok)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputKeluhan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(btnReset)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSave)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEdit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDelete)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(kembali, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 653, Short.MAX_VALUE)))
                        .addGap(35, 35, 35))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(kolomCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cariData)
                        .addComponent(jenisData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addGap(18, 18, 18)
                .addComponent(kembali)
                .addGap(26, 26, 26))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        idPasien = inputIdPasien.getText();
        namaPasien = inputNamaPasien.getText();
        jenKelamin = (String) inputJenisKelamin.getSelectedItem();
        usia = inputUsia.getText();
        alamat = inputAlamat.getText();
        keluhan = inputKeluhan.getText();

        if(idPasien.equals("") || namaPasien.equals("") || jenKelamin.equals("") || usia.equals("") || alamat.equals("") || keluhan.equals("")) {
            JOptionPane.showMessageDialog(null, "Mohon input terlebih dahulu", "Informasi", JOptionPane.WARNING_MESSAGE);
        }

        else {
            int konfirm = JOptionPane.showConfirmDialog(null, "Simpan data?", "Konfirmasi", JOptionPane.YES_NO_OPTION);

            if(konfirm == 0) {
                try {
                    String query = "INSERT INTO tb_data_pasien VALUES ('"+idPasien+"','"+namaPasien+"','"+jenKelamin+"','"+usia+"','"+alamat+"','"+keluhan+"')";
                    java.sql.Connection conn = (Connection)koneksi_db.sambung_db();
                    java.sql.PreparedStatement stat = conn.prepareStatement(query);
                    stat.execute();
                    showData();
                    kodePasien();
                    resetInput();

                    JOptionPane.showMessageDialog(null, "Data berhasil disimpan", "Info", JOptionPane.INFORMATION_MESSAGE);
                }

                catch(Exception e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
            }
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        idPasien = inputIdPasien.getText();
        namaPasien = inputNamaPasien.getText();
        jenKelamin = (String) inputJenisKelamin.getSelectedItem();
        usia = inputUsia.getText();
        alamat = inputAlamat.getText();
        keluhan = inputKeluhan.getText();
        
        if(idPasien.equals("") || namaPasien.equals("") || jenKelamin.equals("") || usia.equals("") || alamat.equals("") || keluhan.equals("")) {
            JOptionPane.showMessageDialog(null, "Klik data dan pilih pada tabel dahulu", "Informasi", JOptionPane.WARNING_MESSAGE);
        }
        
        else {
            int konfirm = JOptionPane.showConfirmDialog(null, "Update data?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
            
            if(konfirm == 0) {
                try {
                    String sql = "UPDATE tb_data_pasien SET Nama_Pasien = '"+namaPasien+"', Jenis_kelamin = '"+jenKelamin+"', Usia = '"+usia+"', Alamat = '"+alamat+"', "
                    + "Keluhan = '"+keluhan+"' WHERE ID_Pasien = '"+idPasien+"'";

                    java.sql.Connection conn = (Connection)koneksi_db.sambung_db();
                    java.sql.PreparedStatement stat = conn.prepareStatement(sql);
                    stat.execute();
                    showData();
                    resetInput();
                    kodePasien();
                    btnSave.setEnabled(true);

                    JOptionPane.showMessageDialog(null, "Data berhasil diupdate", "Info", JOptionPane.INFORMATION_MESSAGE);
                }

                catch(Exception e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }        
            }
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        idPasien = inputIdPasien.getText();
        
        if(idPasien.equals("") || namaPasien.equals("") || jenKelamin.equals("") || usia.equals("") || alamat.equals("") || keluhan.equals("")) {
            JOptionPane.showMessageDialog(null, "Klik data dan pilih pada tabel dahulu", "Informasi", JOptionPane.WARNING_MESSAGE);
        }
        
        else {
            int konfirm = JOptionPane.showConfirmDialog(null, "Delete data?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
            
            if(konfirm == 0) {
                try {
                    String sql = "DELETE FROM tb_data_pasien WHERE ID_Pasien = '"+idPasien+"'";

                    java.sql.Connection conn = (Connection)koneksi_db.sambung_db();
                    java.sql.PreparedStatement stat = conn.prepareStatement(sql);
                    stat.execute();
                    showData();
                    resetInput();
                    kodePasien();
                    btnSave.setEnabled(true);

                    JOptionPane.showMessageDialog(null, "Data berhasil didelete", "Info", JOptionPane.INFORMATION_MESSAGE);

                }

                catch(Exception e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
            }
        }  
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void dataPasienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dataPasienMouseClicked
        int nomer = dataPasien.rowAtPoint(evt.getPoint());

        String kode = dataPasien.getValueAt(nomer, 0).toString();
        inputIdPasien.setText(kode);
        inputIdPasien.setEditable(false);
        btnSave.setEnabled(false);

        String nama = dataPasien.getValueAt(nomer, 1).toString();
        inputNamaPasien.setText(nama);

        String gender = dataPasien.getValueAt(nomer, 2).toString();
        inputJenisKelamin.setSelectedItem(gender);

        String usia = dataPasien.getValueAt(nomer, 3).toString();
        inputUsia.setText(usia);

        String alamat = dataPasien.getValueAt(nomer, 4).toString();
        inputAlamat.setText(alamat);

        String keluhan = dataPasien.getValueAt(nomer, 5).toString();
        inputKeluhan.setText(keluhan);
    }//GEN-LAST:event_dataPasienMouseClicked

    private void cariDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cariDataActionPerformed
        DefaultTableModel tabeldata = new DefaultTableModel();

        tabeldata.addColumn("ID_Pasien");
        tabeldata.addColumn("Nama_Pasien");
        tabeldata.addColumn("Jenis_Kelamin");
        tabeldata.addColumn("Usia");
        tabeldata.addColumn("Alamat");
        tabeldata.addColumn("Keluahan");

        try {
            String sql = "SELECT * FROM tb_data_pasien WHERE "+jenisData.getSelectedItem()+" LIKE '%"+kolomCari.getText()+"%'";

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
                        res.getString(5),
                        res.getString(6)
                    }
                );
            }

            dataPasien.setModel(tabeldata);
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
        kodePasien();
        btnSave.setEnabled(true);
    }//GEN-LAST:event_btnResetActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(Data_Pasien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Data_Pasien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Data_Pasien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Data_Pasien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Data_Pasien().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton cariData;
    private javax.swing.JTable dataPasien;
    private javax.swing.JLabel harga;
    private javax.swing.JTextField inputAlamat;
    private javax.swing.JTextField inputIdPasien;
    private javax.swing.JComboBox<String> inputJenisKelamin;
    private javax.swing.JTextField inputKeluhan;
    private javax.swing.JTextField inputNamaPasien;
    private javax.swing.JTextField inputUsia;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> jenisData;
    private javax.swing.JLabel jenisObat;
    private javax.swing.JToggleButton kembali;
    private javax.swing.JTextField kolomCari;
    private javax.swing.JLabel namaObat;
    private javax.swing.JLabel namaObat1;
    private javax.swing.JLabel satuan;
    private javax.swing.JLabel stok;
    // End of variables declaration//GEN-END:variables
}
