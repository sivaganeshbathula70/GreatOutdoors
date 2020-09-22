package com.cg.greatoutdoors.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.cg.greatoutdoors.entity.Address;
import com.cg.greatoutdoors.entity.Product;
import com.cg.greatoutdoors.entity.Whishlist;
@Repository
@Transactional
public class IWishListDaoImpl implements IWishListProductDao
{
	@PersistenceContext
	EntityManager entitymanager;

	@Override
	public Whishlist create(Whishlist wishlist) {
		// TODO Auto-generated method stub
		entitymanager.persist(wishlist);
		return wishlist;
	}

	@Override
	public List<Whishlist> retrive() {
		// TODO Auto-generated method stub
		String Qstr="SELECT wishlist FROM Whishlist wishlist";
		TypedQuery<Whishlist> query=entitymanager.createQuery(Qstr,Whishlist.class);
		
		return  query.getResultList();
	}

	@Override
	public boolean deleteProduct( int whishlistId) {
		// TODO Auto-generated method stub
		Whishlist wishlist = entitymanager.find(Whishlist.class, whishlistId);
		entitymanager.remove(wishlist);
		return false;
	}

}
