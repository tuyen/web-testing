package generate_testcase;

import java.util.Random;

public class RandomName {

	private String[] ho = { "Trần", "Nguyễn", "Phan", "Trịnh", "Phùng", "Vũ",
			"Võ", "Hoàng", "Huỳnh", "Hồ" };
	private String[] chulot = { "Minh", "Thanh", "Ngọc", "Kim", "Anh", "Như",
			"Thị" };
	private String[] ten = { "Minh", "Thanh", "Ngọc", "Kim", "Anh", "Như",
			"Thư", "Tuyên", "Luận", "Nam", "Phong", "Ngân", "Kim", "Hoàng",
			"Hạnh", "Hoa", "Hồng", "Hòa", "Phú", "Hiếu", "Luyến", "Quốc" };

	public String getName(Random r) {
		
		
		return ho[Math.abs(r.nextInt()) % ho.length] + " " + chulot[Math.abs(r.nextInt()) % chulot.length] + " " + ten[Math.abs(r.nextInt()) % ten.length];
	}
}
