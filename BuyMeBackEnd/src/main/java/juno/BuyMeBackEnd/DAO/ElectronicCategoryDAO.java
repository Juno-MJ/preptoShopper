package juno.BuyMeBackEnd.DAO;

import java.util.List;

import juno.BuyMeBackEnd.DTO.ElectronicCategory;

public interface ElectronicCategoryDAO {
	boolean addCategory(ElectronicCategory electronicCategory);
	boolean updateCategory(ElectronicCategory electronicCategory);
	List<ElectronicCategory> listCategories();
	ElectronicCategory getCategory(int id);
}
