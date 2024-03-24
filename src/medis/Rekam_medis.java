package medis;
import koneksidb.koneksi_db;
import java.sql.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Rekam_medis extends javax.swing.JFrame {
    String idMedis, tglPeriksa, namaPasien, diagnosis, namaDokter;
    
    public Rekam_medis() {
        initComponents();
        showData();
        kodeRekam();
        listNamaPasien();
        listNamaDokter();
        inputIdMedis.setEditable(false);
        idPasien.setEditable(false);
        idDokter.setEditable(false);
        keluhanPasien.setEditable(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        dataRekamMedis = new javax.swing.JTable();
        jenisData = new javax.swing.JComboBox<>();
        kolomCari = new javax.swing.JTextField();
        cariData = new javax.swing.JButton();
        kembali = new javax.swing.JToggleButton();
        jPanel2 = new javax.swing.JPanel();
        inputNamPasien = new javax.swing.JComboBox<>();
        satuan = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        inputIdMedis = new javax.swing.JTextField();
        btnEdit = new javax.swing.JButton();
        harga = new javax.swing.JLabel();
        btnDelete = new javax.swing.JButton();
        namaObat = new javax.swing.JLabel();
        inputTglPeriksa = new javax.swing.JTextField();
        jenisObat = new javax.swing.JLabel();
        namaObat1 = new javax.swing.JLabel();
        inputDiagnosis = new javax.swing.JTextField();
        btnReset = new javax.swing.JButton();
        inputNamDokter = new javax.swing.JComboBox<>();
        satuan1 = new javax.swing.JLabel();
        idPasien = new javax.swing.JTextField();
        satuan2 = new javax.swing.JLabel();
        idDokter = new javax.swing.JTextField();
        satuan3 = new javax.swing.JLabel();
        keluhanPasien = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SI Rekam Medis | Data Rekam Medis");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 153, 153));
        jLabel3.setText("DATA REKAM MEDIS");

        dataRekamMedis.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Medis", "Tanggal Periksa", "ID Pasien", "Nama Pasien", "Diagnosa", "ID Dokter", "Nama Dokter"
            }
        ));
        dataRekamMedis.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dataRekamMedisMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(dataRekamMedis);

        jenisData.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID_Medis", "Tanggal_Periksa", "Nama_Pasien", "Nama_Dokter", " " }));
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

        inputNamPasien.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Pilih Pasien --" }));
        inputNamPasien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputNamPasienActionPerformed(evt);
            }
        });

        satuan.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        satuan.setForeground(new java.awt.Color(0, 153, 153));
        satuan.setText("Diagnosa");

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
        harga.setText("Nama Dokter");

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ikon/trash_box.png"))); // NOI18N
        btnDelete.setText("Delete Data");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        namaObat.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        namaObat.setForeground(new java.awt.Color(0, 153, 153));
        namaObat.setText("Tanggal Periksa");

        jenisObat.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        jenisObat.setForeground(new java.awt.Color(0, 153, 153));
        jenisObat.setText("Nama Pasien");

        namaObat1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        namaObat1.setForeground(new java.awt.Color(0, 153, 153));
        namaObat1.setText("ID Medis");

        btnReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ikon/refresh.png"))); // NOI18N
        btnReset.setText("Reset Data");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        inputNamDokter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Pilih Dokter --" }));
        inputNamDokter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputNamDokterActionPerformed(evt);
            }
        });

        satuan1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        satuan1.setForeground(new java.awt.Color(0, 153, 153));
        satuan1.setText("ID Pasien");

        satuan2.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        satuan2.setForeground(new java.awt.Color(0, 153, 153));
        satuan2.setText("ID Dokter");

        satuan3.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        satuan3.setForeground(new java.awt.Color(0, 153, 153));
        satuan3.setText("Keluhan Pasien");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jenisObat)
                    .addComponent(namaObat)
                    .addComponent(namaObat1)
                    .addComponent(satuan1)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(idPasien, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(inputNamPasien, javax.swing.GroupLayout.Alignment.LEADING, 0, 280, Short.MAX_VALUE)
                        .addComponent(inputTglPeriksa, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(inputIdMedis, javax.swing.GroupLayout.Alignment.LEADING)))
                .addGap(36, 36, 36)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(harga)
                    .addComponent(satuan2)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(idDokter, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(inputNamDokter, javax.swing.GroupLayout.Alignment.LEADING, 0, 280, Short.MAX_VALUE)
                        .addComponent(satuan3, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(satuan, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(inputDiagnosis, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(keluhanPasien, javax.swing.GroupLayout.Alignment.LEADING)))
                .addGap(45, 45, 45)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnReset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEdit, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnReset)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSave)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEdit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDelete))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(namaObat1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(inputIdMedis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(namaObat)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(inputTglPeriksa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jenisObat)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(inputNamPasien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(satuan1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(idPasien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(satuan3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(keluhanPasien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(satuan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(inputDiagnosis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(harga)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(inputNamDokter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(satuan2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(idDokter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 315, Short.MAX_VALUE)
                        .addComponent(jenisData, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(kolomCari, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cariData, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(kembali, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(35, 35, 35))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(kolomCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cariData)
                    .addComponent(jenisData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(kembali)
                .addContainerGap(27, Short.MAX_VALUE))
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
    
    private void resetInput() {
        inputTglPeriksa.setText("");
        inputNamPasien.setSelectedItem("-- Pilih Pasien --");
        idPasien.setText("");
        inputDiagnosis.setText("");
        inputNamDokter.setSelectedItem("-- Pilih Dokter --");
        idDokter.setText("");
    }
    
    private void kodeRekam() {
        String kode = "66000000";
        int i = 0;
        try {
            String sql = "SELECT ID_Medis FROM tb_data_rekam_medis";
            Connection connect = (Connection)koneksi_db.sambung_db();
            Statement stat = connect.createStatement();
            ResultSet res = stat.executeQuery(sql);
            
            while(res.next()) {
                kode = res.getString("ID_Medis");
            }
            
            kode = kode.substring(6);
            i = Integer.parseInt(kode) + 01;
            kode = "0000"+ i;
            kode = "660" + kode.substring(kode.length()-5);
            inputIdMedis.setText(kode);        
        } 
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    private void showData() {
        DefaultTableModel tabel = new DefaultTableModel();
        tabel.addColumn("ID Medis");
        tabel.addColumn("Tanggal Periksa");
        tabel.addColumn("ID Pasien");
        tabel.addColumn("Pasien");
        tabel.addColumn("Diagnosa");
        tabel.addColumn("ID Dokter");
        tabel.addColumn("Dokter");
        
        try {
            String sql = "SELECT tb_data_rekam_medis.ID_Medis, tb_data_rekam_medis.Tanggal_Periksa, "
                    + "tb_data_pasien.ID_Pasien, tb_data_pasien.Nama_Pasien, "
                    + "tb_data_rekam_medis.Diagnosa, tb_data_dokter.ID_Dokter, tb_data_dokter.Nama_Dokter "
                    + "FROM tb_data_rekam_medis INNER JOIN tb_data_pasien ON "
                    + "tb_data_rekam_medis.ID_Pasien = tb_data_pasien.ID_Pasien INNER JOIN "
                    + "tb_data_dokter ON tb_data_rekam_medis.ID_Dokter = tb_data_dokter.ID_Dokter";
            
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
                        hasil.getString(6),
                        hasil.getString(7)
                    }
                );
            }
            dataRekamMedis.setModel(tabel); 
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    private void listNamaPasien() {
        try {
            String sql = "SELECT Nama_Pasien FROM tb_data_pasien";
            Connection conn = (Connection)koneksi_db.sambung_db();
            Statement stat = conn.createStatement();
            ResultSet res = stat.executeQuery(sql);
            
            while(res.next()) {
                inputNamPasien.addItem(res.getString("Nama_Pasien"));
            }
            
            res.last();
            int jumlahPasien = res.getRow();
            res.first();
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    private void listNamaDokter() {
        try {
            String sql = "SELECT Nama_Dokter FROM tb_data_dokter";
            Connection conn = (Connection)koneksi_db.sambung_db();
            Statement stat = conn.createStatement();
            ResultSet res = stat.executeQuery(sql);
            
            while(res.next()) {
                inputNamDokter.addItem(res.getString("Nama_Dokter"));
            }
            
            res.last();
            int jumlahDokter = res.getRow();
            res.first();
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    private void kembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kembaliActionPerformed
        new Menu_Utama().setVisible(true);
        dispose();
    }//GEN-LAST:event_kembaliActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        idMedis = inputIdMedis.getText();
        tglPeriksa = inputTglPeriksa.getText();
        namaPasien = idPasien.getText();
        diagnosis = inputDiagnosis.getText();
        namaDokter = idDokter.getText();

        if(idMedis.equals("") || tglPeriksa.equals("") || namaPasien.equals("") || diagnosis.equals("") || namaDokter.equals("")) {
            JOptionPane.showMessageDialog(null, "Mohon input terlebih dahulu", "Informasi", JOptionPane.WARNING_MESSAGE);
        }
        else {
            int konfirm = JOptionPane.showConfirmDialog(null, "Simpan data?", "Konfirmasi", JOptionPane.YES_NO_OPTION);

            if(konfirm == 0) {
                try {
                    String query = "INSERT INTO tb_data_rekam_medis VALUES ('"+idMedis+"','"+tglPeriksa+"','"+namaPasien+"','"+diagnosis+"','"+namaDokter+"')";
                    java.sql.Connection conn = (Connection)koneksi_db.sambung_db();
                    java.sql.PreparedStatement stat = conn.prepareStatement(query);
                    stat.execute();
                    showData();
                    kodeRekam();
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
        idMedis = inputIdMedis.getText();
        tglPeriksa = inputTglPeriksa.getText();
        namaPasien = idPasien.getText();
        diagnosis = inputDiagnosis.getText();
        namaDokter = idDokter.getText();

        if(idMedis.equals("") || tglPeriksa.equals("") || namaPasien.equals("") || diagnosis.equals("") || namaDokter.equals("")) {
            JOptionPane.showMessageDialog(null, "Klik data dan pilih pada tabel dahulu", "Informasi", JOptionPane.WARNING_MESSAGE);
        }
        else {
            int konfirm = JOptionPane.showConfirmDialog(null, "Update data?", "Konfirmasi", JOptionPane.YES_NO_OPTION);

            if(konfirm == 0) {
                try {
                    String sql = "UPDATE tb_data_rekam_medis SET Tanggal_Periksa = '"+tglPeriksa+"', ID_Pasien = '"+namaPasien+"', Diagnosa = '"+diagnosis+"', ID_Dokter = '"+namaDokter+"', "
                    + "WHERE ID_Medis = '"+idMedis+"'";

                    java.sql.Connection conn = (Connection)koneksi_db.sambung_db();
                    java.sql.PreparedStatement stat = conn.prepareStatement(sql);
                    stat.execute();
                    showData();
                    resetInput();
                    kodeRekam();
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
        idMedis = inputIdMedis.getText();

        if(idMedis.equals("") || tglPeriksa.equals("") || namaPasien.equals("") || diagnosis.equals("") || namaDokter.equals("")) {
            JOptionPane.showMessageDialog(null, "Klik data dan pilih pada tabel dahulu", "Informasi", JOptionPane.WARNING_MESSAGE);
        }
        else {
            int konfirm = JOptionPane.showConfirmDialog(null, "Delete data?", "Konfirmasi", JOptionPane.YES_NO_OPTION);

            if(konfirm == 0) {
                try {
                    String sql = "DELETE FROM tb_data_rekam_medis WHERE ID_Medis = '"+idMedis+"'";

                    java.sql.Connection conn = (Connection)koneksi_db.sambung_db();
                    java.sql.PreparedStatement stat = conn.prepareStatement(sql);
                    stat.execute();
                    showData();
                    resetInput();
                    kodeRekam();
                    btnSave.setEnabled(true);

                    JOptionPane.showMessageDialog(null, "Data berhasil didelete", "Info", JOptionPane.INFORMATION_MESSAGE);

                }
                catch(Exception e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        resetInput();
        kodeRekam();
        btnSave.setEnabled(true);
    }//GEN-LAST:event_btnResetActionPerformed

    private void inputNamPasienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputNamPasienActionPerformed
        String listPasien = (String) inputNamPasien.getSelectedItem();
        
        try {
            String sql = "SELECT ID_Pasien, Keluhan FROM tb_data_pasien WHERE Nama_Pasien = '"+ listPasien  +"'";
            Connection conn = (Connection)koneksi_db.sambung_db();
            Statement stat = conn.createStatement();
            ResultSet res = stat.executeQuery(sql);
            
            while(res.next()) {
                String id = res.getString("ID_Pasien");
                String keluhan = res.getString("Keluhan");
                idPasien.setText(id);
                keluhanPasien.setText(keluhan);
            }
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_inputNamPasienActionPerformed

    private void inputNamDokterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputNamDokterActionPerformed
        String listDokter = (String) inputNamDokter.getSelectedItem();
        
        try {
            String sql = "SELECT ID_Dokter FROM tb_data_dokter WHERE Nama_Dokter = '"+ listDokter  +"'";
            Connection conn = (Connection)koneksi_db.sambung_db();
            Statement stat = conn.createStatement();
            ResultSet res = stat.executeQuery(sql);
            
            while(res.next()) {
                String id = res.getString("ID_Dokter");
                idDokter.setText(id);
            }
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_inputNamDokterActionPerformed

    private void dataRekamMedisMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dataRekamMedisMouseClicked
        int nomer = dataRekamMedis.rowAtPoint(evt.getPoint());

        String kode = dataRekamMedis.getValueAt(nomer, 0).toString();
        inputIdMedis.setText(kode);
        inputIdMedis.setEditable(false);
        btnSave.setEnabled(false);

        String tglPeriksa = dataRekamMedis.getValueAt(nomer, 1).toString();
        inputTglPeriksa.setText(tglPeriksa);
        
        String kolomIdPasien = dataRekamMedis.getValueAt(nomer, 2).toString();
        idPasien.setText(kolomIdPasien);
        idPasien.setEditable(false);
        
        String pasien = dataRekamMedis.getValueAt(nomer, 3).toString();
        inputNamPasien.setSelectedItem(pasien);
        
        String diagnos = dataRekamMedis.getValueAt(nomer, 4).toString();
        inputDiagnosis.setText(diagnos);
        
        String kolomIdDokter = dataRekamMedis.getValueAt(nomer, 5).toString();
        idDokter.setText(kolomIdDokter);
        idDokter.setEditable(false);
        
        String dokter = dataRekamMedis.getValueAt(nomer, 6).toString();
        inputNamDokter.setSelectedItem(dokter);
    }//GEN-LAST:event_dataRekamMedisMouseClicked

    private void cariDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cariDataActionPerformed
        DefaultTableModel tabeldata = new DefaultTableModel();
        tabeldata.addColumn("ID Medis");
        tabeldata.addColumn("Tanggal Periksa");
        tabeldata.addColumn("ID Pasien");
        tabeldata.addColumn("Pasien");
        tabeldata.addColumn("Diagnosa");
        tabeldata.addColumn("ID Dokter");
        tabeldata.addColumn("Dokter");

        try {
            String sql = "SELECT tb_data_rekam_medis.ID_Medis, tb_data_rekam_medis.Tanggal_Periksa, "
                    + "tb_data_pasien.ID_Pasien, tb_data_pasien.Nama_Pasien, tb_data_rekam_medis.Diagnosa, "
                    + "tb_data_dokter.ID_Dokter, tb_data_dokter.Nama_Dokter FROM tb_data_rekam_medis INNER JOIN "
                    + "tb_data_pasien ON tb_data_rekam_medis.ID_Pasien = tb_data_pasien.ID_Pasien INNER JOIN "
                    + "tb_data_dokter ON tb_data_rekam_medis.ID_Dokter = tb_data_dokter.ID_Dokter "
                    + "WHERE "+jenisData.getSelectedItem()+" LIKE '%"+kolomCari.getText()+"%'";

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
                        res.getString(6),
                        res.getString(7)
                    }
                );
            }

            dataRekamMedis.setModel(tabeldata);
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Info",JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_cariDataActionPerformed

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
            java.util.logging.Logger.getLogger(Rekam_medis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Rekam_medis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Rekam_medis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Rekam_medis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Rekam_medis().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton cariData;
    private javax.swing.JTable dataRekamMedis;
    private javax.swing.JLabel harga;
    private javax.swing.JTextField idDokter;
    private javax.swing.JTextField idPasien;
    private javax.swing.JTextField inputDiagnosis;
    private javax.swing.JTextField inputIdMedis;
    private javax.swing.JComboBox<String> inputNamDokter;
    private javax.swing.JComboBox<String> inputNamPasien;
    private javax.swing.JTextField inputTglPeriksa;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> jenisData;
    private javax.swing.JLabel jenisObat;
    private javax.swing.JTextField keluhanPasien;
    private javax.swing.JToggleButton kembali;
    private javax.swing.JTextField kolomCari;
    private javax.swing.JLabel namaObat;
    private javax.swing.JLabel namaObat1;
    private javax.swing.JLabel satuan;
    private javax.swing.JLabel satuan1;
    private javax.swing.JLabel satuan2;
    private javax.swing.JLabel satuan3;
    // End of variables declaration//GEN-END:variables
}
