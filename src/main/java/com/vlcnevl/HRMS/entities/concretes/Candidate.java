package com.vlcnevl.HRMS.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.vlcnevl.HRMS.core.entities.concretes.User;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@PrimaryKeyJoinColumn(name="id")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name="candidates")
public class Candidate extends User{
	
	@Column(name="first_name")
	@NotNull(message = "required")
	@NotBlank
	private String firstName;
	
	@Column(name="last_name")
	@NotNull(message = "required")
	@NotBlank
	private String lastName;
	
	@Column(name="nationality_id")
	@NotNull(message = "required")
	@NotBlank
	private String nationalityId;
	 
	@Column(name="birth_year")
	@NotNull(message = "required")
	private int birthYear;
	
	public Candidate(String email, String password, boolean status,
			@NotNull(message = "required") @NotBlank String firstName,
			@NotNull(message = "required") @NotBlank String lastName,
			@NotNull(message = "required") @NotBlank String nationalityId,
			@NotNull(message = "required") @NotBlank int birthYear) {
		super(email, password, status);
		this.firstName = firstName;
		this.lastName = lastName;
		this.nationalityId = nationalityId;
		this.birthYear = birthYear;
	}
	
	
	
}
