package com.bookly.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
@AllArgsConstructor
@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;
	@Column(name = "first_name", length = 30)
	private String firstName;
	@Column(name = "last_name", length = 30)
	private String lastName;
	@Column(name = "password")
	private String password;
	@Column(length = 30, unique = true)
	private String email;
	@Column(name = "contact_no", length = 30)
	private String contactNo;
	@Column(name = "birth_date")
	private LocalDate birthDate;
	@Column(name = "img" , length = 100)
	private String imgPath;
	@Column(name = "created_at")
	private LocalDate createdAt;
	@Enumerated(EnumType.STRING)
	@Column(length = 30)
	private Role role;
}
