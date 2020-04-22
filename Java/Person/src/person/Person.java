/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package person;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.Scanner;
import person.NewJFrame;
/**
 *
 * @author No Name
 */

public class Person implements Serializable {
    private static final long serialVersionUID = 1L;
    
    public String hoten, diachi, gioitinh, ngaysinh;
    public Person() {
    }
    public Person(String hoten, String diachi, String gioitinh, String ngaysinh) {
        this.hoten = hoten;
        this.diachi = diachi;
        this.gioitinh = gioitinh;
        this.ngaysinh = ngaysinh;
    }
    public void nhap() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập họ tên: ");
        hoten = scanner.nextLine();
        System.out.println("Nhập ngày sinh: ");
        ngaysinh = scanner.nextLine();
        System.out.println("Nhập Địa chỉ: ");
        diachi = scanner.nextLine();
        System.out.println("Nhập giới tính: ");
        gioitinh = scanner.nextLine();
    }
    public void hienthi() {
        System.out.println("Họ tên: " + hoten);
        System.out.println("Ngày sinh: " + ngaysinh);
        System.out.println("Địa chỉ: " + diachi);
        System.out.println("Giới tính: " + gioitinh);
    }
    public String xuat() {
        return "Họ tên: " + hoten + "\t Ngày sinh: " + ngaysinh;
    }

    public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException {
        NhanVien nv = new NhanVien("1", "1", "1", "1", "1", 1, 1, 1, 1);
        NhanVien nv1 = new NhanVien();
        nv.ghi_data();
        nv1.doc_data();
    }
}
