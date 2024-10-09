package com.bookly.dto;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

import com.bookly.entities.Role;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

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
public class RegisterDTO {
	@JsonProperty(access = Access.READ_ONLY)
	private Long userId;
	@NotBlank
	
	private String firstName;
	@NotBlank
	private String lastName;
	@JsonProperty(access = Access.WRITE_ONLY)	
	private String password;
	@Email
	private String email;
	@NotBlank
	private String contactNo;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate birthDate;
	private Role role;
}
