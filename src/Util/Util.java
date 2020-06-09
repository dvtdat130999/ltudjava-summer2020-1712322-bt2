package Util;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class Util {
    public static void show()
    {
        System.out.println("Chon chuc nang (vi du 2a)");
        System.out.println("1.Xem danh sach hoc sinh");
        System.out.println("    a.Ma hoc sinh tang dan");
        System.out.println("    b.Ma hoc sinh giam dan");
        System.out.println("    c.Diem tang dan");
        System.out.println("    d.Diem giam dan");
        System.out.println("2.Them hoc sinh");
        System.out.println("3.Xoa hoc sinh");
        System.out.println("4.Cap nhat thong tin hoc sinh");
        System.out.println("5.Import danh sach hoc sinh");
        System.out.println("6.Export thong tin hoc sinh");
        System.out.println("7.Ket thuc chuong trinh");


    }
    public static int stringCompare(String str1, String str2)
    {

        int l1 = str1.length();
        int l2 = str2.length();
        int lmin = Math.min(l1, l2);

        for (int i = 0; i < lmin; i++) {
            int str1_ch = (int)str1.charAt(i);
            int str2_ch = (int)str2.charAt(i);

            if (str1_ch != str2_ch) {
                return str1_ch - str2_ch;
            }
        }

        // Edge case for strings like
        // String 1="Geeks" and String 2="Geeksforgeeks"
        if (l1 != l2) {
            return l1 - l2;
        }

        // If none of the above conditions is true,
        // it implies both the strings are equal
        else {
            return 0;
        }
    }
    public static boolean checkSecondLine(String csvLine)
    {
        if(Util.stringCompare(ExportCSV.FILE_HEADER,csvLine)==0)
            return true;
        return false;
    }
    public static boolean checkSecondLine(String csvLine)
    {
        if(Util.stringCompare(ExportCSV.FILE_HEADER,csvLine)==0)
            return true;
        return false;
    }




}
