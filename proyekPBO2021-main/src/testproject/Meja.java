
package testproject;

//PROJECT PBO

import java.util.ArrayList;

public class Meja implements java.io.Serializable{
    static Meja[] listMeja = new Meja[10]; 
    private int nomerMeja;
    private ArrayList<DTrans> listPesanan = new ArrayList<>();

    public Meja(int nomor) {
        this.nomerMeja = nomor;
    }

    public int getNomerMeja() {
        return nomerMeja;
    }

    public void setNomerMeja(int nomerMeja) {
        this.nomerMeja = nomerMeja;
    }

    public ArrayList<DTrans> getListPesanan() {
        return listPesanan;
    }

    public void setListPesanan(ArrayList<DTrans> listPesanan) {
        this.listPesanan = listPesanan;
    }
    
    
    
}
