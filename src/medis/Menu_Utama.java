package medis;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class Menu_Utama extends javax.swing.JFrame {

    public Menu_Utama() {
        Locale locale = new Locale ("id","ID");
        Locale.setDefault(locale);
        
        initComponents();
        tanggal();
        waktu();
    }
    
    private void tanggal() {
        java.util.Date tglsekarang = new java.util.Date();
        SimpleDateFormat smpdtfmt = new SimpleDateFormat("dd MMMMMMMMM yyyy", Locale.getDefault());
        String kalender = smpdtfmt.format(tglsekarang);
        tanggal.setText(kalender);
    }
    
    private void waktu() {
        ActionListener taskPerformer = new ActionListener() {
 
        @Override
            public void actionPerformed(ActionEvent evt) {
            String nol_jam = "", nol_menit = "",nol_detik = "";
 
            java.util.Date dateTime = new java.util.Date();
            int nilai_jam = dateTime.getHours();
            int nilai_menit = dateTime.getMinutes();
            int nilai_detik = dateTime.getSeconds();
 
            if(nilai_jam <= 9) nol_jam= "0";
            if(nilai_menit <= 9) nol_menit= "0";
            if(nilai_detik <= 9) nol_detik= "0";
 
            String jam = nol_jam + Integer.toString(nilai_jam);
            String menit = nol_menit + Integer.toString(nilai_menit);
            String detik = nol_detik + Integer.toString(nilai_detik);
 
            waktu.setText(jam+":"+menit+":"+detik+"");
            }
        };
        new Timer(1000, taskPerformer).start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        exit = new javax.swing.JToggleButton();
        jLabel2 = new javax.swing.JLabel();
        tanggal = new javax.swing.JLabel();
        waktu = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        pendataanObat = new javax.swing.JMenu();
        dataObat = new javax.swing.JMenuItem();
        dataPasien = new javax.swing.JMenuItem();
        dataDokter = new javax.swing.JMenuItem();
        dataRekamMedis = new javax.swing.JMenuItem();
        laporanData = new javax.swing.JMenu();
        laporanObat = new javax.swing.JMenuItem();
        laporanPasien = new javax.swing.JMenuItem();
        laporanDokter = new javax.swing.JMenuItem();
        laporanRekamMedis = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SI Rekam Medis | Dashboard");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 153));
        jLabel1.setText("SISTEM INFORMASI REKAM MEDIS");

        exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ikon/arrow_left.png"))); // NOI18N
        exit.setText("Keluar");
        exit.setFocusable(false);
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 153, 153));
        jLabel2.setText("KLINIK UMUM ABC");

        tanggal.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        tanggal.setForeground(new java.awt.Color(0, 153, 153));
        tanggal.setText("Tanggal");

        waktu.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        waktu.setForeground(new java.awt.Color(0, 153, 153));
        waktu.setText("Waktu");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tanggal)
                            .addComponent(waktu))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(exit, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addContainerGap(477, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 136, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(exit)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(tanggal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(waktu)))
                .addGap(20, 20, 20))
        );

        jMenuBar1.setBackground(new java.awt.Color(255, 255, 255));

        pendataanObat.setText("Master Menu");

        dataObat.setText("Pendataan Obat");
        dataObat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dataObatActionPerformed(evt);
            }
        });
        pendataanObat.add(dataObat);

        dataPasien.setText("Pendataan Pasien");
        dataPasien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dataPasienActionPerformed(evt);
            }
        });
        pendataanObat.add(dataPasien);

        dataDokter.setText("Pendataan Dokter");
        dataDokter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dataDokterActionPerformed(evt);
            }
        });
        pendataanObat.add(dataDokter);

        dataRekamMedis.setText("Pendataan Rekam Medis");
        dataRekamMedis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dataRekamMedisActionPerformed(evt);
            }
        });
        pendataanObat.add(dataRekamMedis);

        jMenuBar1.add(pendataanObat);

        laporanData.setText("Laporan");

        laporanObat.setText("Laporan Obat");
        laporanObat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                laporanObatActionPerformed(evt);
            }
        });
        laporanData.add(laporanObat);

        laporanPasien.setText("Laporan Pasien");
        laporanPasien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                laporanPasienActionPerformed(evt);
            }
        });
        laporanData.add(laporanPasien);

        laporanDokter.setText("Laporan Dokter");
        laporanDokter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                laporanDokterActionPerformed(evt);
            }
        });
        laporanData.add(laporanDokter);

        laporanRekamMedis.setText("Laporan Rekam Medis");
        laporanRekamMedis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                laporanRekamMedisActionPerformed(evt);
            }
        });
        laporanData.add(laporanRekamMedis);

        jMenuBar1.add(laporanData);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        int konfirm = JOptionPane.showConfirmDialog(null, "Keluar dari aplikasi?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        
        if(konfirm == 0) {
            setVisible(false);
            new Login_admin().setVisible(true);
        }
    }//GEN-LAST:event_exitActionPerformed

    private void dataPasienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dataPasienActionPerformed
        new Data_Pasien().setVisible(true);
        dispose();
    }//GEN-LAST:event_dataPasienActionPerformed

    private void dataObatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dataObatActionPerformed
        new Data_Obat().setVisible(true);
        dispose();
    }//GEN-LAST:event_dataObatActionPerformed

    private void dataDokterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dataDokterActionPerformed
        new Data_Dokter().setVisible(true);
        dispose();
    }//GEN-LAST:event_dataDokterActionPerformed

    private void laporanObatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_laporanObatActionPerformed
        new Laporan_obat().setVisible(true);
        dispose();
    }//GEN-LAST:event_laporanObatActionPerformed

    private void laporanPasienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_laporanPasienActionPerformed
        new Laporan_pasien().setVisible(true);
        dispose();
    }//GEN-LAST:event_laporanPasienActionPerformed

    private void laporanDokterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_laporanDokterActionPerformed
        new Laporan_dokter().setVisible(true);
        dispose();
    }//GEN-LAST:event_laporanDokterActionPerformed

    private void laporanRekamMedisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_laporanRekamMedisActionPerformed
        new Laporan_rekam_medis().setVisible(true);
        dispose();
    }//GEN-LAST:event_laporanRekamMedisActionPerformed

    private void dataRekamMedisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dataRekamMedisActionPerformed
        new Rekam_medis().setVisible(true);
        dispose();
    }//GEN-LAST:event_dataRekamMedisActionPerformed

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
            java.util.logging.Logger.getLogger(Menu_Utama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu_Utama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu_Utama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu_Utama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu_Utama().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem dataDokter;
    private javax.swing.JMenuItem dataObat;
    private javax.swing.JMenuItem dataPasien;
    private javax.swing.JMenuItem dataRekamMedis;
    private javax.swing.JToggleButton exit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JMenu laporanData;
    private javax.swing.JMenuItem laporanDokter;
    private javax.swing.JMenuItem laporanObat;
    private javax.swing.JMenuItem laporanPasien;
    private javax.swing.JMenuItem laporanRekamMedis;
    private javax.swing.JMenu pendataanObat;
    private javax.swing.JLabel tanggal;
    private javax.swing.JLabel waktu;
    // End of variables declaration//GEN-END:variables
}
