package com.bookly.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "discount")
public class Discount
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name = "discount_id")
	private int discountId;
	
	private String name;
	
	@Column(name = "discount_percent")
    private BigDecimal discountPercent; 
	
	@Column(name = "created_at", nullable = false)
	private LocalDateTime createdAt;
	
    @Column(name = "created_till")
	private LocalDateTime createdTill;
    
    @OneToMany(mappedBy = "discount")
    
    private List<Book> books = new ArrayList<>();

}
