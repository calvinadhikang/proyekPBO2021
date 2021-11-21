
package testproject; 
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
    
}
