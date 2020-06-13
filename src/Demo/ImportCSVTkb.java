package Demo;

import DTO.Lop;
import DTO.MonHoc;
import DTO.SinhVien;
import DTO.ThoiKhoaBieu;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ImportCSVTkb {
    private static final String COMMA_DELIMITER = ",";
    // CSV file second line
    public static String FILE_SECOND_LINE = "STT,Mã môn,Tên môn,Phòng học";

    public static ThoiKhoaBieu ReadCsvFile(String src) throws IOException {
        ThoiKhoaBieu tkb=new ThoiKhoaBieu();
        BufferedReader br = null;
        List<MonHoc> monHocs=new ArrayList<MonHoc>();
        try {
            String line;
            br = new BufferedReader(new FileReader(src));
            line=br.readLine();//dong dong dau
            String[] information=parseCsvLine(line);
            tkb.setLop(information[0]);
            tkb.setNam(information[1]);
            tkb.setHocKy(Integer.parseInt(information[2]));


            line=br.readLine();//doc dong thu hai

            // How to read file in java line by line?
            while ((line = br.readLine()) != null)
            {
                MonHoc a=new MonHoc();
                information=parseCsvLine(line);
                a.setMa(information[1]);
                a.setTen(information[2]);
                a.setPhong(information[3]);

                monHocs.add(a);

            }
            br.close();

        } catch (IOException e) {
            System.out.println("Mo file that bai");
        }

        tkb.setMon(monHocs);
        return tkb;

    }


    public static String[] parseCsvLine(String csvLine) {
        String[] splitData = csvLine.split(COMMA_DELIMITER);


        return splitData;



    }
}
