package com.vlcnevl.HRMS.entities.dtos;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployerForRegisterDto {
	
	@Email
	@NotBlank
	private String email;
	@NotNull
	private String password;
	@NotNull
	private String rePassword;
	@NotNull
	private String companyName;
	@NotNull
	private String webAddress;
	@NotNull
	private String phoneNumber;

}
