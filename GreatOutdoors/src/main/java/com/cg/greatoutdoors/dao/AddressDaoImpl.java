package com.cg.greatoutdoors.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.cg.greatoutdoors.entity.Address;
import com.cg.greatoutdoors.entity.User;

@Repository
@Transactional
public class AddressDaoImpl implements AddressDao {
	@PersistenceContext
	EntityManager entitymanager;

	@Override
	public Address insertAddress(Address address) {
		// TODO Auto-generated method stub
	
		entitymanager.persist(address);
		return address;
		
	}


	@Override
	public void delete(int addressId) {
		// TODO Auto-generated method stub
		Address address = entitymanager.find(Address.class, addressId);
		entitymanager.remove(address);
	}

	@Override
	public void update(Address address, int addressId) {
		// TODO Auto-generated method stub
		Address updateAddress = entitymanager.find(Address.class, addressId);
		updateAddress.setBuildingNo(address.getBuildingNo());
		updateAddress.setCity(address.getCity());
		updateAddress.setField(address.getField());
		updateAddress.setState(address.getState());
		updateAddress.setZip(address.getZip());
		entitymanager.merge(updateAddress);

		
	}

	@Override
	public List<Address> retreive() {
		String Qstr="SELECT address FROM Address address";
		TypedQuery<Address> query=entitymanager.createQuery(Qstr,Address.class);
		return query.getResultList();	
	}


	@Override
	public Address findById(int id) {
		// TODO Auto-generated method stub
		//return null;
		return entitymanager.find(Address.class, id);
	}	

}
