 
package testproject;
 
import java.util.ArrayList;

public class Transaction {
    static ArrayList<Transaction> listTransaction = new ArrayList<>();
    private String nomorNota;
    private String tglTrans;
    private String metodePembayaran;
    private int total;
    private String jam;
    private String namaKasir;
    private int statusNomorMeja;
    private ArrayList<DTrans> listPesanan = new ArrayList<>();

    public Transaction(String nomorNota, String tglTrans,
            String metodePembayaran, int total, String jam, 
            String namaKasir, int statusNomorMeja) {
        this.nomorNota = nomorNota;
        this.tglTrans = tglTrans;
        this.metodePembayaran = metodePembayaran;
        this.total = total;
        this.jam = jam;
        this.namaKasir = namaKasir;
        this.statusNomorMeja = statusNomorMeja;
    }

    public int getStatusNomorMeja() {
        return statusNomorMeja;
    }

    public void setStatusNomorMeja(int statusNomorMeja) {
        this.statusNomorMeja = statusNomorMeja;
    }

    public String getNomorNota() {
        return nomorNota;
    }

    public void setNomorNota(String nomorNota) {
        this.nomorNota = nomorNota;
    }

    public String getTglTrans() {
        return tglTrans;
    }

    public void setTglTrans(String tglTrans) {
        this.tglTrans = tglTrans;
    }

    public String getMetodePembayaran() {
        return metodePembayaran;
    }

    public void setMetodePembayaran(String metodePembayaran) {
        this.metodePembayaran = metodePembayaran;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getJam() {
        return jam;
    }

    public void setJam(String jam) {
        this.jam = jam;
    }

    public String getNamaKasir() {
        return namaKasir;
    }

    public void setNamaKasir(String namaKasir) {
        this.namaKasir = namaKasir;
    }

    public ArrayList<DTrans> getListPesanan() {
        return listPesanan;
    }

    public void setListPesanan(ArrayList<DTrans> listPesanan) {
        this.listPesanan = listPesanan;
    }
    
}
