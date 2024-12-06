import java.util.Scanner;
public class DanhSachPhieuNhapHang {
    Scanner userInput = new Scanner(System.in);
    public int option = 1;
    static Phieu[] DanhSachPhieuNhapHang = new Phieu[0];
    public void themPhieuNhapHang(
        int maDH,int maNV,String ngayNhap,int maNSX  ){
            Phieu phieuMoi = new Phieu(maDH, maNV, ngayNhap, maNSX);
            Phieu[] DanhSachPhieuCu = DanhSachPhieuNhapHang;
            DanhSachPhieuNhapHang = new Phieu[DanhSachPhieuNhapHang.length + 1];
        for(int i = 0; i< DanhSachPhieuCu.length;i++){
            DanhSachPhieuNhapHang[i] = DanhSachPhieuCu[i];
        }
DanhSachPhieuNhapHang[DanhSachPhieuNhapHang.length - 1]=phieuMoi;
themChiTietPhieuNhapHang();
    }
public Phieu[] getDanhSachPhieuNhapHang(){
    return DanhSachPhieuNhapHang;
}    
    public void themChiTietPhieuNhapHang(){
while (option != 0){
    System.out.println("---------------------------------------------------------------------------------");
    System.out.println("1.them chi tiet hoa don");
    System.out.println("2.Xem thong ke.");
    System.out.println("0.Thoat");
    this.option = userInput.nextInt();
    if (option == 1) {
        DanhSachChiTiet danhSachChiTiet = new DanhSachChiTiet();
        danhSachChiTiet.themChitiet(DanhSachPhieuNhapHang[DanhSachPhieuNhapHang.length - 1]);
        // ChiTietPhieuNhapHang
    }
    if (option == 2) {
        ThongKe thongKe = new ThongKe();
        thongKe.inLuaChon();
    }
}
    }
}
