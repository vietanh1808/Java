/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Book;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author No Name
 */
public class book implements Serializable {
    String id, authors, title, category;
//    tapchi, KHTN, KHXH, luanvan

    public book() {
        
    }

    public book(String id, String authors, String title, String category) {
        this.id = id;
        this.authors = authors;
        this.title = title;
        this.category = category;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
    
    public void ghi_data() throws FileNotFoundException, IOException, ClassNotFoundException {
        File f = new File("E:\\Documents\\Java\\books.dat");
        ArrayList<book> books = this.doc_data();
        if (!f.exists())
            f.createNewFile();
        FileOutputStream fos = new FileOutputStream(f);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        book b = new book(this.id, this.authors, this.title, this.category);
        books.add(b);
        oos.writeObject(books);
        System.out.println("Lưu thành công!");
        oos.close();
        fos.close();
    }
    
    public ArrayList doc_data() throws IOException, ClassNotFoundException {
        File f = new File("E:\\Documents\\Java\\books.dat");
        if (!f.exists())
            f.createNewFile();
        ArrayList<book> books = null;
        try (FileInputStream fis = new FileInputStream(f); ObjectInputStream ois = new ObjectInputStream(fis)) {
             books = (ArrayList<book>) ois.readObject();
            for (book b: books)
                System.out.println("ID: " + b.id);
            fis.close();
            ois.close();
        } catch(Exception e) {
            books = new ArrayList<book>();
        }
        return books;
    }
    
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        book b = new book();
        
        b.doc_data();
    }
}
