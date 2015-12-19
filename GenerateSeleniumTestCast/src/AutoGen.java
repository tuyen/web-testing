import java.util.Random;

public class AutoGen {

	private static String[] ho = { "Trần", "Nguyễn", "Phan", "Trịnh", "Phùng", "Vũ",
			"Võ", "Hoàng", "Huỳnh", "Hồ" };
	private static String[] chulot = { "Minh", "Thanh", "Ngọc", "Kim", "Anh", "Như",
			"Thị" };
	private static String[] ten = { "Minh", "Thanh", "Ngọc", "Kim", "Anh", "Như",
			"Thư", "Tuyên", "Luận", "Nam", "Phong", "Ngân", "Kim", "Hoàng",
			"Hạnh", "Hoa", "Hồng", "Hòa", "Phú", "Hiếu", "Luyến", "Quốc" };
	private static String[] dantoc = { "Kinh", "Moong", "Mường", "Thái", "Tày", "Cơ ho",
		"Nùng", "Hre", "Hoa" };
	private static String[] tinh = { "Quảng Ngãi", "HCM", "Hà Nội", "Tuyên Quang", "Lào Cai", "Lạng Sơn",
		"Quảng Nam", "Điện Biên", "Vũng Tàu" };
	private static String[] tongiao = { "Không", "Hindu", "Thiên chúa", "Phật", "Hồi giáo", "Công giáo"};
	private static String[] gioitinh = { "Nam", "Nu", "N/A"};
	private static String[] ngay = { "1", "2", "3","4", "5", "6","7", "8", "9"};
	private static String[] thang = { "1", "2", "3","4", "5", "6","7", "8", "9"};
	private static String[] nam = { "2001", "2002", "2003","2004", "2005", "2006","2007", "2008", "2009"};
	
	public static String getName(Random r) {
		return ho[Math.abs(r.nextInt()) % ho.length] + " "
				+ chulot[Math.abs(r.nextInt()) % chulot.length] + " "
				+ ten[Math.abs(r.nextInt()) % ten.length];
	}
	
	public static String getDanToc(Random r) {
		return dantoc[Math.abs(r.nextInt()) % dantoc.length];
	}
	
	public static String getDiaChi(Random r) {
		return tinh[Math.abs(r.nextInt()) % tinh.length];
	}
	
	public static String getTonGiao(Random r) {
		return tongiao[Math.abs(r.nextInt()) % tongiao.length];
	}
	
	public static String getGioiTinh(Random r) {
		return gioitinh[Math.abs(r.nextInt()) % gioitinh.length];
	}
	
	public static String getNgaySinh(Random r) {
		return ngay[Math.abs(r.nextInt()) % ngay.length] + "-"
				+ thang[Math.abs(r.nextInt()) % thang.length] + "-"
				+ nam[Math.abs(r.nextInt()) % nam.length];
	}
}
