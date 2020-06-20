package Controller;

import DTO.NguoiDung;
import View.SinhVienDoiMatKhauView;
import View.SinhVienXemDiemView;

public class SinhVienDoiMatKhauController {
    public SinhVienDoiMatKhauController()
    {

    }

    public static void createGUI(NguoiDung nguoiDung)
    {
        new SinhVienDoiMatKhauView(nguoiDung);
    }
}
