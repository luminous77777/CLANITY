//package mapper;
//
//import java.util.List;
//
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//
//import com.google.gson.GsonBuilder;
//
//import domain.onedayClass.ClassOpen;
//import domain.onedayClass.ClassSocialingCategory;
//import lombok.extern.slf4j.Slf4j;
//import util.MybatisUtil;
//
//@Slf4j
//public class ClassSocialCategoryTest {
//
//	private ClassSocialingCategoryMapper mapper = MybatisUtil.getSqlSession().getMapper(ClassSocialingCategoryMapper.class);
//
//
//
//	@Test
//	@DisplayName("클래스 카테고리 조회")
//	public void classTest() {
//		mapper.list().forEach(c -> log.info("Category: {}", c));
////		
////		List<ClassSocialingCategory> list = mapper.list();
////
////		list.forEach(c -> log.info("Category: {}", c));
//	}
//	
//	@Test
//	@DisplayName("클래스 카테고리 조회")
//	public void classTest2() {
//		// setprettyPrinting : 줄바꿈
//		String json = new GsonBuilder().setPrettyPrinting().create().toJson(mapper.listRegion());
//		log.info(json);
//		
//		
//	}
//	
//
////	private 
//	@Test
//	@DisplayName("클래스 카테고리 조회")
//	public void regionTest() {
//		// setprettyPrinting : 줄바꿈
//		String json = new GsonBuilder().setPrettyPrinting().create().toJson(mapper.listRegion());
//		log.info(json);
//		
//		
//	}
//	
//
//	@Test
//	@DisplayName("클래스 카테고리 조회")
//	public void regionTestJson() {
//		// setprettyPrinting : 줄바꿈
//		String json = new GsonBuilder().setPrettyPrinting().create().toJson(mapper.list());
//		log.info(json);
//		
//		
//	}
//	
//	
//
//
//}
