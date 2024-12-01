import java.time.LocalDate;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class nhanvien
{
    private String manv;
    private String ho;
    private String ten;
    private String gioitinh;
    private String ngaysinh;
    private String sdt;
    private int nghi0phep;
    private static List<String> listmanv = new ArrayList<>(); // Lưu mã nhân viên đã nhập

    public nhanvien()
    {
        manv = "";
        ho = "";
        ten = "";
        gioitinh = "";
        ngaysinh = "";
        sdt = "";
        nghi0phep = 0;
    }

    public nhanvien(String manv, String ho, String ten, String ngaysinh, String gioitinh, String sdt, int nghi0phep)
    {
        this.manv = manv; 
        this.ho = ho;
        this.ten = ten;
        this.gioitinh = gioitinh;
        this.ngaysinh = ngaysinh;
        this.sdt = sdt;
        this.nghi0phep = nghi0phep;
    }

    public nhanvien (nhanvien nv)
    {
        manv = nv.manv;
        ho = nv.ho;
        ten = nv.ten;
        gioitinh = nv.gioitinh;
        ngaysinh = nv.ngaysinh;
        sdt = nv.sdt;
        nghi0phep = nv.nghi0phep;
    }

    public void nhap()
    {
        Scanner sc = new Scanner(System.in);

        do
        {
            System.out.print("Nhap ma nhan vien : ");
            manv = sc.nextLine();
            if(manv.trim().isEmpty())
            {
                System.out.println("Error : Ma nhan vien khong duoc de trong ! ");
            }
            else if(!nhanvien.nhanvienduynhat(manv))
            {
                System.out.println("Error : Ma nhan vien da ton tai . Vui long nhap ma nhan vien khac !");
            }
        }
        while (manv.trim().isEmpty() || !nhanvien.nhanvienduynhat(manv));
        listmanv.add(manv);

        do {
            System.out.print("Nhap ho nhan vien : ");
            ho = sc.nextLine();
            
            // Kiểm tra xem người dùng có nhập họ hay không
            if (ho.trim().isEmpty()) 
            {
                System.out.println("Error : Ho khong duoc de trong ! ");
            }
            // Kiểm tra xem họ có chứa ký tự không hợp lệ (chỉ cho phép chữ cái và khoảng trắng)
            else if (!ho.matches("[a-zA-Z\\s]+")) {
                System.out.println("Error : Ho chi duoc nhap cac chu cai khong co dau ! ");
            }
            // Kiểm tra xem từng từ trong họ có đúng định dạng "Chữ hoa đầu" không
            else if (!ho.matches("([A-Z][a-z]*)(\\s[A-Z][a-z]*)*")) 
            {
                System.out.println("Error : Moi tu trong ho phai bat dau bang chu cai hoa va chi co 1 chu cai hoa trong moi tu  !");
            }
        } 
        while (ho.trim().isEmpty() || !ho.matches("[a-zA-Z\\s]+") || !ho.matches("([A-Z][a-z]*)(\\s[A-Z][a-z]*)*"));
        
        do
        {
            System.out.print("Nhap ten nhan vien : ");
            ten = sc.nextLine();

            if(ten.trim().isEmpty())
            {
                System.out.println("Error : Ten khong duoc de trong ! ");
            }
            else if(!ten.matches("[a-zA-Z\\s]+"))
            {
                System.out.println("Error : Ten nhap vao phai la chu cai khong co dau ! ");
            }
            else if (!ten.matches("([A-Z][a-z]*)(\\s[A-Z][a-z]*)*"))
            {
                System.out.println("Error : Moi tu trong ten phai bat dau bang chu cai hoa va chi co 1 chu cai hoa trong moi tu ! ");
            }
            }
            while (ten.trim().isEmpty() || !ten.matches("[a-zA-Z\\s]+") || !ten.matches("([A-Z][a-z]*)(\\s[A-Z][a-z]*)*"));

        do 
        {
            System.out.print("Nhap gioi tinh nhan vien ( Nam / Nu ) : ");
            gioitinh = sc.nextLine();
            // Kiểm tra chính xác "Nam" hoặc "Nu" với phân biệt chữ hoa, chữ thường
            if (!gioitinh.equals("Nam") && !gioitinh.equals("Nu")) 
            {
                System.out.println("Error: gioi tinh nhap vao phai dung dinh dang la 'Nam' hoac 'Nu'. Vui long nhap lai ! ");
            }
        } 
        while (!gioitinh.equals("Nam") && !gioitinh.equals("Nu"));

        DateTimeFormatter dfm = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        do
        {
            System.out.print("Nhap ngay sinh cua khach hang (dd/MM/yyyy) : ");
            ngaysinh = sc.nextLine();

            if (isvalidate(ngaysinh))
            {
                LocalDate date = LocalDate.parse(ngaysinh, dfm);
                ngaysinh = date.format(dfm);
                break;
            }
        }
        while (true);

        do
        {
            System.out.print("Nhap SDT cua nhan vien ( SDT phai co toi thieu 10 so ) : ");
            sdt = sc.nextLine();
            if (!sdt.matches("\\d{10,}"))
            {
                System.out.println("Error : So dien thoai khong duoc de trong va khi nhap vao phai co 10 so (khong chua ky tu nao khac) ! ");
            }
            else
            {
                break;
            }
        }
        while (true);

        do 
        {
            try
            {
                System.out.print("Nhap so lan nghi khong phep : ");
                nghi0phep = Integer.parseInt(sc.nextLine());
                if (nghi0phep < 0)
                {
                    System.out.println("Error : Du lieu nhap vao khong duoc am . Vui long nhap lai ! ");
                }
            }
            catch (NumberFormatException e)
            {
                System.out.println("Error : Du lieu nhap vao khong phai so nguyen ! ");
                nghi0phep = -1;
            }
        }
        while (nghi0phep < 0);

    }

   

    public void xuat()
    {
        System.out.println("Ma nhan vien : " + manv + " Ho va ten nhan vien: " + ho + " " + ten + " Gioi tinh : " + gioitinh + " Ngay sinh : " + ngaysinh + " Tuoi : " + calcage() + " SDT : " + sdt + " So lan nghi 0 phep : " + nghi0phep + " Luong : " + luong());
    }
    
    public void xuat(int stt)
    {
        System.out.printf(" %-3d %-15s %-30s %-20s %-15s %-15s %-15s %-15s %-15d %-15d \n"
        , stt, manv, ho, ten, gioitinh, ngaysinh, calcage(), sdt, nghi0phep, luong());
    }

    public boolean suaMNV(String manv) {
        if (nhanvien.nhanvienduynhat(manv)) {
            this.manv = manv;
            return true; // Thành công
        }
        return false; // Mã mới đã tồn tại
    }

    public boolean suaHo(String ho)
    {
        if (ho.trim().isEmpty())
        {
            System.out.println("Error : Ho khong duoc de trong ! ");
            return false;
        }
        else if (!ho.matches("[a-zA-Z\\s]+"))
        {
            System.out.println("Error : Ho chi duoc nhap cac chu cai khong co dau ! ");
            return false;
        }
        else if (!ho.matches("([A-Z][a-z]*)(\\s[A-Z][a-z]*)*"))
        {
            System.out.println("Error : Moi tu trong ho phai bat dau bang chu cai viet hoa va chi co 1 chu cai hoa trong moi tu ! ");;
            return false;
        }
        this.ho = ho;
        return true;
    }

    public boolean suaTen(String ten)
    {
        if (ten.trim().isEmpty())
        {
            System.out.println("Error : Ten khong duoc de trong ! ");
            return false;
        }
        else if (!ten.matches("[a-zA-Z\\s]+"))
        {
            System.out.println("Error : Ten chi duoc nhap cac chu cai khong co dau ! ");
            return false;
        }
        else if (!ten.matches("([A-Z][a-z]*)(\\s[A-Z][a-z]*)*"))
        {
            System.out.println("Error : Moi tu trong ho phai bat dau bang chu cai viet hoa va chi co 1 chu cai hoa trong moi tu ! ");;
            return false;
        }
        this.ten = ten;
        return true;
    }

    public boolean suagioitinh(String gioitinh)
    {
        if (!gioitinh.equals("Nam") && !gioitinh.equals("Nu"))
        {
            System.out.println("Error : Gioi tinh phai la 'Nam' hoac 'Nu' ! ");
            return false;
        }
        this.gioitinh = gioitinh;
        return true;
    }
    
    public boolean suaNgaySinh(String ngaysinh)
    {
        if (!isvalidate(ngaysinh))
        {
            return false;
        }
        this.ngaysinh = ngaysinh;
        return true;
    }

    public boolean suaSDT(String sdt)
    {
        if(!sdt.isEmpty() && (!sdt.matches("\\d+") || sdt.length() < 10))
        {
            System.out.println("Error : SDT phai la so va co it nhat la 10 so ! ");
            return false;
        }
        this.sdt = sdt.isEmpty() ? "Khong cung cap" : sdt;
        return true;
    }

    public boolean suanghi0phep(int nghi0phep)
    {
        if (nghi0phep < 0)
        {
            System.out.println("Error : Du lieu nhap vao khong duoc am . Vui long nhap lai ! ");
            return false;
        }
        this.nghi0phep = nghi0phep;
        return true;

    }

    public boolean isvalidate(String ngaysinh)
    {
        int currentyear = Year.now().getValue();
        int agelimit = currentyear - 85;
        DateTimeFormatter dfm = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        if (!ngaysinh.matches("\\d{2}/\\d{2}/\\d{4}"))
        {
            System.out.println("Error : Ngay sinh khong dung dinh dang (dd/MM/yyyy) . Vui long nhap lai ! ");
            return false;
        }

        try 
        {
            LocalDate date = LocalDate.parse(ngaysinh, dfm);
            int namsinh = date.getYear();

            if (namsinh > currentyear)
            {
                System.out.println("Error : Nam sinh khong duoc vuot qua nam hien tai : " + currentyear);
                return false;
            }
            else if (namsinh < agelimit)
            {
                System.out.println("Error : Tuoi khong duoc vuot qua 85 " + agelimit);
                return false;
            }
            if (!ngaysinh.equals(date.format(dfm)))
            {
                System.out.println("Error : Ngay sinh khong ton tai ! (VD: 30/02, 31/04, ...) ! ");
                return false;
            }
            return true;
        } 
        catch (DateTimeParseException e)
        {
            System.out.println("Error : Ngay sinh khong ton tai hoac khong hop le ! ");
            return false;
        }
    }


    private int calcage()
    {
        DateTimeFormatter dfm = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate birthDate = LocalDate.parse(ngaysinh, dfm);
        LocalDate currenDate = LocalDate.now();
        int age = currenDate.getYear() - birthDate.getYear();
        if (currenDate.getDayOfYear() < birthDate.getDayOfYear())
        {
            age --;
        }
        return age;
    }

    public int getyearofbirth()
    {
        if(isvalidate(this.ngaysinh))
        {
            DateTimeFormatter dfm = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate date = LocalDate.parse(this.ngaysinh, dfm);
            return date.getYear(); 
        }
        return -1;
    }

    public int luong()
    {
        int luongcoban = 5000000;
        int truluong = nghi0phep * 200000;
        return luongcoban - truluong;
    }

    public int getnghi0phep() { return nghi0phep; }
    public void setnghi0phep(int nghi0phep) { this.nghi0phep = nghi0phep; } 
    public static boolean nhanvienduynhat(String manv) { return !listmanv.contains(manv); }
    public static List<String> getlistmanv() { return listmanv; }
    public int getage() { return calcage(); }
    public int getluong() { return luong(); }
    public static void setlistmanv(List<String> newList) { listmanv = newList; }
    public String getmanv() { return manv; }
    public void setmanv(String manv) { this.manv = manv; }
    public String getho() { return ho; }
    public void setho(String ho) { this.ho = ho; }
    public String getten() { return ten; }
    public void setten(String ten) { this.ten = ten; }
    public String getgioitinh() { return gioitinh; }
    public void setgioitinh(String gioitinh) { this.gioitinh = gioitinh; }
    public String getngaysinh() { return ngaysinh; }
    public void setngaysinh(String ngaysinh) { this.ngaysinh = ngaysinh; }
    public String getsdt() { return sdt; }
    public void setsdt(String sdt) { this.sdt = sdt; }
    

    public static void main(String[] args) {
        nhanvien nv1 = new nhanvien("mgs", "Solid", "Snake", "12/12/1999", "Nam", "0937651919", 3);
        nhanvien nv2 = new nhanvien("nv002", "Nguyen", "An", "15/06/1995", "Nam", "0912345678", 1);
        nhanvien nv3 = new nhanvien("nv003", "Le", "Trang", "20/08/2000", "Nam", "0945678901", 0);
        nhanvien nv4 = new nhanvien("nv004", "Tran", "Hoang", "30/11/1987", "Nu", "0987654321", 5);
        nhanvien nv5 = new nhanvien("nv005", "Pham", "Huong", "01/01/1993", "Nu", "0971234567", 2);
    
        nv1.xuat(1);
        nv2.xuat(2);
        nv3.xuat(3);
        nv4.xuat(4);
        nv5.xuat(5);
    }

}