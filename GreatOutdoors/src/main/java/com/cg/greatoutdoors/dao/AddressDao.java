package com.cg.greatoutdoors.dao;

import com.cg.greatoutdoors.entity.Address;

import java.util.List;


public interface AddressDao {
	
	public Address findById(int id);
	 List<Address> retreive();
		
		
		public void delete(int addressId);
		public void update(Address address,int addressId);

		 public Address insertAddress(Address address);
		
}
