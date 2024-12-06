public class Phieu {
    
    private int maPNH;
    private String ngayNhap;
    private int maNSX;
    private int maNV;

    public void setNguoiNhap(String ngayNhap){
        this.ngayNhap = ngayNhap;
    }
    public String getNguoiNhap(){
        return this.ngayNhap;
    }
    public void setMaDNH(int ma){
        this.maPNH = ma; 
    }
    public int getMaDNH(){
        return this.maPNH;
    }
    public void setMaNSX(int ma){
        this.maNSX = ma; 
    }
    public int getMaNSX(){
        return this.maNSX;
    }

    public void setMaNV(int ma){
        this.maNV = ma; 
    }
    public int getMaNV(){
        return this.maNV;
    }
    public Phieu(int maPNH,int maNV,String ngayNhap,int maNSX){
        this.maPNH = maPNH;
        this.ngayNhap = ngayNhap;
        this.maNV = maNV;
        this.maNSX = maNSX;
    }
}
