package juno.BuyMeBackEnd.DAOimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import juno.BuyMeBackEnd.DAO.ElectronicCategoryDAO;
import juno.BuyMeBackEnd.DTO.ElectronicCategory;

@Repository("electronicCategoryDAO")
@Transactional // check that spring's transactional lib is added
public class ElectronicCategoryDAOImpl implements ElectronicCategoryDAO {

	// get the sessionFactory from available bean
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<ElectronicCategory> listCategories() {
		return sessionFactory.getCurrentSession().createQuery("From category").list();
	}

	@Override
	public ElectronicCategory getCategory(int id) {

		return sessionFactory.getCurrentSession().get(ElectronicCategory.class, Integer.valueOf(id));

	}

	@Override
	public boolean addCategory(ElectronicCategory electronicCategory) {

		try {
			// add object to DB
			sessionFactory.getCurrentSession().persist(electronicCategory);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateCategory(ElectronicCategory electronicCategory) {

		try {
			// add object to DB
			sessionFactory.getCurrentSession().update(electronicCategory);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}


}
