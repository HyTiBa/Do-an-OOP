// import java.util.ArrayList;
import java.util.List;
public class Main {
    public static void main(String[] args) {
        DanhSachTrungTam dsTrungTam = new DanhSachTrungTam();

        // Nhập n phần tử mới
        dsTrungTam.nhapTrungTam(new TrungTam("001", "Trung Tam A", "Dia chi A"));
        dsTrungTam.nhapTrungTam(new TrungTam("002", "Trung Tam B", "Dia chi B"));

        // Xuất danh sách
        dsTrungTam.xuatDanhSach();

        // Thêm 1 phần tử
        dsTrungTam.themTrungTam(new TrungTam("003", "Trung Tam C", "Dia chi C"));

        // Sửa phần tử theo mã
        dsTrungTam.suaTrungTamTheoMa("002", "Trung Tam B - Sua Doi", "Dia chi B - Sua Doi");

        // Xóa phần tử theo mã
        dsTrungTam.xoaTrungTamTheoMa("001");

        // Tìm kiếm trung tâm
        List<TrungTam> ketQuaTimKiem = dsTrungTam.timKiemTrungTam("B");
        System.out.println("Ket qua tim kiem:");
        for (TrungTam tt : ketQuaTimKiem) {
            System.out.println(tt);
        }

        // Thống kê số lượng trung tâm
        System.out.println("So luong trung tam: " + dsTrungTam.thongKeSoLuongTrungTam());
    }
}
