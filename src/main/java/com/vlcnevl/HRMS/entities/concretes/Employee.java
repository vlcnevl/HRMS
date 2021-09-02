package com.vlcnevl.HRMS.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.vlcnevl.HRMS.core.entities.concretes.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name="id",referencedColumnName = "id")
@Table(name="employees")
public class Employee extends User
{
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

	public Employee(String email, String password, boolean status,
			@NotNull(message = "required") @NotBlank String firstName,
			@NotNull(message = "required") @NotBlank String lastName,
			@NotNull(message = "required") @NotBlank String nationalityId) {
		super(email, password, status);
		this.firstName = firstName;
		this.lastName = lastName;
		this.nationalityId = nationalityId;
	}
}
