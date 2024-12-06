import java.util.Scanner;
public class DanhSachChiTiet {
    Scanner scanner = new Scanner(System.in);
    Phieu phieuCanNhap;
static ChiTietPhieu[] danhSachChiTiet = new ChiTietPhieu[0];
void themChitiet(Phieu phieuMoi){
int maDH = phieuMoi.getMaDNH();
System.out.println("Ten san pham:");
String ten = scanner.nextLine();
System.out.println("So luong:");
int soLuong = scanner.nextInt();
scanner.nextLine();
System.out.println("Gia ca:");
int gia = scanner.nextInt();
scanner.nextLine();
int tongCong = soLuong*gia;
ChiTietPhieu chiTietPhieu = new ChiTietPhieu(maDH, soLuong, gia, ten, tongCong);
this.themVaoDanhSach(chiTietPhieu);
}
private void themVaoDanhSach(ChiTietPhieu chiTietPhieu){
    ChiTietPhieu chiTietMoi = new ChiTietPhieu(chiTietPhieu);
    ChiTietPhieu[] danhSachCu = danhSachChiTiet;
    danhSachChiTiet = new ChiTietPhieu[danhSachChiTiet.length + 1];
    for(int i = 0; i< danhSachCu.length;i++){
        danhSachChiTiet[i] = danhSachCu[i];
    }
danhSachChiTiet[danhSachChiTiet.length - 1]=chiTietMoi;


}
ChiTietPhieu[] getDanhSach(){
return danhSachChiTiet;
}
}
