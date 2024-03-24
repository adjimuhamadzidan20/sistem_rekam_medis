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

public class Laporan_dokter extends javax.swing.JFrame {

    public Laporan_dokter() {
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
        jScrollPane45 = new javax.swing.JScrollPane();
        laporanDataDokter = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SI Rekam Medis | Laporan Dokter");
        setResizable(false);

        jPanel66.setBackground(new java.awt.Color(255, 255, 255));

        jLabel47.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(0, 153, 153));
        jLabel47.setText("LAPORAN DATA DOKTER");

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

        laporanDataDokter.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Dokter", "Nama Dokter", "Jenis Kelamin", "Tanggal Lahir", "Spesialis", "Alamat"
            }
        ));
        jScrollPane45.setViewportView(laporanDataDokter);

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
                    .addGroup(jPanel66Layout.createSequentialGroup()
                        .addGroup(jPanel66Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane45, javax.swing.GroupLayout.DEFAULT_SIZE, 916, Short.MAX_VALUE)
                            .addGroup(jPanel66Layout.createSequentialGroup()
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jScrollPane45, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(kembaliDokter)
                .addGap(27, 27, 27))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel66, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
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
            laporanDataDokter.setModel(tabel); 
        } 
        
        catch(Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    private void cetakDataDokterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cetakDataDokterActionPerformed
        Map<String, Object> parameters = new HashMap<>();
        
        try {
            JasperPrint JP = JasperFillManager.fillReport("src/laporan/laporan_dokter.jasper", parameters, koneksi_db.sambung_db());
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
            java.util.logging.Logger.getLogger(Laporan_dokter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Laporan_dokter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Laporan_dokter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Laporan_dokter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Laporan_dokter().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnDelete1;
    private javax.swing.JButton btnDelete10;
    private javax.swing.JButton btnDelete11;
    private javax.swing.JButton btnDelete12;
    private javax.swing.JButton btnDelete13;
    private javax.swing.JButton btnDelete14;
    private javax.swing.JButton btnDelete15;
    private javax.swing.JButton btnDelete16;
    private javax.swing.JButton btnDelete17;
    private javax.swing.JButton btnDelete18;
    private javax.swing.JButton btnDelete19;
    private javax.swing.JButton btnDelete2;
    private javax.swing.JButton btnDelete20;
    private javax.swing.JButton btnDelete3;
    private javax.swing.JButton btnDelete4;
    private javax.swing.JButton btnDelete5;
    private javax.swing.JButton btnDelete6;
    private javax.swing.JButton btnDelete7;
    private javax.swing.JButton btnDelete8;
    private javax.swing.JButton btnDelete9;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnEdit1;
    private javax.swing.JButton btnEdit10;
    private javax.swing.JButton btnEdit11;
    private javax.swing.JButton btnEdit12;
    private javax.swing.JButton btnEdit13;
    private javax.swing.JButton btnEdit14;
    private javax.swing.JButton btnEdit15;
    private javax.swing.JButton btnEdit16;
    private javax.swing.JButton btnEdit17;
    private javax.swing.JButton btnEdit18;
    private javax.swing.JButton btnEdit19;
    private javax.swing.JButton btnEdit2;
    private javax.swing.JButton btnEdit20;
    private javax.swing.JButton btnEdit3;
    private javax.swing.JButton btnEdit4;
    private javax.swing.JButton btnEdit5;
    private javax.swing.JButton btnEdit6;
    private javax.swing.JButton btnEdit7;
    private javax.swing.JButton btnEdit8;
    private javax.swing.JButton btnEdit9;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnReset1;
    private javax.swing.JButton btnReset10;
    private javax.swing.JButton btnReset11;
    private javax.swing.JButton btnReset12;
    private javax.swing.JButton btnReset13;
    private javax.swing.JButton btnReset14;
    private javax.swing.JButton btnReset15;
    private javax.swing.JButton btnReset16;
    private javax.swing.JButton btnReset17;
    private javax.swing.JButton btnReset18;
    private javax.swing.JButton btnReset19;
    private javax.swing.JButton btnReset2;
    private javax.swing.JButton btnReset20;
    private javax.swing.JButton btnReset3;
    private javax.swing.JButton btnReset4;
    private javax.swing.JButton btnReset5;
    private javax.swing.JButton btnReset6;
    private javax.swing.JButton btnReset7;
    private javax.swing.JButton btnReset8;
    private javax.swing.JButton btnReset9;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSave1;
    private javax.swing.JButton btnSave10;
    private javax.swing.JButton btnSave11;
    private javax.swing.JButton btnSave12;
    private javax.swing.JButton btnSave13;
    private javax.swing.JButton btnSave14;
    private javax.swing.JButton btnSave15;
    private javax.swing.JButton btnSave16;
    private javax.swing.JButton btnSave17;
    private javax.swing.JButton btnSave18;
    private javax.swing.JButton btnSave19;
    private javax.swing.JButton btnSave2;
    private javax.swing.JButton btnSave20;
    private javax.swing.JButton btnSave3;
    private javax.swing.JButton btnSave4;
    private javax.swing.JButton btnSave5;
    private javax.swing.JButton btnSave6;
    private javax.swing.JButton btnSave7;
    private javax.swing.JButton btnSave8;
    private javax.swing.JButton btnSave9;
    private javax.swing.JButton cariData;
    private javax.swing.JButton cariData1;
    private javax.swing.JButton cariData10;
    private javax.swing.JButton cariData11;
    private javax.swing.JButton cariData12;
    private javax.swing.JButton cariData13;
    private javax.swing.JButton cariData14;
    private javax.swing.JButton cariData15;
    private javax.swing.JButton cariData16;
    private javax.swing.JButton cariData17;
    private javax.swing.JButton cariData18;
    private javax.swing.JButton cariData19;
    private javax.swing.JButton cariData2;
    private javax.swing.JButton cariData20;
    private javax.swing.JButton cariData21;
    private javax.swing.JButton cariData22;
    private javax.swing.JButton cariData23;
    private javax.swing.JButton cariData24;
    private javax.swing.JButton cariData25;
    private javax.swing.JButton cariData26;
    private javax.swing.JButton cariData27;
    private javax.swing.JButton cariData28;
    private javax.swing.JButton cariData29;
    private javax.swing.JButton cariData3;
    private javax.swing.JButton cariData30;
    private javax.swing.JButton cariData31;
    private javax.swing.JButton cariData32;
    private javax.swing.JButton cariData33;
    private javax.swing.JButton cariData34;
    private javax.swing.JButton cariData35;
    private javax.swing.JButton cariData36;
    private javax.swing.JButton cariData37;
    private javax.swing.JButton cariData38;
    private javax.swing.JButton cariData39;
    private javax.swing.JButton cariData4;
    private javax.swing.JButton cariData40;
    private javax.swing.JButton cariData41;
    private javax.swing.JButton cariData42;
    private javax.swing.JButton cariData43;
    private javax.swing.JButton cariData5;
    private javax.swing.JButton cariData6;
    private javax.swing.JButton cariData7;
    private javax.swing.JButton cariData8;
    private javax.swing.JButton cariData9;
    private javax.swing.JButton cetakDataDokter;
    private javax.swing.JTable dataDokter;
    private javax.swing.JTable dataDokter1;
    private javax.swing.JTable dataDokter10;
    private javax.swing.JTable dataDokter11;
    private javax.swing.JTable dataDokter12;
    private javax.swing.JTable dataDokter13;
    private javax.swing.JTable dataDokter14;
    private javax.swing.JTable dataDokter15;
    private javax.swing.JTable dataDokter16;
    private javax.swing.JTable dataDokter17;
    private javax.swing.JTable dataDokter18;
    private javax.swing.JTable dataDokter19;
    private javax.swing.JTable dataDokter2;
    private javax.swing.JTable dataDokter20;
    private javax.swing.JTable dataDokter3;
    private javax.swing.JTable dataDokter4;
    private javax.swing.JTable dataDokter5;
    private javax.swing.JTable dataDokter6;
    private javax.swing.JTable dataDokter7;
    private javax.swing.JTable dataDokter8;
    private javax.swing.JTable dataDokter9;
    private javax.swing.JTable dataPasien;
    private javax.swing.JTable dataPasien1;
    private javax.swing.JTable dataPasien10;
    private javax.swing.JTable dataPasien11;
    private javax.swing.JTable dataPasien12;
    private javax.swing.JTable dataPasien13;
    private javax.swing.JTable dataPasien14;
    private javax.swing.JTable dataPasien15;
    private javax.swing.JTable dataPasien16;
    private javax.swing.JTable dataPasien17;
    private javax.swing.JTable dataPasien18;
    private javax.swing.JTable dataPasien19;
    private javax.swing.JTable dataPasien2;
    private javax.swing.JTable dataPasien20;
    private javax.swing.JTable dataPasien21;
    private javax.swing.JTable dataPasien22;
    private javax.swing.JTable dataPasien3;
    private javax.swing.JTable dataPasien4;
    private javax.swing.JTable dataPasien5;
    private javax.swing.JTable dataPasien6;
    private javax.swing.JTable dataPasien7;
    private javax.swing.JTable dataPasien8;
    private javax.swing.JTable dataPasien9;
    private javax.swing.JLabel harga;
    private javax.swing.JLabel harga1;
    private javax.swing.JLabel harga10;
    private javax.swing.JLabel harga11;
    private javax.swing.JLabel harga12;
    private javax.swing.JLabel harga13;
    private javax.swing.JLabel harga14;
    private javax.swing.JLabel harga15;
    private javax.swing.JLabel harga16;
    private javax.swing.JLabel harga17;
    private javax.swing.JLabel harga18;
    private javax.swing.JLabel harga19;
    private javax.swing.JLabel harga2;
    private javax.swing.JLabel harga20;
    private javax.swing.JLabel harga3;
    private javax.swing.JLabel harga4;
    private javax.swing.JLabel harga5;
    private javax.swing.JLabel harga6;
    private javax.swing.JLabel harga7;
    private javax.swing.JLabel harga8;
    private javax.swing.JLabel harga9;
    private javax.swing.JTextField inputAlamat;
    private javax.swing.JTextField inputAlamat1;
    private javax.swing.JTextField inputAlamat10;
    private javax.swing.JTextField inputAlamat11;
    private javax.swing.JTextField inputAlamat12;
    private javax.swing.JTextField inputAlamat13;
    private javax.swing.JTextField inputAlamat14;
    private javax.swing.JTextField inputAlamat15;
    private javax.swing.JTextField inputAlamat16;
    private javax.swing.JTextField inputAlamat17;
    private javax.swing.JTextField inputAlamat18;
    private javax.swing.JTextField inputAlamat19;
    private javax.swing.JTextField inputAlamat2;
    private javax.swing.JTextField inputAlamat20;
    private javax.swing.JTextField inputAlamat3;
    private javax.swing.JTextField inputAlamat4;
    private javax.swing.JTextField inputAlamat5;
    private javax.swing.JTextField inputAlamat6;
    private javax.swing.JTextField inputAlamat7;
    private javax.swing.JTextField inputAlamat8;
    private javax.swing.JTextField inputAlamat9;
    private javax.swing.JTextField inputIdDokter;
    private javax.swing.JTextField inputIdDokter1;
    private javax.swing.JTextField inputIdDokter10;
    private javax.swing.JTextField inputIdDokter11;
    private javax.swing.JTextField inputIdDokter12;
    private javax.swing.JTextField inputIdDokter13;
    private javax.swing.JTextField inputIdDokter14;
    private javax.swing.JTextField inputIdDokter15;
    private javax.swing.JTextField inputIdDokter16;
    private javax.swing.JTextField inputIdDokter17;
    private javax.swing.JTextField inputIdDokter18;
    private javax.swing.JTextField inputIdDokter19;
    private javax.swing.JTextField inputIdDokter2;
    private javax.swing.JTextField inputIdDokter20;
    private javax.swing.JTextField inputIdDokter3;
    private javax.swing.JTextField inputIdDokter4;
    private javax.swing.JTextField inputIdDokter5;
    private javax.swing.JTextField inputIdDokter6;
    private javax.swing.JTextField inputIdDokter7;
    private javax.swing.JTextField inputIdDokter8;
    private javax.swing.JTextField inputIdDokter9;
    private javax.swing.JComboBox<String> inputJenisKelamin;
    private javax.swing.JComboBox<String> inputJenisKelamin1;
    private javax.swing.JComboBox<String> inputJenisKelamin10;
    private javax.swing.JComboBox<String> inputJenisKelamin11;
    private javax.swing.JComboBox<String> inputJenisKelamin12;
    private javax.swing.JComboBox<String> inputJenisKelamin13;
    private javax.swing.JComboBox<String> inputJenisKelamin14;
    private javax.swing.JComboBox<String> inputJenisKelamin15;
    private javax.swing.JComboBox<String> inputJenisKelamin16;
    private javax.swing.JComboBox<String> inputJenisKelamin17;
    private javax.swing.JComboBox<String> inputJenisKelamin18;
    private javax.swing.JComboBox<String> inputJenisKelamin19;
    private javax.swing.JComboBox<String> inputJenisKelamin2;
    private javax.swing.JComboBox<String> inputJenisKelamin20;
    private javax.swing.JComboBox<String> inputJenisKelamin3;
    private javax.swing.JComboBox<String> inputJenisKelamin4;
    private javax.swing.JComboBox<String> inputJenisKelamin5;
    private javax.swing.JComboBox<String> inputJenisKelamin6;
    private javax.swing.JComboBox<String> inputJenisKelamin7;
    private javax.swing.JComboBox<String> inputJenisKelamin8;
    private javax.swing.JComboBox<String> inputJenisKelamin9;
    private javax.swing.JTextField inputNamaDokter;
    private javax.swing.JTextField inputNamaDokter1;
    private javax.swing.JTextField inputNamaDokter10;
    private javax.swing.JTextField inputNamaDokter11;
    private javax.swing.JTextField inputNamaDokter12;
    private javax.swing.JTextField inputNamaDokter13;
    private javax.swing.JTextField inputNamaDokter14;
    private javax.swing.JTextField inputNamaDokter15;
    private javax.swing.JTextField inputNamaDokter16;
    private javax.swing.JTextField inputNamaDokter17;
    private javax.swing.JTextField inputNamaDokter18;
    private javax.swing.JTextField inputNamaDokter19;
    private javax.swing.JTextField inputNamaDokter2;
    private javax.swing.JTextField inputNamaDokter20;
    private javax.swing.JTextField inputNamaDokter3;
    private javax.swing.JTextField inputNamaDokter4;
    private javax.swing.JTextField inputNamaDokter5;
    private javax.swing.JTextField inputNamaDokter6;
    private javax.swing.JTextField inputNamaDokter7;
    private javax.swing.JTextField inputNamaDokter8;
    private javax.swing.JTextField inputNamaDokter9;
    private javax.swing.JComboBox<String> inputSpesialis;
    private javax.swing.JComboBox<String> inputSpesialis1;
    private javax.swing.JComboBox<String> inputSpesialis10;
    private javax.swing.JComboBox<String> inputSpesialis11;
    private javax.swing.JComboBox<String> inputSpesialis12;
    private javax.swing.JComboBox<String> inputSpesialis13;
    private javax.swing.JComboBox<String> inputSpesialis14;
    private javax.swing.JComboBox<String> inputSpesialis15;
    private javax.swing.JComboBox<String> inputSpesialis16;
    private javax.swing.JComboBox<String> inputSpesialis17;
    private javax.swing.JComboBox<String> inputSpesialis18;
    private javax.swing.JComboBox<String> inputSpesialis19;
    private javax.swing.JComboBox<String> inputSpesialis2;
    private javax.swing.JComboBox<String> inputSpesialis20;
    private javax.swing.JComboBox<String> inputSpesialis3;
    private javax.swing.JComboBox<String> inputSpesialis4;
    private javax.swing.JComboBox<String> inputSpesialis5;
    private javax.swing.JComboBox<String> inputSpesialis6;
    private javax.swing.JComboBox<String> inputSpesialis7;
    private javax.swing.JComboBox<String> inputSpesialis8;
    private javax.swing.JComboBox<String> inputSpesialis9;
    private javax.swing.JTextField inputTglLahir;
    private javax.swing.JTextField inputTglLahir1;
    private javax.swing.JTextField inputTglLahir10;
    private javax.swing.JTextField inputTglLahir11;
    private javax.swing.JTextField inputTglLahir12;
    private javax.swing.JTextField inputTglLahir13;
    private javax.swing.JTextField inputTglLahir14;
    private javax.swing.JTextField inputTglLahir15;
    private javax.swing.JTextField inputTglLahir16;
    private javax.swing.JTextField inputTglLahir17;
    private javax.swing.JTextField inputTglLahir18;
    private javax.swing.JTextField inputTglLahir19;
    private javax.swing.JTextField inputTglLahir2;
    private javax.swing.JTextField inputTglLahir20;
    private javax.swing.JTextField inputTglLahir3;
    private javax.swing.JTextField inputTglLahir4;
    private javax.swing.JTextField inputTglLahir5;
    private javax.swing.JTextField inputTglLahir6;
    private javax.swing.JTextField inputTglLahir7;
    private javax.swing.JTextField inputTglLahir8;
    private javax.swing.JTextField inputTglLahir9;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel39;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel40;
    private javax.swing.JPanel jPanel41;
    private javax.swing.JPanel jPanel42;
    private javax.swing.JPanel jPanel43;
    private javax.swing.JPanel jPanel44;
    private javax.swing.JPanel jPanel45;
    private javax.swing.JPanel jPanel46;
    private javax.swing.JPanel jPanel47;
    private javax.swing.JPanel jPanel48;
    private javax.swing.JPanel jPanel49;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel50;
    private javax.swing.JPanel jPanel51;
    private javax.swing.JPanel jPanel52;
    private javax.swing.JPanel jPanel53;
    private javax.swing.JPanel jPanel54;
    private javax.swing.JPanel jPanel55;
    private javax.swing.JPanel jPanel56;
    private javax.swing.JPanel jPanel57;
    private javax.swing.JPanel jPanel58;
    private javax.swing.JPanel jPanel59;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel60;
    private javax.swing.JPanel jPanel61;
    private javax.swing.JPanel jPanel62;
    private javax.swing.JPanel jPanel63;
    private javax.swing.JPanel jPanel64;
    private javax.swing.JPanel jPanel65;
    private javax.swing.JPanel jPanel66;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane17;
    private javax.swing.JScrollPane jScrollPane18;
    private javax.swing.JScrollPane jScrollPane19;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane20;
    private javax.swing.JScrollPane jScrollPane21;
    private javax.swing.JScrollPane jScrollPane22;
    private javax.swing.JScrollPane jScrollPane23;
    private javax.swing.JScrollPane jScrollPane24;
    private javax.swing.JScrollPane jScrollPane25;
    private javax.swing.JScrollPane jScrollPane26;
    private javax.swing.JScrollPane jScrollPane27;
    private javax.swing.JScrollPane jScrollPane28;
    private javax.swing.JScrollPane jScrollPane29;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane30;
    private javax.swing.JScrollPane jScrollPane31;
    private javax.swing.JScrollPane jScrollPane32;
    private javax.swing.JScrollPane jScrollPane33;
    private javax.swing.JScrollPane jScrollPane34;
    private javax.swing.JScrollPane jScrollPane35;
    private javax.swing.JScrollPane jScrollPane36;
    private javax.swing.JScrollPane jScrollPane37;
    private javax.swing.JScrollPane jScrollPane38;
    private javax.swing.JScrollPane jScrollPane39;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane40;
    private javax.swing.JScrollPane jScrollPane41;
    private javax.swing.JScrollPane jScrollPane42;
    private javax.swing.JScrollPane jScrollPane43;
    private javax.swing.JScrollPane jScrollPane44;
    private javax.swing.JScrollPane jScrollPane45;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JComboBox<String> jenisData;
    private javax.swing.JComboBox<String> jenisData1;
    private javax.swing.JComboBox<String> jenisData10;
    private javax.swing.JComboBox<String> jenisData11;
    private javax.swing.JComboBox<String> jenisData12;
    private javax.swing.JComboBox<String> jenisData13;
    private javax.swing.JComboBox<String> jenisData14;
    private javax.swing.JComboBox<String> jenisData15;
    private javax.swing.JComboBox<String> jenisData16;
    private javax.swing.JComboBox<String> jenisData17;
    private javax.swing.JComboBox<String> jenisData18;
    private javax.swing.JComboBox<String> jenisData19;
    private javax.swing.JComboBox<String> jenisData2;
    private javax.swing.JComboBox<String> jenisData20;
    private javax.swing.JComboBox<String> jenisData3;
    private javax.swing.JComboBox<String> jenisData4;
    private javax.swing.JComboBox<String> jenisData5;
    private javax.swing.JComboBox<String> jenisData6;
    private javax.swing.JComboBox<String> jenisData7;
    private javax.swing.JComboBox<String> jenisData8;
    private javax.swing.JComboBox<String> jenisData9;
    private javax.swing.JLabel jenisObat;
    private javax.swing.JLabel jenisObat1;
    private javax.swing.JLabel jenisObat10;
    private javax.swing.JLabel jenisObat11;
    private javax.swing.JLabel jenisObat12;
    private javax.swing.JLabel jenisObat13;
    private javax.swing.JLabel jenisObat14;
    private javax.swing.JLabel jenisObat15;
    private javax.swing.JLabel jenisObat16;
    private javax.swing.JLabel jenisObat17;
    private javax.swing.JLabel jenisObat18;
    private javax.swing.JLabel jenisObat19;
    private javax.swing.JLabel jenisObat2;
    private javax.swing.JLabel jenisObat20;
    private javax.swing.JLabel jenisObat3;
    private javax.swing.JLabel jenisObat4;
    private javax.swing.JLabel jenisObat5;
    private javax.swing.JLabel jenisObat6;
    private javax.swing.JLabel jenisObat7;
    private javax.swing.JLabel jenisObat8;
    private javax.swing.JLabel jenisObat9;
    private javax.swing.JToggleButton kembali;
    private javax.swing.JToggleButton kembali1;
    private javax.swing.JToggleButton kembali10;
    private javax.swing.JToggleButton kembali11;
    private javax.swing.JToggleButton kembali12;
    private javax.swing.JToggleButton kembali13;
    private javax.swing.JToggleButton kembali14;
    private javax.swing.JToggleButton kembali15;
    private javax.swing.JToggleButton kembali16;
    private javax.swing.JToggleButton kembali17;
    private javax.swing.JToggleButton kembali18;
    private javax.swing.JToggleButton kembali19;
    private javax.swing.JToggleButton kembali2;
    private javax.swing.JToggleButton kembali20;
    private javax.swing.JToggleButton kembali21;
    private javax.swing.JToggleButton kembali22;
    private javax.swing.JToggleButton kembali23;
    private javax.swing.JToggleButton kembali24;
    private javax.swing.JToggleButton kembali25;
    private javax.swing.JToggleButton kembali26;
    private javax.swing.JToggleButton kembali27;
    private javax.swing.JToggleButton kembali28;
    private javax.swing.JToggleButton kembali29;
    private javax.swing.JToggleButton kembali3;
    private javax.swing.JToggleButton kembali30;
    private javax.swing.JToggleButton kembali31;
    private javax.swing.JToggleButton kembali32;
    private javax.swing.JToggleButton kembali33;
    private javax.swing.JToggleButton kembali34;
    private javax.swing.JToggleButton kembali35;
    private javax.swing.JToggleButton kembali36;
    private javax.swing.JToggleButton kembali37;
    private javax.swing.JToggleButton kembali38;
    private javax.swing.JToggleButton kembali39;
    private javax.swing.JToggleButton kembali4;
    private javax.swing.JToggleButton kembali40;
    private javax.swing.JToggleButton kembali41;
    private javax.swing.JToggleButton kembali42;
    private javax.swing.JToggleButton kembali43;
    private javax.swing.JToggleButton kembali5;
    private javax.swing.JToggleButton kembali6;
    private javax.swing.JToggleButton kembali7;
    private javax.swing.JToggleButton kembali8;
    private javax.swing.JToggleButton kembali9;
    private javax.swing.JToggleButton kembaliDokter;
    private javax.swing.JTextField kolomCari;
    private javax.swing.JTextField kolomCari1;
    private javax.swing.JTextField kolomCari10;
    private javax.swing.JTextField kolomCari11;
    private javax.swing.JTextField kolomCari12;
    private javax.swing.JTextField kolomCari13;
    private javax.swing.JTextField kolomCari14;
    private javax.swing.JTextField kolomCari15;
    private javax.swing.JTextField kolomCari16;
    private javax.swing.JTextField kolomCari17;
    private javax.swing.JTextField kolomCari18;
    private javax.swing.JTextField kolomCari19;
    private javax.swing.JTextField kolomCari2;
    private javax.swing.JTextField kolomCari20;
    private javax.swing.JTextField kolomCari3;
    private javax.swing.JTextField kolomCari4;
    private javax.swing.JTextField kolomCari5;
    private javax.swing.JTextField kolomCari6;
    private javax.swing.JTextField kolomCari7;
    private javax.swing.JTextField kolomCari8;
    private javax.swing.JTextField kolomCari9;
    private javax.swing.JTable laporanDataDokter;
    private javax.swing.JLabel namaObat;
    private javax.swing.JLabel namaObat1;
    private javax.swing.JLabel namaObat10;
    private javax.swing.JLabel namaObat11;
    private javax.swing.JLabel namaObat12;
    private javax.swing.JLabel namaObat13;
    private javax.swing.JLabel namaObat14;
    private javax.swing.JLabel namaObat15;
    private javax.swing.JLabel namaObat16;
    private javax.swing.JLabel namaObat17;
    private javax.swing.JLabel namaObat18;
    private javax.swing.JLabel namaObat19;
    private javax.swing.JLabel namaObat2;
    private javax.swing.JLabel namaObat20;
    private javax.swing.JLabel namaObat21;
    private javax.swing.JLabel namaObat22;
    private javax.swing.JLabel namaObat23;
    private javax.swing.JLabel namaObat24;
    private javax.swing.JLabel namaObat25;
    private javax.swing.JLabel namaObat26;
    private javax.swing.JLabel namaObat27;
    private javax.swing.JLabel namaObat28;
    private javax.swing.JLabel namaObat29;
    private javax.swing.JLabel namaObat3;
    private javax.swing.JLabel namaObat30;
    private javax.swing.JLabel namaObat31;
    private javax.swing.JLabel namaObat32;
    private javax.swing.JLabel namaObat33;
    private javax.swing.JLabel namaObat34;
    private javax.swing.JLabel namaObat35;
    private javax.swing.JLabel namaObat36;
    private javax.swing.JLabel namaObat37;
    private javax.swing.JLabel namaObat38;
    private javax.swing.JLabel namaObat39;
    private javax.swing.JLabel namaObat4;
    private javax.swing.JLabel namaObat40;
    private javax.swing.JLabel namaObat41;
    private javax.swing.JLabel namaObat5;
    private javax.swing.JLabel namaObat6;
    private javax.swing.JLabel namaObat7;
    private javax.swing.JLabel namaObat8;
    private javax.swing.JLabel namaObat9;
    private javax.swing.JLabel satuan;
    private javax.swing.JLabel satuan1;
    private javax.swing.JLabel satuan10;
    private javax.swing.JLabel satuan11;
    private javax.swing.JLabel satuan12;
    private javax.swing.JLabel satuan13;
    private javax.swing.JLabel satuan14;
    private javax.swing.JLabel satuan15;
    private javax.swing.JLabel satuan16;
    private javax.swing.JLabel satuan17;
    private javax.swing.JLabel satuan18;
    private javax.swing.JLabel satuan19;
    private javax.swing.JLabel satuan2;
    private javax.swing.JLabel satuan20;
    private javax.swing.JLabel satuan3;
    private javax.swing.JLabel satuan4;
    private javax.swing.JLabel satuan5;
    private javax.swing.JLabel satuan6;
    private javax.swing.JLabel satuan7;
    private javax.swing.JLabel satuan8;
    private javax.swing.JLabel satuan9;
    private javax.swing.JLabel stok;
    private javax.swing.JLabel stok1;
    private javax.swing.JLabel stok10;
    private javax.swing.JLabel stok11;
    private javax.swing.JLabel stok12;
    private javax.swing.JLabel stok13;
    private javax.swing.JLabel stok14;
    private javax.swing.JLabel stok15;
    private javax.swing.JLabel stok16;
    private javax.swing.JLabel stok17;
    private javax.swing.JLabel stok18;
    private javax.swing.JLabel stok19;
    private javax.swing.JLabel stok2;
    private javax.swing.JLabel stok20;
    private javax.swing.JLabel stok3;
    private javax.swing.JLabel stok4;
    private javax.swing.JLabel stok5;
    private javax.swing.JLabel stok6;
    private javax.swing.JLabel stok7;
    private javax.swing.JLabel stok8;
    private javax.swing.JLabel stok9;
    // End of variables declaration//GEN-END:variables
}
