package com.cg.greatoutdoors.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.greatoutdoors.dao.AddressDaoImpl;
import com.cg.greatoutdoors.entity.Address;
import com.cg.greatoutdoors.exception.AddressException;
import com.cg.greatoutdoors.exception.AddressNotFoundException;
import com.cg.greatoutdoors.exception.IdNotFoundException;
@Service
@Transactional
public class AddressServiceImpl implements AddressserviceInterface {
	@PersistenceContext
	private EntityManager entitymanager;

	@Autowired
	AddressDaoImpl addressDao;

	@Override
	public Address findById(int id)  throws IdNotFoundException{
		// TODO Auto-generated method stub
	//	Address address = addressDao.findById(id);
		return addressDao.findById(id);
	}

	

	@Override
	public List<Address> retreive()  throws AddressNotFoundException {
		
		
			if(addressDao.retreive().size()>0)
			{
				
				return  addressDao.retreive();
			
			}
			else
			{
				
			
			throw new AddressNotFoundException("no Data available");
			}
		}

	

	@Override
	public boolean delete(int addressId) throws AddressNotFoundException {

		{
			Address address1 = addressDao.findById(addressId);
			if (address1 != null) {
				addressDao.delete(addressId);
				return true;
			} else {

				throw new AddressNotFoundException("Id does Not exist or Deleted!!");

			}
		}

	}

	

	@Override
	public void update(Address address, int id)throws AddressNotFoundException {

		Address address1 = addressDao.findById(id);
		if (address1 != null) {

			addressDao.update(address, id);

		} else {

			throw new AddressNotFoundException("AddressId not found please check the id ");

		}

	}
	

	@Override
	public Address insertAddress(Address address) throws AddressException {

		{
			if(addressDao.insertAddress(address)==null) 
			{
				throw new AddressException("no data");
			}
			else
			{
				Address data= addressDao.insertAddress(address);
				return data;
			}

}
}
}