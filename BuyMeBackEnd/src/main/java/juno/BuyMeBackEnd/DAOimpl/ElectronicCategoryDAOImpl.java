package juno.BuyMeBackEnd.DAOimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import juno.BuyMeBackEnd.DAO.ElectronicCategoryDAO;
import juno.BuyMeBackEnd.DTO.ElectronicCategory;


@Repository("electronicCategoryDAO")
public class ElectronicCategoryDAOImpl implements ElectronicCategoryDAO{
	
	private static List<ElectronicCategory> categoryList = new ArrayList<>();
	
	static {
		
		ElectronicCategory ec1 = new ElectronicCategory();
		ec1.setCategoryId(1);
		ec1.setCategoryName("Mobile Phones");
		ec1.setImagePath("ec1_path.png");
		categoryList.add(ec1);
		
		ElectronicCategory ec2 = new ElectronicCategory();
		ec2.setCategoryId(2);
		ec2.setCategoryName("Laptops");
		ec2.setImagePath("ec2_path.png");
		categoryList.add(ec2);
		
		ElectronicCategory ec3 = new ElectronicCategory();
		ec3.setCategoryId(3);
		ec3.setCategoryName("Xbox");
		ec3.setImagePath("ec3_path.png");
		categoryList.add(ec3);
		
	}

	@Override
	public List<ElectronicCategory> listCategories() {
		return categoryList;
	}

	@Override
	public ElectronicCategory getCategory(int id) {
		
		for(ElectronicCategory  category:categoryList) {
			if(category.getCategoryId()==id)
				return category;
		}
		return null;
	}
	
}
