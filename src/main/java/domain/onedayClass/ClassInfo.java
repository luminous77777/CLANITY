package domain.onedayClass;

import java.sql.Date;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ClassInfo {
	// 이게 나중에 클래스 등록
	 private Long classId;
	    private String businessId;
	    private Long categoryId;
	    private String title;
	    private String description;
	    private String description2;
	    private String duration;
	    private Date createdAt;
	    private String price;
	    private String url;
	    private String discount;
	    private String discountPrice;
	    private String instructorName;
	    private String difficulty;
	    private String curriculum;
	    private String hostIntroduction;
	    private String thumbnailImages;
	    private String detailImages;
	    private String instructorImageUrl;
	    private String address;
	    private String region;
	    private String classType;
	    
	    
		public ClassInfo(String businessId) {
			super();
			this.businessId = businessId;
		}
//		public ClassInfo getClassInfo() {
//			return ClassInfo.builder()
//					.title("title")
//	                .description("description")
//	                .description2("description2")
//	                .duration("duration")
//	                .discountPrice("discountPrice")
//	                .instructorName("instructorName")
//	                .difficulty("difficulty")
//	                .curriculum("curriculum")
//	                .hostIntroduction("hostIntroduction")
//	                .thumbnailImages("thumbnailImages")
//	                .detailImages("detailImages")
//	                .instructorImageUrl("instructorImageUrl")
//	                .address("address")
//	                .region("region")
//	                .classType("classType") // 원데이
//	                .createdAt(Date.valueOf(LocalDate.now()))
//					.build();
//		}
		
}
