package com.bookly.dto;

import java.time.LocalDate;
import java.util.List;



import com.bookly.entities.OrderItem;
import com.bookly.entities.PaymentDetail;
import com.bookly.entities.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {
	private Long orderId;
	private List<OrderItem> orderItemList;
	private User user;
	private double totalPrice;
	private PaymentDetail paymentdetails;
	private LocalDate createdAt;
}
