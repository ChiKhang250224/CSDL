package Task2;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public class DanhMucAnPham {
	private List<AnPham> dmAnPham;

	public DanhMucAnPham(List<AnPham> dmAnPham) {
		super();
		this.dmAnPham = dmAnPham;
	}

	public boolean xuatBanHon10Nam() {
		for (AnPham ap : dmAnPham) {
			if (ap.xuatBan10NamTruoc() && ap.getType().equals("Tạp chí")) {
				return true;
			}
		}
		return false;
	}

	public int tongTien() {
		int Tong = 0;
		for (AnPham ap : dmAnPham) {
			Tong += ap.getGiaTien();
		}
		return Tong;
	}

	public boolean timTapChi(String tenTC) {
		for (AnPham ap : dmAnPham) {
			if (ap.getTieuDe().equals(tenTC) && ap.getType().equals("Tạp chí")) {
				return true;
			}
		}
		return false;
	}

	public SachThamKhao sachNhieuChuongNhat() {
		SachThamKhao sachNhieuChuongNhat = null;

		for (AnPham ap : dmAnPham) {
			if (ap instanceof SachThamKhao) {
				SachThamKhao sach = (SachThamKhao) ap;
				ChuongSach chuongNhieuTrang = sach.chuongNhieuTrangNhat();

				if (chuongNhieuTrang != null) {
					if (sachNhieuChuongNhat == null || chuongNhieuTrang.getSoTrang() > sachNhieuChuongNhat
							.chuongNhieuTrangNhat().getSoTrang()) {
						sachNhieuChuongNhat = sach;
					}
				}
			}
		}

		return sachNhieuChuongNhat;
	}

	public AnPham timAnPhamTheoNam(int year) {
		for (AnPham ap : dmAnPham) {
			if (ap.getNamXuatBan() == year) {
				return ap;
			}
		}
		System.out.println("Không có danh sách tạp chí nào xuất bản vào " + year);
		return null;
	}

	class AnPhamCompare implements Comparator<AnPham> {
		@Override
		public int compare(AnPham ap1, AnPham ap2) {
			if (ap1 == null || ap2 == null) {
				return 0;
			}

			int tieuDe = ap1.getTieuDe().compareTo(ap2.getTieuDe());
			if (tieuDe == 0) {
				return ap2.getNamXuatBan() - ap1.getNamXuatBan();
			}
			return tieuDe;
		}
	}

	public void sapXepAnPham() {
		TreeSet<AnPham> sorted = new TreeSet<>(new AnPhamCompare());
		sorted.addAll(dmAnPham);
		System.out.println("Danh sach an pham sau khi sap xep:");
		for (AnPham ap : sorted) {
			System.out.println(ap);
		}
	}

	public void thongKeAnPham(List<AnPham> dmAnPham) {
		Map<Integer, Integer> anPhamTheoNam = new HashMap<>();

		for (AnPham ap : dmAnPham) {
			int year = ap.getNamXuatBan();
			if (anPhamTheoNam.containsKey(year)) {
				anPhamTheoNam.put(year, anPhamTheoNam.get(year) + 1);
			} else {
				anPhamTheoNam.put(year, 1);
			}
		}

		System.out.println("So luong an pham theo nam xuat :");
		for (Map.Entry<Integer, Integer> entry : anPhamTheoNam.entrySet()) {
			System.out.println("Nam " + entry.getKey() + ": " + entry.getValue() + " an pham");
		}
	}
}
