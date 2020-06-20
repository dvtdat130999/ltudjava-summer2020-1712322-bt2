package Demo;

import DTO.DiemSinhVien;
import DTO.Lop;
import DTO.SinhVien;

import javax.persistence.criteria.CriteriaBuilder;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ImportCSVDiem {
    private static final String COMMA_DELIMITER = ",";
    // CSV file second line
    public static String FILE_SECOND_LINE = "STT,MSSV,Họ tên,Điểm GK,Điểm CK,Điểm khác,Điểm tổng";

    public static List<DiemSinhVien> ReadCsvFile(String src) throws IOException {
        List<DiemSinhVien> dsv=new ArrayList<>();
        BufferedReader br = null;
        try {
            String line;
            br = new BufferedReader(new FileReader(src));
            line=br.readLine();//doc dong dau
            String[] information=parseCsvLine(line);
            String tenLop=information[0];
            String mon=information[1];
            String nam=information[2];
            int hocKy=Integer.parseInt(information[3]);


            line=br.readLine();//doc dong thu hai

            // How to read file in java line by line?
            while ((line = br.readLine()) != null)
            {
                DiemSinhVien a=new DiemSinhVien();
                information=parseCsvLine(line);

                a.setMssv(Integer.parseInt(information[1]));
                a.setHoTen(information[2]);
                a.setDiemGk(Double.parseDouble(information[3]));
                a.setDiemCk(Double.parseDouble(information[4]));
                a.setDiemKhac(Double.parseDouble(information[5]));
                a.setDiemTong(Double.parseDouble(information[6]));

                a.setMaMon(mon);
                a.setLop(tenLop);
                a.setNam(nam);
                a.setHocKy(hocKy);


                dsv.add(a);

            }
            br.close();

        } catch (IOException e) {
            System.out.println("Mo file that bai");
        }

        return dsv;

    }


    public static String[] parseCsvLine(String csvLine) {
        String[] splitData = csvLine.split(COMMA_DELIMITER);


        return splitData;



    }
}
