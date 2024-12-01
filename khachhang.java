import java.util.Scanner;
import java.time.LocalDate;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

class khachhang 
{
    private String makh;
    private String ho;
    private String ten;
    private String gioitinh;
    private String ngaysinh;
    private String diachi;
    private String sdt;
    private static List<String> listmakh = new ArrayList<>(); // Lưu mã khách hàng đã nhập

    public khachhang()
    {
        makh = "";
        ho = "";
        ten = "";
        gioitinh = "";
        ngaysinh = "";
        diachi = "";
        sdt = "";
    }
    
    public khachhang(String makh, String ho, String ten, String gioitinh, String ngaysinh, String sdt, String diachi)
    {
        this.makh = makh;
        this.ho = ho;
        this.ten = ten;
        this.gioitinh = gioitinh;        
        this.ngaysinh = ngaysinh;        
        this.sdt = sdt;
        this.diachi = diachi;        
    }
    
    public khachhang(khachhang kh)
    {
        makh = kh.makh;
        ho = kh.ho;
        ten = kh.ten;
        gioitinh = kh.gioitinh;
        ngaysinh = kh.ngaysinh;
        sdt = kh.sdt;
        diachi = kh.diachi;
    }
    
    public void nhap()
    {
        Scanner sc = new Scanner(System.in);

        do
        {
            System.out.print("Nhap ma khach hang : ");
            makh = sc.nextLine();
            if (makh.trim().isEmpty()) 
            {
                System.out.print("Error : Ma khach hang khong duoc de trong ! ");
            }
            else if (!khachhang.khachhangduynhat(makh))
            {
                System.out.println("Error : Ma khach hang da ton tai. Vui long nhap ma khach hang khac ! ");
            }
        } 
        while (makh.trim().isEmpty() || !khachhang.khachhangduynhat(makh));
        
        // Sau khi nhập mã hợp lệ, thêm mã khách hàng vào listmakh
        listmakh.add(makh);
        
        do
        {
          System.out.print("Nhap ho khach hang : "); 
          ho = sc.nextLine();

          if (ho.trim().isEmpty()) 
          {
            System.out.println("Error : Ho khong duoc de trong ! ");  
          } 
          else if (!ho.matches("[a-zA-Z\\s]+"))
          {
              System.out.println("Error : Ho chi duoc nhap cac chu cai khong co dau ! ");
          }
          else if (!ho.matches("([A-Z][a-z]*)(\\s[A-Z][a-z]*)*")) 
          {
              System.out.println("Error : Moi tu trong ho phai bat dau bang chu cai hoa va chi co 1 chu cai hoa trong moi tu  ! ");
          }
        }
        while (ho.trim().isEmpty() || !ho.matches("[a-zA-Z\\s]+") || !ho.matches("([A-Z][a-z]*)(\\s[A-Z][a-z]*)*"));

        do
        {
            System.out.print("Nhap ten khach hang : ");
            ten = sc.nextLine();

            if(ten.trim().isEmpty())
            {
                System.out.println("Error : Ten khong duoc de trong . ");
            }
            else if (!ten.matches("[a-zA-Z\\s]+"))
            {
                System.out.println("Error : Ten khach hang chi duoc nhap chu cai khong co dau ! ");   
            }
            else if (!ten.matches("([A-Z][a-z]*)(\\s[A-Z][a-z]*)*"))
            {
                System.out.println("Error : Moi tu trong ten phai bat dau bang chu cai hoa va chi co 1 chu cai hoa trong moi tu ! ");
            }
        }
        while (ten.trim().isEmpty() || !ten.matches("[a-zA-Z\\s]+") || !ten.matches("([A-Z][a-z]*)(\\s[A-Z][a-z]*)*"));
        
        do
        {
            System.out.print("Nhap gioi tinh khach hang ( nam / nu ) : ");
            gioitinh = sc.nextLine();

            if(!gioitinh.equals("Nam") && !gioitinh.equals("Nu"))
            {
                System.out.println("Error : Gioi tinh phai la 'Nam' hoac 'Nu' . Vui long nhap lai ! ");
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
            System.out.print("Nhap SDT cua khach hang ( SDT phai co toi thieu 10 so ) : ");
            sdt = sc.nextLine();
            if (!sdt.matches("\\d{10,}")) 
            {
                System.out.println("Error : SDT nhap vao phai co 10 so (khong chua ky tu nao khac) ! ");
            }
            else
            {
                break;
            }
        }
        while (true);

        do
        {
            System.out.print("Nhap dia chi : ");
            diachi = sc.nextLine();
            if (diachi.trim().isEmpty())
            {
                System.out.println("Error : Dia chi khong duoc de trong. ");
            }
            
        }
        while (diachi.trim().isEmpty());
    }

    public void xuat()
    {
        System.out.println(" Ma khach hang : " + makh + " Ho va ten : " + ho + " " + ten + " Gioi tinh : " + gioitinh + " Ngay sinh : " + ngaysinh + " Tuoi : " + calcage()  + " SDT: " + sdt + " Dia chi : " + diachi); //+ " || Email : " + email + "||"); Diem tich luy : " + diemTL + " || Uu dai hien tai : " + kiemtradiemtl() + " || ");
    }

    public void xuat(int stt)
    {
        System.out.printf(" %-3s  %-15s  %-15s  %-15s  %-10s  %-10s  %-3s  %-15s  %-30s \n",
        stt, makh, ho, ten, gioitinh, ngaysinh, calcage(), sdt, diachi);
    }

    public boolean suaMakh(String makh) {
        if (khachhang.khachhangduynhat(makh)) {
            this.makh = makh;
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

    public boolean suaDiaChi(String diachi)
    {
        if (diachi.trim().isEmpty())
        {
            System.out.println("Error : Dia chi khong duoc de trong ! ");
            return false;
        }
        this.diachi = diachi;
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
        LocalDate currentDate = LocalDate.now();
        int age = currentDate.getYear() - birthDate.getYear();
        if (currentDate.getDayOfYear() < birthDate.getDayOfYear())
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

    public static boolean khachhangduynhat(String makh) { return !listmakh.contains(makh); }
    public static List<String> getlistmakh() { return listmakh; }
    public int getage(){ return calcage(); }
    public static void setlistmakh(List<String> newList) { listmakh = newList; }
    public String getmakh() { return makh; }
    public void setmakh(String makh) { this.makh = makh; }
    public String getho() { return ho; }
    public void setho( String ho) { this.ho = ho; }
    public String getten() { return ten; }
    public void setten(String ten) { this.ten = ten; }
    public String getgioitinh() { return gioitinh; }
    public void setgioitinh(String gioitinh) { this.gioitinh = gioitinh; }
    public String getngaysinh() { return ngaysinh; }
    public void setngaysinh(String ngaysinh) { this.ngaysinh = ngaysinh; }
    public String getsdt() { return sdt; }
    public void setsdt(String sdt) { this.sdt = sdt;}
    public String getdiachi() { return diachi; }
    public void setdiachi(String diachi) { this.diachi = diachi; }

     public static void main(String[] args) 
    {
        // Tạo 5 đối tượng khách hàng với thông tin mẫu
        khachhang kh1 = new khachhang("KH001", "Nguyen", "An", "Nam", "15/04/1985", "123 Le Loi", "0912345678");
        khachhang kh2 = new khachhang("KH002", "Tran", "Binh", "Nam", "02/11/1975", "456 Tran Phu", "0912345679");
        khachhang kh3 = new khachhang("KH003", "Le", "Chi", "Nu", "23/03/1990", "789 Nguyen Hue", "0912345680");
        khachhang kh4 = new khachhang("KH004", "Pham", "Dung", "Nam", "30/06/2000", "101 Hoang Hoa Tham", "0912345681");
        khachhang kh5 = new khachhang("KH005", "Vu", "Ha", "Nu", "12/12/1988", "111 Ba Trieu", "0912345682");

        // Hiển thị thông tin từng khách hàng bằng phương thức xuat()
        kh1.xuat(1);
        kh2.xuat(2);
        kh3.xuat(3);
        kh4.xuat(4);
        kh5.xuat(5);
    }
}

