package Task2;

import java.util.ArrayList;
import java.util.List;

public class SachThamKhao extends AnPham {
	public SachThamKhao(String tieuDe, int soTrang, int namXuatBan, String tacGia, int giaTien, String linhVuc) {
		super(tieuDe, soTrang, namXuatBan, tacGia, giaTien);
		this.linhVuc = linhVuc;
		this.dsChuongSach = new ArrayList<>();
	}

	private String linhVuc;
	private List<ChuongSach> dsChuongSach;

	public String getType() {
		return "Sách tham khảo";
	}

	public String getLinhVuc() {
		return linhVuc;
	}

	public void setLinhVuc(String linhVuc) {
		this.linhVuc = linhVuc;
	}

	public List<ChuongSach> getDsChuongSach() {
		return dsChuongSach;
	}

	public void setDsChuongSach(List<ChuongSach> dsChuongSach) {
		this.dsChuongSach = dsChuongSach;
	}

	public void themChuongSach(ChuongSach chuongSach) {
		dsChuongSach.add(chuongSach);
	}

	public ChuongSach chuongNhieuTrangNhat() {
		if (dsChuongSach.isEmpty()) {
			return null;
		}

		ChuongSach chuongNhieuTrangNhat = dsChuongSach.get(0);

		for (ChuongSach chuong : dsChuongSach) {
			if (chuong.getSoTrang() > chuongNhieuTrangNhat.getSoTrang()) {
				chuongNhieuTrangNhat = chuong;
			}
		}

		return chuongNhieuTrangNhat;
	}

	@Override
	public String toString() {
		return super.toString() + ", " + "Linh vuc: " + linhVuc;
	}

}
