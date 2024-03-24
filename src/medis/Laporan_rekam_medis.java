package medis;
import java.sql.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import koneksidb.koneksi_db;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

public class Laporan_rekam_medis extends javax.swing.JFrame {
    
    public Laporan_rekam_medis() {
        initComponents();
        showData();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel66 = new javax.swing.JPanel();
        jLabel47 = new javax.swing.JLabel();
        cetakDataDokter = new javax.swing.JButton();
        kembaliDokter = new javax.swing.JToggleButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        dataRekamMedis = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SI Rekam Medis | Laporan Rekam Medis");
        setResizable(false);

        jPanel66.setBackground(new java.awt.Color(255, 255, 255));

        jLabel47.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(0, 153, 153));
        jLabel47.setText("LAPORAN DATA REKAM MEDIS");

        cetakDataDokter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ikon/printer.png"))); // NOI18N
        cetakDataDokter.setText("Cetak Data (PDF)");
        cetakDataDokter.setFocusable(false);
        cetakDataDokter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cetakDataDokterActionPerformed(evt);
            }
        });

        kembaliDokter.setText("Kembali");
        kembaliDokter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kembaliDokterActionPerformed(evt);
            }
        });

        dataRekamMedis.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Medis", "Tanggal Periksa", "ID Pasien", "Nama Pasien", "Keluhan Pasien", "Diagnosa", "ID Dokter", "Nama Dokter", "Spesialisasi"
            }
        ));
        jScrollPane1.setViewportView(dataRekamMedis);

        javax.swing.GroupLayout jPanel66Layout = new javax.swing.GroupLayout(jPanel66);
        jPanel66.setLayout(jPanel66Layout);
        jPanel66Layout.setHorizontalGroup(
            jPanel66Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel66Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel66Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel66Layout.createSequentialGroup()
                        .addComponent(kembaliDokter, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel66Layout.createSequentialGroup()
                        .addGroup(jPanel66Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 984, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel66Layout.createSequentialGroup()
                                .addComponent(jLabel47)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cetakDataDokter)))
                        .addGap(35, 35, 35))))
        );
        jPanel66Layout.setVerticalGroup(
            jPanel66Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel66Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel66Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cetakDataDokter)
                    .addComponent(jLabel47))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 408, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(kembaliDokter)
                .addGap(27, 27, 27))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel66, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel66, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void showData() {
        DefaultTableModel tabel = new DefaultTableModel();
        tabel.addColumn("ID Medis");
        tabel.addColumn("Tanggal Periksa");
        tabel.addColumn("ID Pasien");
        tabel.addColumn("Pasien");
        tabel.addColumn("Keluhan");
        tabel.addColumn("Diagnosa");
        tabel.addColumn("ID Dokter");
        tabel.addColumn("Dokter");
        tabel.addColumn("Spesialisasi");
        
        try {
            String sql = "SELECT tb_data_rekam_medis.ID_Medis, tb_data_rekam_medis.Tanggal_Periksa, "
                    + "tb_data_pasien.ID_Pasien, tb_data_pasien.Nama_Pasien, tb_data_pasien.Keluhan,"
                    + "tb_data_rekam_medis.Diagnosa, tb_data_dokter.ID_Dokter, tb_data_dokter.Nama_Dokter, tb_data_dokter.Praktik_Spesialis "
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
                        hasil.getString(7),
                        hasil.getString(8),
                        hasil.getString(9)
                    }
                );
            }
            dataRekamMedis.setModel(tabel); 
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    private void cetakDataDokterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cetakDataDokterActionPerformed
        Map<String, Object> parameters = new HashMap<>();
        
        try {
            JasperPrint JP = JasperFillManager.fillReport("src/laporan/laporan_rekam_medis.jasper", parameters, koneksi_db.sambung_db());
            JasperViewer.viewReport(JP, false);
        }
        catch (JRException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_cetakDataDokterActionPerformed

    private void kembaliDokterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kembaliDokterActionPerformed
        new Menu_Utama().setVisible(true);
        dispose();
    }//GEN-LAST:event_kembaliDokterActionPerformed

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
            java.util.logging.Logger.getLogger(Laporan_rekam_medis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Laporan_rekam_medis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Laporan_rekam_medis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Laporan_rekam_medis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Laporan_rekam_medis().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cetakDataDokter;
    private javax.swing.JTable dataRekamMedis;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JPanel jPanel66;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToggleButton kembaliDokter;
    // End of variables declaration//GEN-END:variables
}
