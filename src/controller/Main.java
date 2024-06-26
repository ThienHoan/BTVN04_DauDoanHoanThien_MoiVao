/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import model.SinhVien;

/**
 *
 * @author hoan6
 */
public class Main {

    static Scanner sc = new Scanner(System.in);
    static ArrayList<SinhVien> listSV = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            System.out.println("*****Menu*****");
            System.out.println("1. Them Sinh Vien Vao Lop");
            System.out.println("2. Xoa SVien Khoi Lop");
            System.out.println("3. In Thong Tin");
            System.out.println("4. Sua Thong Tin them mssv");
            System.out.println("5. In ra thong tin toan bo sVien Nam");
            System.out.println("6. In ra thong tin toan bo sVien Nu");
            System.out.println("7. Quit");
            System.out.println("Moi ban chon: ");

            int choice;
            try {
                choice = sc.nextInt();
                sc.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Vui long nhap tu 1...4");
                sc.nextLine();
                continue;
            }

            switch (choice) {
                case 1:
                    addSV();
                    break;
                case 2:
                    rmSV();
                    break;
                case 3:
                    printSV();
                    break;
                case 4:
                    fixMssv();
                    break;
                case 5:
                   printNam();
                    break;
                case 6:
                    printNu();
                    break;
                case 7:
                    System.out.println("Hen gap lai.");
                    break;

            }
            if (choice == 7) {
                break;
            }
        }
    }

    public static void addSV() {
        System.out.println("Moi ban nhap id: ");
        String id = sc.nextLine();
        System.out.println("Moi ban nhap ten:  ");
        String name = sc.nextLine();
        System.out.println("Moi ban nhap gioi tinh: ");
        String gender = sc.nextLine();
        System.out.println("Moi ban nhap chuyen nganh: ");
        String major = sc.nextLine();

        SinhVien sV = new SinhVien(id, name, gender, major);

        listSV.add(sV);
        System.out.println("Them Thanh Cong.");
    }

    public static void rmSV() {
        for (SinhVien sinhVien : listSV) {
            System.out.println(sinhVien);
        }
        System.out.println("Ban muon xoa SVien nao?");
        int rm = Integer.parseInt(sc.nextLine());
        listSV.remove(rm);
    }

    public static void printSV() {
        for (SinhVien sinhVien : listSV) {
            System.out.println(sinhVien);
            System.out.println("So luong sinh vien trong mang hien co: " + listSV.size());
        }
    }

    public static void fixMssv() {
        System.out.println("Nhap mssv ban muon sua: ");
        String fix = sc.nextLine();
        for (int i = 0; i < listSV.size(); i++) {
            if (listSV.get(i).getId().equals(fix)) {
                System.out.println("Moi ban nhap id moi: ");
                String newid = sc.nextLine();
                System.out.println("Moi ban nhap ten moi:  ");
                String newname = sc.nextLine();
                System.out.println("Moi ban nhap gioi tinh moi: ");
                String newgender = sc.nextLine();
                System.out.println("Moi ban nhap chuyen nganh moi: ");
                String newmajor = sc.nextLine();
                listSV.get(i).setId(newid);
                listSV.get(i).setName(newname);
                listSV.get(i).setGender(newgender);
                listSV.get(i).setMajor(newmajor);
            }

        }

    }
    
    public static void printNam(){
        for (int i = 0; i < listSV.size(); i++) {
            if(listSV.get(i).getGender().equalsIgnoreCase("Nam"))
                System.out.println(listSV);
            
        }
    }
    
    public static void printNu(){
        for (int i = 0; i < listSV.size(); i++) {
            if(listSV.get(i).getGender().equalsIgnoreCase("Nu"))
                System.out.println(listSV);
            
        }
    }
}
