package bkapt.su1312m.WorldCup2014;

import java.io.Serializable;

public class ThongTinDuDoan implements Serializable{
	
	
	
	private String SoBanThang;
	private String SoNguoiCoCungDuDoan;
	
	private String ID_DoiBongVoDich;
	
	private String ID_DoiBongCauThuSuatSac;
	private String Name_DoiBongCauThuSuatSac;
	
	private String ID_DoiBongCauThuGhiNhieuBan;
	private String Name_DoiBongCauThuGhiNhieuBan;
	
	private String CMTND;
	
	private String DateTimeDangKy;
	private String DateTimeHienTai;
	
	public String getDateTimeDangKy() {
		return DateTimeDangKy;
	}
	public void setDateTimeDangKy(String dateTimeDangKy) {
		DateTimeDangKy = dateTimeDangKy;
	}
	public String getDateTimeHienTai() {
		return DateTimeHienTai;
	}
	public void setDateTimeHienTai(String dateTimeHienTai) {
		DateTimeHienTai = dateTimeHienTai;
	}
	public ThongTinDuDoan(){
		setCMTND("");
		setID_DoiBongCauThuGhiNhieuBan("");
		setID_DoiBongCauThuSuatSac("");
		setID_DoiBongVoDich("");
		setName_DoiBongCauThuGhiNhieuBan("");
		setName_DoiBongCauThuSuatSac("");
	}
	public String getSoBanThang() {
		return SoBanThang;
	}
	public void setSoBanThang(String soBanThang) {
		SoBanThang = soBanThang;
	}
	public String getSoNguoiCoCungDuDoan() {
		return SoNguoiCoCungDuDoan;
	}
	public void setSoNguoiCoCungDuDoan(String soNguoiCoCungDuDoan) {
		SoNguoiCoCungDuDoan = soNguoiCoCungDuDoan;
	}
	public String getID_DoiBongVoDich() {
		return ID_DoiBongVoDich;
	}
	public void setID_DoiBongVoDich(String iD_DoiBongVoDich) {
		ID_DoiBongVoDich = iD_DoiBongVoDich;
	}
	public String getID_DoiBongCauThuSuatSac() {
		return ID_DoiBongCauThuSuatSac;
	}
	public void setID_DoiBongCauThuSuatSac(String iD_DoiBongCauThuSuatSac) {
		ID_DoiBongCauThuSuatSac = iD_DoiBongCauThuSuatSac;
	}
	public String getName_DoiBongCauThuSuatSac() {
		return Name_DoiBongCauThuSuatSac;
	}
	public void setName_DoiBongCauThuSuatSac(String name_DoiBongCauThuSuatSac) {
		Name_DoiBongCauThuSuatSac = name_DoiBongCauThuSuatSac;
	}
	public String getID_DoiBongCauThuGhiNhieuBan() {
		return ID_DoiBongCauThuGhiNhieuBan;
	}
	public void setID_DoiBongCauThuGhiNhieuBan(String iD_DoiBongCauThuGhiNhieuBan) {
		ID_DoiBongCauThuGhiNhieuBan = iD_DoiBongCauThuGhiNhieuBan;
	}
	public String getName_DoiBongCauThuGhiNhieuBan() {
		return Name_DoiBongCauThuGhiNhieuBan;
	}
	public void setName_DoiBongCauThuGhiNhieuBan(
			String name_DoiBongCauThuGhiNhieuBan) {
		Name_DoiBongCauThuGhiNhieuBan = name_DoiBongCauThuGhiNhieuBan;
	}
	public String getCMTND() {
		return CMTND;
	}
	public void setCMTND(String cMTND) {
		CMTND = cMTND;
	}
}
