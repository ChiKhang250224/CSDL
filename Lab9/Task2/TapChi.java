package Task2;

public class TapChi extends AnPham {
	public TapChi(String tieuDe, int soTrang, int namXuatBan, String tacGia, int giaTien, String tenTapChi) {
		super(tieuDe, soTrang, namXuatBan, tacGia, giaTien);
		this.tenTapChi = tenTapChi;
	}

	private String tenTapChi;

	public String getType() {
		return "Tạp chí";

	}

	public String getTenTapChi() {
		return tenTapChi;
	}

	public void setTenTapChi(String tenTapChi) {
		this.tenTapChi = tenTapChi;
	}

	@Override
	public String toString() {
		return super.toString() + ", " + "Ten tap chi: " + tenTapChi ;
	}

}
