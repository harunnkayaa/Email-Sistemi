/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mycompany.emailproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author harnk
 */
public class DB_Kullanici_Management {
    

    // Tablo modeli için üye değişken
    DefaultTableModel tbl_mailler_model;
    
    // MySQL veritabanına bağlantı dizesini tutacak sabit bir dize
    private static final String connectionString = "jdbc:mysql://127.0.0.1:3306/db_email?user=root&password=Harun.kaya1";
    
    // Veritabanı bağlantısını sağlayacak Connection nesnesi
    private static Connection conn;

    // Kullanıcı girişini gerçekleştirecek method
    public static Kullanici Login(String email, String password) {
        // Giriş başarılı olduğunda kullanıcı verilerini depolayacak değişken
        Kullanici person = null;

        try {
            // Veritabanına bağlantı kur
            conn = DriverManager.getConnection(connectionString);
            
            // Bir Statement nesnesi oluştur
            Statement stmt = conn.createStatement();
            
            // Kullanıcı verilerini, girilen eposta ve şifreye dayalı olarak veritabanından seçmek için bir sorgu oluştur
            String query = "SELECT*FROM db_email.tbl_kullanici_email_kayit WHERE email='" + email + "' AND password='" + password + "';";
            
            // Sorguyu çalıştır ve sonucu ResultSet nesnesinde sakla
            ResultSet rs = stmt.executeQuery(query);
            
            // Bir sonuç bulunursa (yani, kullanıcı mevcut ve girilen şifre eşleşiyor)
            if (rs.next()) {
                // Yeni bir kullanıcı nesnesi oluştur ve veritabanından gelen verilerle doldur
                person = new Kullanici();
                person.id = rs.getInt("id");
                person.name_surname = rs.getString("name_surname");
                person.email = rs.getString("email");
                person.telefon_numarasi = rs.getString("telefon_numarasi");
                person.cinsiyet = rs.getString("cinsiyet");
                person.password = rs.getString("password");
            }
            // Veritabanı bağlantısını kapat
            conn.close();
        } catch (SQLException ex) {
            // Herhangi bir SQL istisnasını konsola yazdır
            System.out.println(ex.getMessage());
        }
        // Kullanıcı nesnesini döndür (veya giriş başarısız olduysa null döndür)
        return person;
    }

    // Yeni bir kullanıcıyı veritabanına eklemek için method
    public static boolean AddKullanici(Kullanici np1) {
        try {
            // Veritabanına bağlantı kur
            conn = DriverManager.getConnection(connectionString);
            
            // Bir Statement nesnesi oluştur
            Statement stmt = conn.createStatement();
            
            // Yeni kullanıcı verilerini veritabanına eklemek için bir sorgu oluştur
            String query = "INSERT INTO db_email.tbl_kullanici_email_kayit"
                    + "(id, name_surname, email, password, cinsiyet, telefon_numarasi) "
                    + "VALUES ('" + np1.id + "','" + np1.name_surname + "','" + np1.email
                    + "','" + np1.password + "','" + np1.cinsiyet + "','" + np1.telefon_numarasi + "')";
            stmt.executeUpdate(query);
            conn.close();
            return true;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

            return false;
        }
    }

    

