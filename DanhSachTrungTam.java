import java.util.ArrayList;
import java.util.List;

public class DanhSachTrungTam {
    private List<TrungTam> danhSach = new ArrayList<>();

    // a. Nhập n phần tử mới đầu tiên
    public void nhapTrungTam(TrungTam tt) {
        danhSach.add(tt);
    }

    // b. Xuất danh sách
    public void xuatDanhSach() {
        for (TrungTam tt : danhSach) {
            System.out.println(tt);
        }
    }

    // c. Thêm 1 phần tử, k phần tử
    public void themTrungTam(TrungTam tt) {
        danhSach.add(tt);
    }

    // d. Sửa phần tử theo mã
    public void suaTrungTamTheoMa(String ma, String tenMoi, String diaChiMoi) {
        for (TrungTam tt : danhSach) {
            if (tt.getMa().equals(ma)) {
                tt.setTen(tenMoi);
                tt.setDiaChi(diaChiMoi);
                break;
            }
        }
    }

    // e. Xóa phần tử theo mã
    public void xoaTrungTamTheoMa(String ma) {
        danhSach.removeIf(tt -> tt.getMa().equals(ma));
    }

    // f. Tìm kiếm: nhiều khóa, từ chính xác đến gần đúng
    public List<TrungTam> timKiemTrungTam(String tuKhoa) {
        List<TrungTam> ketQua = new ArrayList<>();
        for (TrungTam tt : danhSach) {
            if (tt.getTen().contains(tuKhoa) || tt.getMa().contains(tuKhoa)) {
                ketQua.add(tt);
            }
        }
        return ketQua;
    }

    // g. Thống kê số liệu theo nhiều khóa (ví dụ thống kê số lượng trung tâm)
    public int thongKeSoLuongTrungTam() {
        return danhSach.size();
    }

    // h. Các chức năng nghiệp vụ khác có thể thêm vào đây

    // i. Có sử dụng đa hình (có thể thêm các lớp con của TrungTam)
}