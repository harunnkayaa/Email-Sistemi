/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.emailproject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
public class Frm_GereksizMailler extends javax.swing.JFrame {

    DefaultTableModel tbl_mailler_model;
    Kullanici kullanici;
    Mailler mailler; 
    /**
     * Creates new form Frm_GereksizMailler
     */
  public Frm_GereksizMailler(Kullanici person) {
    initComponents();

    this.kullanici = person;
    tbl_mailler_model = new DefaultTableModel();
    tbl_mailler_model.setColumnIdentifiers(new Object[]{"Kimden", "Konu", "Gelen Mail", "Mail Türü","Okundu Mu"});
    jtbl_Mailler.setModel(tbl_mailler_model);
   DoldurGereksizMaillerTablosu();
}
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane4 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        cmbx_nailler = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbl_Mailler = new javax.swing.JTable();
        rbtn_gereksizMaillerTablosu = new javax.swing.JRadioButton();
        btn_mailleriGetir = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtbl_gereksizMailler = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(500, 570));
        setPreferredSize(new java.awt.Dimension(500, 570));

        jTabbedPane4.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));
        jPanel1.setMinimumSize(new java.awt.Dimension(500, 570));
        jPanel1.setPreferredSize(new java.awt.Dimension(500, 570));

        cmbx_nailler.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        cmbx_nailler.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tüm Mailler", "Okunan Mailler", "Okunmayan Mailler", " " }));

        jtbl_Mailler.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "Kimden", "Konu", "Gelen Mail", "Mail Türü"
            }
        ));
        jScrollPane1.setViewportView(jtbl_Mailler);

        rbtn_gereksizMaillerTablosu.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        rbtn_gereksizMaillerTablosu.setText("Gereksiz Mailler Tablosuna Ekle");
        rbtn_gereksizMaillerTablosu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtn_gereksizMaillerTablosuActionPerformed(evt);
            }
        });

        btn_mailleriGetir.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        btn_mailleriGetir.setText("Mailleri Getir");
        btn_mailleriGetir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_mailleriGetirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(cmbx_nailler, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(25, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(167, 167, 167)
                .addComponent(btn_mailleriGetir, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(rbtn_gereksizMaillerTablosu, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(cmbx_nailler, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(btn_mailleriGetir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbtn_gereksizMaillerTablosu)
                .addContainerGap(132, Short.MAX_VALUE))
        );

        jTabbedPane4.addTab("Mailler", jPanel1);

        jPanel2.setBackground(new java.awt.Color(0, 204, 204));

        jtbl_gereksizMailler.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Kimden", "Konu", "Gelen Mail", "Mail Türü"
            }
        ));
        jScrollPane2.setViewportView(jtbl_gereksizMailler);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 555, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane4.addTab("Gereksiz Mailler", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane4)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane4)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Mail tablosunu güncelleyen metot
    private void updateTable(ArrayList<Mailler> mailler) {
    tbl_mailler_model.setRowCount(0);
    
     // Her mail için tabloya bir satır ekleyin
    for (Mailler mail : mailler) {
        String okunduMuText = "";
        if (mail.okunduMu != null) {
            okunduMuText = mail.okunduMu ? "Okundu" : "Okunmadı";
        }
        tbl_mailler_model.addRow(new Object[]{mail.kime, mail.konu, mail.emailMesaj, mail.yildizliMi ? "Yıldızlı" : "Normal", okunduMuText});
    }
}
    // Gereksiz mail tablosunu güncelleyen metot
    private void updateGereksizMaillerTable(ArrayList<Mailler> gereksizMailler) {
    DefaultTableModel model = (DefaultTableModel) jtbl_gereksizMailler.getModel();
    model.setRowCount(0);
    // Her gereksiz mail için tabloya bir satır ekleyin
    for (Mailler mail : gereksizMailler) {
        String okunduMuText = "";
        if (mail.okunduMu != null) {
            okunduMuText = mail.okunduMu ? "Okundu" : "Okunmadı";
        }
        model.addRow(new Object[]{mail.kime, mail.konu, mail.emailMesaj, mail.yildizliMi ? "Yıldızlı" : "Normal", okunduMuText});
    }
}
    private void btn_mailleriGetirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_mailleriGetirActionPerformed
    
       // Combobox'da seçili olan item'ın indexini aldım
    int selectedIndex = cmbx_nailler.getSelectedIndex();

    // Tüm mailleri getirir
    if (selectedIndex == 0) {
        ArrayList<Mailler> mailler = DB_Kullanici_Management.GetMailler(kullanici);
        updateTable(mailler);
    }
    // Okunan mailleri getirir
    else if (selectedIndex == 1) {
        ArrayList<Mailler> mailler = DB_Kullanici_Management.GetOkunanMailler(kullanici);
        updateTable(mailler);
       
    }
    // Okunmayan mailleri getirir
    else if (selectedIndex == 2) {
        ArrayList<Mailler> mailler = DB_Kullanici_Management.GetOkunmayanMailler(kullanici);
        updateTable(mailler);
    }
   
            
    }//GEN-LAST:event_btn_mailleriGetirActionPerformed
 public void DoldurGereksizMaillerTablosu() {
    // Veritabanından verileri almak için bir SQL sorgusu
    String sql = "SELECT * FROM tbl_gereksiz_mailler";
    
    // Veritabanına bağlan
    try (Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/db_email?user=root&password=Harun.kaya1"); // Gerçek username ve password ile değiştirin
         PreparedStatement psmt = conn.prepareStatement(sql)) {

        // SQL sorgusunu çalıştır ve sonuçları al
        ResultSet rs = psmt.executeQuery();

        // jtbl_gereksizMailler tablosundaki mevcut tüm satırları sil
        DefaultTableModel model = (DefaultTableModel) jtbl_gereksizMailler.getModel();
        model.setRowCount(0);

        // Sonuç setindeki tüm satırlar için
        while (rs.next()) {
            // Satırın verilerini al
            String kime = rs.getString("emailKime");
            String konu = rs.getString("emailKonu");
            String emailMesaj = rs.getString("emailMesaji");
            boolean yildizliMi = rs.getInt("yildizliMesaj") == 1;
            boolean okunduMu = rs.getInt("okunduMu") == 1;

            // Bu verileri jtbl_gereksizMailler tablosuna ekle
            model.addRow(new Object[]{kime, konu, emailMesaj, yildizliMi ? "Yıldızlı" : "Normal", okunduMu ? "Okundu" : "Okunmadı"});
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
   /* public void DoldurGereksizMaillerTablosu() {
    // Kullanıcıya ait gereksiz mailleri getiren SQL sorgusu
    String sql = "SELECT * FROM tbl_gereksiz_mailler WHERE id=?";

    // Veritabanına bağlan
    try (Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/db_email?user=root&password=Harun.kaya1");
         PreparedStatement psmt = conn.prepareStatement(sql)) {
         
        // Kullanıcı id'sini SQL sorgusuna ekleyin
        psmt.setInt(1, kullanici.id);

        // SQL sorgusunu çalıştır ve sonuçları al
        ResultSet rs = psmt.executeQuery();

        // jtbl_gereksizMailler tablosundaki mevcut tüm satırları sil
        DefaultTableModel model = (DefaultTableModel) jtbl_gereksizMailler.getModel();
        model.setRowCount(0);

        // Sonuç setindeki tüm satırlar için
        while (rs.next()) {
            // Satırın verilerini al
            String kime = rs.getString("emailKime");
            String konu = rs.getString("emailKonu");
            String emailMesaj = rs.getString("emailMesaji");
            boolean yildizliMi = rs.getInt("yildizliMesaj") == 1;
            boolean okunduMu = rs.getInt("okunduMu") == 1;

            // Bu verileri jtbl_gereksizMailler tablosuna ekle
            model.addRow(new Object[]{kime, konu, emailMesaj, yildizliMi ? "Yıldızlı" : "Normal", okunduMu ? "Okundu" : "Okunmadı"});
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}*/
 
    private void rbtn_gereksizMaillerTablosuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtn_gereksizMaillerTablosuActionPerformed
        // jtbl_Mailler tablosundan seçili satırı al
        
        
     // jtbl_Mailler tablosundan seçili satırı al
    int selectedRow = jtbl_Mailler.getSelectedRow();

    if (selectedRow != -1) { // Eğer bir satır seçiliyse
        // Seçili satırdaki verileri alıp yeni bir Mail objesi oluştur
        String sender = jtbl_Mailler.getValueAt(selectedRow, 0).toString();
        String subject = jtbl_Mailler.getValueAt(selectedRow, 1).toString();
        String content = jtbl_Mailler.getValueAt(selectedRow, 2).toString();
        String yildizliMi= jtbl_Mailler.getValueAt(selectedRow, 3).toString();
        //Boolean yildizliMi = Boolean.parseBoolean(jtbl_Mailler.getValueAt(selectedRow, 3).toString());
        
        Mailler mail = new Mailler(); 
        mail.kime = sender;
        mail.konu = subject;
        mail.emailMesaj = content;
        mail.yildizliMi = Boolean.parseBoolean(yildizliMi);
        mail.okunduMu=true;

        // Bu maili veritabanındaki gereksiz mailler tablosuna ekle
        boolean success = DB_Kullanici_Management.EkleGereksizMail(mail);

        if(success){
            // Başarı mesajı göster
            JOptionPane.showMessageDialog(null, "Mail veritabanındaki gereksiz mailler tablosuna başarıyla eklendi.");

            // jtbl_gereksizMailler tablosuna bu maili ekle
            DefaultTableModel model = (DefaultTableModel) jtbl_gereksizMailler.getModel();
            model.addRow(new Object[]{sender, subject, content, yildizliMi});

            // rbtn_gereksizMaillerTablosu'nun seçimini kaldır
            rbtn_gereksizMaillerTablosu.setSelected(false);
        } else {
            // Ekleme başarısız olduğunda hata mesajı göster
            JOptionPane.showMessageDialog(null, "Mail gereksiz mailler tablosuna eklenirken bir hata oluştu.");
            // rbtn_gereksizMaillerTablosu'nun seçimini kaldır
            rbtn_gereksizMaillerTablosu.setSelected(false);
        }
    } else {
        // Eğer hiçbir satır seçili değilse, hata mesajı göster
        JOptionPane.showMessageDialog(null, "Bir mail seçmelisiniz.");
        // rbtn_gereksizMaillerTablosu'nun seçimini kaldır
        rbtn_gereksizMaillerTablosu.setSelected(false);
    }
    
        // jtbl_Mailler tablosundan seçili satırı al
    /*int selectedRow = jtbl_Mailler.getSelectedRow();

    if (selectedRow != -1) { // Eğer bir satır seçiliyse
        Mailler selectedMail = new Mailler(); // seçilen maili temsil edecek yeni bir Mailler objesi oluştur

        // Seçili satırdaki verileri alıp Mailler objesine atama yap
        selectedMail.kime = tbl_mailler_model.getValueAt(selectedRow, 0).toString();
        selectedMail.konu = tbl_mailler_model.getValueAt(selectedRow, 1).toString();
        selectedMail.emailMesaj = tbl_mailler_model.getValueAt(selectedRow, 2).toString();
        selectedMail.yildizliMi = tbl_mailler_model.getValueAt(selectedRow, 3).toString().equals("Yıldızlı") ? true : false;
        selectedMail.okunduMu = tbl_mailler_model.getValueAt(selectedRow, 4).toString().equals("Okundu") ? true : false;

        // Bu maili veritabanındaki gereksiz mailler tablosuna ekle
        boolean success = DB_Kullanici_Management.EkleGereksizMail(selectedMail);

        // Eğer ekleme başarılıysa
        if(success){
            // Başarı mesajı göster
            JOptionPane.showMessageDialog(null, "Mail veritabanındaki gereksiz mailler tablosuna başarıyla eklendi.");

            // jtbl_gereksizMailler tablosunu veritabanı ile senkronize et
            DoldurGereksizMaillerTablosu();

        } else {
            // Ekleme başarısız olduğunda hata mesajı göster
            JOptionPane.showMessageDialog(null, "Mail gereksiz mailler tablosuna eklenirken bir hata oluştu.");
        }
        rbtn_gereksizMaillerTablosu.setSelected(false);
    }*/
        /* // TODO add your handling code here:
        // Get the selected row in jtbl_Mailler
          // jtbl_Mailler tablosundan seçili satırı al
    int selectedRow = jtbl_Mailler.getSelectedRow();

    if (selectedRow != -1) { // Eğer bir satır seçiliyse
        Mailler selectedMail = new Mailler(); // seçilen maili temsil edecek yeni bir Mailler objesi oluştur

        // Seçili satırdaki verileri alıp Mailler objesine atama yap
        selectedMail.kime = tbl_mailler_model.getValueAt(selectedRow, 0).toString();
        selectedMail.konu = tbl_mailler_model.getValueAt(selectedRow, 1).toString();
        selectedMail.emailMesaj = tbl_mailler_model.getValueAt(selectedRow, 2).toString();
        selectedMail.yildizliMi = tbl_mailler_model.getValueAt(selectedRow, 3).toString().equals("Yıldızlı") ? true : false;
        selectedMail.okunduMu = tbl_mailler_model.getValueAt(selectedRow, 4).toString().equals("Okundu") ? true : false;

        // Bu maili veritabanındaki gereksiz mailler tablosuna ekle
        boolean success = DB_Kullanici_Management.EkleGereksizMail(selectedMail);

        // Eğer ekleme başarılıysa
        if(success){
            // "jtbl_gereksizMailler" tablosuna ekleyin
            DefaultTableModel model = (DefaultTableModel) jtbl_gereksizMailler.getModel();
            model.addRow(new Object[]{selectedMail.kime, selectedMail.konu, selectedMail.emailMesaj, selectedMail.yildizliMi ? "Yıldızlı" : "Normal", selectedMail.okunduMu ? "Okundu" : "Okunmadı"});

            // Başarı mesajı göster
            JOptionPane.showMessageDialog(null, "Gereksiz mailler tablosuna başarıyla eklendi.");
        } else {
            // Ekleme başarısız olduğunda hata mesajı göster
            JOptionPane.showMessageDialog(null, "Mail gereksiz mailler tablosuna eklenirken bir hata oluştu.");
        }
    }*/
   
    }//GEN-LAST:event_rbtn_gereksizMaillerTablosuActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_mailleriGetir;
    private javax.swing.JComboBox<String> cmbx_nailler;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane4;
    private javax.swing.JTable jtbl_Mailler;
    private javax.swing.JTable jtbl_gereksizMailler;
    private javax.swing.JRadioButton rbtn_gereksizMaillerTablosu;
    // End of variables declaration//GEN-END:variables
}
