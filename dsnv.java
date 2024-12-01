import java.util.Arrays;
import java.util.Scanner;

class dsnv {
    private nhanvien[] dsnv;
    private int n;

    public dsnv()
    {
        dsnv = new nhanvien[0];
        n = 0;
    }
    
    public dsnv(int n, nhanvien[] ds2)
    {
        this.n = n;
        this.dsnv = new nhanvien[n];

        for (int i = 0; i < n; i++)
        {
            this.dsnv[i] = new nhanvien(ds2[i]);
        }
    }

    public void nhap()
    {
        Scanner sc = new Scanner(System.in);
        System.out.print(" Nhap so luong nhan vien muon nhap vao danh sach nhan vien : ");
        n = sc.nextInt();
        sc.nextLine();

        dsnv = new nhanvien[n];

        if (n == 0)
        {
            System.out.println("Danh sach nhan vien khong co du lieu !");
        }
        else
        for (int i = 0; i < n; i++)
        {
            System.out.println(" Nhap thong tin nhan vien " + (i + 1) + " : ");
            dsnv[i] = new nhanvien();
            dsnv[i].nhap();
        }
    }

    public void xuat()
    {
        System.out.printf(" %-3s  %-15s  %-15s  %-15s  %-10s  %-10s  %-3s  %-15s %-5s  %-30s \n"
        , " STT ", " Ma nhan vien ", " Ho ", " Ten ", " Gioi tinh ", " Ngay sinh ", " Tuoi ", " SDT ", "Nghi 0 phep", " Luong ");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------");
        
        for (int i = 0; i < n; i++)
        {
            dsnv[i].xuat(i + 1);
        }
    }

    public void them()
    {
        n = dsnv.length;
        dsnv = Arrays.copyOf(dsnv, n + 1);
        dsnv[n] = new nhanvien();
        dsnv[n].nhap();
        n++;
    }

    public void them(nhanvien x)
    {
        if (!nhanvien.nhanvienduynhat(x.getmanv()))
        {
            System.out.println(" Ma da ton tai, khong the them ! ");
            return;
        }
        
        n = dsnv.length;
        dsnv = Arrays.copyOf(dsnv, n + 1);
        dsnv[n] = new nhanvien(x);
        n++;
    }

    public void xoa()
    {
        n = dsnv.length;
        dsnv = new nhanvien[0];
        n = 0;
        System.out.println(" Da xoa toan bo nhan vien trong danh sach ! ");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------");
    }

    public void xoa(String manv) {
        n = dsnv.length;
        if (n == 0)
        {
            System.out.println("Khong tim thay ma nhan vien : " + manv);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (dsnv[i].getmanv().equals(manv)) {
                System.out.println("Da tim thay khach hang can xoa ! ");

                nhanvien[] dsnv2 = new nhanvien[n - 1];
            
                for (int j = 0, k = 0; j < n; j++) {
                    if (j != i) 
                    {
                        dsnv2[k++] = dsnv[j];  
                    } 
                      
                }
                dsnv = dsnv2;
                n = dsnv.length;
                return;
            }
        }
            System.out.println("Khong tim thay ma nhan vien : " + manv);
    }

    public void timkiem()
    {

        if (n == 0)
        {
            System.out.println(" Danh sach nhan vien hien khong co du lieu ! ");
            System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        }
        else
        {
            System.out.println(" Da tim thay danh sach luu tru thong tin nhan vien ! ");
            System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            xuat();
        }
    }

    public int timkiem(String manv)
    {
        n = dsnv.length;
        for (int i=0; i < n; i++)
        {
            if (dsnv[i] != null && dsnv[i].getmanv().equals(manv))
            {
                return i + 1;
            }
        }
        return -1;
    }

    public nhanvien timkiemNV(String manv) {
        n = dsnv.length;

        for (int i = 0; i < n; i++) {
            if (dsnv[i] != null && dsnv[i].getmanv().equals(manv)) 
            {
                System.out.println(" Da tim thay nhan vien co ma : " + manv + " trong danh sach ! ");
                dsnv[i].xuat();
                return dsnv[i];
            }
        }

        System.out.println(" Khong tim thay nhan vien co ma : " + manv + " trong danh sach ! ");
        return null;
    }

    // Phương thức tổng quát cho tìm kiếm các thuộc tính
    private void timkiem(ConditionChecker checker) {
        n = dsnv.length;
        boolean found = false;
        for (int i = 0; i < n; i++) {
            if (dsnv[i] != null && checker.check(dsnv[i])) {
                if(!found) 
                {
                    System.out.println("Da tim thay nhan vien ! ");
                    found = true;
                }
                dsnv[i].xuat();       
            }
        }
        if (!found)
        {
            System.out.println("Khong tim thay nhan vien thoa man dieu kien !");
        }
    }

