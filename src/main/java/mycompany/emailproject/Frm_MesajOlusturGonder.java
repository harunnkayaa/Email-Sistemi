/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package mycompany.emailproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author harnk
 */
public class Frm_MesajOlusturGonder extends javax.swing.JFrame {

    /**
     * Creates new form Frm_MesajOlusturGonder
     */
    DefaultTableModel tbl_mailler_model;
    Kullanici kullanici;

    public Frm_MesajOlusturGonder(Kullanici person) {
        initComponents();

        this.kullanici = person;
        tbl_mailler_model = new DefaultTableModel();
        tbl_mailler_model.setColumnIdentifiers(new Object[]{"Kime", "Konu", "Gönderilen mail", "Mail Türü"});
        jtbl_Mailler.setModel(tbl_mailler_model);
        fillTableWithMessages();

        jPanel1.setVisible(true);
        jPanel2.setVisible(true);
        jLabel1.setVisible(false);
        jLabel2.setVisible(false);
        btn_mailGonder.setVisible(false);
        jScrollPane1.setVisible(false);
        rbtn_yildizliMesaj.setVisible(false);
        tbpn_gonderilenMailler.setVisible(false);
        txt_emailKime.setVisible(false);
        txt_emailKonu.setVisible(false);
        txt_emailMesaji.setVisible(false);

        btn_MailOlustur.setVisible(true);
        tbpn_gonderilenMailler.setVisible(true);
        tbpn_gonderilenMailler.setVisible(true);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tbpn_gonderilenMailler = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_emailMesaji = new javax.swing.JTextArea();
        txt_emailKime = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_emailKonu = new javax.swing.JTextField();
        btn_MailOlustur = new javax.swing.JButton();
        btn_mailGonder = new javax.swing.JButton();
        rbtn_yildizliMesaj = new javax.swing.JRadioButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtbl_Mailler = new javax.swing.JTable();
        btn_mailiSil = new javax.swing.JButton();
        btn_yildiziKaldir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 255));
        setMinimumSize(new java.awt.Dimension(375, 580));

        tbpn_gonderilenMailler.setBackground(new java.awt.Color(204, 204, 255));
        tbpn_gonderilenMailler.setMinimumSize(new java.awt.Dimension(375, 580));
        tbpn_gonderilenMailler.setPreferredSize(new java.awt.Dimension(375, 580));

        jPanel2.setBackground(new java.awt.Color(255, 204, 153));
        jPanel2.setMinimumSize(new java.awt.Dimension(375, 580));
        jPanel2.setPreferredSize(new java.awt.Dimension(375, 580));

        txt_emailMesaji.setBackground(new java.awt.Color(204, 204, 255));
        txt_emailMesaji.setColumns(20);
        txt_emailMesaji.setRows(5);
        jScrollPane1.setViewportView(txt_emailMesaji);

        txt_emailKime.setBackground(new java.awt.Color(204, 204, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel1.setText("KİME");

        jLabel2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel2.setText("KONU");

        txt_emailKonu.setBackground(new java.awt.Color(204, 204, 255));

        btn_MailOlustur.setBackground(new java.awt.Color(204, 204, 255));
        btn_MailOlustur.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        btn_MailOlustur.setText("Mail Oluştur");
        btn_MailOlustur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_MailOlusturActionPerformed(evt);
            }
        });

        btn_mailGonder.setBackground(new java.awt.Color(204, 204, 255));
        btn_mailGonder.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        btn_mailGonder.setText("Mail Gönder");
        btn_mailGonder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_mailGonderActionPerformed(evt);
            }
        });

        rbtn_yildizliMesaj.setBackground(new java.awt.Color(204, 204, 255));
        rbtn_yildizliMesaj.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        rbtn_yildizliMesaj.setText("Yıldızlı Mail Olarak İşaretle");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_mailGonder, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel1))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txt_emailKime, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                                .addComponent(txt_emailKonu)))
                        .addComponent(btn_MailOlustur, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(rbtn_yildizliMesaj, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(66, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(btn_MailOlustur)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_emailKime, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_emailKonu, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(16, 16, 16)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rbtn_yildizliMesaj)
                .addGap(18, 18, 18)
                .addComponent(btn_mailGonder, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 491, Short.MAX_VALUE)
                .addContainerGap())
        );

        tbpn_gonderilenMailler.addTab("Mail Gönder", jPanel1);

        jPanel4.setBackground(new java.awt.Color(204, 204, 255));

        jtbl_Mailler.setBackground(new java.awt.Color(255, 204, 153));
        jtbl_Mailler.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Kime", "Konu", "Gönderilen mail", "Mail Türü"
            }
        ));
        jScrollPane2.setViewportView(jtbl_Mailler);

        btn_mailiSil.setBackground(new java.awt.Color(255, 204, 153));
        btn_mailiSil.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        btn_mailiSil.setText("Maili Sil");
        btn_mailiSil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_mailiSilActionPerformed(evt);
            }
        });

        btn_yildiziKaldir.setBackground(new java.awt.Color(255, 204, 153));
        btn_yildiziKaldir.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        btn_yildiziKaldir.setText("Yıldızı Kaldır");
        btn_yildiziKaldir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_yildiziKaldirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(btn_mailiSil, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_yildiziKaldir)
                .addContainerGap(51, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_yildiziKaldir, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_mailiSil, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(63, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        tbpn_gonderilenMailler.addTab("Gönderilen Mailler", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tbpn_gonderilenMailler, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tbpn_gonderilenMailler, javax.swing.GroupLayout.PREFERRED_SIZE, 522, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void fillTableWithMessages() {

    //tbl_mailler_model.setRowCount(0);

    // Mesajları veri tabanından al
    ArrayList<Mailler> mailler = DB_Kullanici_Management.GetMailler(kullanici);

    // Her mesajı tabloya ekle
    for (Mailler mail : mailler) {
        if(mail.senderID == kullanici.id || mail.receiverID == kullanici.id){// burada sadece kullanıcının aldığı maillri yazmak gerek bunu düzenle şu an belki tam anlatamadım ama anladın sen 
            tbl_mailler_model.addRow(new Object[]{mail.kime, mail.konu, mail.emailMesaj, mail.yildizliMi ? "Yıldızlı" : "Normal"});
        }
    }
}
    private void btn_MailOlusturActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_MailOlusturActionPerformed
        // TODO add your handling code here:
        jScrollPane1.setVisible(true);
        rbtn_yildizliMesaj.setVisible(true);
        tbpn_gonderilenMailler.setVisible(true);
        txt_emailKime.setVisible(true);
        txt_emailKonu.setVisible(true);
        txt_emailMesaji.setVisible(true);
        btn_MailOlustur.setVisible(true);
        tbpn_gonderilenMailler.setVisible(true);
        tbpn_gonderilenMailler.setVisible(true);
        jPanel1.setVisible(true);
        jPanel2.setVisible(true);
        jLabel1.setVisible(true);
        jLabel2.setVisible(true);
        btn_mailGonder.setVisible(true);
    }//GEN-LAST:event_btn_MailOlusturActionPerformed


    private void btn_mailGonderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_mailGonderActionPerformed
        // TODO add your handling code here:
        

        // Veritabanına eklenecek bilgileri formdan al
        String emailKime = txt_emailKime.getText();
        String emailKonu = txt_emailKonu.getText();
        String emailMesaji = txt_emailMesaji.getText();
        boolean yildizliMesaj = rbtn_yildizliMesaj.isSelected();
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            // Veritabanı bağlantısını oluşturur
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/db_email?user=root&password=Harun.kaya1");

            // Alıcı kullanıcının ID'sini bulur
            String sql = "SELECT id FROM tbl_kullanici_email_kayit WHERE email = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, emailKime);
            ResultSet rs = pstmt.executeQuery();

            int receiverID = -1; // default değer

            if (rs.next()) {
                receiverID = rs.getInt("id");
            }
            // Sorguyu oluşturur
            sql = "INSERT INTO tbl_mesaj_gonder (senderID, receiverID, emailKime, emailKonu, emailMesaji, yildizliMesaj) VALUES (?, ?, ?, ?, ?, ?)";

            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, kullanici.id);
            pstmt.setInt(2, receiverID);
            pstmt.setString(3, emailKime);
            pstmt.setString(4, emailKonu);
            pstmt.setString(5, emailMesaji);
            pstmt.setBoolean(6, yildizliMesaj);

            // Sorguyu çalıştırır
            pstmt.executeUpdate();

            // İşlem başarılı olduysa kullanıcıya bilgi mesajı göster
            JOptionPane.showMessageDialog(null, "Mesaj başarıyla gönderildi ve kaydedildi.");
            fillTableWithMessages();
        } catch (SQLException e) {
            // Bir hata oluşursa, hatayı konsola yaz ve kullanıcıya hata mesajı göster
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Mesaj gönderilemedi, bir hata oluştu: " + e.getMessage());
        } finally {
            // Kullanılan kaynakları temizle
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Kaynakları kapatırken bir hata oluştu: " + e.getMessage());
            }
        }

    }//GEN-LAST:event_btn_mailGonderActionPerformed

    // Yıldızı kaldırma işlemi gerçekleştirilir
    private void btn_yildiziKaldirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_yildiziKaldirActionPerformed
        // Seçilen satırın index numarası alınır
        int selectedRow = jtbl_Mailler.getSelectedRow();
        if (selectedRow != -1) {
            // Seçili satırdan 'emailKime' değeri alınır
            String emailKime = tbl_mailler_model.getValueAt(selectedRow, 0).toString();

            Connection conn = null;
            PreparedStatement pstmt = null;
            try {
                // Veritabanı bağlantısı kurulur
                conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/db_email?user=root&password=Harun.kaya1");
                
                // Yıldızlı mesajın yıldızının kaldırılması için SQL sorgusu
                String sql = "UPDATE tbl_mesaj_gonder SET yildizliMesaj = ? WHERE emailKime = ?";

                pstmt = conn.prepareStatement(sql);
                pstmt.setBoolean(1, false);// Yıldızlı mesaj değeri 'false' olarak ayarlanır
                pstmt.setString(2, emailKime);// Yıldızlı mesajın alıcısı belirlenir

                pstmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (pstmt != null) {
                        pstmt.close();// PreparedStatement kapatılır
                    }
                    if (conn != null) {
                        conn.close();// Veritabanı bağlantısı kapatılır
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            // Tablo modelinde yıldızı kaldırılan mesajın tipi 'Normal Mail' olarak güncellenir
            tbl_mailler_model.setValueAt("Normal Mail", selectedRow, 3);
        }


    }//GEN-LAST:event_btn_yildiziKaldirActionPerformed

    private void btn_mailiSilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_mailiSilActionPerformed
        // TODO add your handling code here:
        int selectedRow = jtbl_Mailler.getSelectedRow();
         // Eğer bir satır seçiliyse
        if (selectedRow != -1) {
            // Seçili satırdan 'emailKime', 'emailKonu' ve 'emailMesaji' değerleri alınır
            String emailKime = tbl_mailler_model.getValueAt(selectedRow, 0).toString();
            String emailKonu = tbl_mailler_model.getValueAt(selectedRow, 1).toString();
            String emailMesaji = tbl_mailler_model.getValueAt(selectedRow, 2).toString();

            Connection conn = null;
            PreparedStatement pstmt = null;
            try {
                conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/db_email?user=root&password=Harun.kaya1");
                // Mesajın silinmesi için SQL sorgusu
                String sql = "DELETE FROM tbl_mesaj_gonder WHERE emailKime = ? AND emailKonu = ? AND emailMesaji = ?";

                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, emailKime);// Silinecek mesajın alıcısı belirlenir
                pstmt.setString(2, emailKonu);// Silinecek mesajın konusu belirlenir
                pstmt.setString(3, emailMesaji);// Silinecek mesajın içeriği belirlenir

                pstmt.executeUpdate();// Sorgu çalıştırılır
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (pstmt != null) {
                        pstmt.close();
                    }
                    if (conn != null) {
                        conn.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            // Tablo modelinde silinen mesaj satırı kaldırılır
            tbl_mailler_model.removeRow(selectedRow);
        }
    }//GEN-LAST:event_btn_mailiSilActionPerformed

    /**
     * @param args the command line argumentsxfgh
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_MailOlustur;
    private javax.swing.JButton btn_mailGonder;
    private javax.swing.JButton btn_mailiSil;
    private javax.swing.JButton btn_yildiziKaldir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jtbl_Mailler;
    private javax.swing.JRadioButton rbtn_yildizliMesaj;
    private javax.swing.JTabbedPane tbpn_gonderilenMailler;
    private javax.swing.JTextField txt_emailKime;
    private javax.swing.JTextField txt_emailKonu;
    private javax.swing.JTextArea txt_emailMesaji;
    // End of variables declaration//GEN-END:variables
}
