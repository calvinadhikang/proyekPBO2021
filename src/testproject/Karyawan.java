
package testproject;
 
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class Karyawan {
    static String username;
    static String nama;
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
    
    public static int loginKaryawan(String username1, String password1) throws Exception{
        if (username1.equals("") || password1.equals("") || username1.equalsIgnoreCase("Username")) {
            throw new Exception("Field harus diisi semua");
        }
        String usr = ""; String pass = ""; String nama1 ="";
        int status = -1; int jabatan = -1;
        int id1 = -1; 
        PreparedStatement ps = DB.conn.prepareStatement
                            ("SELECT id_karyawan, username, password, nama, status,"
                                    + "jabatan from KARYAWAN WHERE username=? "
                                    + "and password=?");
        ps.setString(1, username1);
        ps.setString(2, password1);
        ResultSet st = ps.executeQuery();
        while (st.next()) { 
            id1 = Integer.parseInt(st.getString("id_karyawan"));
            usr = st.getString("username");
            pass = st.getString("password");
            nama1 = st.getString("nama");
            status = Integer.parseInt(st.getString("status"));
            jabatan = Integer.parseInt(st.getString("jabatan"));
        }
        if (usr.equals("")) {
            throw new Exception("User tidak ditemukan atau password salah");
        } 
        if (status != 1) {
            throw new Exception("User ini sedang tidak aktif!"); 
        } 
        id = id1;
        nama = nama1;
        username = usr; 
            
        return jabatan;
    }
    public static void insertTableKaryawan(String username, String password, String nama, int status, int jabatan) throws Exception {
        if(username.equals("") || password.equals("") || nama.equals("") || (!(status == 0 || status == 1)) || (!(jabatan == 1 || jabatan == 2)) ){
            //exception
            throw new Exception("Field tidak boleh kosong / harga > 0 !");
        }

        PreparedStatement ps = DB.conn.prepareStatement
                ("insert into karyawan (username, password, nama, status, jabatan) values (?, ?, ?, ?, ?)");
        ps.setString(1, username);
        ps.setString(2, password);
        ps.setString(3, nama);
        ps.setInt(4, status);
        ps.setInt(5, jabatan);

        ps.executeUpdate();
    }
    
    public static void updateTableKaryawan(int idKaryawan, String username, String password, String nama, int status, int jabatan) throws Exception {
        if(username.equals("") || password.equals("") || nama.equals("") || (!(status == 0 || status == 1)) || (!(jabatan == 1 || jabatan == 2)) ){
            throw new Exception("Field tidak boleh kosong / harga harus > 0 !");
        }
        PreparedStatement ps = DB.conn.prepareStatement
                ("update karyawan set username = ?, password = ?, nama = ?, status = ?, jabatan = ? where id_karyawan = ?");

        ps.setString(1, username);
        ps.setString(2, password);
        ps.setString(3, nama);
        ps.setInt(4, status);
        ps.setInt(5, jabatan);
        ps.setInt(6, idKaryawan);

        ps.executeUpdate();
    }
    
    public static void deleteTableKaryawan(int idKaryawan) throws Exception {
        int valid = -99;
        valid = idKaryawan;
        
        if(valid == -99){
            throw new Exception("idKaryawan tidak boleh kosong !");
        }
        PreparedStatement pr = DB.conn.prepareStatement
                ("delete from karyawan where id_karyawan = ?");
        pr.setInt(1, idKaryawan);

        pr.executeUpdate();
    }
}