    public void timkiemHNV(String ho) {
        timkiem(nv -> nv.getho().equalsIgnoreCase(ho));  // Sử dụng lambda để kiểm tra điều kiện
    }    

    public void timkiemTNV(String ten) {
        timkiem(nv -> nv.getten().equalsIgnoreCase(ten));  // Sử dụng lambda để kiểm tra điều kiện
    }

    public void timkiemGT(String gioitinh) {
        timkiem(nv -> nv.getgioitinh().equalsIgnoreCase(gioitinh));
    }

    public void timkiemSDT(String sdt) {
        timkiem(nv -> nv.getgioitinh().equalsIgnoreCase(sdt));
    }

    public void timkiemN0P(int nghi0phep)
    {
        timkiem(nv -> nv.getnghi0phep() == nghi0phep);
    }
    
    public void timkiemkhoangN0P(int nghi0phepStart, int nghi0phepEnd)
    {
        timkiem(nv -> nv.getnghi0phep() >= nghi0phepStart && nv.getnghi0phep() <= nghi0phepEnd);
    }

    public void timkiemTuoiNV(int age) {
        timkiem(nv -> nv.getage() == age);  // Sử dụng lambda để kiểm tra điều kiện
    }
    
    public void timkiemKhoangTuoiNV(int ageStart, int ageEnd) {
        timkiem(nv -> nv.getage() >= ageStart && nv.getage() <= ageEnd);  // Sử dụng lambda để kiểm tra điều kiện
    }
    

    // Định nghĩa interface ConditionChecker
    @FunctionalInterface
    public interface ConditionChecker {
        // Phương thức này sẽ kiểm tra một điều kiện trên một đối tượng KhachHang
        boolean check(nhanvien nv);
    }

        // Hàm tổng quát cho thống kê theo điều kiện
    private int thongke(ConditionChecker checker) {
        n = dsnv.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (dsnv[i] != null && checker.check(dsnv[i])) {
                count++;  // Tăng số lượng khách hàng thỏa mãn
            }
        }

