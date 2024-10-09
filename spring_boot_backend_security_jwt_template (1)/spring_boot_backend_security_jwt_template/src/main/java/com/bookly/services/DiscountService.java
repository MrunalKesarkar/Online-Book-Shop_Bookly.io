package com.bookly.services;
import java.util.List;
import java.util.Optional;

import com.bookly.dto.ApiResponse;
import com.bookly.dto.DiscountDTO;

public interface DiscountService 
{
	 

	    public List<DiscountDTO> getAllDiscounts();

	    public DiscountDTO getDiscountById(Long discount_id);

	    public DiscountDTO createOrUpdateDiscount(DiscountDTO dto);

	    public ApiResponse deleteDiscount(Long discount_id);

}
