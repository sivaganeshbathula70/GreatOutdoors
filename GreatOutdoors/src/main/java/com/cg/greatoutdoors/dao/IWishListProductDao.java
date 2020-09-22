package com.cg.greatoutdoors.dao;

import java.util.List;

import com.cg.greatoutdoors.entity.Address;
import com.cg.greatoutdoors.entity.Product;
import com.cg.greatoutdoors.entity.Whishlist;

public interface IWishListProductDao {
	public Whishlist create(Whishlist product);

public List<Whishlist> retrive();

public boolean deleteProduct(int whishlistId);


}
