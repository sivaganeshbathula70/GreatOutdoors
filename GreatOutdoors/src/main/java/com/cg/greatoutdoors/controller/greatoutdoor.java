package com.cg.greatoutdoors.controller;

import com.cg.greatoutdoors.entity.Address;
import com.cg.greatoutdoors.entity.Whishlist;
import com.cg.greatoutdoors.dao.AddressDaoImpl;
import com.cg.greatoutdoors.exception.AddressException;
import com.cg.greatoutdoors.service.AddressServiceImpl;
import com.cg.greatoutdoors.service.WishlistserviceImpl;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("http://localhost:4200")
public class greatoutdoor {
	@Autowired
	AddressServiceImpl addressService;
	@Autowired
	WishlistserviceImpl wishservice;
	@PostMapping("/address")
	public ResponseEntity<String>saveAddress(@RequestBody Address address) {
        addressService.insertAddress(address);
      
    	      	   
       
		return new ResponseEntity<String>("Added  successfully",HttpStatus.OK);
    	   
       
	}
	
	@PostMapping("/wishlist")
	public ResponseEntity<String>savewish(@RequestBody Whishlist wishlist){
		wishservice.create(wishlist);
		return new ResponseEntity<String>("Added succesfull",HttpStatus.OK);
	}
	@GetMapping(value = "/showById/{id}")
	public Address findAddress(@PathVariable int id)

	{
		return addressService.findById(id);
	}
	@GetMapping(value = "/showAll")
	public List<Address> fetchAddress() {
		return addressService.retreive();
	}
	@GetMapping(value="/view")
	public List<Whishlist> fetchwishlist(){
		return wishservice.retrive();
	}
	@DeleteMapping(value = "/address/delete/{id}")
	public void deleteAddress(@PathVariable int id) {
		addressService.delete(id);
	
	}
	@DeleteMapping(value="/wishlist/delete/{id}")
	public void deletewishlist(@PathVariable int id) {
		wishservice.deleteProduct(id);
	}

	@PutMapping(value = "/address/update/{id}")
	public void updateAddress(@PathVariable int id, @RequestBody Address address) {
		addressService.update(address, id);

	
}
}
