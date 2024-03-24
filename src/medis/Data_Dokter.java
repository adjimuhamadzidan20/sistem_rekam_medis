package medis;
import koneksidb.koneksi_db;
import java.sql.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Data_Dokter extends javax.swing.JFrame {
    
    String idDokter, namaDokter, jenKel, tgllahir, spesialis, alamat;

    public Data_Dokter() {
        initComponents();
        showData();
        kodeDokter();
        inputIdDokter.setEditable(false);
    }
    
    private void resetInput() {
        inputNamaDokter.setText("");
        inputJenisKelamin.setSelectedItem("");
        inputTglLahir.setText("");
        inputSpesialis.setSelectedItem("");
        inputAlamat.setText("");
    }
    
    private void showData() {
        DefaultTableModel tabel = new DefaultTableModel();
        tabel.addColumn("ID_Dokter");
        tabel.addColumn("Nama_Dokter");
        tabel.addColumn("Jenis_Kelamin");
        tabel.addColumn("Tanggal_lahir");
        tabel.addColumn("Praktik_Spesialis");
        tabel.addColumn("Alamat");
        
        try {
            String sql = "SELECT * FROM tb_data_dokter";
            
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
        
            dataDokter.setModel(tabel); 
        } 
        
        catch(Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    private void kodeDokter() {
        String kode = "55000000";
        int i = 0;
        try {
            String sql = "SELECT ID_Dokter FROM tb_data_dokter";
            Connection connect = (Connection)koneksi_db.sambung_db();
            Statement stat = connect.createStatement();
            ResultSet res = stat.executeQuery(sql);
            
            while(res.next()) {
                kode = res.getString("ID_Dokter");
            }
            
            kode = kode.substring(6);
            i = Integer.parseInt(kode) + 01;
            kode = "0000"+ i;
            kode = "550" + kode.substring(kode.length()-5);
            inputIdDokter.setText(kode);        
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jenisData = new javax.swing.JComboBox<>();
        kolomCari = new javax.swing.JTextField();
        cariData = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        dataDokter = new javax.swing.JTable();
        kembali = new javax.swing.JToggleButton();
        jPanel2 = new javax.swing.JPanel();
        namaObat1 = new javax.swing.JLabel();
        inputIdDokter = new javax.swing.JTextField();
        namaObat = new javax.swing.JLabel();
        inputNamaDokter = new javax.swing.JTextField();
        jenisObat = new javax.swing.JLabel();
        inputJenisKelamin = new javax.swing.JComboBox<>();
        satuan = new javax.swing.JLabel();
        inputTglLahir = new javax.swing.JTextField();
        harga = new javax.swing.JLabel();
        inputSpesialis = new javax.swing.JComboBox<>();
        stok = new javax.swing.JLabel();
        inputAlamat = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SI Rekam Medis | Data Dokter");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jenisData.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID_Dokter", "Nama_Dokter" }));
        jenisData.setFocusable(false);

        cariData.setText("Search");
        cariData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cariDataActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 153, 153));
        jLabel3.setText("PENDATAAN DOKTER");

        dataDokter.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Dokter", "Nama Dokter", "Jenis Kelamin", "Tanggal Lahir", "Spesialis", "Alamat"
            }
        ));
        dataDokter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dataDokterMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(dataDokter);

        kembali.setText("Kembali");
        kembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kembaliActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153)));
        jPanel2.setForeground(new java.awt.Color(0, 102, 102));

        namaObat1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        namaObat1.setForeground(new java.awt.Color(0, 153, 153));
        namaObat1.setText("ID Dokter");

        namaObat.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        namaObat.setForeground(new java.awt.Color(0, 153, 153));
        namaObat.setText("Nama Dokter");

        jenisObat.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        jenisObat.setForeground(new java.awt.Color(0, 153, 153));
        jenisObat.setText("Jenis Kelamin");

        inputJenisKelamin.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Laki-laki", "Perempuan" }));

        satuan.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        satuan.setForeground(new java.awt.Color(0, 153, 153));
        satuan.setText("Tanggal Lahir");

        harga.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        harga.setForeground(new java.awt.Color(0, 153, 153));
        harga.setText("Spesialis");

        inputSpesialis.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Spesialis Anak", "Spesialis Kandungan", "Spesialis Psikiater", "Spesialis Gigi", "Spesialis THT" }));

        stok.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        stok.setForeground(new java.awt.Color(0, 153, 153));
        stok.setText("Alamat");

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
                    .addComponent(inputIdDokter)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(stok)
                            .addComponent(harga)
                            .addComponent(satuan)
                            .addComponent(jenisObat)
                            .addComponent(namaObat)
                            .addComponent(namaObat1))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(btnReset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEdit, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(inputNamaDokter)
                    .addComponent(inputJenisKelamin, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(inputTglLahir)
                    .addComponent(inputSpesialis, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(inputAlamat))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(namaObat1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputIdDokter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(namaObat)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputNamaDokter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jenisObat)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputJenisKelamin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(satuan)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputTglLahir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(harga)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputSpesialis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(stok)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
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
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jenisData, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(kolomCari, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cariData, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 651, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(kembali, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(38, 38, 38))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(kolomCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cariData)
                        .addComponent(jenisData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(kembali)
                .addGap(26, 26, 26))
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

    private void kembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kembaliActionPerformed
        new Menu_Utama().setVisible(true);
        dispose();
    }//GEN-LAST:event_kembaliActionPerformed

    private void dataDokterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dataDokterMouseClicked
        int nomer = dataDokter.rowAtPoint(evt.getPoint());

        String kode = dataDokter.getValueAt(nomer, 0).toString();
        inputIdDokter.setText(kode);
        inputIdDokter.setEditable(false);
        btnSave.setEnabled(false);

        String nama = dataDokter.getValueAt(nomer, 1).toString();
        inputNamaDokter.setText(nama);

        String gender = dataDokter.getValueAt(nomer, 2).toString();
        inputJenisKelamin.setSelectedItem(gender);

        String tgl_lahir = dataDokter.getValueAt(nomer, 3).toString();
        inputTglLahir.setText(tgl_lahir);

        String spesialis = dataDokter.getValueAt(nomer, 4).toString();
        inputSpesialis.setSelectedItem(spesialis);

        String alamat = dataDokter.getValueAt(nomer, 5).toString();
        inputAlamat.setText(alamat);

    }//GEN-LAST:event_dataDokterMouseClicked

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        idDokter = inputIdDokter.getText();

        if(idDokter.equals("") || namaDokter.equals("") || jenKel.equals("") || tgllahir.equals("") || spesialis.equals("") || alamat.equals("")) {
            JOptionPane.showMessageDialog(null, "Klik data dan pilih pada tabel dahulu", "Informasi", JOptionPane.WARNING_MESSAGE);
        }

        else {
            int konfirm = JOptionPane.showConfirmDialog(null, "Delete data?", "Konfirmasi", JOptionPane.YES_NO_OPTION);

            if(konfirm == 0) {
                try {
                    String sql = "DELETE FROM tb_data_dokter WHERE ID_Dokter = '"+idDokter+"'";

                    java.sql.Connection conn = (Connection)koneksi_db.sambung_db();
                    java.sql.PreparedStatement stat = conn.prepareStatement(sql);
                    stat.execute();
                    showData();
                    resetInput();
                    kodeDokter();
                    btnSave.setEnabled(true);

                    JOptionPane.showMessageDialog(null, "Data berhasil didelete", "Info", JOptionPane.INFORMATION_MESSAGE);

                }

                catch(Exception e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        idDokter = inputIdDokter.getText();
        namaDokter = inputNamaDokter.getText();
        jenKel = (String) inputJenisKelamin.getSelectedItem();
        tgllahir = inputTglLahir.getText();
        spesialis = (String) inputSpesialis.getSelectedItem();
        alamat = inputAlamat.getText();

        if(idDokter.equals("") || namaDokter.equals("") || jenKel.equals("") || tgllahir.equals("") || spesialis.equals("") || alamat.equals("")) {
            JOptionPane.showMessageDialog(null, "Klik data dan pilih pada tabel dahulu", "Informasi", JOptionPane.WARNING_MESSAGE);
        }

        else {
            int konfirm = JOptionPane.showConfirmDialog(null, "Update data?", "Konfirmasi", JOptionPane.YES_NO_OPTION);

            if(konfirm == 0) {
                try {
                    String sql = "UPDATE tb_data_dokter SET Nama_Dokter = '"+namaDokter+"', Jenis_kelamin = '"+jenKel+"', Tanggal_lahir = '"+tgllahir+"', Praktik_Spesialis = '"+spesialis+"', "
                    + "Alamat = '"+alamat+"' WHERE ID_Dokter = '"+idDokter+"'";

                    java.sql.Connection conn = (Connection)koneksi_db.sambung_db();
                    java.sql.PreparedStatement stat = conn.prepareStatement(sql);
                    stat.execute();
                    showData();
                    resetInput();
                    kodeDokter();
                    btnSave.setEnabled(true);

                    JOptionPane.showMessageDialog(null, "Data berhasil diupdate", "Info", JOptionPane.INFORMATION_MESSAGE);
                }

                catch(Exception e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
            }
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        idDokter = inputIdDokter.getText();
        namaDokter = inputNamaDokter.getText();
        jenKel = (String) inputJenisKelamin.getSelectedItem();
        tgllahir = inputTglLahir.getText();
        spesialis = (String) inputSpesialis.getSelectedItem();
        alamat = inputAlamat.getText();

        if(namaDokter.equals("") || jenKel.equals("") || tgllahir.equals("") || spesialis.equals("") || alamat.equals("")) {
            JOptionPane.showMessageDialog(null, "Mohon input terlebih dahulu", "Informasi", JOptionPane.WARNING_MESSAGE);
        }

        else {
            int konfirm = JOptionPane.showConfirmDialog(null, "Simpan data?", "Konfirmasi", JOptionPane.YES_NO_OPTION);

            if(konfirm == 0) {
                try {
                    String query = "INSERT INTO tb_data_dokter VALUES ('"+idDokter+"','"+namaDokter+"','"+jenKel+"','"+tgllahir+"','"+spesialis+"','"+alamat+"')";
                    java.sql.Connection conn = (Connection)koneksi_db.sambung_db();
                    java.sql.PreparedStatement stat = conn.prepareStatement(query);
                    stat.execute();
                    showData();
                    kodeDokter();
                    resetInput();
                    
                    JOptionPane.showMessageDialog(null, "Data berhasil disimpan", "Info", JOptionPane.INFORMATION_MESSAGE);

                }

                catch(Exception e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
            }
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void cariDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cariDataActionPerformed
        DefaultTableModel tabel = new DefaultTableModel();

        tabel.addColumn("ID_Dokter");
        tabel.addColumn("Nama_Dokter");
        tabel.addColumn("Jenis_Kelamin");
        tabel.addColumn("Tanggal_lahir");
        tabel.addColumn("Praktik_Spesialis");
        tabel.addColumn("Alamat");

        try {
            String sql = "SELECT * FROM tb_data_dokter WHERE "+jenisData.getSelectedItem()+" LIKE '%"+kolomCari.getText()+"%'";

            java.sql.Connection conn = (Connection)koneksi_db.sambung_db();
            java.sql.Statement stat = conn.createStatement();
            java.sql.ResultSet res = stat.executeQuery(sql);

            while(res.next()) {
                tabel.addRow(
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

            dataDokter.setModel(tabel);
        }

        catch(Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Info",JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_cariDataActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        resetInput();
        kodeDokter();
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
            java.util.logging.Logger.getLogger(Data_Dokter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Data_Dokter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Data_Dokter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Data_Dokter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Data_Dokter().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton cariData;
    private javax.swing.JTable dataDokter;
    private javax.swing.JLabel harga;
    private javax.swing.JTextField inputAlamat;
    private javax.swing.JTextField inputIdDokter;
    private javax.swing.JComboBox<String> inputJenisKelamin;
    private javax.swing.JTextField inputNamaDokter;
    private javax.swing.JComboBox<String> inputSpesialis;
    private javax.swing.JTextField inputTglLahir;
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
