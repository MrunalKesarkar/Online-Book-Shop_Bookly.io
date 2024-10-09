package com.bookly.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BookReviewDTO {
	@JsonProperty(access = Access.READ_ONLY)
	private Long bookReviewId;
	private int rating;
	private String comment;
	
}
