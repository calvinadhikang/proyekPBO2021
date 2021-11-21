
package testproject;
 
import java.sql.PreparedStatement;
import static testproject.DB.conn;

public class Karyawan {
    static String username;
    static int id;
    
    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        Karyawan.username = username;
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Karyawan.id = id;
    }
    
    public static void insertTableKaryawan(String username, String password, String nama, int status, int jabatan) throws Exception {
        if(username.equals("") || password.equals("") || nama.equals("") || (!(status == 0 || status == 1)) || (!(jabatan == 1 || jabatan == 2)) ){
            //exception
            throw new Exception("Field tidak boleh kosong / harga > 0 !");
        }
        
        try {
            PreparedStatement ps = conn.prepareStatement
                    ("insert into karyawan (username, password, nama, status, jabatan) values (?, ?, ?, ?, ?)");
            ps.setString(1, username);
            ps.setString(2, password);
            ps.setString(3, nama);
            ps.setInt(4, status);
            ps.setInt(5, jabatan);
            
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void updateTableKaryawan(int idKaryawan, String username, String password, String nama, int status, int jabatan) throws Exception {
        if(username.equals("") || password.equals("") || nama.equals("") || (!(status == 0 || status == 1)) || (!(jabatan == 1 || jabatan == 2)) ){
            throw new Exception("Field tidak boleh kosong / harga harus > 0 !");
        }
        
        try {
            // TODO add your handling code here:
            PreparedStatement ps = conn.prepareStatement
                    ("update karyawan set username = ?, password = ?, nama = ?, status = ?, jabatan = ? where id_karyawan = ?");
            
            //
            ps.setString(1, username);
            ps.setString(2, password);
            ps.setString(3, nama);
            ps.setInt(4, status);
            ps.setInt(5, jabatan);
            ps.setInt(6, idKaryawan);
            
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void deleteTableKaryawan(int idKaryawan) throws Exception {
        int valid = -99;
        valid = idKaryawan;
        
        if(valid == -99){
            throw new Exception("idKaryawan tidak boleh kosong !");
        }
        
        try {
            PreparedStatement pr = conn.prepareStatement
                    ("delete from karyawan where id_karyawan = ?");
            //
            pr.setInt(1, idKaryawan);
            
            pr.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
