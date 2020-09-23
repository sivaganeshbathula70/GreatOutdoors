package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.greatoutdoors.dao.AddressDaoImpl;
import com.cg.greatoutdoors.dao.IWishListDaoImpl;
import com.cg.greatoutdoors.entity.Address;
import com.cg.greatoutdoors.entity.Whishlist;
import com.cg.greatoutdoors.exception.AddressException;
import com.cg.greatoutdoors.exception.AddressNotFoundException;
import com.cg.greatoutdoors.exception.IdNotFoundException;
import com.cg.greatoutdoors.service.AddressServiceImpl;
import com.cg.greatoutdoors.service.WishlistserviceImpl;

//@RunWith(SpringRunner.class)
//@SpringBootTest()
//@Transactional
public class GreatOutdoorsApplicationTests {
	@Autowired
	private WishlistserviceImpl wishlistService;
	@Autowired
	AddressServiceImpl userService;
	Address address;
	@Test
	public void  insertAddress() throws AddressException
	{
		Throwable expection=assertThrows(AddressException.class,()->{userService.insertAddress(address);});
		assertEquals("error",expection.getMessage());
		address.setAddressId(101);
		address.setBuildingNo("u");
		address.setCity("gunturu");
		address.setField("u");
		address.setState("u");
		address.setZip("u");
		address.setUser(null);
	userService.insertAddress(address);
	assertEquals(true,userService.insertAddress(address));
		
	}
	
	@Test
	public void delete() throws AddressNotFoundException{
		Throwable expection=assertThrows(AddressNotFoundException.class,()->{userService.delete(1);});
		assertEquals("Product Not In Cart",expection.getMessage());
		userService.delete(1);
		assertEquals(true,userService.delete(1));

		
		
	}
	@Test
	public void retreive()  throws AddressNotFoundException {
		Throwable expection=assertThrows(AddressNotFoundException.class,()->{userService.retreive();});
		assertEquals("List is empty",expection.getMessage());
		userService.retreive();
		assertEquals(true,userService.retreive());
		assertNotNull(userService.retreive());
		
	}
	
	
	@Test
	public void retreive1()  throws AddressNotFoundException {
		Throwable expection=assertThrows(AddressNotFoundException.class,()->{wishlistService.retrive();});
		assertEquals("List is empty",expection.getMessage());
		wishlistService.retrive();
		assertEquals(true,wishlistService.retrive());
		assertNotNull(wishlistService.retrive());
		
	}

	
	@Test
	public void delete1() throws AddressNotFoundException{
		Throwable expection=assertThrows(AddressNotFoundException.class,()->{wishlistService.deleteProduct(1);});
		assertEquals(" Not In Cart",expection.getMessage());
		//Address delete=new Address(1, null, null, null, null, null,null);
		wishlistService.deleteProduct(1);
	
		

	}

}

