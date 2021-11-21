
package testproject;

//PROJECT PBO GAIS

import java.sql.PreparedStatement;
import java.util.ArrayList;
import static testproject.DB.conn;

public class Menu {
    static ArrayList<Menu> listMenu = new ArrayList<>();
    private int idMenu;
    private String namaMenu;
    private String category;
    private int harga;
    private int status;

    public Menu(int idMenu, String namaMenu, String category, int harga, int status) {
        this.idMenu = idMenu;
        this.namaMenu = namaMenu;
        this.category = category;
        this.harga = harga;
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(int idMenu) {
        this.idMenu = idMenu;
    }

    public String getNamaMenu() {
        return namaMenu;
    }

    public void setNamaMenu(String namaMenu) {
        this.namaMenu = namaMenu;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }
    
    public static void insertTableMenu(String namaMenu, String category, int harga, int status) throws Exception {
        if(namaMenu.equals("") || category.equals("") || harga <= 0 || (!(status == 0 || status == 1)) ){
            //exception
            throw new Exception("Field tidak boleh kosong / harga > 0 !");
        }
        
        try {
            PreparedStatement ps = conn.prepareStatement
                    ("insert into menu values (nama, kategori, harga, status) values (?, ?, ?, ?)");
            ps.setString(1, namaMenu);
            ps.setString(2, category);
            ps.setInt(3, harga);
            ps.setInt(4, status);
            
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
