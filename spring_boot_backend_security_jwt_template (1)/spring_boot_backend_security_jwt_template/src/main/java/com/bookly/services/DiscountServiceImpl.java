package com.bookly.services;

import java.util.ArrayList;
import java.util.List;


import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookly.custom_exceptions.ResourceNotFoundException;
import com.bookly.dao.DiscountDao;
import com.bookly.dto.ApiResponse;
import com.bookly.dto.DiscountDTO;
import com.bookly.entities.Discount;

@Service
@Transactional
public class DiscountServiceImpl implements DiscountService 
{
	 @Autowired
	 private DiscountDao discountDao;
	 
	 @Autowired
	 private ModelMapper mapper;

	 public List<DiscountDTO> getAllDiscounts() {
		 	List<Discount> discounts = discountDao.findAll();
		 	List<DiscountDTO> dtoList = new ArrayList<DiscountDTO>();
		 	for (Discount discount : discounts) {
				dtoList.add(mapper.map(discount, DiscountDTO.class));
			}
	        return dtoList;
	    }

	 public DiscountDTO getDiscountById(Long discount_id){
		 Discount discount = discountDao.findById(discount_id).orElseThrow(()-> new ResourceNotFoundException("Invalid Discount Id"));
		 
		 return mapper.map(discount, DiscountDTO.class);
	 }

	 public DiscountDTO createOrUpdateDiscount(DiscountDTO dto) {
	     Discount discount  = mapper.map(dto, Discount.class);
	     Discount persistentDiscount = discountDao.save(discount);
		 return mapper.map(persistentDiscount, DiscountDTO.class);
	    }

	 public ApiResponse deleteDiscount(Long discount_id){
	    	discountDao.deleteById(discount_id);
	    	return new ApiResponse("Discount Deleted Successfully");
	 }
	 

}
