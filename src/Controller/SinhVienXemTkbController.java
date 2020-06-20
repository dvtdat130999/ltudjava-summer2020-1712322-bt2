package Controller;

import DTO.NguoiDung;
import View.SinhVienDoiMatKhauView;
import View.SinhVienXemTkbView;

public class SinhVienXemTkbController {

    public SinhVienXemTkbController(){}
    public static void createGUI(NguoiDung nguoiDung)
    {
        new SinhVienXemTkbView(nguoiDung);
    }

}
