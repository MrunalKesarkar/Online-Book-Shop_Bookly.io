package com.bookly.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_id")
	private Long orderId;
	@OneToMany(mappedBy = "order")
	private List<OrderItem> orderItemList = new ArrayList<OrderItem>();
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	@Column(name = "total_price")
	private double totalPrice;
	@OneToOne
	@JoinColumn(name = "payment_details_id")
	private PaymentDetail paymentdetails;
	@Column(name = "created_at")
	private LocalDate createdAt;

}
