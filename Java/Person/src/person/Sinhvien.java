package person;

import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
/**
 *
 * @author No Name
 */

public class Sinhvien implements Serializable {
    
    private static final long serialVersionUID = 1L;
    String masv, hoten, gioitinh, dtb;
    
    public Sinhvien() {
    }
    public Sinhvien(String masv, String hoten, String gioitinh, String dtb) {
        this.masv = masv;
        this.hoten = hoten;
        this.gioitinh = gioitinh;
        this.dtb = dtb;
    }

    public String getMasv() {
        return masv;
    }
    public void setMasv(String masv) {
        this.masv = masv;
    }
    public String getHoten() {
        return hoten;
    }
    public void setHoten(String hoten) {
        this.hoten = hoten;
    }
    public String getGioitinh() {
        return gioitinh;
    }
    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }
    public String getDtb() {
        return dtb;
    }
    public void setDtb(String dtb) {
        this.dtb = dtb;
    }    
    
    public void nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.println("masv: ");
        masv = sc.nextLine();
        System.out.println("hoten: ");
        hoten = sc.nextLine();
        System.out.println("gioitinh: " );
        gioitinh = sc.nextLine();
        System.out.println("dtb: " );
        dtb = sc.nextLine();
    }  
    public void xuat() {
        System.out.println("Mã sinh viên: " + masv);
        System.out.println("Họ tên: " + hoten);
        System.out.println("Giới tính: " + gioitinh);
        System.out.println("Điểm trung bình: " + dtb);
    }
    public String getinfo() {
        return "Mã sinh viên: " + masv + "; Tên: " + hoten + 
               "; Giới tính: " + gioitinh + "; Điểm trung bình: " + dtb;
    }
    
    public void ghi_file_svutt(File f ,ArrayList<Sinhvien> arr_sv) throws IOException {
        if (!f.exists()) {
            f.createNewFile();
        }
        FileOutputStream fos = new FileOutputStream(f); 
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(arr_sv);
        oos.close();
        fos.close();
    }
    public void ghi_file_svhttt(File f ,ArrayList<Sinhvien> arr_sv) throws IOException {
        if (!f.exists()) {
            f.createNewFile();
        }
        FileOutputStream fos = new FileOutputStream(f); 
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(arr_sv);
        oos.close();
        fos.close();
    }
    
    public ArrayList doc_file_svutt(File f) throws FileNotFoundException, IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(f);
        ObjectInputStream ois = new ObjectInputStream (fis);
        ArrayList<Sinhvien> arr_sv = (ArrayList<Sinhvien>) ois.readObject();
        return arr_sv;
    }
    public ArrayList doc_file_svhttt(File f) throws FileNotFoundException, IOException, ClassNotFoundException {        
        FileInputStream fis = new FileInputStream(f);
        ObjectInputStream ois = new ObjectInputStream (fis);
        ArrayList<Sinhvien> arr_sv = (ArrayList<Sinhvien>) ois.readObject();
        return arr_sv;
    }  
    
    public static void main(String[] args) throws ClassNotFoundException, IOException  {
        Scanner sc1 = new Scanner(System.in);
        ArrayList<Sinhvien> arr_svutt = null;
        ArrayList<Sinhvien> arr_svhttt = null;
        Sinhvien sv1 = new Sinhvien();
        File f = new File("E:\\Documents\\Java\\svhttt.dat");
        File f1 = new File("E:\\Documents\\Java\\svutt.dat");
        boolean k = true;
        
        arr_svutt = sv1.doc_file_svutt(f);
        arr_svhttt = sv1.doc_file_svhttt(f1);
        
        System.out.println("+------------------------------------------+");
        System.out.println("| Bấm 1. Để nhập cho sinh viên UTT         |");
        System.out.println("| Bấm 2. Để nhập cho sinh viên HTTT        |");
        System.out.println("| Bấm 3. Để  THOÁT khỏi chương trình       |");
        System.out.println("| Bấm 4. Để xuất dữ liệu sinh viên UTT     |");
        System.out.println("| Bấm 5. Để xuất dữ liệu sinh viên HTTT    |");
        System.out.println("+------------------------------------------+");
        
        while(k == true) {
            Sinhvien sv = new Sinhvien();
            System.out.println("Mời bạn nhập số: " + "");
            int nhap = Integer.parseInt(sc1.nextLine());
            
            switch (nhap) {
                case 1:
                    sv.nhap();
                    arr_svutt.add(sv);
                    System.out.println("Ghi thành công");
                    break;
                case 2:
                    sv.nhap();
                    arr_svhttt.add(sv);
                    System.out.println("Ghi thành công");
                    break;
                case 3:
                    k = false;
                    break;
                case 4:
                    System.out.println("---------Dữ liệu sinh viên UTT---------");
                    for (Sinhvien svutt: arr_svutt)
                        System.out.println(svutt.getinfo());
                    break;
                case 5:
                    System.out.println("---------Dữ liệu sinh viên HTTT---------");
                    for (Sinhvien svhttt: arr_svhttt)
                        System.out.println(svhttt.getinfo());
                    break;
                default:
                    System.out.println("Bạn đã bấm sai số. Mời bạn nhập lại");
            }
        }   
        //// ghi đối tượng ở đây
        sv1.ghi_file_svutt(f, arr_svutt);
        sv1.ghi_file_svutt(f1, arr_svhttt);
        
    }
}
