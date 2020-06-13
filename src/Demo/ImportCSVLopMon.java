package Demo;

import DAO.LopDAO;
import DTO.Lop;
import DTO.Lop_MonHoc;
import DTO.SinhVien;
import DTO.SinhVien_Lop_Mon;

import javax.persistence.criteria.CriteriaBuilder;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ImportCSVLopMon {
    private static final String COMMA_DELIMITER = ",";

    // CSV file second line
    public static String FILE_SECOND_LINE = "STT,MSSV,Họ tên,Giới tính,CMND";

    public static SinhVien_Lop_Mon ReadCsvFile(String src) throws IOException {
        SinhVien_Lop_Mon lm=new SinhVien_Lop_Mon();
        BufferedReader br = null;
        List<SinhVien> sinhViens=new ArrayList<SinhVien>();
        try {
            String line;
            br = new BufferedReader(new FileReader(src));
            line=br.readLine();//doc dong thu nhat
            String[] information=parseCsvLine(line);

            lm.setTenLop(information[0]);
            lm.setMaMon(information[1]);

            Lop lop= LopDAO.searchLop(information[0]);

            line=br.readLine();//doc dong thu hai

            // How to read file in java line by line?
            while ((line = br.readLine()) != null)
            {
                SinhVien a=new SinhVien();
                information=parseCsvLine(line);
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

        lm.setSinhVien(sinhViens);
        return lm;

    }


    public static String[] parseCsvLine(String csvLine) {
        String[] splitData = csvLine.split(COMMA_DELIMITER);


        return splitData;



    }
}
