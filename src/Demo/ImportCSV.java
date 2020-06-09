package Demo;

import DTO.Lop;
import DTO.SinhVien;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ImportCSV {
    private static final String COMMA_DELIMITER = ",";
    // CSV file second line
    public static String FILE_SECOND_LINE = "mhs,ten,dia chi,diem,ghi chu,hinh anh";

    public static Lop ReadCsvFile(String src) throws IOException {
        Lop lop=null;
        BufferedReader br = null;
        boolean first=true;
        try {
            String line;
            br = new BufferedReader(new FileReader(src));
            if(first)
            {
                line = br.readLine();
                lop.setTenLop(line);
            }

            // How to read file in java line by line?
            while ((line = br.readLine()) != null)
            {
                SinhVien a=new SinhVien();
                if(parseCsvLine(line,a))
                    list.add(a);

            }
            br.close();

        } catch (IOException e) {
            System.out.println("Mo file that bai");
        }

        return list;

    }


    public static boolean parseCsvLine(String csvLine, SinhVien result) {
        if(Util.checkFirstLine(csvLine))
        {
            return false;
        }
        else
        {
            String[] splitData = csvLine.split(COMMA_DELIMITER);

            result.setMHS(Integer.parseInt(splitData[0]));

            result.setTenHS(splitData[1]);
            result.setDiaChi(splitData[2]);
            result.setDiem(Double.parseDouble(splitData[3]));
            result.setGhiChu(splitData[4]);
            if(Util.stringCompare(ExportCSV.EMPTY,splitData[5])!=0)
            {
                result.setHinhAnh(splitData[5]);
            }
            else
            {

            }
            return true;
        }



    }
}
