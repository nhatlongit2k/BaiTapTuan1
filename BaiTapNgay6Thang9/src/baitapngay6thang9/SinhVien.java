/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baitapngay6thang9;

import java.awt.FontFormatException;
import java.util.Scanner;

/**
 *
 * @author LongTienSinh
 */
public class SinhVien {

    private String ten;
    private int namSinh;
    private String SDT;
    private String chuyenNganh;

    public SinhVien() {
    }

    public SinhVien(String ten, int namSinh, String SDT, String chuyenNganh) {
        this.ten = ten;
        this.namSinh = namSinh;
        this.SDT = SDT;
        this.chuyenNganh = chuyenNganh;
    }

    public String getTen() {
        return ten;
    }

    public int getNamSinh() {
        return namSinh;
    }

    public String getSDT() {
        return SDT;
    }

    public String getChuyenNganh() {
        return chuyenNganh;
    }

    public void setTen(String ten) throws Exception {
        this.ten = ten;
        if(this.ten.equals(""))
            throw new Exception("Tên không được để trống!");
    }

    public void setNamSinh(int namSinh) throws NumberFormatException {
        this.namSinh = namSinh;
    }

    public void setSDT(String SDT) throws Exception {
        this.SDT = SDT;
        if(this.SDT.equals(""))
            throw new Exception("Số điện thoại không được để trống!");
    }

    public void setChuyenNganh(String chuyenNganh) {
        this.chuyenNganh = chuyenNganh;
    }

    //Hàm nhập cho sinh viên
    public void nhap() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                int CN = 0;//Dùng để lựa chọn chuyên ngành
                System.out.print("Nhập tên sinh viên: ");
                setTen(sc.nextLine());
                System.out.print("Nhập năm sinh: ");
                setNamSinh(Integer.parseInt(sc.nextLine()));
                System.out.print("Nhập số điện thoại: ");
                setSDT(sc.nextLine());
                if(QuanLySinhVien.checkSDT(getSDT()))
                    throw new Exception("Số điện thoại này đã tồn tại rồi!!");
                System.out.println("Nhập chuyên ngành: ");
                while (CN < 1 || CN > 2) {
                    System.out.println("\t 1.Đại học");
                    System.out.println("\t 2.Cao đẳng");
                    System.out.print("\t Chọn:");
                    CN = Integer.parseInt(sc.nextLine());
                    if (CN > 2 && CN < 1) {
                        System.out.println("Chỉ được chọn 1 hoặc 2! Hãy chọn lại");
                    }
                }
                if (CN == 1) {
                    chuyenNganh = "Đại học";
                } else {
                    chuyenNganh = "Cao đẳng";
                }
                break;//Nếu không có lỗi gì thì thoát vòng lặp
            } catch (NumberFormatException e) {
                System.out.println("Năm sinh chỉ được nhập số nguyên! Hãy nhập lại");
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static void formXuat() {
        System.out.printf("%10s%30s%20s\n", "Tên", "Số điện thoại", "Hệ");
    }

    public void xuat() {
        System.out.printf("%10s%30s%20s\n", ten, SDT, chuyenNganh);
    }
}