        return count;
    }

    // Điều kiện kiểm tra cho "Ho"
    public int thongkeHo(String ho) {
        return thongke(nv -> nv.getho().equals(ho));
    }

    // Điều kiện kiểm tra cho "Ten"
    public int thongkeTen(String ten) {
        return thongke(nv -> nv.getten().equals(ten));
    }

    public int thongkeGT(String gioitinh) {
        return thongke(nv -> nv.getgioitinh().equalsIgnoreCase(gioitinh));
    }

    public int TKnghi0phep(int nghi0phep){
        return thongke(nv -> nv.getnghi0phep() == nghi0phep);
    }
    
    public int TKkhoangnghi0phep(int nghi0phepStart, int nghi0phepEnd){
        return thongke(nv -> nv.getnghi0phep() >= nghi0phepStart && nv.getnghi0phep() <= nghi0phepEnd);
    }

    // Điều kiện kiểm tra cho "Tuoi"
    public int thongkeTuoi(int age) {
        return thongke(nv -> nv.getage() == age);
    }

    // Điều kiện kiểm tra cho "Khoang tuoi"
    public int TKkhoangdotuoi(int ageStart, int ageEnd) {
        return thongke(nv -> nv.getage() >= ageStart && nv.getage() <= ageEnd);
    }

    public int TKNamsinh(int namsinh)
    {
        return thongke(nv -> nv.getyearofbirth() == namsinh);
    }

    public int TKkhoangnamsinh(int yearStart, int yearEnd)
    {
        return thongke(nv -> nv.getyearofbirth() >= yearStart && nv.getyearofbirth() <= yearEnd);
    }

    public int TKluong(int luong) {
        return thongke(nv -> nv.getluong() == luong);
    }

    public int TKkhoangluong(int luongStart, int luongEnd) {
        return thongke(nv -> nv.getluong() >= luongStart && nv.getluong() <= luongEnd);
    }

    public void sua(String manv) {
        n = dsnv.length;
        boolean found = false;

        for (int i = 0; i < n; i++) {
            if (dsnv[i] != null && dsnv[i].getmanv().equals(manv)) {
                found = true;
                System.out.println("Ban dang thuc hien sua thong tin nhan vien co ma: " + manv + " trong danh sach.");
                Scanner sc = new Scanner(System.in);
    
                while (true) {
                    System.out.println("Nhap thong tin muon sua (manv, ho, ten, gioitinh, ngaysinh, sdt) hoac 'thoat' de ket thuc: ");
                    String field = sc.nextLine().toLowerCase();
    
                    switch (field) {
                        case "manv":
                            while (true) {
                                System.out.print("Nhap ma nhan vien moi (hoac bo qua de giu nguyen): ");
                                String newmanv = sc.nextLine();
                                if (newmanv.isEmpty() || dsnv[i].suaMNV(newmanv)) {
                                    System.out.println("Ma nhan vien da duoc cap nhat thanh: " + (newmanv.isEmpty() ? manv : newmanv));
                                    break;
                                }
                                System.out.println("Ma nhan vien moi da ton tai hoac khong hop le. Vui long thu lai!");
                            }
                            break;
    
                        case "ho":
                            while (true) {
                                System.out.print("Nhap ho moi (hoac bo qua de giu nguyen): ");
                                String newho = sc.nextLine();
                                if (newho.isEmpty() || dsnv[i].suaHo(newho)) {
                                    System.out.println("Ho da duoc cap nhat thanh: " + dsnv[i].getho());
                                    break;
                                }
                                System.out.println("Ho khong hop le. Vui long thu lai!");
                            }
                            break;
    
                        case "ten":
                            while (true) {
                                System.out.print("Nhap ten moi (hoac bo qua de giu nguyen): ");
                                String newten = sc.nextLine();
                                if (newten.isEmpty() || dsnv[i].suaTen(newten)) {
                                    System.out.println("Ten da duoc cap nhat thanh: " + dsnv[i].getten());
                                    break;
                                }
                                System.out.println("Ten khong hop le. Vui long thu lai!");
                            }
                            break;
    
                        case "gioitinh":
                            while (true) {
                                System.out.print("Nhap gioi tinh moi (Nam/Nu, hoac bo qua de giu nguyen): ");
                                String newgioitinh = sc.nextLine();
                                if (newgioitinh.isEmpty() || dsnv[i].suagioitinh(newgioitinh)) {
                                    System.out.println("Gioi tinh da duoc cap nhat thanh: " + dsnv[i].getgioitinh());
                                    break;
                                }
                                System.out.println("Gioi tinh khong hop le. Vui long thu lai!");
                            }
                            break;
    
                        case "ngaysinh":
                            while (true) {
                                System.out.print("Nhap ngay thang nam sinh moi (dd/MM/yyyy, hoac bo qua de giu nguyen): ");
                                String newngaysinh = sc.nextLine();
                                if (newngaysinh.isEmpty() || dsnv[i].suaNgaySinh(newngaysinh)) {
                                    System.out.println("Ngay sinh da duoc cap nhat thanh: " + dsnv[i].getngaysinh());
                                    break;
                                }
                                System.out.println("Ngay sinh khong hop le. Vui long thu lai!");
                            }
                            break;

                        case "sdt":
                            while (true) {
                                System.out.print("Nhap so dien thoai moi (hoac bo qua de giu nguyen): ");
                                String newsdt = sc.nextLine();
                                if (newsdt.isEmpty() || dsnv[i].suaSDT(newsdt)) {
                                    System.out.println("So dien thoai da duoc cap nhat thanh: " + dsnv[i].getsdt());
                                    break;
                                }
                                System.out.println("So dien thoai khong hop le. Vui long thu lai!");
                            }
                            break;
                        
                        case "nghi0phep":
                            while (true) {
                                System.out.println("Nhap so lan nghi 0 phep moi (hoac 'bo qua' de giu nguyen): ");
                                String input = sc.nextLine();
                        
                                if (input.equalsIgnoreCase("bo qua")) {
                                    System.out.println("Thong tin nghi 0 phep duoc giu nguyen: " + dsnv[i].getnghi0phep());
                                    break; // Thoát vòng lặp nếu người dùng muốn giữ nguyên
                                }
                        
                                try {
                                    int nghi0phepnew = Integer.parseInt(input); // Chuyển chuỗi nhập vào thành số nguyên
                                    if (nghi0phepnew < 0) {
                                        System.out.println("Error: So ngay nghi 0 phep khong duoc am ! Vui long nhap lai.");
                                    } else {
                                        dsnv[i].suanghi0phep(nghi0phepnew); // Cập nhật giá trị mới
                                        System.out.println("Cap nhat so lan nghi 0 phep thanh cong ! ");
                                        break; // Thoát vòng lặp khi cập nhật thành công
                                    }
                                } catch (NumberFormatException e) {
                                    System.out.println("Error: Vui long nhap mot so nguyen hop le !"); // Thông báo lỗi nếu không phải số nguyên
                                }
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
        dsnv dsNV = new dsnv();

        dsNV.nhap();
        dsNV.xuat();
        dsNV.them();
        dsNV.xuat();
        dsNV.sua("olga");
        dsNV.xuat();
        dsNV.xoa();
    }   
}     
         