    public static boolean EkleGereksizMail(Mailler mail) {
        boolean success = false; // işlem başarılı mı kontrol için bir değişken

        // Veritabanına bağlanmak için Connection ve PreparedStatement nesneleri
        Connection conn = null;
        PreparedStatement psmt = null;

        try {
            // Veritabanına bağlantı oluştur
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/db_email?user=root&password=Harun.kaya1");

            // Kontrol etmek için SQL sorgusu: bu e-postanın zaten tbl_gereksiz_mailler tablosunda olup olmadığını kontrol eder.
            String sqlCheck = "SELECT * FROM tbl_gereksiz_mailler WHERE emailKonu = ? AND emailMesaji = ?";
            psmt = conn.prepareStatement(sqlCheck);
            psmt.setString(1, mail.konu);
            psmt.setString(2, mail.emailMesaj);

            ResultSet rs = psmt.executeQuery();

            // Eğer bu e-posta zaten veritabanında bulunuyorsa, ekleme yapma ve false döndür.
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Bu mail zaten 'Gereksiz Email Tablonuzda Bulunmaktadır'");

                return false;
            }

            // SQL sorgusu: mail bilgilerini tbl_gereksiz_mailler tablosuna ekleyen bir INSERT INTO sorgusu
            String sql = "INSERT INTO tbl_gereksiz_mailler (emailKime, emailKonu, emailMesaji, yildizliMesaj, okunduMu) VALUES (?, ?, ?, ?, ?)";
            // PreparedStatement oluştur
            psmt = conn.prepareStatement(sql);
            // ? yerlerine gerekli değerleri ata
            psmt.setString(1, mail.kime);
            psmt.setString(2, mail.konu);
            psmt.setString(3, mail.emailMesaj);
            psmt.setInt(4, mail.yildizliMi ? 1 : 0);
            psmt.setInt(5, mail.okunduMu ? 1 : 0);

            // SQL sorgusunu çalıştır ve eklenen satır sayısını al
            int affectedRows = psmt.executeUpdate();

            // Eğer en az 1 satır eklenmişse, işlem başarılı
            if (affectedRows > 0) {
                success = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Veritabanı bağlantısını kapat
            try {
                if (psmt != null) {
                    psmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return success;
    }

    public static ArrayList<Mailler> GetOkunmayanMailler(Kullanici kullanici) {
        ArrayList<Mailler> mailler = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            // Veritabanı bağlantısını oluştur
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/db_email?user=root&password=Harun.kaya1");

            // Sorguyu oluştur
            String sql = "SELECT * FROM tbl_mesaj_gonder WHERE okunduMu = FALSE AND (senderID = ? OR receiverID = ?)";

            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, kullanici.id);
            pstmt.setInt(2, kullanici.id);

            // Sorguyu çalıştır ve sonuçları al
            rs = pstmt.executeQuery();

            // ResultSet'teki tüm sonuçları döngü ile işle
            while (rs.next()) {
                Mailler mail = new Mailler();
                mail.senderID = rs.getInt("senderID");
                mail.receiverID = rs.getInt("receiverID");
                mail.kime = rs.getString("emailKime");
                mail.konu = rs.getString("emailKonu");
                mail.emailMesaj = rs.getString("emailMesaji");
                mail.yildizliMi = rs.getBoolean("yildizliMesaj");
                mail.okunduMu=rs.getBoolean("okunduMu");//
                mailler.add(mail);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
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

        return mailler;// mailler dönmesi doğru mu okunan mailler veya okunmayan mailler döndürmemi yapmalıyım
    }

    public static ArrayList<Mailler> GetOkunanMailler(Kullanici kullanici) {
        ArrayList<Mailler> mailler = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            // Veritabanı bağlantısını oluştur
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/db_email?user=root&password=Harun.kaya1");

            // Sorguyu oluştur
            String sql = "SELECT * FROM tbl_mesaj_gonder WHERE okunduMu = TRUE AND (senderID = ? OR receiverID = ?)";

            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, kullanici.id);
            pstmt.setInt(2, kullanici.id);

            // Sorguyu çalıştır ve sonuçları al
            rs = pstmt.executeQuery();

            // ResultSet'teki tüm sonuçları döngü ile işle
            while (rs.next()) {
                Mailler mail = new Mailler();
                mail.senderID = rs.getInt("senderID");
                mail.receiverID = rs.getInt("receiverID");
                mail.kime = rs.getString("emailKime");
                mail.konu = rs.getString("emailKonu");
                mail.emailMesaj = rs.getString("emailMesaji");
                mail.yildizliMi = rs.getBoolean("yildizliMesaj");
                mail.okunduMu=rs.getBoolean("okunduMu");//
                mailler.add(mail);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
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

        return mailler;// mailler dönmesi doğru mu okunan mailler veya okunmayan mailler döndürmemi yapmalıyım
    }

    public static ArrayList<Mailler> GetMailler(Kullanici kullanici) {
        ArrayList<Mailler> mailler = new ArrayList<>();

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            // Veritabanı bağlantısını oluştur
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/db_email?user=root&password=Harun.kaya1");

            // Sorguyu oluştur
            String sql = "SELECT * FROM tbl_mesaj_gonder WHERE senderID = ? OR receiverID = ?";

            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, kullanici.id);
            pstmt.setInt(2, kullanici.id);

            // Sorguyu çalıştır ve sonuçları al
            rs = pstmt.executeQuery();

            // ResultSet'teki tüm sonuçları döngü ile işle
            while (rs.next()) {
                Mailler mail = new Mailler();
                mail.senderID = rs.getInt("senderID");
                mail.receiverID = rs.getInt("receiverID");
                mail.kime = rs.getString("emailKime");// hata olursa buraya bak
                mail.konu = rs.getString("emailKonu");
                mail.emailMesaj = rs.getString("emailMesaji");
                mail.yildizliMi = rs.getBoolean("yildizliMesaj");
                mailler.add(mail);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
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

        return mailler;
    }
    public static ArrayList<Mailler> GetAlınanMailler(Kullanici kullanici) {
        ArrayList<Mailler> mailler = new ArrayList<>();

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            // Veritabanı bağlantısını oluştur
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/db_email?user=root&password=Harun.kaya1");

            // Sorguyu oluştur
            String sql = "SELECT * FROM db_email.tbl_kullanici_email_kayit INNER JOIN db_email.tbl_mesaj_gonder ON db_email.tbl_kullanici_email_kayit.id = db_email.tbl_mesaj_gonder.receiverID WHERE db_email.tbl_kullanici_email_kayit.id = ?";

            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, kullanici.id);
            

            // Sorguyu çalıştır ve sonuçları al
            rs = pstmt.executeQuery();

            // ResultSet'teki tüm sonuçları döngü ile işle
            while (rs.next()) {
                Mailler mail = new Mailler();
                mail.senderID = rs.getInt("senderID");
                mail.receiverID = rs.getInt("receiverID");
                mail.kime = rs.getString("emailKime");
                mail.konu = rs.getString("emailKonu");
                mail.emailMesaj = rs.getString("emailMesaji");
                mail.yildizliMi = rs.getBoolean("yildizliMesaj");
                mailler.add(mail);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
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

        return mailler;
    }

    public static ArrayList<Mailler> GetGönderilenMailler(Kullanici kullanici) {
        ArrayList<Mailler> mailler = new ArrayList<>();

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            // Veritabanı bağlantısını oluştur
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/db_email?user=root&password=Harun.kaya1");

            // Sorguyu oluştur
            String sql = "SELECT * FROM db_email.tbl_kullanici_email_kayit INNER JOIN db_email.tbl_mesaj_gonder ON db_email.tbl_kullanici_email_kayit.id = db_email.tbl_mesaj_gonder.senderID WHERE db_email.tbl_kullanici_email_kayit.id = ?";

            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, kullanici.id);
           
            // Sorguyu çalıştır ve sonuçları al
            rs = pstmt.executeQuery();

            // ResultSet'teki tüm sonuçları döngü ile işle
            while (rs.next()) {
                Mailler mail = new Mailler();
                mail.senderID = rs.getInt("senderID");
                mail.receiverID = rs.getInt("receiverID");
                mail.emailkimden = rs.getString("emailKime");
                mail.konu = rs.getString("emailKonu");
                mail.emailMesaj = rs.getString("emailMesaji");
                mail.yildizliMi = rs.getBoolean("yildizliMesaj");
                mailler.add(mail);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
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

        return mailler;
    }

    public static ArrayList<Mailler> GetReceivedMailler(Kullanici kullanici) {
        ArrayList<Mailler> mailler = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            // Veritabanına bağlan
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/db_email?user=root&password=Harun.kaya1");

            // Alıcı ID'si kullanıcı olan tüm mailleri al
            String sql = "SELECT * FROM tbl_mesaj_gonder WHERE receiverID = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, kullanici.id);

            // Sorguyu çalıştır ve sonuçları al
            rs = pstmt.executeQuery();

            // Sonuçları Mailler listesine dönüştür
            while (rs.next()) {
                Mailler mail = new Mailler();
                mail.id = rs.getInt("id");
                mail.senderID = rs.getInt("senderID");
                mail.receiverID = rs.getInt("receiverID");
                mail.emailkimden = rs.getString("emailKime");// en son bunu değiştirdim
                mail.konu = rs.getString("emailKonu");
                mail.emailMesaj = rs.getString("emailMesaji");
                mail.yildizliMi = rs.getBoolean("yildizliMesaj");
                mail.okunduMu = rs.getBoolean("okunduMu");

                // Kimden bilgisini alma
                PreparedStatement pstmtSender = conn.prepareStatement("SELECT email FROM db_email.tbl_kullanici_email_kayit WHERE id = ?");
                pstmtSender.setInt(1, mail.senderID);
                ResultSet rsSender = pstmtSender.executeQuery();
                if (rsSender.next()) {
                    mail.emailkimden = rsSender.getString("email");
                }

                mailler.add(mail);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Kullanılan kaynakları temizle
            try {
                if (rs != null) {
                    rs.close();
                }
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

        return mailler;
    }

    public static void MarkMessageAsRead(String emailkimden, String konu, String emailMesaj, String yildizliMi, Boolean okunduMu) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            // Veritabanına bağlan
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/db_email?user=root&password=Harun.kaya1");

            // Verileri içeren satırı okundu olarak işaretle
            String sql = "UPDATE tbl_mesaj_gonder SET okunduMu = ? WHERE emailKime = ? AND emailKonu = ? AND emailMesaji = ? AND yildizliMesaj = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setBoolean(1, true); // 'Okundu' olarak işaretlemek için true kullanın
            pstmt.setString(2, emailkimden);
            pstmt.setString(3, konu);
            pstmt.setString(4, emailMesaj);
            pstmt.setBoolean(5, Boolean.valueOf(yildizliMi));

            // Sorguyu çalıştır
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
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
            }
        }
    }
}
/*public static ArrayList<Mailler> getMaillerByFilter(Kullanici kullanici, String filter) {
    ArrayList<Mailler> mailler = new ArrayList<>();
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    try {
        // Veritabanına bağlan
        conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/db_email?user=root&password=Harun.kaya1");

        // SQL sorgusu için şablon oluştur
        String sqlTemplate = "SELECT * FROM tbl_mesaj_gonder WHERE receiverID = ?";

        // JComboBox'tan gelen filtreye göre sorguyu düzenle
        switch (filter) {
            case "All":
                // Tüm mailleri al
                break;
            case "Read":
                // Sadece okunan mailleri al
                sqlTemplate += " AND okunduMu = 1";
                break;
            case "Unread":
                // Sadece okunmayan mailleri al
                sqlTemplate += " AND okunduMu = 0";
                break;
        }

        pstmt = conn.prepareStatement(sqlTemplate);
        pstmt.setInt(1, kullanici.id);

        // Sorguyu çalıştır ve sonuçları al
        rs = pstmt.executeQuery();

        // Sonuçları Mailler listesine dönüştür
        while (rs.next()) {
            Mailler mail = new Mailler();
            mail.id = rs.getInt("id");
            mail.senderID = rs.getInt("senderID");
            mail.receiverID = rs.getInt("receiverID");
            mail.emailkimden = rs.getString("emailKime");
            mail.konu = rs.getString("emailKonu");
            mail.emailMesaj = rs.getString("emailMesaji");
            mail.yildizliMi = rs.getBoolean("yildizliMesaj");
            mail.okunduMu = rs.getBoolean("okunduMu");

            // Kimden bilgisini alma
            PreparedStatement pstmtSender = conn.prepareStatement("SELECT email FROM db_email.tbl_kullanici_email_kayit WHERE id = ?");
            pstmtSender.setInt(1, mail.senderID);
            ResultSet rsSender = pstmtSender.executeQuery();
            if (rsSender.next()) {
                mail.emailkimden = rsSender.getString("email");
            }

            mailler.add(mail);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        // Kullanılan kaynakları temizle
        try {
            if (rs != null) {
                rs.close();
            }
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

    return mailler;
}
}


/*public static ArrayList<Mailler> GetMailler(Kullanici kullanici) {
    ArrayList<Mailler> mailler = new ArrayList<>();
    try {
        conn = DriverManager.getConnection(connectionString);
        Statement stmt = conn.createStatement();
        String query = "SELECT * FROM db_email.tbl_mesaj_gonder WHERE id = " + kullanici.id + ";";
        ResultSet rs = stmt.executeQuery(query);
        
        while (rs.next()) {
            Mailler mail = new Mailler();
            
            mail.emailKime = rs.getString("emailKime");
            mail.konu = rs.getString("emailKonu");
            mail.emailMesaj = rs.getString("emailMesaji");
            mail.yildizliMi = rs.getBoolean("yildizliMesaj");
            mailler.add(mail);
        }
        
        conn.close();
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    }
    return mailler;
}
    
}*/
 /*
public static ArrayList<Mailler> GetUnreadMailler(Kullanici kullanici) {
    ArrayList<Mailler> mailler = new ArrayList<>();
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    try {
        // Veritabanına bağlan
        conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/db_email?user=root&password=Harun.kaya1");

        // Alıcı ID'si kullanıcı olan ve okunmamış olan tüm mailleri al
        String sql = "SELECT * FROM tbl_mesaj_gonder WHERE receiverID = ? AND okunduMu = false";
        pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, kullanici.id);

        // Sorguyu çalıştır ve sonuçları al
        rs = pstmt.executeQuery();

        // Sonuçları Mailler listesine dönüştür
        while (rs.next()) {
            Mailler mail = new Mailler();
            mail.senderID = rs.getInt("senderID");
            mail.receiverID = rs.getInt("receiverID");
            mail.konu = rs.getString("emailKonu");
            mail.emailMesaj = rs.getString("emailMesaji");
            mail.yildizliMi = rs.getBoolean("yildizliMesaj");
            mail.okunduMu = rs.getBoolean("okunduMu");

            // Kimden bilgisini alma
            PreparedStatement pstmtSender = conn.prepareStatement("SELECT email FROM db_email.tbl_kullanici_email_kayit WHERE id = ?");
            pstmtSender.setInt(1, mail.senderID);
            ResultSet rsSender = pstmtSender.executeQuery();
            if (rsSender.next()) {
                mail.emailkimden = rsSender.getString("email");
            }

            mailler.add(mail);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        // Kullanılan kaynakları temizle
        try {
            if (rs != null) {
                rs.close();
            }
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

    return mailler;
}

private void btn_showUnreadMaillerActionPerformed(java.awt.event.ActionEvent evt) {                                                 
    ArrayList<Mailler> mailler = DB_Kullanici_Management.GetUnreadMailler(kullanici);
    DefaultTableModel model = (DefaultTableModel) jtbl_gelenMail.getModel();
    model.setRowCount(0); // tabloyu temizle
    for (Mailler mail : mailler) {
        if (kullanici.id == mail.receiverID && !mail.okunduMu) {
            // tabloya gelen okunmamış maili ekle
            model.addRow(new Object[] {mail.emailkimden, mail.konu, mail.emailMesaj, mail.yildizliMi ? "Yıldızlı" : "Normal", mail.okunduMu ? "Okundu" : "Okunmadı" });
        }
    }
}
 */
