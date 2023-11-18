package Task2;

import java.util.ArrayList;
import java.util.List;

public class Test {

//	public static void main(String[] args) {
//		List<AnPham> dmAnPham = new ArrayList<>();
//		dmAnPham.add(new TapChi("Khoa hoc", 50, 2020, "Nguyen Van A", 100000, "Tap Chi Khoa hoc"));
//		dmAnPham.add(new SachThamKhao("Sach tham khao Toan hoc", 200, 2019, "Tran Thi B", 150000, "Toan hoc"));
//		dmAnPham.add(new TapChi("Thoi trang", 50, 2020, "Nguyen Van A", 125000, "Tap chi Thoi trang"));
//		dmAnPham.add(new SachThamKhao("Sach tham khao lich su: ", 300, 2018, "Pham Thi D", 200000, "Lich su"));
//		dmAnPham.add(new TapChi("The thao", 60, 2020, "Nguyen Van B", 120000, "Tap chi The thao"));
//
//		DanhMucAnPham dmap = new DanhMucAnPham(dmAnPham);
//
//		for (AnPham anPham : dmAnPham) {
//			if (anPham instanceof SachThamKhao) {
//				SachThamKhao sachThamKhao = (SachThamKhao) anPham;
//				List<ChuongSach> dsChuongSach = sachThamKhao.getDsChuongSach();
//
//				if (dsChuongSach != null) {
//					System.out.println("Danh sách chương sách cho " + sachThamKhao.getTieuDe() + ":");
//					for (ChuongSach chuongSach : dsChuongSach) {
//						System.out.println("  - " + chuongSach.getTieuDe() + ", Số trang: " + chuongSach.getSoTrang());
//					}
//				} else {
//					System.out.println(sachThamKhao.getTieuDe() + " không có danh sách chương sách.");
//				}
//			}
//		}

	public static void main(String[] args) {
		List<AnPham> dmAnPham = new ArrayList<>();
		dmAnPham.add(new TapChi("Khoa hoc", 50, 2020, "Nguyen Van A", 100000, "Tap Chi Khoa hoc"));
		dmAnPham.add(new SachThamKhao("Sach tham khao Toan hoc", 200, 2019, "Tran Thi B", 150000, "Toan hoc"));
		dmAnPham.add(new TapChi("Thoi trang", 50, 2020, "Nguyen Van A", 125000, "Tap chi Thoi trang"));
		dmAnPham.add(new SachThamKhao("Sach tham khao lich su: ", 300, 2018, "Pham Thi D", 200000, "Lich su"));
		dmAnPham.add(new TapChi("The thao", 60, 2020, "Nguyen Van B", 120000, "Tap chi The thao"));
		
		DanhMucAnPham dmap = new DanhMucAnPham(dmAnPham);

		SachThamKhao sachNhieuTrangNhat = dmap.sachNhieuChuongNhat();
		if (sachNhieuTrangNhat != null) {
			System.out.println("Sach tham khao co chuong nhieu trang nhat: " + sachNhieuTrangNhat.getTieuDe());
			ChuongSach chuongNhieuTrang = sachNhieuTrangNhat.chuongNhieuTrangNhat();
			if (chuongNhieuTrang != null) {
				System.out.println("Chuong nhieu trang nhat: " + chuongNhieuTrang.getTieuDe() + ", So trang: "
						+ chuongNhieuTrang.getSoTrang());
			} else {
				System.out.println("Khong co chuong trong sach.");
			}
		} else {
			System.out.println("Khong co sach tham khao nao trong danh muc.");
		}
		System.out.println("An pham tap chi xuat ban cach day 10 nam? " + dmap.xuatBanHon10Nam());
		System.out.println("Tong tien an pham la: " + dmap.tongTien());
		System.out.println("Co tap chi khoa hoc khong: " + dmap.timTapChi("Tap chi Khoa hoc"));
		System.out.println("An pham nam 2020: " + dmap.timAnPhamTheoNam(2018));
		System.out.println("Sap xep an pham: ");
		dmap.sapXepAnPham();
		System.out.println("Thong ke so luong theo nam xuat ban: ");
		dmap.thongKeAnPham(dmAnPham);
	}
}
