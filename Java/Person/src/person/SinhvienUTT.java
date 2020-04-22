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
public class SinhvienUTT extends Sinhvien{
    public String donvi;
    public int luong;

    public String getDonvi() {
        return donvi;
    }
    public void setDonvi(String donvi) {
        this.donvi = donvi;
    }
    public int getLuong() {
        return luong;
    }
    public void setLuong(int luong) {
        this.luong = luong;
    }
    
    public SinhvienUTT() {
    }
    public SinhvienUTT(String donvi, int luong, String masv, String hoten, String gioitinh, String dtb) {
        super(masv, hoten, gioitinh, dtb);
        this.donvi = donvi;
        this.luong = luong;
    }
    
    public void hienthi() {
        super.xuat();
        System.out.println("Đơn vị = " + donvi);
        System.out.println("Lương = " + luong);
    }
}
