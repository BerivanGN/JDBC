import java.sql.*;

public class JDBC01_Query01 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        // 1 - ilgili driver'i yüklemeliyiz. MySQL kullandığımızı bildiriyoruz
        // Driver'i bulamama ihtimaline karşı bizden forName() metodu icin
        // ClassNotFoundException'ı metod signature'ımıza exception olarak fırlatmamızı istiyor.


        Class.forName("com.mysql.cj.jdbc.Driver");

        // 2 - Baglantıyı oluşturmak için username ve password girmeliyiz
        // Burada da bu userName ve password'un yanlış olma ihtimaline karşı
        // SQLException fırlatmamızı istiyor.

        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys?serverTimezone=UTC", "root", "1234");

        // 3 - SQL query'leri için bir Statement objesi oluşturup java'da SQL
        // sorgularımız için bir alan açacağız.

        Statement st = con.createStatement();

        // 4 - SQL query'lerimizi yazıp çalıştırabiliriz.

       ResultSet veri = st.executeQuery("SELECT * FROM personel");

        // 5 - Sonuçları görmek için iteration ile Set içindeki elemanları
        // while döngüsü ile yazdırıyoruz.

        while (veri.next()){
            System.out.println(veri.getInt(1) + " " + veri.getString(2) + " "
                            + veri.getString(3) + " " + veri.getInt(4) + " "
                            + veri.getString(5));
        }

        // 6 - Oluşturulan bağlantıları kapatıyoruz.

        con.close();
        st.close();
        veri.close();


    }
}
