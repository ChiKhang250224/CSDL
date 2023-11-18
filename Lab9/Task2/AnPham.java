package Task2;

import java.util.List;

public abstract class AnPham {
	protected String tieuDe;
	protected int soTrang;
	protected int namXuatBan;
	protected String tacGia;
	protected int giaTien;

	public AnPham(String tieuDe, int soTrang, int namXuatBan, String tacGia, int giaTien) {
		super();
		this.tieuDe = tieuDe;
		this.soTrang = soTrang;
		this.namXuatBan = namXuatBan;
		this.tacGia = tacGia;
		this.giaTien = giaTien;
	}

	public String getTieuDe() {
		return tieuDe;
	}

	public void setTieuDe(String tieuDe) {
		this.tieuDe = tieuDe;
	}

	public int getSoTrang() {
		return soTrang;
	}

	public void setSoTrang(int soTrang) {
		this.soTrang = soTrang;
	}

	public int getNamXuatBan() {
		return namXuatBan;
	}

	public void setNamXuatBan(int namXuatBan) {
		this.namXuatBan = namXuatBan;
	}

	public String getTacGia() {
		return tacGia;
	}

	public void setTacGia(String tacGia) {
		this.tacGia = tacGia;
	}

	public int getGiaTien() {
		return giaTien;
	}

	public void setGiaTien(int giaTien) {
		this.giaTien = giaTien;
	}

	abstract String getType();

	public boolean xuatBan10NamTruoc() {
		return (2021 - this.namXuatBan == 10);
	}

	public boolean cungTacGiavaLoai(AnPham other) {
		return this.getType().equals(other.getType()) && this.tacGia.equals(other.tacGia);
	}

	public List<ChuongSach> getDsChuongSach() {
		return null;
	}

	@Override
	public String toString() {
		return "Tieu de: " + tieuDe + ", So trang: " + soTrang + ", Nam xuat ban: " + namXuatBan + ", Tac gia: " + tacGia
				+ ", Gia tien: " + giaTien;
	}
	
}
