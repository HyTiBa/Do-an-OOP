// Lớp cơ bản abstract (nếu có)
abstract class DanhSach {
    protected String tenDanhSach;

    public DanhSach(String tenDanhSach) {
        this.tenDanhSach = tenDanhSach;
    }

    public abstract void hienThiThongTin();
}

// Lớp Trung tâm thống kê
public class thongKe extends DanhSach {
    private DanhSachSanPham danhSachSanPham;
    private DanhSachKhachHang danhSachKhachHang;
    private DanhSachDonHang danhSachDonHang;

    public thongKe(DanhSachSanPham dsSanPham, DanhSachKhachHang dsKhachHang, DanhSachDonHang dsDonHang) {
        super("Trung tâm thống kê");
        this.danhSachSanPham = dsSanPham;
        this.danhSachKhachHang = dsKhachHang;
        this.danhSachDonHang = dsDonHang;
    }

    @Override
    public void hienThiThongTin() {
        System.out.println("Thống kê tổng quan:");
        System.out.println("Tổng số sản phẩm: " + danhSachSanPham.demSoLuong());
        System.out.println("Tổng số khách hàng: " + danhSachKhachHang.demSoLuong());
        System.out.println("Tổng số đơn hàng: " + danhSachDonHang.demSoLuong());
    }

    // Tính năng đa hình (ví dụ: phân tích theo loại sản phẩm)
    public void thongKeTheoLoai(String loaiSanPham) {
        System.out.println("Thống kê sản phẩm loại " + loaiSanPham + ":");
        danhSachSanPham.hienThiSanPhamTheoLoai(loaiSanPham);
    }

    public void thongKeDoanhThu() {
        double tongDoanhThu = danhSachDonHang.tinhTongDoanhThu();
        System.out.println("Tổng doanh thu: " + tongDoanhThu);
    }
}
