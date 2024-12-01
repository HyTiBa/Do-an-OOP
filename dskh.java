import java.util.Arrays;
import java.util.Scanner;

public class dskh 
{
    private khachhang[] dskh;
    private int n;

    public dskh()
    {
        dskh = new khachhang[0];
        n = 0;
    }

    public dskh(int n, khachhang[] ds2)
    {
        this.n = n;
        this.dskh = new khachhang[n];
        
        for (int i = 0; i < n; i++)
        {
            this.dskh[i] = new khachhang(ds2[i]);
        }
        
    }

    public void nhap()
    {
        Scanner sc = new Scanner(System.in);
        System.out.print(" Nhap so luong khach hang cho vao danh sach : " );
        n = sc.nextInt();
        sc.nextLine();

        dskh = new khachhang[n];
        if ( n==0 )
        {
            System.out.println(" Danh sach khach hang hien tai khong co du lieu ! ");
        }
        else 
        for(int i = 0; i < n; i++)
        {
            System.out.println(" Nhap thong tin khach hang " + (i + 1) + ": ");
            dskh[i] = new khachhang();
            dskh[i].nhap();
        }
    }
    
    public void xuat()
    {
        System.out.printf(" %-3s  %-15s  %-15s  %-15s  %-10s  %-10s  %-3s  %-15s  %-30s \n",
                "STT", "Ma KH", "Ho", "Ten", "Gioi Tinh", "Ngay Sinh", "Tuoi", "SDT", "Dia Chi"); 
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------");
    
        for (int i = 0; i < n; i++)
        {
            dskh[i].xuat(i + 1);
        }
    }

    public void them()
    {   
        n = dskh.length;
        dskh = Arrays.copyOf(dskh, n + 1);// cấp 1 phàn tử cho mảng
        dskh[n] = new khachhang();
        dskh[n].nhap();
        n++;
    }
    public void them(khachhang x)
    {
        if (!khachhang.khachhangduynhat(x.getmakh()))
        {
            System.out.println(" Ma da ton tai, khong the them ! ");
            return; // Nếu mã đã tồn tại, không thêm khách hàng
        }

        n = dskh.length;
        dskh = Arrays.copyOf(dskh, n + 1);
        dskh[n] = new khachhang(x);
        n++;
    }

    public void xoa()
    {
        n = dskh.length;
        dskh = new khachhang[0];
        n = 0;
        System.out.println(" Da xoa toan bo khach hang trong danh sach ! ");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------");
    }

    public void xoa(String makh) {
        n = dskh.length;
    
        if (n == 0)
        {
            System.out.println("Khong tim thay ma khach hang : " + makh);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (dskh[i].getmakh().equals(makh)) 
            {
                System.out.println("Da tim thay khach hang can xoa ! ");

                khachhang[] dskh2 = new khachhang[n-1];
    
                for (int j = 0, k = 0; j < n; j++) {
                    if (j != i)
                    {
                        dskh2[k++] = dskh[j];
                    }
                }
                dskh = dskh2;
                n = dskh.length;
                return;
            }
        }
            System.out.println("Khong tim thay ma khach hang : " + makh + " trong danh sach ! ");
        
    }

    public void timkiem()
    {
        if (n == 0)
        {
            System.out.println(" Danh sach khach hang hien khong co du lieu ! ");
            System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        }
        else
        {
            System.out.println(" Da tim thay danh sach luu tru thong tin khach hang ! ");
            System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            xuat();
        }
    }

    public int timkiem(String makh)
    {
        n = dskh.length;
        for (int i = 0; i < n; i++)
        {
            if (dskh[i] != null && dskh[i].getmakh().equals(makh))
            {
                return i + 1;
            }
        }
        return -1;
    }

    public khachhang timkiemKH(String makh) {
        n = dskh.length;

        for (int i = 0; i < n; i++) {
            if (dskh[i] != null && dskh[i].getmakh().equals(makh)) 
            {
                System.out.println(" Da tim thay nhan vien co ma : " + makh + " trong danh sach ! ");
                dskh[i].xuat();
                return dskh[i];
            }
        }

        System.out.println(" Khong tim thay nhan vien co ma : " + makh + " trong danh sach ! ");
        return null;
    }

