/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baitapngay6thang9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author LongTienSinh
 */
public class QuanLySinhVien {

    /**
     * @param args the command line arguments
     */
    public static Scanner sc = new Scanner(System.in);
    public static ArrayList<SinhVien> sinhViens = new ArrayList<>();

    public static void main(String[] args) {
        // TODO code application logic here

        int chose = 0;
        do {
            try {
                System.out.println("\t\t-----------MENU--------------");
                System.out.println("Chọn 1 để nhập thông tin sinh viên");
                System.out.println("Chọn 2 để sửa thông tin sinh viên");
                System.out.println("Chọn 3 để xóa thông tin sinh viên");
                System.out.println("Chọn 4 để hiển thị thông tin danh sách sinh viên");
                System.out.println("Chọn 5 để sắp xếp sinh viên theo trường mong muốn");
                System.out.println("Chọn 6 để lọc sinh viên theo hệ");
                System.out.println("Chọn 7 để tìm kiếm sinh viên");
                System.out.println("Chọn 0 để thoát chương trình");
                System.out.print("Chọn: ");
                chose = sc.nextInt();
                if (chose < 0 || chose > 7) {
                    throw new Exception("Không có lựa chọn này! Hãy chọn lại");
                }
            } catch (NumberFormatException e) {
                System.out.println("Hãy nhập lựa chọn đúng định dạng");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            switch (chose) {
                case 1:
                    nhap();
                    break;
                case 2:
                    sua();
                    break;
                case 3:
                    xoa();
                    break;
                case 4:
                    xuat();
                    break;
                case 5:
                    sapXep();
                    break;
                case 6:
                    loc();
                    break;
                case 7:
                    timKiem();
                    break;
            }
        } while (chose != 0);
    }

    private static void nhap() {
        int chose = 0;
        do {
            SinhVien newSV = new SinhVien();
            newSV.nhap();
            sinhViens.add(newSV);
            System.out.println("Tiếp tục thêm sinh viên?");
            System.out.println("\t1.ok");
            System.out.println("\tNhập 0 để ngừng thêm sinh viên");
            sc.nextLine();
            chose = sc.nextInt();
        } while (chose == 1);
    }

    public static Boolean checkSDT(String sdt) {//Kiếm tra xem số điện thoại có trùng nhau hay không
        for (SinhVien sv : sinhViens) {
            if (sdt.equals(sv.getSDT())) {
                return true;
            }
        }
        return false;
    }

    private static void xuat() {
        System.out.println("\t\t--Xuất thông tin sinh viên--");
        if (sinhViens.isEmpty()) {
            System.out.println("Không có sinh viên");
        } else {
            SinhVien.formXuat();
            for (SinhVien sv : sinhViens) {
                sv.xuat();
            }
        }
    }

    private static void sua() {
        int vt; //Biến vị trí
        SinhVien sv = new SinhVien();
        System.out.println("\t\t--Sửa thông tin sinh viên--");
        while (true) {
            try {
                System.out.print("Nhập vị trí sinh viên cần sửa: ");
                sc.nextLine();
                vt = sc.nextInt();
                if (vt > sinhViens.size()) {
                    throw new Exception("vị trí sinh viên vượt quá số lượng sinh viên hiện có");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Vị trí của sinh viên phải là số nguyên");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("Nhập thông tin sinh viên cần sửa");
        sv.nhap();
        sinhViens.set(vt, sv);
        System.out.println("Sửa thành công!");
    }

    private static void xoa() {
        int vt;
        while (true) {
            try {
                System.out.print("Nhập vị trí sinh viên cần xóa: ");
                sc.nextLine();
                vt = sc.nextInt();
                if (vt > sinhViens.size()) {
                    System.out.println("vị trí sinh viên vượt quá số lượng sinh viên hiện có! Hãy nhập lại");
                } else {
                    sinhViens.remove(vt);
                    System.out.println("Xóa thành công");
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Vị trí cần xóa phải là số nguyên");
            }
        }

    }

    private static void sapXep() {
        int chose = -1;
        System.out.println("----Sắp xếp theo tiêu trí----");
        while (true) {
            try {
                System.out.println("1. Theo tên");
                System.out.println("2. Theo năm sinh");
                System.out.println("3. Theo số ĐT");
                System.out.println("4. Theo chuyên ngành");
                System.out.println("0. Thôi");
                sc.nextLine();
                chose = sc.nextInt();
                if (chose < 0 || chose > 4) {
                    throw new Exception("Không có lựa chọn này");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Nhập vào không đúng định dạng! Hãy nhập lại");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        if (chose == 1) {
            Comparator<SinhVien> sv = new Comparator<SinhVien>() {
                @Override
                public int compare(SinhVien o1, SinhVien o2) {
                    return o1.getTen().compareTo(o2.getTen());
                    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
            };
            Collections.sort(sinhViens, sv);
        }
        if (chose == 2) {
            Comparator<SinhVien> sv = new Comparator<SinhVien>() {
                @Override
                public int compare(SinhVien o1, SinhVien o2) {
                    return o1.getNamSinh() - (o2.getNamSinh());
                    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
            };
            Collections.sort(sinhViens, sv);
        }
        if (chose == 3) {
            Comparator<SinhVien> sv = new Comparator<SinhVien>() {
                @Override
                public int compare(SinhVien o1, SinhVien o2) {
                    return o1.getSDT().compareTo(o2.getSDT());
                    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
            };
            Collections.sort(sinhViens, sv);
        }
        if (chose == 4) {
            Comparator<SinhVien> sv = new Comparator<SinhVien>() {
                @Override
                public int compare(SinhVien o1, SinhVien o2) {
                    return o1.getChuyenNganh().compareTo(o2.getChuyenNganh());
                    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
            };
            Collections.sort(sinhViens, sv);
        }
        System.out.println("--Thông tin sau khi sắp xếp: ");
        xuat();
    }

    private static void loc() {
        int chose = 0;
        String he = "";
        System.out.println("--Lọc sinh viên theo hệ--");
        System.out.println("1. Hệ đại học");
        System.out.println("2. Hệ cao đẳng");
        System.out.print("Chọn: ");
        sc.nextLine();
        chose = sc.nextInt();
        if (chose == 1) {
            he = "Đại học";
        } else {
            he = "Cao đẳng";
        }
        ArrayList<SinhVien> listSV = new ArrayList<>();
        for (SinhVien sv : sinhViens) {
            if (sv.getChuyenNganh().equals(he)) {
                listSV.add(sv);
            }
        }
        if (listSV.isEmpty()) {
            System.out.println("Không có sinh viên nào thuộc hệ " + he);
        } else {
            SinhVien.formXuat();
            for (SinhVien sv : listSV) {
                sv.xuat();
            }
        }
    }

    private static void timKiem() {
        int chose = 0;
        System.out.println("--Tìm Kiếm--");
        while (true) {
            try {
                System.out.println("1. Tìm kiếm theo tên");
                System.out.println("2. Tìm kiếm theo năm sinh");
                System.out.println("3. Tìm kiếm theo số ĐT");
                System.out.println("4. Tìm kiếm theo hệ");
                System.out.print("Chọn: ");
                sc.nextLine();
                chose = sc.nextInt();
                if(chose < 1 || chose > 4)
                    throw new Exception("Không có lựa chọn này! Hãy nhập lại");
                break;
            } catch (NumberFormatException e) {
                System.out.println("Lựa chọn không đúng định dạng! Hãy nhập lại");
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
        ArrayList<SinhVien> listSV = new ArrayList<>();
        System.out.print("Nhập từ khóa tìm kiếm: ");
        if (chose == 1) {
            sc.nextLine();
            String tuKhoa = sc.nextLine();
            for (SinhVien sv : sinhViens) {
                if (sv.getTen().toLowerCase().contains(tuKhoa.toLowerCase()))// So sánh không phân biệt hoa thường
                {
                    listSV.add(sv);
                }
            }
        }
        if (chose == 2) {
            sc.nextLine();
            int tuKhoa = sc.nextInt();
            for (SinhVien sv : sinhViens) {
                if (tuKhoa == sv.getNamSinh())// So sánh năm sinh
                {
                    listSV.add(sv);
                }
            }
        }
        if (chose == 3) {
            sc.nextLine();
            String tuKhoa = sc.nextLine();
            for (SinhVien sv : sinhViens) {
                if (sv.getSDT().toLowerCase().contains(tuKhoa.toLowerCase()))// So sánh không phân biệt hoa thường
                {
                    listSV.add(sv);
                }
            }
        }
        if (chose == 4) {
            sc.nextLine();
            String tuKhoa = sc.nextLine();
            for (SinhVien sv : sinhViens) {
                if (sv.getChuyenNganh().toLowerCase().contains(tuKhoa.toLowerCase()))// So sánh không phân biệt hoa thường
                {
                    listSV.add(sv);
                }
            }
        }
        System.out.println("Kết quả tìm kiếm: ");
        SinhVien.formXuat();
        for (SinhVien sv : listSV) {
            sv.xuat();
        }
    }
}
