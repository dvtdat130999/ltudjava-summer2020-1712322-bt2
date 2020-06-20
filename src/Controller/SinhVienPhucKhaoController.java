package Controller;

import DTO.NguoiDung;
import View.SinhVienPhucKhaoView;

public class SinhVienPhucKhaoController {
    public SinhVienPhucKhaoController()
    {

    }

    public static void createGUI(NguoiDung nguoiDung)
    {

        new SinhVienPhucKhaoView(nguoiDung);
    }
}
