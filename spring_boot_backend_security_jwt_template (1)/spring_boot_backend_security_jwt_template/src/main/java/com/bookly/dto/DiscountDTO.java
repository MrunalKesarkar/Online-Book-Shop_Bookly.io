package com.bookly.dto;

import java.time.LocalDateTime;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DiscountDTO 
{
	@JsonProperty(access = Access.READ_ONLY)
	private int discountId;
	private String name;
	private double discountPercent; 
	private LocalDateTime createdAt;
	private LocalDateTime createdTill;

}
