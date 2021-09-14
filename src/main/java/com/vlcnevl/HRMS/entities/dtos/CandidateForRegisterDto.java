package com.vlcnevl.HRMS.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CandidateForRegisterDto {
	private String email;
	private String password;
	private String rePassword;
	private String firstName;
	private String lastName;
	private String nationalityId;
	private int birthYear;

}