    // Phương thức tổng quát cho tìm kiếm các thuộc tính
    private void timkiem(ConditionChecker checker) {
        n = dskh.length;
        boolean found = false;
        for (int i = 0; i < n; i++) {
            if (dskh[i] != null && checker.check(dskh[i])) {
                if(!found) 
                {
                    System.out.println("Da tim thay khach hang ! ");
                    found = true;
                }
                dskh[i].xuat();       
            }
        }
        if (!found)
        {
            System.out.println("Khong tim thay khach hang thoa man dieu kien !");
        }
    }

    public void timkiemHKH(String ho) {
        timkiem(kh -> kh.getho().equalsIgnoreCase(ho));  // Sử dụng lambda để kiểm tra điều kiện
    }    

    public void timkiemTKH(String ten) {
        timkiem(kh -> kh.getten().equalsIgnoreCase(ten));  // Sử dụng lambda để kiểm tra điều kiện
    }

    public void timkiemGT(String gioitinh) {
        timkiem(kh -> kh.getgioitinh().equalsIgnoreCase(gioitinh));
    }

    public void timkiemSDT(String sdt) {
        timkiem(kh -> kh.getgioitinh().equalsIgnoreCase(sdt));
    }
    
    public void timkiemDiachi(String diachi){
        timkiem(kh -> kh.getdiachi().equalsIgnoreCase(diachi));
    }

    public void timkiemTuoiKH(int age) {
        timkiem(kh -> kh.getage() == age);  // Sử dụng lambda để kiểm tra điều kiện
    }
    
    public void timkiemKhoangTuoiKH(int ageStart, int ageEnd) {
        timkiem(kh -> kh.getage() >= ageStart && kh.getage() <= ageEnd);  // Sử dụng lambda để kiểm tra điều kiện
    }
    

    // Định nghĩa interface ConditionChecker
    @FunctionalInterface
    public interface ConditionChecker {
        // Phương thức này sẽ kiểm tra một điều kiện trên một đối tượng KhachHang
        boolean check(khachhang kh);
    }

        // Hàm tổng quát cho thống kê theo điều kiện
    private int thongke(ConditionChecker checker) {
        n = dskh.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (dskh[i] != null && checker.check(dskh[i])) {
                count++;  // Tăng số lượng khách hàng thỏa mãn
            }
        }

