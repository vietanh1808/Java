/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package person;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
/**
 *
 * @author No Name
 */
public class NhanVien extends Person {
    private static final long serialVersionUID = 1L;
    
    public String phongban;
    public float heso, thamnien, luongthuclinh, luongcoban;

    public NhanVien() {
    }
    public NhanVien(String hoten, String diachi, String gioitinh, String ngaysinh, String phongban, float heso, float thamnien, float luongthuclinh, float luongcoban) {
        super(hoten, diachi, gioitinh, ngaysinh);
        this.phongban = phongban;
        this.heso = heso;
        this.thamnien = thamnien;
        this.luongthuclinh = luongthuclinh;
        this.luongcoban = luongcoban;
    }
    public String getPhongban() {
        return phongban;
    }

    public void setPhongban(String phongban) {
        this.phongban = phongban;
    }

    public float getHeso() {
        return heso;
    }

    public void setHeso(float heso) {
        this.heso = heso;
    }

    public float getThamnien() {
        return thamnien;
    }

    public void setThamnien(float thamnien) {
        this.thamnien = thamnien;
    }

    public float getLuongthuclinh() {
        return luongthuclinh;
    }

    public void setLuongthuclinh(float luongthuclinh) {
        this.luongthuclinh = luongthuclinh;
    }

    public float getLuongcoban() {
        return luongcoban;
    }

    public void setLuongcoban(float luongcoban) {
        this.luongcoban = luongcoban;
    }
        
    public void ghi_data() throws FileNotFoundException, IOException, ClassNotFoundException {
        
        File f = new File("E:\\Documents\\Java\\nhanvien.dat");
        NhanVien nv = new NhanVien(this.hoten, this.diachi, this.gioitinh, this.ngaysinh, this.phongban, this.heso, this.thamnien, this.luongthuclinh, this.luongcoban);
        ArrayList<NhanVien> arr_nv = this.doc_data();
        
        if (!f.exists())
            f.createNewFile();
        
        FileOutputStream fos = new FileOutputStream(f);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        arr_nv.add(nv);
        oos.writeObject(arr_nv);
        System.out.println("Lưu thành công");
        
        fos.close();
        oos.close();
    }
    
    public ArrayList doc_data() throws FileNotFoundException, IOException, ClassNotFoundException {
        File f = new File("E:\\Documents\\Java\\nhanvien.dat");
        
        ArrayList<NhanVien> arr_nv = null;
        if (!f.exists())
            f.createNewFile();
        
        try (FileInputStream fis = new FileInputStream(f); ObjectInputStream ois = new ObjectInputStream(fis)) {
            arr_nv = (ArrayList<NhanVien>) ois.readObject();
            for (NhanVien nhanvien: arr_nv)
                System.out.println("Họ tên: " + nhanvien.hoten);
            fis.close();
            ois.close();
        }
        catch (Exception e) {
            System.out.println("Chưa có dữ liệu người dùng hãy ghi thêm dữ liệu");
        }
        return arr_nv;
    }
    
    public float luong() {
        return luongthuclinh = luongcoban * heso*(1 + thamnien / 100);
    }
}
