package juno.BuyMeBackEnd.DAO;

import java.util.List;

import juno.BuyMeBackEnd.DTO.ElectronicCategory;

public interface ElectronicCategoryDAO {
	List<ElectronicCategory> listCategories();
	ElectronicCategory getCategory(int id);
}
