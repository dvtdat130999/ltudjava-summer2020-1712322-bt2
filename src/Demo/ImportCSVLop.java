package Demo;

import DTO.Lop;
import DTO.SinhVien;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ImportCSVLop {
    private static final String COMMA_DELIMITER = ",";
    // CSV file second line
    public static String FILE_SECOND_LINE = "STT,MSSV,Họ tên, Giới tính, CMND";

    public static Lop ReadCsvFile(String src) throws IOException {
        Lop lop=new Lop();
        BufferedReader br = null;
        List<SinhVien> sinhViens=new ArrayList<SinhVien>();
        try {
            String line;
            br = new BufferedReader(new FileReader(src));
            line=br.readLine();
            lop.setTenLop(line);

            line=br.readLine();//doc dong thu hai

            // How to read file in java line by line?
            while ((line = br.readLine()) != null)
            {
                SinhVien a=new SinhVien();
                String[] information=parseCsvLine(line);
                a.setMssv(Integer.parseInt(information[1]));
                a.setHoTen(information[2]);
                a.setGioiTinh(information[3]);
                a.setCmnd(information[4]);
                a.setLop(lop);

                sinhViens.add(a);

            }
            br.close();

        } catch (IOException e) {
            System.out.println("Mo file that bai");
        }

        lop.setSinhVien(sinhViens);
        return lop;

    }


    public static String[] parseCsvLine(String csvLine) {
        String[] splitData = csvLine.split(COMMA_DELIMITER);


        return splitData;



    }
}
