public class TrungTam {
    private String ma;
    private String ten;
    private String diaChi;

    public TrungTam(String ma, String ten, String diaChi) {
        this.ma = ma;
        this.ten = ten;
        this.diaChi = diaChi;
    }

    // Getters và Setters
    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    @Override
    public String toString() {
        return "TrungTam{" +
                "ma='" + ma + '\'' +
                ", ten='" + ten + '\'' +
                ", diaChi='" + diaChi + '\'' +
                '}';
    }
}