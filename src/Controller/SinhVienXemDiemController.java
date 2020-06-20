package Controller;

import DTO.NguoiDung;
import View.SinhVienXemDiemView;

public class SinhVienXemDiemController {
    public SinhVienXemDiemController(){}
    public static void createGUI(NguoiDung nguoiDung)
    {
        new SinhVienXemDiemView(nguoiDung);
    }
}
