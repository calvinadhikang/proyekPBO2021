
package testproject; 

import java.sql.PreparedStatement;
import static testproject.DB.conn;

public class DTrans extends Menu{
    private int quantity;
    private String keterangan;
    public DTrans(int idMenu, String namaMenu, String category, int harga, int status) {
        super(idMenu, namaMenu, category, harga, status);
    }
    public int getSubtotal(){
        return super.getHarga()*quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }
    
    public static void insertTableDTrans(String nomorNota, int idMenu, int qty, int harga, int subtotal) throws Exception {
        if(nomorNota.equals("") || harga <= 0 || subtotal <= 0 ){
            //exception
            throw new Exception("Field tidak boleh kosong / harga > 0 !");
        }
        
        try {
            PreparedStatement ps = conn.prepareStatement
                    ("insert into dtrans (nomornota, id_menu, qty, harga, subtotal) values (?, ?, ?, ?, ?)");
            ps.setString(1, nomorNota);
            ps.setInt(2, idMenu);
            ps.setInt(3, qty);
            ps.setInt(4, harga);
            ps.setInt(5, subtotal);
            
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void updateTableDTrans(String nomorNota, int idMenu, int qty, int harga, int subtotal) throws Exception {
        if(nomorNota.equals("") || harga <= 0 || subtotal <= 0 ){
            //exception
            throw new Exception("Field tidak boleh kosong / harga > 0 !");
        }
        
        try {
            PreparedStatement ps = conn.prepareStatement
                    ("update dtrans set qty = ?, harga = ?, subtotal = ? where nomorNota = ? and id_menu = ?");
            ps.setInt(1, qty);
            ps.setInt(2, harga);
            ps.setInt(3, subtotal);
            ps.setString(4, nomorNota);
            ps.setInt(5, idMenu);
            
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void deleteTableDTrans(String nomorNota, int idMenu) throws Exception {
        int valid1 = -99;
        valid1 = idMenu;
        
        if(valid1 == -99 || nomorNota.equals("")){
            throw new Exception("Field tidak boleh kosong !");
        }
        
        try {
            PreparedStatement ps = conn.prepareStatement
                        ("delete from dtrans where nomorNota = ? and id_menu = ?");
            ps.setString(1, nomorNota);
            ps.setInt(2, idMenu);

            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
