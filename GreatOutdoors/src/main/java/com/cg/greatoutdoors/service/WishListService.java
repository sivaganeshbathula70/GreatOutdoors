package com.cg.greatoutdoors.service;

import java.util.List;

import com.cg.greatoutdoors.entity.Address;
import com.cg.greatoutdoors.entity.Whishlist;

public interface WishListService {
	public Whishlist create(Whishlist wishlist);

	public List<Whishlist> retrive();

	public void deleteProduct(int whishlistId);
}
