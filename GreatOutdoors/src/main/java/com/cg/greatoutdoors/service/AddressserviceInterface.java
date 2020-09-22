package com.cg.greatoutdoors.service;

import java.util.List;

import com.cg.greatoutdoors.entity.Address;

public interface AddressserviceInterface {
	public Address findById(int id);
	 List<Address> retreive();
		
		
		public boolean delete(int addressId);
		public void update(Address address,int id);

		 public Address insertAddress(Address address);

}
