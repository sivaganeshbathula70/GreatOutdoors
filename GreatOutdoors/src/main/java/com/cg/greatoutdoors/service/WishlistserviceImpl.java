package com.cg.greatoutdoors.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.greatoutdoors.dao.AddressDaoImpl;
import com.cg.greatoutdoors.dao.IWishListDaoImpl;
import com.cg.greatoutdoors.entity.Address;
import com.cg.greatoutdoors.entity.Whishlist;
import com.cg.greatoutdoors.exception.AddressException;
import com.cg.greatoutdoors.exception.AddressNotFoundException;
@Service
@Transactional
public class WishlistserviceImpl  implements WishListService{
	@PersistenceContext
	private EntityManager entitymanager;
	@Autowired
	IWishListDaoImpl wishlistu;
	@Override
	public Whishlist create(Whishlist wishlist) {
		{
			if(wishlistu.create(wishlist)==null) 
			{
				throw new AddressException("no data");
			}
			else
			{
				Whishlist data= wishlistu.create(wishlist);
				return data;
			}

}
	
	}

	@Override
	public List<Whishlist> retrive()  throws AddressNotFoundException {
		return wishlistu.retrive();
		
	}

	@Override
	public void deleteProduct(int whishlistId) throws AddressNotFoundException{
		// TODO Auto-generated method stub
		if(true)
		{
			wishlistu.deleteProduct(whishlistId);
		}else
		{
					throw new AddressNotFoundException("Id does Not exist or Deleted!!");

		}	

	}}
