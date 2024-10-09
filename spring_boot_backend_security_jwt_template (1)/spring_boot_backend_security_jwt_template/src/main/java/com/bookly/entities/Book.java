package com.bookly.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "book_id")
	private Long bookId;
	@Column(length = 30)
	private String title;
	@Column(length = 30)
	private String author;
	@Column(length = 2000)
	private String description;
	private double price;
	private int quantity;
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;
	@Column(name = "img" , length = 100)
	private String imgPath;
	@Column(length = 30)
	private String publication;
	@ManyToOne
	@JoinColumn(name="discount_id")
	private Discount discount;
	
}

