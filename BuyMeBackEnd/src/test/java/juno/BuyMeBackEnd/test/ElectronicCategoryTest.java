package juno.BuyMeBackEnd.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import juno.BuyMeBackEnd.DAO.ElectronicCategoryDAO;
import juno.BuyMeBackEnd.DTO.ElectronicCategory;

public class ElectronicCategoryTest {
	private static AnnotationConfigApplicationContext context;
	private static ElectronicCategoryDAO categoryDAO;
	private ElectronicCategory electronicCategory;
	
	@BeforeClass
	public static void init() {
		
		context = new AnnotationConfigApplicationContext();
		context.scan("juno.BuyMeBackEnd");
		context.refresh();
		
		categoryDAO = (ElectronicCategoryDAO)context.getBean("electronicCategoryDAO");
		
	}
	
	
	/*@Test
	public void testAddCategory() {
		ElectronicCategory electronicCategory1 = new ElectronicCategory();
		electronicCategory1.setCategoryName("Laptops");
		electronicCategory1.setImagePath("laptop.png");
		assertEquals("Data inserted",true,categoryDAO.addCategory(electronicCategory1));
		ElectronicCategory electronicCategory2 = new ElectronicCategory();
		electronicCategory2.setCategoryName("Mobile Phones");
		electronicCategory2.setImagePath("mobile.png");
		assertEquals("Data inserted",true,categoryDAO.addCategory(electronicCategory2));
		ElectronicCategory electronicCategory3 = new ElectronicCategory();
		electronicCategory3.setCategoryName("Landlines Phones");
		electronicCategory3.setImagePath("landlinePhones.png");
		assertEquals("Data inserted",true,categoryDAO.addCategory(electronicCategory3));
		ElectronicCategory electronicCategory4 = new ElectronicCategory();
		electronicCategory4.setCategoryName("Trimmers");
		electronicCategory4.setImagePath("trimmers.png");
		assertEquals("Data inserted",true,categoryDAO.addCategory(electronicCategory4));
	}*/
	
	/*@Test
	public void updateCategory() {
		ElectronicCategory electronicCategory = categoryDAO.getCategory(7);
		electronicCategory.setActive(false);
		assertEquals("Updated",true,categoryDAO.updateCategory(electronicCategory));
	}
	*/
	
	@Test
	public void getSingleCategory() {
		assertEquals("Data match",false,categoryDAO.getCategory(7).isActive());
	}
	
}
