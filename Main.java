// import java.util.ArrayList;
import java.util.List;
public class Main {
    public static void main(String[] args) {
        DanhSachTrungTam dsTrungTam = new DanhSachTrungTam();

        // Nhập n phần tử mới
        dsTrungTam.nhapTrungTam(new TrungTam("001", "Trung Tam A", "Địa chỉ A"));
        dsTrungTam.nhapTrungTam(new TrungTam("002", "Trung Tam B", "Địa chỉ B"));

        // Xuất danh sách
        dsTrungTam.xuatDanhSach();

        // Thêm 1 phần tử
        dsTrungTam.themTrungTam(new TrungTam("003", "Trung Tâm C", "Địa chỉ C"));

        // Sửa phần tử theo mã
        dsTrungTam.suaTrungTamTheoMa("002", "Trung Tâm B - Sửa Đổi", "Địa chỉ B - Sửa Đổi");

        // Xóa phần tử theo mã
        dsTrungTam.xoaTrungTamTheoMa("001");

        // Tìm kiếm trung tâm
        List<TrungTam> ketQuaTimKiem = dsTrungTam.timKiemTrungTam("B");
        System.out.println("Kết quả tìm kiếm:");
        for (TrungTam tt : ketQuaTimKiem) {
            System.out.println(tt);
        }

        // Thống kê số lượng trung tâm
        System.out.println("Số lượng trung tâm: " + dsTrungTam.thongKeSoLuongTrungTam());
    }
}
