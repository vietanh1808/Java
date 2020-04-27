/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package person;

/**
 *
 * @author No Name
 */
public class SinhvienHTTT extends Sinhvien {
    public int hocphi;

    public int getHocphi() {
        return hocphi;
    }
    public void setHocphi(int hocphi) {
        this.hocphi = hocphi;
    }
    
    public SinhvienHTTT() {
    }
    public SinhvienHTTT(int hocphi, String masv, String hoten, String gioitinh, String dtb) {
        super(masv, hoten, gioitinh, dtb);
        this.hocphi = hocphi;
    }
   
    public void hienthi() {
        super.xuat();
        System.out.println("học phí = " + hocphi);
    }
    public static void main(String[] args) {
        
    }

}
