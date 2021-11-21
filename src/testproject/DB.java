 
package testproject;

//Project PBO

import java.sql.Connection;
import java.sql.DriverManager;  
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class DB {
    static Connection conn;
    public DB(){ }
    public static void initConn(){ 
            try { 
                Class.forName("com.mysql.jdbc.Driver");  
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_pbo_proyek","root","");  
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
    } 
//    public static void insert(String sql, Object[] data){ 
//        try {
//            PreparedStatement stmt = conn.prepareStatement(sql);
//             for (int i = 0; i < data.length; i++) {
//                    stmt.setObject(i+1, data[i]);
//             }
//             stmt.execute(); 
//            
//        } catch (Exception exc) {
//                JOptionPane.showMessageDialog(null, exc.getMessage());
//        } 
//    }
//    
//    public static void update(String sql, Object[] data){ 
//        try {
//            PreparedStatement s = conn.prepareStatement(sql);
//             for (int i = 0; i < data.length; i++) {
//                    s.setObject(i+1, data[i]);
//             } 
//             s.executeUpdate();  
//        } catch (Exception exc) {
//           JOptionPane.showMessageDialog(null, exc.getMessage());
//        }
//         
//    }
//    public static void delete(String sql, Object[] data){
//        update(sql, data); 
//    }
    
    public static void close(){
        try {
            conn.close();
        } catch (Exception exc) {
          JOptionPane.showMessageDialog(null, exc.getMessage()); 
        }
    }
    
    
    public static DefaultTableModel getTabelKaryawan(){
        //function buat query tabel karyawan di master karyawan
        DefaultTableModel tabelKaryawan = new DefaultTableModel();
        String[] rows = {"ID","NAMA",
            "USERNAME","PASSWORD", 
            "STATUS", "JABATAN"};
        tabelKaryawan = new DefaultTableModel(rows, 0);  
        try { 
        PreparedStatement ps = conn.prepareStatement("SELECT k.id_karyawan as \"ID\",k.nama as \"Nama\" ,"
                + "k.username as \"Username\",\n" +
                "k.password as \"Password\", case k.status when k.status=1 then 'Aktif' "
                + "else 'Tidak aktif' end as \"Status\",\n" +
                "case k.jabatan when k.jabatan=1 then 'Kasir' else "
                +"'Manager' end as \"Jabatan\"\n" +
                "FROM `karyawan` k");
            ResultSet st = ps.executeQuery();
            while (st.next()) {
                Object[] rows1 = new Object[]{
                    st.getString("ID"),st.getString("Nama"),st.getString("Username"),st.getString("Password"),
                st.getString("Status"),st.getString("Jabatan")}; 
                tabelKaryawan.addRow(rows1);   
            } 
        } catch (Exception exc) {
            JOptionPane.showMessageDialog(null, exc.getMessage());
        } 
        
        return tabelKaryawan;
    }
    
    public static DefaultTableModel getTabelMenu(){
        //function buat query tabel karyawan di master karyawan
        DefaultTableModel tabelMenu = new DefaultTableModel();
        String[] rows = {"ID","Nama",
            "Harga","Kategori", 
            "Status"};
        tabelMenu = new DefaultTableModel(rows, 0);  
        try { 
        PreparedStatement ps = conn.prepareStatement
                            ("SELECT id_menu as \"ID\",\n" +
                            "NAMA as \"Nama\", harga as \"Harga\", kategori as \"Kategori\",\n" +
                            "case M1.status when 1 then 'Available' else 'Not Available'end  as \"Status\" \n" +
                            "FROM MENU M1");
            ResultSet st = ps.executeQuery();
            while (st.next()) {
                Object[] rows1 = new Object[]{
                    st.getString("ID"),st.getString("Nama"),st.getString("Harga"),st.getString("Kategori"),
                st.getString("Status")}; 
                tabelMenu.addRow(rows1);   
            } 
        } catch (Exception exc) {
            JOptionPane.showMessageDialog(null, exc.getMessage());
        } 
        
        return tabelMenu;
    }
    
}   