        return count;
    }

    // Điều kiện kiểm tra cho "Ho"
    public int thongkeHo(String ho) {
        return thongke(kh -> kh.getho().equals(ho));
    }

    // Điều kiện kiểm tra cho "Ten"
    public int thongkeTen(String ten) {
        return thongke(kh -> kh.getten().equals(ten));
    }

    public int thongkeGT(String gioitinh) {
        return thongke(kh -> kh.getgioitinh().equalsIgnoreCase(gioitinh));
    }

    public int thongkeDC(String diachi){
        return thongke(kh -> kh.getdiachi().equals(diachi));
    }

    // Điều kiện kiểm tra cho "Tuoi"
    public int thongkeTuoi(int age) {
        return thongke(kh -> kh.getage() == age);
    }

    // Điều kiện kiểm tra cho "Khoang tuoi"
    public int TKkhoangdotuoi(int ageStart, int ageEnd) {
        return thongke(kh -> kh.getage() >= ageStart && kh.getage() <= ageEnd);
    }

    public int TKNamsinh(int namsinh)
    {
        return thongke(kh -> kh.getyearofbirth() == namsinh);
    }

    public int TKkhoangnamsinh(int yearStart, int yearEnd)
    {
        return thongke(kh -> kh.getyearofbirth() >= yearStart && kh.getyearofbirth() <= yearEnd);
    }

    public void sua(String makh) {
        int n = dskh.length;
        boolean found = false;
    
        for (int i = 0; i < n; i++) {
            if (dskh[i] != null && dskh[i].getmakh().equals(makh)) {
                found = true;
                System.out.println("Ban dang thuc hien sua thong tin khach hang co ma: " + makh + " trong danh sach.");
                Scanner sc = new Scanner(System.in);
    
                while (true) {
                    System.out.println("Nhap thong tin muon sua (makh, ho, ten, gioitinh, ngaysinh, sdt, diachi) hoac 'thoat' de ket thuc: ");
                    String field = sc.nextLine().toLowerCase();
    
                    switch (field) {
                        case "makh":
                            while (true) {
                                System.out.print("Nhap ma khach hang moi (hoac bo qua de giu nguyen): ");
                                String newmakh = sc.nextLine();
                                if (newmakh.isEmpty() || dskh[i].suaMakh(newmakh)) {
                                    System.out.println("Ma khach hang da duoc cap nhat thanh: " + (newmakh.isEmpty() ? makh : newmakh));
                                    break;
                                }
                                System.out.println("Ma khach hang moi da ton tai hoac khong hop le. Vui long thu lai!");
                            }
                            break;
    
                        case "ho":
                            while (true) {
                                System.out.print("Nhap ho moi (hoac bo qua de giu nguyen): ");
                                String newho = sc.nextLine();
                                if (newho.isEmpty() || dskh[i].suaHo(newho)) {
                                    System.out.println("Ho da duoc cap nhat thanh: " + dskh[i].getho());
                                    break;
                                }
                                System.out.println("Ho khong hop le. Vui long thu lai!");
                            }
                            break;
    
                        case "ten":
                            while (true) {
                                System.out.print("Nhap ten moi (hoac bo qua de giu nguyen): ");
                                String newten = sc.nextLine();
                                if (newten.isEmpty() || dskh[i].suaTen(newten)) {
                                    System.out.println("Ten da duoc cap nhat thanh: " + dskh[i].getten());
                                    break;
                                }
                                System.out.println("Ten khong hop le. Vui long thu lai!");
                            }
                            break;
    
                        case "gioitinh":
                            while (true) {
                                System.out.print("Nhap gioi tinh moi (Nam/Nu, hoac bo qua de giu nguyen): ");
                                String newgioitinh = sc.nextLine();
                                if (newgioitinh.isEmpty() || dskh[i].suagioitinh(newgioitinh)) {
                                    System.out.println("Gioi tinh da duoc cap nhat thanh: " + dskh[i].getgioitinh());
                                    break;
                                }
                                System.out.println("Gioi tinh khong hop le. Vui long thu lai!");
                            }
                            break;
    
                        case "ngaysinh":
                            while (true) {
                                System.out.print("Nhap ngay thang nam sinh moi (dd/MM/yyyy, hoac bo qua de giu nguyen): ");
                                String newngaysinh = sc.nextLine();
                                if (newngaysinh.isEmpty() || dskh[i].suaNgaySinh(newngaysinh)) {
                                    System.out.println("Ngay sinh da duoc cap nhat thanh: " + dskh[i].getngaysinh());
                                    break;
                                }
                                System.out.println("Ngay sinh khong hop le. Vui long thu lai!");
                            }
                            break;
    
                        case "sdt":
                            while (true) {
                                System.out.print("Nhap so dien thoai moi (hoac bo qua de giu nguyen): ");
                                String newsdt = sc.nextLine();
                                if (newsdt.isEmpty() || dskh[i].suaSDT(newsdt)) {
                                    System.out.println("So dien thoai da duoc cap nhat thanh: " + dskh[i].getsdt());
                                    break;
                                }
                                System.out.println("So dien thoai khong hop le. Vui long thu lai!");
                            }
                            break;
    
                        case "diachi":
                            while (true) {
                                System.out.print("Nhap dia chi moi (hoac bo qua de giu nguyen): ");
                                String newdiachi = sc.nextLine();
                                if (newdiachi.isEmpty() || dskh[i].suaDiaChi(newdiachi)) {
                                    System.out.println("Dia chi da duoc cap nhat thanh: " + dskh[i].getdiachi());
                                    break;
                                }
                                System.out.println("Dia chi khong hop le. Vui long thu lai!");
                            }
                            break;
    
                        case "thoat":
                            System.out.println("Ket thuc qua trinh sua thong tin khach hang.");
                            return;
    
                        default:
                            System.out.println("Lua chon khong hop le. Vui long thu lai!");
                    }
                }
            }
        }
    
        if (!found) {
            System.out.println("Ma khach hang khong ton tai trong danh sach!");
        }
    }
    

    public static void main(String[] args) {
        
    }
}    
