/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package person;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author No Name
 */
public class Student extends Person {
    String masv, email;
    Float dtk;

    public Student() {
    }

    public Student(String hoten, String diachi, String gioitinh, String ngaysinh, String masv, String email, Float dtk) {
        super(hoten, diachi, gioitinh, ngaysinh);
        this.masv = masv;
        this.email = email;
        this.dtk = dtk;
    }

    public String getMasv() {
        return masv;
    }

    public void setMasv(String masv) {
        this.masv = masv;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Float getDtk() {
        return dtk;
    }

    public void setDtk(Float dtk) {
        this.dtk = dtk;
    }
    
    public void ghi_data() throws IOException, FileNotFoundException, ClassNotFoundException {
        File f = new File("E:\\Documents\\Java\\student.dat");
        Student st = new Student(this.hoten, this.diachi, this.gioitinh, this.ngaysinh, this.masv, this.email, this.dtk);
        ArrayList<Student> arr_st = this.doc_data();
        
        if (!f.exists())
            f.createNewFile();
        
        arr_st.add(st);
        FileOutputStream fos = new FileOutputStream(f);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(arr_st);
        System.out.println("Ghi Student thành công!");
        
        oos.close();
        fos.close();
    }
    
    public ArrayList doc_data() throws FileNotFoundException, IOException, ClassNotFoundException {
        File f = new File("E:\\Documents\\Java\\student.dat");
        ArrayList<Student> arr_st = new ArrayList();
        
        if (!f.exists())
            f.createNewFile();
                 
        try (FileInputStream fis = new FileInputStream(f); 
                ObjectInputStream ois = new ObjectInputStream(fis)) {
            arr_st = (ArrayList) ois.readObject();
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
        return arr_st;
    }
    
    public void create_table() throws IOException, FileNotFoundException, FileNotFoundException, ClassNotFoundException {
        String[] columnNames = {"Họ tên", "Giới tính", "Ngày sinh", "Địa chỉ", "Mã sinh viên", "Email", "Điểm tổng kết"};
        ArrayList<Student> arr_st = new ArrayList();
        Student st = new Student();

        arr_st = st.doc_data();
        DefaultTableModel model;
        JTable table = new JTable();
        model = (DefaultTableModel) table.getModel();
        JFrame jf = new JFrame();
        jf.setSize(700, 500);
      
        model.setColumnIdentifiers(columnNames);
        for (Student st1: arr_st) {
            model.addRow(new Object[] {
                st1.hoten, st1.diachi, st1.gioitinh, st1.ngaysinh, 
                st1.getMasv(), st1.getEmail(), st1.getDtk()
            });
        }
        JScrollPane jsp = new JScrollPane(table);
        table.setFillsViewportHeight(true);
        jf.add(table);
        jf.setVisible(true);
    }
}

