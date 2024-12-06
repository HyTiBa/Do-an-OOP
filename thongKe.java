import java.util.Scanner;
public class ThongKe {
    Scanner scanner = new Scanner(System.in);
    void soLuongHangNhap(){
        DanhSachChiTiet danhSachChiTiet = new DanhSachChiTiet();
        int soLuong = 0;
        for(ChiTietPhieu chiTiet: danhSachChiTiet.getDanhSach()){
    soLuong= soLuong + chiTiet.getSoLuong();
}
System.out.println("So luong hang trong kho:");
System.out.println(soLuong);
    }
    void DoanhThu(){
         DanhSachChiTiet danhSachChiTiet = new DanhSachChiTiet();
        int doanhThu = 0;
        for(ChiTietPhieu chiTiet: danhSachChiTiet.getDanhSach()){
    doanhThu= doanhThu + chiTiet.getTongCong();
}
System.out.println("So luong hang trong kho:");
System.out.println(doanhThu);
    }
    void inLuaChon(){
        int option = 1;
while (option != 0) {
    System.out.println("---------------------------------------------------------------------------------");
    System.out.println("1.Xem doanh thu:");
    System.out.println("2.Xem so luong hang trong kho:");
    System.out.println("0.Thoat");
    option = scanner.nextInt();
    scanner.nextLine();
    if (option == 1) {
        DoanhThu();
    }
    if (option == 2) {
        soLuongHangNhap();
    }
}


    }
}

